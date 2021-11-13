package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage {
    Faker faker = new Faker();

    String userName = faker.name().firstName();
    String userLastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userPassword = "Test123456";

    private SelenideElement firstName = $("#FirstName");
    private SelenideElement lastName = $("#LastName");
    private SelenideElement email = $("#Email");
    private SelenideElement password = $("#Password");
    private SelenideElement confirmPassword = $("#ConfirmPassword");
    private SelenideElement registerButton = $("#register-button");
    private SelenideElement resultPage = $(".result");

    private SelenideElement myAccount = $(".header-links").$(".account");

    @Step("Открываем страницу регистрации")
    public RegisterPage openPage() {
        open("http://demowebshop.tricentis.com/register");
        $(".page-title").shouldHave(Condition.text("Register"));
        return this;
    }

    @Step("Вводим имя")
    public RegisterPage typeFirstName() {
        firstName.setValue(userName);
        return this;
    }

    @Step("Вводим фамилию")
    public RegisterPage typeLastName() {
        lastName.setValue(userLastName);
        return this;
    }

    @Step("Вводим емаил")
    public RegisterPage typeEmail() {
        email.setValue(userEmail);
        return this;
    }

    @Step("Вводим пароль")
    public RegisterPage typePassword() {
        password.setValue(userPassword);
        return this;
    }

    @Step("Вводим подтверждение пароля")
    public RegisterPage typeConfirmPassword() {
        confirmPassword.setValue(userPassword);
        return this;
    }

    @Step("Жмем на кнопку [Register]")
    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return this;
    }

    @Step("Переходим в личный кабинет созданного пользователя, проверяем, что Имя, Фамилия, Емаил верны")
    public RegisterPage checkSuccessfulRegistration() {
        resultPage.shouldHave(Condition.text("Your registration completed"));
        myAccount.click();
        firstName.shouldHave(Condition.value(userName));
        lastName.shouldHave(Condition.value(userLastName));
        email.shouldHave(Condition.value(userEmail));
        return this;
    }
}
