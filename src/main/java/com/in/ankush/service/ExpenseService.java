package com.in.ankush.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.in.ankush.dto.ExpenseDto;

public interface ExpenseService {
	
	//List<Expense> getAllExpenses();
	
	List<ExpenseDto> getAllExpenses(Pageable page);
	
	ExpenseDto getExpenseById(String expenseId);

	void deleteExpenseById(String expenseId);
	
	ExpenseDto saveExpenseDetails(ExpenseDto expenseDto);

	ExpenseDto updateExpenseDetails(String expenseId, ExpenseDto expenseDto);
	
	List<ExpenseDto> readByCategory(String category, Pageable page);

	List<ExpenseDto> readByName(String keyword, Pageable page);
	
	List<ExpenseDto> readByDate(LocalDate startDate, LocalDate endDate, Pageable page);
	
	
	
}
