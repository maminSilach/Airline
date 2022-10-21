<!DOCTYPE html>
<html lang="eng">
<head>
    <title>Tickets</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous" />
</head>
<body>
<nav class="navbar sticky-top navbar-dark bg-primary">
</nav>
<div class="container">
    <h2> Все зарегистрированные билеты </h2>
    <hr style="height:2px;border:none;color:#333;background-color:#333;" />
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Имя</th>
            <th>Время рейса</th>
            <th>Класс</th>
            <th>Откуда</th>
            <th>Куда</th>
            <th>Цена билета</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="item : ${allTickets}">
            <td th:text="${item.getName}"/>
            <td th:text="${item.getTime}"/>
            <td th:text="${item.getType}"/>
            <td th:text="|${item.getFromCountry} , ${item.getFromCity}|"/>
            <td th:text="|${item.getToCountry} , ${item.getToCity}|"/>
            <td th:text="${item.getPrice}"/>
        </tr>
        </tbody>
    </table>
    <a th:href="@{/airline/admin/}">Назад</a>
</div>
<nav class="navbar fixed-bottom navbar-dark bg-primary">
</nav>
</body>
</html>