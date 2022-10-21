<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Login</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous" />
</head>
<body>
<nav class="navbar sticky-top navbar-dark bg-primary">
</nav>
<div class="h-100 d-flex align-items-center justify-content-center">
<div class="container" style="">
    <h2 style="text-align: center"> Вход </h2>
    <hr style="height:2px;border:none;color:#333;background-color:#333;" />
    <form  th:action="@{/airline/login}" method="post">
      <input type="text" name="username" class="form-control col-4 mb-4" placeholder="Почта" />
        <input type="text" name="password" class="form-control col-4 mb-4" placeholder="Пароль" />
          <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit" > Вход </button>
    </form>
    <p>Нет аккаунта? <a href="registration"> Зарегистрироваться </a> </p>
</div>
    </div>






<nav class="navbar fixed-bottom navbar-dark bg-primary">
</nav>
</body>
</html>