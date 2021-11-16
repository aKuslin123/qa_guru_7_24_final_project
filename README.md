# Автотесты для сайтов
### UI - http://demowebshop.tricentis.com
### API - https://reqres.in 
___
## Используемые технологии и инструменты
![Intelij_IDEA](img/icons/Intelij_IDEA.png)![Java](img/icons/Java.png)![Selenide](img/icons/Selenide.png)![Selenoid](img/icons/Selenoid.png)![Gradle](img/icons/Gradle.png)![JUnit5](img/icons/JUnit5.png)![Allure Report](img/icons/Allure_Report.png)![AllureTestOps](img/icons/AllureTestOps.png)![Github](img/icons/Github.png)![Jenkins](img/icons/Jenkins.png)![Rest-Assured](img/icons/Rest-Assured.png)![Telegram](img/icons/Telegram.png)![Jira](img/icons/Jira.png)
___

## Для запуска автотестов используется Jenkins.

##### Примеры готовых сборок можно посмотреть [по ссылке](https://jenkins.autotests.cloud/job/C07-AlexeyKuslin-24_final_project/)

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

___
## Оповещение о результатах прохождения тестов происходит через бот в телеграм

#### После прохождения всех тестов, приходит отчет в канал в телеграме:
![Telegram](img/Telegram.png)

___

## Анализ результатов

Более подробно с результатми тестов (шаги, скриншоты, видео прохождения теста, page source и browser console log) можно ознакомиться:
* В Jenkins через Allure Reports (перейти по ссылке в отчете телеграм)
* В Allure TestOps.

https://github.com/A3211/qa_guru_5_11_quick_project
___

## Анализ результатов в Jenkins через Allure Reports

![Jenkins_Allure_Reports](./img/Jenkins_Allure_Reports.png)

---

## Анализ результатов в Allure TestOps

![Allure TestOps](./img/Allure_TestOps.png)

---

### Видео прохождения теста, взятое из среды выполнения (из Selenoid)

![video](./img/video.gif)