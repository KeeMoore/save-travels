
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
    <title>Edit Expense</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow">
                <div class="card-body">
                    <div class="text-center">
                        <h2 class="display-4 mb-3">Edit Expense</h2>
                    </div>
                    <a href="/expenses" class="btn btn-secondary mt-3">Go Back</a>
                    <form:form modelAttribute="expense" action="/expenses/${expense.id}/update" method="post">
                        <input type="hidden" name="_method" value="PUT" />
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
