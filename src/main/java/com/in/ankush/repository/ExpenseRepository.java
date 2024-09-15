package com.in.ankush.repository;

import java.util.Optional;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.ankush.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	// SELECT * FROM tbl_expenses WHERE category=?;
 //	Page<Expense> findByCategory(String category, Pageable page);
	
	

	// SELECT * FROM tbl_expenses WHERE name LIKE %keyword%;
//	Page<Expense> findByNameContaining(String keyword, Pageable page);
	
	
	// SELECT * FROM tbl_expenses WHERE date BETWEEN ‘startDate’ AND ‘endDate’
//	Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);
	
	
	// SELECT * FROM tbl_expenses WHERE user_id=?;
	Page<Expense>  findByUserId(Long userId, Pageable page);
	
	
	// SELECT * FROM tbl_expenses WHERE user_id=? AND category=?
	Page<Expense> findByUserIdAndCategory(Long userId, String category, Pageable page);
	
	
	Page<Expense> findByUserIdAndCategoryId(Long userId, Long categoryId, Pageable page);

	
	// SELECT * FROM tbl_expenses WHERE user_id=? AND name LIKE ‘%keyword%’
	Page<Expense> findByUserIdAndNameContaining(Long userId, String keyword, Pageable page);
	
	
	// SELECT * FROM tbl_expenses WHERE user_id = ? AND date BETWEEN ‘startDate’ AND ‘endDate’
	Page<Expense> findByUserIdAndDateBetween(Long userId, LocalDate localStartDate, LocalDate localEndDate, Pageable page);
	
	
	// SELECT * FROM tbl_expenses WHERE user_id=? and expense_id=?;
	Optional<Expense>  findByUserIdAndExpenseId(Long userId, String expenseId);
	

}

