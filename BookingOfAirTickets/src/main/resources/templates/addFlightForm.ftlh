<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Add</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous" />
</head>
<body>
<div class="container">
    <nav class="navbar sticky-top navbar-dark bg-primary">
    </nav>
    <h2> Добавить рейс </h2>
    <hr style="height:2px;border:none;color:#333;background-color:#333;" />
    <form th:action="@{/airline/admin/saveFlight}"
          th:object="${flights}" method="POST">
        <table>
        <input type="hidden" th:field="*{id}" id="id">
        <input type="text" th:field="*{fromCountry}" class="form-control col-4 mb-4" placeholder="Из какой страны" />
            <p class="alert alert-danger" th:if="${#fields.hasErrors('fromCountry')}" th:errors="*{fromCountry}"></p>
        <input type="text" th:field="*{fromCity}" class="form-control col-4 mb-4" placeholder="Из какого города"/>
            <p class="alert alert-danger" th:if="${#fields.hasErrors('fromCity')}" th:errors="*{fromCity}"></p>
        <input type="text" th:field="*{toCountry}" class="form-control col-4 mb-4" placeholder="В какую страну"/>
            <p class="alert alert-danger" th:if="${#fields.hasErrors('toCountry')}" th:errors="*{fromCity}"></p>
        <input type="text" th:field="*{toCity}" class="form-control col-4 mb-4" placeholder="В какой город"/>
            <p class="alert alert-danger" th:if="${#fields.hasErrors('toCity')}" th:errors="*{toCity}"></p>
        <input type="text" th:field="*{type}" class="form-control col-4 mb-4" placeholder="Класс"/>
            <p class="alert alert-danger" th:if="${#fields.hasErrors('type')}" th:errors="*{type}"></p>
        <input type="text" th:field="*{time}" class="form-control col-4 mb-4" placeholder="Время вылета"/>
            <p class="alert alert-danger" th:if="${#fields.hasErrors('time')}" th:errors="*{time}"></p>
        <input type="text" th:field="*{price}" class="form-control col-4 mb-4" placeholder="Цена билета" />
            <p class="alert alert-danger" th:if="${#fields.hasErrors('price')}" th:errors="*{price}"></p>
        <input type="submit" value="Далее" />
        </table>
    </form>
</div>
<nav class="navbar fixed-bottom navbar-dark bg-primary">
</nav>

</body>
</html>