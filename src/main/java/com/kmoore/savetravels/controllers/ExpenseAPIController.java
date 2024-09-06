package com.kmoore.savetravels.controllers;

import com.kmoore.savetravels.models.Expense;
import com.kmoore.savetravels.services.ExpenseServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseAPIController {
    private final ExpenseServices expenseService;

    public ExpenseAPIController(ExpenseServices expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/api/expenses")
    public List<Expense> getAllExpenses() {
        return (List<Expense>) expenseService.allExpenses();
    }

    @PostMapping("/api/expenses")
    public Expense createExpense(@Valid @RequestBody Expense Expense) {
        return expenseService.save(Expense);
    }

    @GetMapping("/api/expenses/{expenseId}")
    public Expense getExpense(@PathVariable(value = "expenseId") long expenseId) {
        return this.expenseService.findExpenseById(expenseId);
    }

    @PutMapping("/api/expenses/{expenseId}")
    public Expense updateExpense(@PathVariable(value = "expenseId") long expenseId, @RequestBody Expense updatedExpense) {
        return this.expenseService.updateExpense(expenseId, updatedExpense);
    }

    @DeleteMapping("/api/expenses/{expenseId}")
    public void deleteExpense(@PathVariable(value = "expenseId") long expenseId) {
        this.expenseService.deleteExpense(expenseId);
    }
}
