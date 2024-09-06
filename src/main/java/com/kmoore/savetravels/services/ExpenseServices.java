package com.kmoore.savetravels.services;

import com.kmoore.savetravels.models.Expense;
import com.kmoore.savetravels.repositories.ExpenseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServices {
    public static String allExpenses;
    @Autowired
    // adding the expense repository as a dependency
    private final ExpenseRepository expenseRepository;

    public ExpenseServices(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }

    // creates a new expense
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // updates an existing expense
    public Expense updateExpense(Long id, Expense expense) {
        Optional<Expense> optionalExpense = this.expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            Expense expenseToUpdate = optionalExpense.get();
            expenseToUpdate.setVendor(expense.getVendor());
            expenseToUpdate.setAmount(expense.getAmount());
            expenseToUpdate.setDescription(expense.getDescription());
            return expenseRepository.save(expenseToUpdate);
        }
        return null;
    }

    // finds an expense by its ID
    public Expense findExpenseById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }

    public void deleteExpense(Long id) {
        this.expenseRepository.deleteById(id);
    }

    public List<Expense> findAllExpenses() {
        return List.of();
    }

    public List<Expense> searchByName(String name) {
        return List.of();
    }

    public Expense save(Expense expense) {
        expenseRepository.save(expense);
        return expense;
    }
}
