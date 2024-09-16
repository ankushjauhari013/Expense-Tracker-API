package com.in.ankush.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.in.ankush.dto.CategoryDto;
import com.in.ankush.entity.CategoryEntity;
import com.in.ankush.io.CategoryRequest;
import com.in.ankush.io.CategoryResponse;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	CategoryEntity mapToCategoryEntity(CategoryDto categoryDto);
	
	CategoryDto mapToCategoryDto(CategoryEntity entity);
	
	@Mapping(target = "categoryIcon", source = "icon")
	CategoryDto mapToCategoryDto(CategoryRequest request);
	
	CategoryResponse mapToCategoryResponse(CategoryDto categoryDto);

}
