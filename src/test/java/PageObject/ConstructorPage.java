package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorPage extends BasePage {

    public static final By CONSTRUCTOR_HEADER = By.xpath("//h1[text()='Соберите бургер']");

    public static final By BUNS_TAB = By.xpath("//div[span[text()='Булки']]");
    public static final By SAUCES_TAB = By.xpath("//div[span[text()='Соусы']]");
    public static final By FILLINGS_TAB = By.xpath("//div[span[text()='Начинки']]");

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

    public WebElement getBunsTab() {
        return driver.findElement(BUNS_TAB);
    }

    public WebElement getSaucesTab() {
        return driver.findElement(SAUCES_TAB);
    }

    public WebElement getFillingsTab() {
        return driver.findElement(FILLINGS_TAB);
    }

    public boolean isTabSelected(WebElement tab) {
        return tab.getAttribute("class").contains("noselect");
    }

    public void clickBuns() {
        if (isTabSelected(getBunsTab())) {
            getBunsTab().click();
        }
    }

    public void clickSauces() {
        if (isTabSelected(getSaucesTab())) {
            getSaucesTab().click();
        }
    }

    public void clickFillings() {
        if (isTabSelected(getFillingsTab())) {
            getFillingsTab().click();
        }
    }

}
