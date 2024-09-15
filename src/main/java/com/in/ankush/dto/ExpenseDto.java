package com.in.ankush.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.in.ankush.io.CategoryResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ExpenseDto {

	private String expenseId;
	private String name;
	private String description;
	private BigDecimal amount;
	private LocalDate date;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private CategoryResponse category;
	private CategoryDto categoryDto;
	private UserDto userDto;
	private String categoryId;
	
	
	public ExpenseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExpenseDto(String expenseId, String name, String description, BigDecimal amount, LocalDate date,
			LocalDateTime createdAt, LocalDateTime updatedAt, CategoryResponse category, CategoryDto categoryDto,
			UserDto userDto, String categoryId ) {
		super();
		this.expenseId = expenseId;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
		this.categoryDto = categoryDto;
		this.userDto = userDto;
		this.categoryId = categoryId;
	}


	public String getExpenseId() {
		return expenseId;
	}


	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public CategoryResponse getCategory() {
		return category;
	}


	public void setCategory(CategoryResponse category) {
		this.category = category;
	}


	public CategoryDto getCategoryDto() {
		return categoryDto;
	}


	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}


	public UserDto getUserDto() {
		return userDto;
	}


	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}




	public static class ExpenseDtoBuilder {
        private String expenseId;
        private String name;
        private String description;
        private BigDecimal amount;
        private LocalDate date;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private CategoryResponse category;
        private CategoryDto categoryDto;
        private UserDto userDto;
        private String categoryId;

        public ExpenseDtoBuilder expenseId(String expenseId) {
            this.expenseId = expenseId;
            return this;
        }

        public ExpenseDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ExpenseDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ExpenseDtoBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public ExpenseDtoBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public ExpenseDtoBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ExpenseDtoBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ExpenseDtoBuilder category(CategoryResponse category) {
            this.category = category;
            return this;
        }

        public ExpenseDtoBuilder categoryDto(CategoryDto categoryDto) {
            this.categoryDto = categoryDto;
            return this;
        }

        public ExpenseDtoBuilder userDto(UserDto userDto) {
            this.userDto = userDto;
            return this;
        }
        public ExpenseDtoBuilder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }
        

        public ExpenseDto build() {
            return new ExpenseDto(expenseId, name, description, amount, date, createdAt, updatedAt, category, categoryDto, userDto, categoryId);
        }
    }
	
}
