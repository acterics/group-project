#Group Project

##Сервисы

### [Config Service](./config) (**IN DOCKER-COMPOSE**)
Сервис запускаеться первым и раздает конфиг 
файлы всем остальным сервисам.
Конфиги должны быть в отдельном репозитории, 
но для удобства разработки на данный момент они в локальные

### [Registry Service](./registry) (**IN DOCKER-COMPOSE**)
Запускаеться сразу после конфига и только после него запускаються
остальные сервисы, которые будут зарегестрированы в текущем.
[Eureka Github](https://github.com/Netflix/eureka)

[Eureka Spring Docs](https://spring.io/blog/2015/01/20/microservice-registration-and-discovery-with-spring-cloud-and-netflix-s-eureka)

### [Auth Service](./auth-server) `DEVELOPING`

OAuth2 Server

### [Gateway Service](./api-gateway) (**IN DOCKER-COMPOSE**)
Сервис с которым взаимодействует клиент, проксирует все запросы к
остальным сервисам или формирует сложный ответ обращаясь к нескльким сервисам

### [Product Service](./product-service) (**IN DOCKER-COMPOSE**)
Сервис работающий с товарами

### [User service](./user-service)
Сервис работающий а аккаунтами пользователей

### [Ordering service](./ordering-service)
Сервис обрабатывающий флоу `Order` => `Purchase` => `Delivery`


## Запуск системы

### Docker
`Docker version 17.09.0-ce, build afdb6d4`

`docker-compose version 1.17.0, build ac53b73`

[Docker Install](https://docs.docker.com/engine/installation/)

[Docker Compose Install](https://docs.docker.com/compose/install/)

* Делаем форк репозитория
* Создаём свою ветку из `dev`
* Билдим исходники
    - При наличии Gradle 4.3.1
    
       `gradle build`
    - Без Gradle
    
       Делаем файл `gradlew` исполняемым
       
       `./gradlew build`
* Создаем в корне файл `.env`
* Заносим значения констант из `.env-example`
* Запускаем Docker Compose

    `docker-compose up --build`   
* Запуск отдельного сервиса
    
    `docker-compose up --build <service-name>`
    
    `service-name` можно найти в [`docker-compose.yml`](docker-compose.yml)
    
    при заупуске отдельного сервиса нужно учитывать его конфиг `depends-on`

* Разрабатываем
* Делаем пул-реквест в `dev`

_Запустяться только те сервисы, которые отмечены как **IN DOCKER-COMPOSE**_


### Локальный запуск
Gradle 4.3.1

[Gradle Install](https://gradle.org/install/)

* Делаем форк из репозитория
* Создаем свою ветку из `dev-local`
* 
    - Запуск вместе с конфиг сервером
    
        Заходим в [директорию конфигов](config/src/main/resources/configs)
        
        Изменяем все переменные среды на локальные(значения ваших локальных переменных
         не должны будут попасть в коммит)
         
        `gradle :config:bootRun`
        
        `gradle :<module-name>:bootRun` 
    
    - Запуск без конфиг сервера()
    
        Переносим содержимое нужного конфига в  
        [директории конфигов](config/src/main/resources/configs)
        к соответствующему `bootstrap.yml` в _<module-name>/src/main/resources/_    
        (В пул реквесте все должно быть на своих местах)
        
        `gradle :<module-name>:bootRun`
* Разрабатываем
* Делаем пул реквест в `dev-local`



