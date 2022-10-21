<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Registration</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous" />
</head>
<body>
<nav class="navbar sticky-top navbar-dark bg-primary">
</nav>
<div class="container">
    <h2> Регистрация </h2>
    <hr style="height:2px;border:none;color:#333;background-color:#333;" />
    <form th:action="@{/airline/registration}" method="POST" th:object="${user}">
        <input type="text" name="name" class="form-control col-4 mb-4" placeholder="Имя" />
        <p class="alert alert-danger" th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></p>
        <input type="text" name="email" class="form-control col-4 mb-4" placeholder="Почта" />
        <p class="alert alert-danger" th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></p>
        <input type="text" name="password" class="form-control col-4 mb-4" placeholder="Пароль" />
        <p class="alert alert-danger" th:if="${#fields.hasErrors('password')}" th:errors="*{password}"></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit" > Зарегистрироваться </button>
    </form>
</div>
<nav class="navbar fixed-bottom navbar-dark bg-primary">
</nav>
</body>
</html>