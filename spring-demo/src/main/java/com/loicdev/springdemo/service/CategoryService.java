package com.loicdev.springdemo.service;

import java.util.List;

import com.loicdev.springdemo.api.model.CategoryDTO;

public interface CategoryService {
	
	List<CategoryDTO> getAllCategories();
	
	CategoryDTO findById(Integer id);
	
	CategoryDTO getCategoryByName(String name);

	CategoryDTO create(CategoryDTO categoryDTO);

	CategoryDTO update(Integer id, CategoryDTO categoryDTO);

	void deleteById(Integer id);

	
}
