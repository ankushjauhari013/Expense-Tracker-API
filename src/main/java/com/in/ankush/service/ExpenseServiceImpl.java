package com.in.ankush.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.in.ankush.dto.CategoryDto;
import com.in.ankush.dto.ExpenseDto;
import com.in.ankush.entity.CategoryEntity;
import com.in.ankush.entity.Expense;
import com.in.ankush.exceptions.ResourceNotFoundException;
import com.in.ankush.mappers.ExpenseMapper;
import com.in.ankush.repository.CategoryRepository;
import com.in.ankush.repository.ExpenseRepository;

@Service

public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ExpenseMapper expenseMapper;
	
	/*
	 * @Override public List<Expense> getAllExpenses() { return
	 * expenseRepo.findAll(); }
	 */
	
	
	
	/*
	 * @Override public Page<Expense> getAllExpenses(Pageable page) { return
	 * expenseRepo.findAll(page); }
	 */
	
	
	@Override
	public List<ExpenseDto> getAllExpenses(Pageable page) {
		 List<Expense> listOfExpenses = expenseRepo.findByUserId(userService.getLoggedInUser().getId(), page).toList();
//		 return listOfExpenses.stream().map(expense -> mapToDto(expense)).collect(Collectors.toList());
		 return listOfExpenses.stream().map(expense -> expenseMapper.mapToExpenseDto(expense)).collect(Collectors.toList());
	}
	
	
	/*
	 * @Override public Expense getExpenseById(Long id) { Optional<Expense> expense
	 * =expenseRepo.findById(id);
	 * 
	 * if(expense.isPresent()) { return expense.get(); } throw new
	 * RuntimeException("Expense is not found for id "+id); }
	 */
	

	
	// Custom Exception
	
	@Override
	public ExpenseDto getExpenseById(String expenseId) {
		Expense existingExpense = getExpenseEntity(expenseId);
	//	return mapToDto(existingExpense);		
		return expenseMapper.mapToExpenseDto(existingExpense);		
	}

	private Expense getExpenseEntity(String expenseId) {
		Optional<Expense> expense =expenseRepo.findByUserIdAndExpenseId(userService.getLoggedInUser().getId(),expenseId);
	
		if(!expense.isPresent()) {
			throw new ResourceNotFoundException("Expense is not found for id "+expenseId);
		}
		return  expense.get();
	}
	
	
	@Override
	public void deleteExpenseById(String expenseId) {
		Expense expense= getExpenseEntity(expenseId);
		expenseRepo.delete(expense);
	}

	@Override
	public ExpenseDto saveExpenseDetails(ExpenseDto expenseDto) {
		
		// checking existence of category
		
		Optional<CategoryEntity> optionalCategory = categoryRepository.findByUserIdAndCategoryId(userService.getLoggedInUser().getId(),expenseDto.getCategoryId());
		if(!optionalCategory.isPresent()) {
			throw new ResourceNotFoundException("Category not found for the id "+expenseDto.getCategoryId());
		}
		
		expenseDto.setExpenseId(UUID.randomUUID().toString());
		
		// map to entity object
		
		//Expense newExpense = mapToEntity(expenseDto);
		Expense newExpense = expenseMapper.mapToExpenseEntity(expenseDto);
	
		
		// save to db
		newExpense.setCategory(optionalCategory.get());
		newExpense.setUser(userService.getLoggedInUser());
		newExpense = expenseRepo.save(newExpense);
		
		// map to response object
		//return mapToDto(newExpense);
		return expenseMapper.mapToExpenseDto(newExpense);
		
	}

	/*
	 * private Expense mapToEntity(ExpenseDto expenseDto) {
	 * 
	 * return new Expense.ExpenseBuilder() .expenseId(expenseDto.getExpenseId())
	 * .name(expenseDto.getName()) .description(expenseDto.getDescription())
	 * .amount(expenseDto.getAmount()) .date(expenseDto.getDate()) .build(); }
	 */
	
	/*
	 * private ExpenseDto mapToDto(Expense newExpense) { // TODO Auto-generated
	 * method stub return new ExpenseDto.ExpenseDtoBuilder()
	 * .expenseId(newExpense.getExpenseId()) .name(newExpense.getName())
	 * .description(newExpense.getDescription()) .amount(newExpense.getAmount())
	 * .date(newExpense.getDate()) .updatedAt(newExpense.getUpdatedAt())
	 * .createdAt(newExpense.getCreatedAt())
	 * .categoryDto(mapToCategoryDto(newExpense.getCategory())) .build(); }
	 */



	/*
	 * private CategoryDto mapToCategoryDto(CategoryEntity category) { return new
	 * CategoryDto.CategoryDtoBuilder() .name(category.getName())
	 * .categoryId(category.getCategoryId()) .build(); }
	 */


	@Override
		public ExpenseDto updateExpenseDetails(String expenseId, ExpenseDto expenseDto) {
			
			Expense existingExpense = getExpenseEntity(expenseId);
			if(expenseDto.getCategoryId() != null) {
				Optional<CategoryEntity> optionalCategory = categoryRepository.findByUserIdAndCategoryId(userService.getLoggedInUser().getId(), expenseDto.getCategoryId());
				if(!optionalCategory.isPresent()) {
					throw new ResourceNotFoundException("Category not found for the id "+ expenseDto.getCategoryId());
				}
				existingExpense.setCategory(optionalCategory.get());
			}
			
			existingExpense.setName(expenseDto.getName() != null ? expenseDto.getName() : existingExpense.getName());
			existingExpense.setDescription(expenseDto.getDescription() != null ? expenseDto.getDescription() : existingExpense.getDescription());
			existingExpense.setAmount(expenseDto.getAmount() != null ? expenseDto.getAmount() : existingExpense.getAmount());
			existingExpense.setDate(expenseDto.getDate() != null ? expenseDto.getDate() : existingExpense.getDate());
			existingExpense = expenseRepo.save(existingExpense);
		//	return mapToDto(existingExpense);
			return expenseMapper.mapToExpenseDto(existingExpense);
	}


	@Override
	public List<ExpenseDto> readByCategory(String category, Pageable page) {
	 Optional<CategoryEntity> optionalCategory = categoryRepository.findByNameAndUserId(category, userService.getLoggedInUser().getId());
		if(!optionalCategory.isPresent()) {
			throw new ResourceNotFoundException("Category not found for the name "+ category);
		}
		
		List<Expense> list = expenseRepo.findByUserIdAndCategoryId(userService.getLoggedInUser().getId(), optionalCategory.get().getId(), page).toList();
	//	return list.stream().map(expense-> mapToDto(expense)).collect(Collectors.toList());
		return list.stream().map(expense-> expenseMapper.mapToExpenseDto(expense)).collect(Collectors.toList());

	}


	@Override
	public List<ExpenseDto> readByName(String keyword, Pageable page) {
		List<Expense> list = expenseRepo.findByUserIdAndNameContaining(userService.getLoggedInUser().getId(), keyword, page).toList();
//		return list.stream().map(expense-> mapToDto(expense)).collect(Collectors.toList());
		return list.stream().map(expense-> expenseMapper.mapToExpenseDto(expense)).collect(Collectors.toList());
	}


	@Override
	public List<ExpenseDto> readByDate(LocalDate startDate, LocalDate endDate, Pageable page) {
		if (startDate == null) {
		startDate = LocalDate.of(1970,1,1);
		}
		if (endDate == null) {
		endDate = LocalDate.now();
		}
		
		Page<Expense> expensePage  = expenseRepo.findByUserIdAndDateBetween(userService.getLoggedInUser().getId(),startDate, endDate, page);
	    List<Expense> list = expensePage.getContent();
//		return list.stream().map(expense-> mapToDto(expense)).collect(Collectors.toList());
		return list.stream().map(expense-> expenseMapper.mapToExpenseDto(expense)).collect(Collectors.toList());

	}

}
