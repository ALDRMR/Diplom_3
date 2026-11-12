package pageobject;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    private void selectTab(By tabLocator, String tabName) {
        WebElement tab = driver.findElement(tabLocator);
        if (!isTabSelected(tab)) {
            tab.click();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.attributeContains(tabLocator, "class", "tab_tab_type_current"));
        } else {
            Allure.step("Вкладка " + tabName + " уже выбрана, кнопка не активна");
        }
    }

    @Step("Перейти на вкладку Булки")
    public void clickBuns() {
        selectTab(BUNS_TAB_BUTTON, "Булки");
    }

    @Step("Перейти на вкладку Соусы")
    public void clickSauces() {
        selectTab(SAUCES_TAB_BUTTON, "Соусы");
    }

    @Step("Перейти на вкладку Начинки")
    public void clickFillings() {
        selectTab(FILLINGS_TAB_BUTTON, "Начинки");
    }

    public boolean isLoginButtonPresent() {
        return !driver.findElements(LOGIN_TO_ACCOUNT_BUTTON).isEmpty()
                && driver.findElement(LOGIN_TO_ACCOUNT_BUTTON).isDisplayed();
    }

}
