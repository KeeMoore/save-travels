<%--
  Created by IntelliJ IDEA.
  User: keimh
  Date: 9/4/2024
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
  <title>Save Travels</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card">
        <div class="card-header text-center">
          <h1>Save Travels</h1>
        </div>
        <div class="card-body">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>Expense</th>
              <th>Vendor</th>
              <th>Amount</th>
              <th>Description</th>
              <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="expense" items="${expenses}">
              <tr>
                <td>${expense.expensename}</td>
                <td>${expense.vendor}</td>
                <td>${expense.amount}</td>
                <td>${expense.description}</td>
                <td><a href="/expenses/${expense.id}">View</a></td>
                <td><a href="/expenses/edit/${expense.id}" class="btn btn-warning">Edit</a></td>
                <td><form action="/expenses/${expense.id}/delete" method="post" style="display:inline;">
                  <input type="hidden" name="_method" value="delete" />
                  <button type="submit">Delete</button>
                </form></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <h2 class="mt-4">Add an expense</h2>
          <%--@elvariable id="expense" type="ch"--%>
          <form:form modelAttribute="expense" action="/expenses/create" method="post">
            <div class="form-group mb-3">
              <form:label path="expensename">Expense Name:</form:label>
              <form:input path="expensename" class="form-control" />

              <form:errors path="expensename"/>

            </div>
            <div class="form-group mb-3">
              <form:label path="vendor">Vendor:</form:label>
              <form:input path="vendor" class="form-control" />

              <form:errors path="vendor"/>

            </div>
            <div class="form-group mb-3">
              <form:label path="amount">Amount:</form:label>
              <form:input path="amount" class="form-control" />

              <form:errors path="amount"/>

            </div>
            <div class="form-group mb-3">
              <form:label path="description">Description:</form:label>
              <form:textarea path="description" class="form-control" />

              <form:errors path="description"/>

            </div>
            <button type="submit" class="btn btn-primary w-100">Submit</button>
          </form:form>

        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
<%--<div class="collapse navbar-collapse" id="navbarNav">--%>
<%--  <ul class="navbar-nav ms-auto">--%>
<%--    <li class="nav-item">--%>
<%--      <a class="nav-link active" aria-current="page" href="/expenses">All Expenses</a>--%>
<%--    </li>--%>
<%--  </ul>--%>
<%--</div>--%>