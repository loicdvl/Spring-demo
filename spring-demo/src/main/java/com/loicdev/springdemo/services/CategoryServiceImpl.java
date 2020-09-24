package com.loicdev.springdemo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.loicdev.springdemo.api.mapper.CategoryMapper;
import com.loicdev.springdemo.api.model.CategoryDTO;
import com.loicdev.springdemo.repositories.CategoryRepository;

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

	@Override
	public CategoryDTO getCategoryByName(String name) {
		return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
	}
}
