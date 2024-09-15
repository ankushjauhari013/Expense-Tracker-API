package com.in.ankush.io;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@lombok.Builder

public class ExpenseResponse {
	
	private String expenseId;
	private String name;
	private String description;
	private BigDecimal amount;
	private LocalDate date;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private CategoryResponse category;
	
	
	public ExpenseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExpenseResponse(String expenseId, String name, String description, BigDecimal amount, LocalDate date,
			LocalDateTime createdAt, LocalDateTime updatedAt, CategoryResponse category) {
		super();
		this.expenseId = expenseId;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
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
	
	
	
	 public static class ExpenseResponseBuilder {
	        private String expenseId;
	        private String name;
	        private String description;
	        private BigDecimal amount;
	        private LocalDate date;
	        private LocalDateTime createdAt;
	        private LocalDateTime updatedAt;
	        private CategoryResponse category;

	        public ExpenseResponseBuilder expenseId(String expenseId) {
	            this.expenseId = expenseId;
	            return this;
	        }

	        public ExpenseResponseBuilder name(String name) {
	            this.name = name;
	            return this;
	        }

	        public ExpenseResponseBuilder description(String description) {
	            this.description = description;
	            return this;
	        }

	        public ExpenseResponseBuilder amount(BigDecimal amount) {
	            this.amount = amount;
	            return this;
	        }

	        public ExpenseResponseBuilder date(LocalDate date) {
	            this.date = date;
	            return this;
	        }

	        public ExpenseResponseBuilder createdAt(LocalDateTime createdAt) {
	            this.createdAt = createdAt;
	            return this;
	        }

	        public ExpenseResponseBuilder updatedAt(LocalDateTime updatedAt) {
	            this.updatedAt = updatedAt;
	            return this;
	        }

	        public ExpenseResponseBuilder category(CategoryResponse category) {
	            this.category = category;
	            return this;
	        }

	        public ExpenseResponse build() {
	            return new ExpenseResponse(expenseId, name, description, amount, date, createdAt, updatedAt, category);
	        }
	    }
	
}
