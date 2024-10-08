package com.in.ankush.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.ankush.entity.CategoryEntity;


/*  
 * JPA repository for category Entity
 * @author Ankush Jauhari
 * */

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	/*  
	 * finder method to retrieve the categories by userId
	 * @param userId
	 * @return list
	 * */
	List<CategoryEntity>findByUserId(Long userId);
	
	
	/*  
	 * finder method to fetch the category by userId and categoryId  
	 * @param id, categoryId
	 * @return Optional<categoryEntity>
	 * */
	Optional<CategoryEntity> findByUserIdAndCategoryId(Long id, String categoryId);
	
	
	/*  
	 * It Checks whether category is present or not by userId and categoryName  
	 * @param name, userId
	 * @return boolean
	 * */
	boolean existsByNameAndUserId(String name, Long userId);
	
	/*  
	 * It retrieve the category by name and userId
	 * @param name, userId
	 * @return Optional<CategoryEntity>
	 * */
	Optional<CategoryEntity> findByNameAndUserId(String name, Long userId);

}
