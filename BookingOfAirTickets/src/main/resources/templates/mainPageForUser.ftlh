
<html>
<head>
    <title>Airline</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous" />
</head>
<style>
h2{
    color: black;
text-align: center;
}
h3{
    color: black;
    text-align: center;
}
</style>
<body >
    <nav class="navbar sticky-top navbar-dark bg-primary">
    </nav>

    <h2> Приветствуем вас в Airline</h2>
    <h3 th:if="${session.login} != 'anonymousUser'"> <a href="/airline/logout" class="btn btn-primary">Выйти</a> </h3>
    <h3 th:if="${session.login} == 'anonymousUser'"> <a href="airline/login" class="btn btn-primary">Войти</a></h3>
    <hr style="height:2px;border:none;color:#333;background-color:#333;" />
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="card text-center">
            <div class="card-header border-dark">
                Рекомендуемые
            </div>
            <div class="card-body">
                <h5 class="card-title">Все рейсы</h5>
                <p class="card-text">Узнать о всех рейсах, которые уже забронированны </p>
                <a href="flights" class="btn btn-primary">Перейти</a>
            </div>
            <div class="card-footer text-muted"></div>
        </div>
        <div class="card border-primary text-center">
            <div class="card-header ">
                Рекомендуемые
            </div>
            <div class="card-body">
                <h5 class="card-title">Забронировать рейс</h5>
                <p class="card-text">Узнать о всех рейсах, который доступны для брони</p>
                <a href="reserveFlight" class="btn btn-primary">Перейти</a>
            </div>
            <div class="card-footer text-muted"></div>
        </div>
        <div class="card text-center">
            <div class="card-header border-dark">
                Рекомендуемые
            </div>
            <div class="card-body">
                <h5 class="card-title">Мои билеты</h5>
                <p class="card-text">Узнать о рейсе, который вы уже забронировали</p>
                <a href="infoAboutReserve" class="btn btn-primary">Перейти</a>
            </div>
            <div class="card-footer text-muted"></div>
        </div>
    </div>

    <nav class="navbar fixed-bottom navbar-dark bg-primary">
    </nav>

</body>
</html>