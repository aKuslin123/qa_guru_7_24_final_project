# Автотесты для сайтов
### UI - http://demowebshop.tricentis.com
### API - https://reqres.in 
___
## Используемые технологии и инструменты
![Intelij_IDEA](img/icons/Intelij_IDEA.png)![Java](img/icons/Java.png)![Selenide](img/icons/Selenide.png)![Selenoid](img/icons/Selenoid.png)![Gradle](img/icons/Gradle.png)![JUnit5](img/icons/JUnit5.png)![Allure Report](img/icons/Allure_Report.png)![AllureTestOps](img/icons/AllureTestOps.png)![Github](img/icons/Github.png)![Jenkins](img/icons/Jenkins.png)![Rest-Assured](img/icons/Rest-Assured.png)![Telegram](img/icons/Telegram.png)![Jira](img/icons/Jira.png)
___

## Для запусков автотестов используется Jenkins.

##### Примеры готовых сборок можно посмотреть [по ссылке](https://jenkins.autotests.cloud/job/07-antonina1901-mcdonalds/)

### Используемые параметры по умолчанию

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)

![Jenkins](./img/Jenkins.png)

Run tests with filled remote.properties:

```bash
gradle clean test
```

Run tests with not filled remote.properties:

```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:

```bash
allure serve build/allure-results
```

### Анализ результатов в Jenkins через Allure Reports

![Jenkins_Allure_Reports](./img/Jenkins_Allure_Reports.png)

### Для отображения результатов сборок используется Allure TestOps.

##### Примеры запусков и их результаты можно посмотреть [по ссылке](https://allure.autotests.cloud/project/564/dashboards)

### Пример списка тестов в Allure TestOps

![Allure TestOps](./img/Allure_TestOps.png)

### Пример прохождения тестов в Allure TestOps

![Allure Reports](./img/Allure_Reports.png)

### Результаты запусков Launches в Allure TestOps

![Allure_Launches](./img/Allure_Launches.png)

### Анализ результатов в Allure TestOps

![Allure TestOps_Results](./img/Allure_TestOps_Results.png)

### Основной Dashboards

![Allure Dashboards](img/Allure_Dashboards.png)

### Dashboards по разным типам тестов

![Allure Dashboards_Automation](./img/Allure_Dashboards_Automation.png)

### Dashboards по команде

![Allure Dashboards_Team](./img/Allure_Dashboards_Team.png)

### Добавлена интеграция с Jira, где можно посмотреть запускаемые кейсы и их результаты.

##### Перейти в Jira можно [по ссылке](https://jira.autotests.cloud/browse/HOMEWORK-256)

![Jira](./img/Jira.png)

### После прохождения тестов в telegram канал приходит оповещение с результами.

##### Перейти в telegram канал можно [по ссылке](https://t.me/joinchat/sMZ0AnmoWmVhNDVi)

![Telegram](img/Telegram.png)

### Пример прохождения тестов можно посмотреть на видео

![video](./img/video.gif)