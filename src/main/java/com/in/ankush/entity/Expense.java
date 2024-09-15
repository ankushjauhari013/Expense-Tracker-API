package com.in.ankush.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;


@Entity
@Builder
@Table(name = "tbl_expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String expenseId;


	@Column(name = "expense_name")
	private String name;
	
	private String description;
	
	@Column(name = "expense_amount")
	private BigDecimal amount;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="category_id", nullable = false)
	@OnDelete(action =OnDeleteAction.RESTRICT)
	private CategoryEntity category;
	
	private LocalDate date;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_id", nullable = false)
	@OnDelete(action =OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}
	

public Expense(Long id, String expenseId,String name, String description, BigDecimal amount, CategoryEntity category, LocalDate date, LocalDateTime createdAt, LocalDateTime updatedAt, User user) {
		super();
		this.id = id;
		this.expenseId=expenseId;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	public Expense() {
		super();
	}
	
	
	public static class ExpenseBuilder {
        private Long id;
        private String expenseId;
        private String name;
        private String description;
        private BigDecimal amount;
        private CategoryEntity category;
        private LocalDate date;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private User user;

        public ExpenseBuilder id(Long id) {
            this.id = id;
            return this;
        }
        
        public ExpenseBuilder expenseId(String expenseId) {
            this.expenseId = expenseId;
            return this;
        }

        public ExpenseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ExpenseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ExpenseBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public ExpenseBuilder category(CategoryEntity category) {
            this.category = category;
            return this;
        }

        public ExpenseBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public ExpenseBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ExpenseBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ExpenseBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Expense build() {
            return new Expense(id,expenseId,name,description,amount,category,date,createdAt,updatedAt,user);
        }
    }
}





















