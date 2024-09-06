<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Expense Details</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container">
        <form class="d-flex" role="search" action="/expenses/search" method="post">
            <input class="form-control me-2" type="search" placeholder="Search by name" aria-label="Search" name="name" />
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>
<main class="container py-3">
    <h1 class="display-4 mb-3">Expense Details</h1>

    <div class="card shadow">
        <div class="card-body">
            <p class="card-text">
                <strong>Expense Name: </strong>
                ${expense.expensename}
            </p>

            <p class="card-text">
                <strong>Vendor: </strong>
                ${expense.vendor}
            </p>
            <p class="card-text">
                <strong>Amount: </strong>
                ${expense.amount}
            </p>
            <p class="card-text">
                <strong>Description: </strong>
                ${expense.description}
            </p>
            <a href="/expenses">Back to Expenses</a>
        </div>
    </div>
</main>

<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
