package cloud.autotests.pages;

import cloud.autotests.data.CategoryItem;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement categorySideBar = $(".listbox");
    private SelenideElement pageBody = $(".page");
    private ElementsCollection productItems = pageBody.$$(".product-item");

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("http://demowebshop.tricentis.com/");
        return this;
    }

    @Step("Проверяем что страница открыта")
    public MainPage checkOpenedPage (String text) {
        pageBody.shouldHave(Condition.text(text));
        return this;
    }

    @Step("Переходим в категорию")
    public MainPage navigateToCategory (CategoryItem categoryName) {
        categorySideBar.find(byText(categoryName.getDisplayedName())).click();
        return this;
    }

    @Step("Проверяем кол-во айтемов на странице")
    public MainPage checkQuantityItems (int quantity) {
        productItems.shouldHave(CollectionCondition.size(quantity));
        return this;
    }
}