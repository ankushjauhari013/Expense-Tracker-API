package com.in.ankush.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.ankush.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	List<CategoryEntity>findByUserId(Long userId);
	
	Optional<CategoryEntity> findByUserIdAndCategoryId(Long id, String categoryId);

}
