package com.in.ankush.service;

import java.util.List;

import com.in.ankush.dto.CategoryDto;

public interface CategoryService {
	
	List<CategoryDto> getAllCategories();

	CategoryDto saveCategory(CategoryDto categoryDto);
	
	void deleteCategory(String categoryId);
}
