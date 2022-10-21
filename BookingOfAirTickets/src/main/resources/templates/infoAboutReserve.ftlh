<!DOCTYPE html>
<html lang="eng">
<head>
    <title>Info</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous" />
</head>
<body>
<div class="container">
    <h2> Ваши забронированные билеты </h2>
    <nav class="navbar sticky-top navbar-dark bg-primary">
    </nav>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Время рейса</th>
            <th>Класс</th>
            <th>Откуда</th>
            <th>Куда</th>
            <th>Цена билета</th>
        </tr>
        </thead>
        <tbody>
            <td th:text="${reserveFlights.getTime}"/>
            <td th:text="${reserveFlights.getType}"/>
            <td th:text="|${reserveFlights.getFromCountry} , ${reserveFlights.getFromCity}|"/>
            <td th:text="|${reserveFlights.getToCountry} , ${reserveFlights.getToCity}|"/>
            <td th:text="${reserveFlights.getPrice}"/>
            <td>
                <a th:href="@{/airline/cancel{id}(id=${reserveFlights.getId})}" class="btn btn-danger ml-2">Отменить</a>
            </td>
        </tr>
        </tbody>
    </table>
    <a th:href="@{/airline/}">Назад</a>
</div>

<nav class="navbar fixed-bottom navbar-dark bg-primary">
</nav>
</body>
</html>