package com.kmoore.savetravels.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "expenses")
public class Expense {

    public Expense() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Expense Name is mandatory")
    @Size(min = 2, max = 100, message = "Expense Name must be between 2 and 100 characters")
    private String expensename;

    @NotBlank(message = "Vendor is mandatory")
    @Size(min = 2, max = 100, message = "Vendor must be between 2 and 100 characters")
    private String vendor;

    @Min(value = 0, message = "Amount must be at least 0")
    private double amount;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;

    public Expense(String name, String expensename, String vendor, double amount, String description) {
        this.expensename = expensename;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getExpensename() {
        return expensename;
    }

    public void setExpensename(String expensename) {
        this.expensename = expensename;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
