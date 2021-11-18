package cloud.autotests.tests.ui;

import cloud.autotests.annotations.JiraIssue;
import cloud.autotests.annotations.JiraIssues;
import cloud.autotests.data.CategoryItem;
import cloud.autotests.pages.MainPage;
import cloud.autotests.pages.RegisterPage;
import cloud.autotests.tests.TestBase;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemowebshopTests extends TestBase {
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-111")})
    void openedCategoryBooksTest() {
        mainPage.openPage()
                .navigateToCategory(CategoryItem.BOOKS)
                .checkOpenedPage("Books");
    }

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-111")})
    void openedCategoryComputersTest() {
        mainPage.openPage()
                .navigateToCategory(CategoryItem.COMPUTERS)
                .checkOpenedPage("Computers");
    }

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-111")})
    void checkBooksQuantityTest() {
        mainPage.openPage()
                .checkOpenedPage("Welcome to our store")
                .navigateToCategory(CategoryItem.BOOKS)
                .checkOpenedPage("Books")
                .checkQuantityItems(6);
    }

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-111")})
    void successfulRegistrationTest() {
        registerPage.openPage()
                    .typeFirstName()
                    .typeLastName()
                    .typeEmail()
                    .typePassword()
                    .typeConfirmPassword()
                    .clickRegisterButton()
                    .checkSuccessfulRegistration();
    }

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-111")})
    void addToCartWithCookieTest() {
        mainPage.openPage();
        step("Делаем запрос на добавление продукта в корзину с куками, проверяем statusCode = 200, success = true", () -> {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1")
                .cookie("Nop.customer=d94dddde-703c-4b1f-97fa-8d2408e218c0;")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                .then()
                .statusCode(200)
                .body("success", is(true));
        });
    }
}
