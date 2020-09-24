package com.loicdev.springdemo.services;

import java.util.List;

import com.loicdev.springdemo.api.model.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();
	
	CategoryDTO getCategoryByName(String name);
}
