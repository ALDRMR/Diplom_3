package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Allure;

public class ConstructorPage extends BasePage {

    public static final By CONSTRUCTOR_HEADER = By.xpath("//h1[text()='Соберите бургер']");

    public static final By BUNS_TAB_BUTTON = By.xpath("//div[span[text()='Булки']]");
    public static final By SAUCES_TAB_BUTTON = By.xpath("//div[span[text()='Соусы']]");
    public static final By FILLINGS_TAB_BUTTON = By.xpath("//div[span[text()='Начинки']]");

    public static final By LOGIN_TO_ACCOUNT_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return driver.findElement(CONSTRUCTOR_HEADER).isDisplayed();
    }

    public WebElement getLoginToAccountButton() {
        return driver.findElement(LOGIN_TO_ACCOUNT_BUTTON);
    }

    public WebElement getBunsTabButton() {
        return driver.findElement(BUNS_TAB_BUTTON);
    }

    public WebElement getSaucesTabButton() {
        return driver.findElement(SAUCES_TAB_BUTTON);
    }

    public WebElement getFillingsTabButton() {
        return driver.findElement(FILLINGS_TAB_BUTTON);
    }

    public boolean isTabSelected(WebElement tab) {
        String classAttribute = tab.getAttribute("class");
        return classAttribute != null && classAttribute.contains("tab_tab_type_current");
    }

    @Step("Перейти на вкладку Булки")
    public void clickBuns() {
        if (!isTabSelected(getBunsTabButton())) {
            getBunsTabButton().click();
        } else {
            Allure.step("Вкладка Булки уже выбрана, кнопка не активна");
        }
    }

    @Step("Перейти на вкладку Соусы")
    public void clickSauces() {
        if (!isTabSelected(getSaucesTabButton())) {
            getSaucesTabButton().click();
        } else {
            Allure.step("Вкладка Соусы уже выбрана, кнопка не активна");
        }
    }

    @Step("Перейти на вкладку Начинки")
    public void clickFillings() {
        if (!isTabSelected(getFillingsTabButton())) {
            getFillingsTabButton().click();
        } else {
            Allure.step("Вкладка Начинки уже выбрана, кнопка не активна");
        }
    }

    public boolean isLoginButtonPresent() {
        return !driver.findElements(LOGIN_TO_ACCOUNT_BUTTON).isEmpty()
                && driver.findElement(LOGIN_TO_ACCOUNT_BUTTON).isDisplayed();
    }

}
