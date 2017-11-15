# Электронная Школа
Веб-сайт проект "Электронная Школа".

Можно зарегистрироваться и зайти на страницу с учениками. Можно добавлять/удалять учеников.
Если Вы выключите сервер, база данных пользователей и учеников не сохранится (т.к. БД встроенная - HSQLDB).

Проект использует:
* Spring Boot
* Spring Web
* Spring Security
* Spring Security BCryptPasswordEncoder
* Spring Validator
* HSQLDB
* MyBatis
* jQuery
* Bootstrap
* TestNG

Скрипт для автоматического создания БД находится в `./src/main/resources/import.sql`.

# Вам необходимо:
* Java SDK 8 
* Maven 3.5.2 или выше

# Установка и запуск:
Команда: `mvn spring-boot:run`

После запуска сервера, заходим в браузер по адресу:

`http://localhost:8080`

# Тесты:
Пока один простой тест на основе TestNG.

Команда: `mvn test`