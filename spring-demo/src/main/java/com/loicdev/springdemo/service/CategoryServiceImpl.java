package com.loicdev.springdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.loicdev.springdemo.api.mapper.CategoryMapper;
import com.loicdev.springdemo.api.model.CategoryDTO;
import com.loicdev.springdemo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryMapper categoryMapper;
	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
		this.categoryMapper = categoryMapper;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		return categoryRepository.findAll()
				.stream()
				.map(categoryMapper::categoryToCategoryDTO)
				.collect(Collectors.toList());
	}

	public List<CategoryDTO> getPostEditHistory(Integer categoryID) {

		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();

		categoryRepository.findRevisions(categoryID).get().forEach(x -> {
			x.getEntity().setEditVersion(x.getMetadata());
			categoryDTOList.add(categoryMapper.categoryToCategoryDTO((x.getEntity())));
		});

		return categoryDTOList;
	}
	
	@Override
	public CategoryDTO findById(Integer id) {
		return categoryMapper.categoryToCategoryDTO(categoryRepository.findById(id).get());
	}

	@Override
	public CategoryDTO getCategoryByName(String name) {
		return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
	}

	@Override
	public CategoryDTO create(CategoryDTO categoryDTO) {
		return categoryMapper.categoryToCategoryDTO(
				categoryRepository.save(
						categoryMapper.CategoryDTOToCategory(categoryDTO)));
	}

	@Override
	public CategoryDTO update(Integer id, CategoryDTO categoryDTO) {
		categoryDTO.setId(id);
		return categoryMapper.categoryToCategoryDTO(
				categoryRepository.save(
						categoryMapper.CategoryDTOToCategory(categoryDTO)));
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}
}
