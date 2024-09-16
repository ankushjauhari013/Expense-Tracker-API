package com.in.ankush.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.in.ankush.dto.CategoryDto;
import com.in.ankush.dto.ExpenseDto;
import com.in.ankush.io.CategoryResponse;
import com.in.ankush.io.ExpenseRequest;
import com.in.ankush.io.ExpenseResponse;
import com.in.ankush.mappers.ExpenseMapper;
import com.in.ankush.service.ExpenseService;
import jakarta.validation.Valid;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private ExpenseMapper expenseMapper;
	
	/*
	 * @GetMapping("/expenses") public List<Expense> getAllExpenses() { return
	 * expenseService.getAllExpenses(); }
	 */
	
	
	
	/*
	 * @GetMapping("/expenses") public Page<Expense> getAllExpenses(Pageable page) {
	 * return expenseService.getAllExpenses(page); }
	 */

	
	@GetMapping("/expenses")
	public List<ExpenseResponse> getAllExpenses(Pageable page) {
		
		/*    handleGeneralException()
		 * int number = 5; calculateFactorial(number);
		 */
		
		List<ExpenseDto> listOfExpenses = expenseService.getAllExpenses(page);
			// return listOfExpenses.stream().map(expenseDto -> mapToResponse(expenseDto)).collect(Collectors.toList());
		return listOfExpenses.stream().map(expenseDto -> expenseMapper.mapToExpenseResponse(expenseDto)).collect(Collectors.toList());
	}
	
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/expenses")
	
	public ExpenseResponse saveExpenseDetails(@Valid @RequestBody ExpenseRequest expenseRequest) {
		ExpenseDto expenseDto = expenseMapper.mapToExpenseDto(expenseRequest);
		//ExpenseDto expenseDto = mapToDTO(expenseRequest);
		
		expenseDto = expenseService.saveExpenseDetails(expenseDto);
		
		// return mapToResponse(expenseDto);
		return expenseMapper.mapToExpenseResponse(expenseDto);
	}

	/*
	 * private ExpenseDto mapToDTO(ExpenseRequest expenseRequest) { return new
	 * ExpenseDto.ExpenseDtoBuilder() .name(expenseRequest.getName())
	 * .description(expenseRequest.getDescription())
	 * .amount(expenseRequest.getAmount()) .date(expenseRequest.getDate())
	 * .categoryId(expenseRequest.getCategoryId()) .build(); }
	 */

	/*
	 * private ExpenseResponse mapToResponse(ExpenseDto expenseDto) { return new
	 * ExpenseResponse.ExpenseResponseBuilder()
	 * .expenseId(expenseDto.getExpenseId()) .name(expenseDto.getName())
	 * .description(expenseDto.getDescription()) .amount(expenseDto.getAmount())
	 * .date(expenseDto.getDate()) .createdAt(expenseDto.getCreatedAt())
	 * .updatedAt(expenseDto.getUpdatedAt())
	 * .category(mapToCategoryResponse(expenseDto.getCategoryDto())) .build(); }
	 */


	/*
	 * private CategoryResponse mapToCategoryResponse(CategoryDto categoryDto) {
	 * return new CategoryResponse.CategoryResponseBuilder()
	 * .categoryId(categoryDto.getCategoryId()) .name(categoryDto.getName())
	 * .build(); }
	 */
	
	@GetMapping("/expenses/{expenseId}")
	public ExpenseResponse getExpenseById(@PathVariable String expenseId) {
		ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);
		//return mapToResponse(expenseDto);
		return expenseMapper.mapToExpenseResponse(expenseDto);
	}

	@PutMapping("/expenses/{expenseId}")
		public ExpenseResponse updateExpenseDetails(@RequestBody ExpenseRequest expenseRequest, @PathVariable String expenseId) {
//		ExpenseDto updatedExpense = mapToDTO(expenseRequest);
		ExpenseDto updatedExpense = expenseMapper.mapToExpenseDto(expenseRequest);
		updatedExpense = expenseService.updateExpenseDetails(expenseId,updatedExpense);
//		return mapToResponse(updatedExpense);
		return expenseMapper.mapToExpenseResponse(updatedExpense);

	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam String expenseId) {
		 expenseService.deleteExpenseById(expenseId);	
	}
	
	@GetMapping("/expenses/category")
	public List<ExpenseResponse> getExpensesByCategory(@RequestParam String category, Pageable page){
		List<ExpenseDto> list = expenseService.readByCategory(category, page);

	// return list.stream().map(expenseDto -> mapToResponse(expenseDto)).collect(Collectors.toList());
	
	return list.stream().map(expenseDto -> expenseMapper.mapToExpenseResponse(expenseDto)).collect(Collectors.toList());
	}
	
	@GetMapping("/expenses/name")
	public List<ExpenseResponse> getExpenseByName(@RequestParam String keyword, Pageable page){
		List<ExpenseDto> list = expenseService.readByName(keyword, page);
//		return list.stream().map(expenseDto -> mapToResponse(expenseDto)).collect(Collectors.toList());
		return list.stream().map(expenseDto -> expenseMapper.mapToExpenseResponse(expenseDto)).collect(Collectors.toList());
	}
	
	@GetMapping("/expenses/date")
	public List<ExpenseResponse> getAllExpensesByDates(
	 @RequestParam(required = false) LocalDate startDate, 
	 @RequestParam(required = false) LocalDate endDate, 
	 Pageable page) {
	 List<ExpenseDto> list = expenseService.readByDate(startDate, endDate, page);
	 //return list.stream().map(expenseDto -> mapToResponse(expenseDto)).collect(Collectors.toList());
	 return list.stream().map(expenseDto -> expenseMapper.mapToExpenseResponse(expenseDto)).collect(Collectors.toList());
	
	}
	
}
