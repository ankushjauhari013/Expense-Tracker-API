package com.in.ankush.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.in.ankush.dto.CategoryDto;
import com.in.ankush.io.CategoryRequest;
import com.in.ankush.io.CategoryResponse;
import com.in.ankush.service.CategoryService;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

@RequestMapping("/categories")
public class CategoryController {
	
	private final CategoryService categoryService;
	
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
	
    
    @ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest){
		CategoryDto categoryDTO = mapToDTO(categoryRequest);
		categoryDTO = categoryService.saveCategory(categoryDTO);
//		return mapToResponse(categoryDTO);	
        return ResponseEntity.ok(mapToResponse(categoryDTO));

	}
	
	@GetMapping
	public List<CategoryResponse> readCategories(){
		List<CategoryDto> listOfCategories = categoryService.getAllCategories();
		return listOfCategories.stream().map(categoryDTO -> mapToResponse(categoryDTO)).collect(Collectors.toList());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable String categoryId) {
		categoryService.deleteCategory(categoryId);
	}
	
	private CategoryResponse mapToResponse(CategoryDto categoryDTO) {
		return new CategoryResponse.CategoryResponseBuilder()
				.categoryId(categoryDTO.getCategoryId())
				.name(categoryDTO.getName())
				.description(categoryDTO.getDescription())
				.categoryIcon(categoryDTO.getCategoryIcon())
				.createdAt(categoryDTO.getCreatedAt())
				.updatedAt(categoryDTO.getUpdatedAt())
				.build();
		}

	private CategoryDto mapToDTO(CategoryRequest categoryRequest) {
		return new CategoryDto.CategoryDtoBuilder()
				.name(categoryRequest.getName())
				.description(categoryRequest.getDescription())
				.categoryIcon(categoryRequest.getIcon())
				.build();
		
	}
}
