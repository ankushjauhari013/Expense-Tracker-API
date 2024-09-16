package com.in.ankush.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.in.ankush.dto.ExpenseDto;
import com.in.ankush.entity.Expense;
import com.in.ankush.io.ExpenseRequest;
import com.in.ankush.io.ExpenseResponse;

@Mapper(componentModel = "Spring")
public interface ExpenseMapper {
	
	ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

	@Mapping(target = "category", source = "expenseDto.categoryDto")
	ExpenseResponse mapToExpenseResponse(ExpenseDto expenseDto);
	
	
	ExpenseDto mapToExpenseDto(ExpenseRequest expenseRequest);
	
	
	Expense mapToExpenseEntity(ExpenseDto expenseDto);
	
	@Mapping(target = "categoryDto" , source = "expense.category")
	ExpenseDto mapToExpenseDto(Expense expense);
	
	
	
}
