package com.in.ankush.service;

import java.util.List;
import com.in.ankush.dto.CategoryDto;


/*  
 * Service interface for managing the categories 
 * @author Ankush Jauhari
 * */

public interface CategoryService {

/*  
 * This is for reading the categories from database	 
 * @return list
 * */
	List<CategoryDto> getAllCategories();

/*  
 * This is for creating the new category	 
 * @param categoryDTO
 * @return categoryDTO
 * */
	CategoryDto saveCategory(CategoryDto categoryDto);

/*  
 * This is for deleting the category from database	 
 * @param categoryId
 * @return void
 * */
	void deleteCategory(String categoryId);
}
