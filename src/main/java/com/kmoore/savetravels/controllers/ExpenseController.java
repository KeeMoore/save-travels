//package com.kmoore.savetravels.controllers;
//
//
//
//import com.kmoore.savetravels.models.Expense;
//import com.kmoore.savetravels.services.ExpenseServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/expenses")
//public class ExpenseController {
//
//    @Autowired
//    private final ExpenseServices expenseService;
//
//    public ExpenseController(ExpenseServices expenseService) {
//        this.expenseService = expenseService;
//    }
//
//    @GetMapping("")
//    public String index(Model model) {
//        List<Expense> expenses = expenseService.allExpenses();
//        model.addAttribute("expenses", expenses);
//        return "index.jsp";
//    }
//
//    @GetMapping("/new")
//    public String newExpense(@ModelAttribute("expense") Expense expense) {
//        return "edit.jsp";
//    }
//
//    @PostMapping("")
//    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
//        if (result.hasErrors()) {
//            return "expenses/new";
//        }
//        expenseService.addExpense(expense);
//        return "redirect:/expenses";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        Expense expense = expenseService.findExpenseById(id);
//        if (expense != null) {
//            model.addAttribute("expense", expense);
//            return "expenses/show";
//        }
//        return "redirect:/expenses";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Expense expense = expenseService.findExpenseById(id);
//        if (expense != null) {
//            model.addAttribute("expense", expense);
//            return "expenses/edit";
//        }
//        return "redirect:/expenses";
//    }
//
//    @PutMapping("/{id}")
//    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable("id") Long id) {
//        if (result.hasErrors()) {
//            return "expenses/edit";
//        }
//        expenseService.updateExpense(id, expense);
//        return "redirect:/expenses";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        expenseService.deleteExpense(id);
//        return "redirect:/expenses";
//    }
//}
//

package com.kmoore.savetravels.controllers;

import com.kmoore.savetravels.models.Expense;
import com.kmoore.savetravels.services.ExpenseServices;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kmoore.savetravels.services.ExpenseServices.allExpenses;

@Controller
public class ExpenseController {

    private final ExpenseServices expenseService;

    public ExpenseController(ExpenseServices expenseService) {
        this.expenseService = expenseService;
    }

//    @GetMapping("/")
//    public String index(@ModelAttribute("expense") Expense expense, Model model) {
//        List<Expense> expenses = expenseService.allExpenses();
//        model.addAttribute("expenses", expenses);
//        return "redirect:/expenses";
//    }

    @GetMapping("/expenses")
    public String index(@ModelAttribute ("expense") Expense expense, Model model) {
        List<Expense> allExpenses = this.expenseService.allExpenses();
        model.addAttribute("expenses", allExpenses);
        model.addAttribute("expense", expense);
        return "index.jsp";
    }

    @GetMapping("/expenses/{id}")
    public String expenseDetails(@PathVariable("id") Long id, Model model) {
        Expense expense = this.expenseService.findExpenseById(id);
        if (expense != null) {
            model.addAttribute("expense", expense);
            return "expense-details.jsp";
        }
        return "redirect:/expenses";
    }

    @PostMapping("/expenses/create")
    public String addExpense(@Valid @RequestBody @ModelAttribute Expense expense, BindingResult result, Model model) {
        System.out.println("Request received: " + expense);
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            List<Expense> allExpenses = this.expenseService.findAllExpenses();
            model.addAttribute("expenses", allExpenses);
            return "index.jsp";
        }
        System.out.println("Adding expenses: " + expense); // Debug statement
        this.expenseService.createExpense(expense);
        System.out.println("Expense saved: " + expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/edit/{id}")
    public String editExpense(@PathVariable Long id, Model model) {
        Expense expense = this.expenseService.findExpenseById(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }

    @PutMapping("/expenses/{id}/update")
    public String updateExpense(
            @PathVariable Long id,
            @Valid @ModelAttribute Expense expense,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expense", expense);
            return "edit.jsp";
        }

        this.expenseService.updateExpense(id, expense);
        return "redirect:/expenses";
    }

    @DeleteMapping("/expenses/{id}/delete")
    public String deleteExpense(@PathVariable("id") Long id) {
        this.expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

    @PostMapping("/expenses/search")
    public String searchExpenses(@RequestParam String name, Model model) {
        List<Expense> foundExpenses = this.expenseService.searchByName(name);
        model.addAttribute("expenses", foundExpenses);
        return "index.jsp";
    }

    @GetMapping("/expenses/sort/name")
    public String sortExpensesName() {
        return "redirect:/expenses?q=name";
    }

    @GetMapping("/expenses/sort/vendor")
    public String sortExpensesVendor() {
        return "redirect:/expenses?q=vendor";
    }

    @GetMapping("/expenses/sort/amount")
    public String sortExpensesAmount() {
        return "redirect:/expenses?q=amount";
    }
}

