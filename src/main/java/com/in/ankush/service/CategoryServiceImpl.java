package com.in.ankush.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.in.ankush.dto.CategoryDto;
import com.in.ankush.dto.UserDto;
import com.in.ankush.entity.CategoryEntity;
import com.in.ankush.entity.User;
import com.in.ankush.exceptions.ResourceNotFoundException;
import com.in.ankush.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{


	private final CategoryRepository categoryRepository;
	private final UserService userService;


	public CategoryServiceImpl(CategoryRepository categoryRepository, UserService userService) {
	        this.categoryRepository = categoryRepository;
	        this.userService = userService;
	    }

/*  
 * This is for reading the categories from database	 
 * @return List
 * */
	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryEntity> list = categoryRepository.findByUserId(userService.getLoggedInUser().getId());
		return list.stream().map(CategoryEntity -> mapToDTO(CategoryEntity)).collect(Collectors.toList());
	}

/*  
 * Mapper method to convert category Entity TO category Dto 
 * @param categoryEntity
 * @return categoryDto
 * */
	private CategoryDto mapToDTO(CategoryEntity categoryEntity) {
		return CategoryDto.builder()
				   .categoryId(categoryEntity.getCategoryId())
				   .name(categoryEntity.getName())
				   .description(categoryEntity.getDescription())
				   .categoryIcon(categoryEntity.getCategoryIcon())
				   .createdAt(categoryEntity.getCreatedAt())
				   .updatedAt(categoryEntity.getUpdatedAt())
				   .user(mapToUserDTO(categoryEntity.getUser()))
				   .build();   
	}

/*  
 * Mapper method to convert User Entity to User Dto 
 * @param userEntity
 * @return userDto
 * */
	private UserDto mapToUserDTO(User user) {
		return UserDto.builder()
			   .email(user.getEmail())
			   .name(user.getName())
			   .build();
	}

	
/*  
 * This is for creating the new category
 * @param categoryDto
 * @return categoryDto
 * */
	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		boolean isCategoryPresent = categoryRepository.existsByNameAndUserId(categoryDto.getName(),userService.getLoggedInUser().getId());
		if(isCategoryPresent) {
			throw new ItemAlreadyExistsException("Category is already present for "+ categoryDto.getName());
		}
		CategoryEntity newCategory = mapToEntity(categoryDto);
		newCategory = categoryRepository.save(newCategory);
		return mapToDTO(newCategory);
	}

	/*
	 * private CategoryEntity mapToEntitity(CategoryDto categoryDto) { 
	 * return CategoryEntity.builder() 
	 * .name(categoryDto.getName())
	 * .description(categoryDto.getDescription())
	 * .categoryIcon(categoryDto.getCategoryIcon())
	 * .categoryId(UUID.randomUUID().toString()) 
	 * .build(); }
	 */


	
/*  
 * Mapper method to convert category Dto to category Entity
 * @param categoryDto
 * @return categoryEntity
 * */
	 private CategoryEntity mapToEntity(CategoryDto categoryDto) {
	        return CategoryEntity.builder()
	                .categoryId(UUID.randomUUID().toString())
	                .name(categoryDto.getName())
	                .description(categoryDto.getDescription())
	                .categoryIcon(categoryDto.getCategoryIcon())
	                .user(userService.getLoggedInUser()) // Assuming userService provides the logged-in user
	                .build();
	    }

	
/*  
 * This is for deleting the categories from database	 
 * @param categoryId
 * */
	@Override
	public void deleteCategory(String categoryId) {
		Optional<CategoryEntity> optionalCategory = categoryRepository.findByUserIdAndCategoryId(userService.getLoggedInUser().getId(),categoryId);
		
		if(!optionalCategory.isPresent()) {
			throw new ResourceNotFoundException("Category not found for the id "+categoryId);
		}
		categoryRepository.delete(optionalCategory.get());
	}

}
