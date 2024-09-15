package com.in.ankush.io;

import java.math.BigDecimal;
import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@lombok.Builder


public class ExpenseRequest {
	
	@NotBlank(message="Expense name must not be NULL!")
	@Size(min=3, message = "Expense name must be atleast 3 Characters")
	private String name;
	
	private String description;
	
	@NotBlank(message="Category should not be empty")
	private String categoryId;
	
	@Column(name = "expense_amount")
	@NotNull(message="Expense Amount should not be NULL!")
	private BigDecimal amount;
	
	@NotNull(message="Date must not be NULL!")
	private LocalDate date;

	public ExpenseRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenseRequest(
			@NotBlank(message = "Expense name must not be NULL!") @Size(min = 3, message = "Expense name must be atleast 3 Characters") String name,
			String description, @NotBlank(message = "Category should not be empty") String categoryId,
			@NotNull(message = "Expense Amount should not be NULL!") BigDecimal amount,
			@NotNull(message = "Date must not be NULL!") LocalDate date) {
		super();
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
		this.amount = amount;
		this.date = date;
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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	
	
	public static class Builder {
        private String name;
        private String description;
        private String categoryId;
        private BigDecimal amount;
        private LocalDate date;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public ExpenseRequest build() {
            return new ExpenseRequest(name, description, categoryId, amount, date);
        }
	
	}
}
