# DEMO WEB SERVICE (SOAP)

Пример реализации SOAP веб-сервиса с использованием Spring Web Services.

Модули:

1. __producing-web-service__ </br>

SOAP сервис. Предоставляет информацию о столице, валюте и населению страны по ее названию.
 
Описание сервиса доступно после его старта по ссылке: http://localhost:8081/ws/countries.wsdl  

2. __consuming-web-service__ </br>

REST сервис. Сервис представляет собой REST прослойку для обращения к SOAP сервису.

Пример запроса:

```
http://localhost:8082/country?&name=Spain
```

Пример ответа:

```json
{
  "name": "Spain",
  "population": 46704314,
  "capital": "Madrid",
  "currency": "EUR"
}
```






