package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final WebDriver driver;

    private final By CONSTRUCTOR_BUTTON = By.xpath("//nav//a[contains(., 'Конструктор')]");
    private final By ORDER_FEED_BUTTON = By.xpath("//nav//a[contains(., 'Лента Заказов')]");
    private final By ACCOUNT_BUTTON = By.xpath("//nav//a[contains(., 'Личный Кабинет')]");

    private final By LOGO_BUTTON = By.cssSelector("div[class^='AppHeader_header__logo'] > a");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructor() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    public void clickOrderFeed() {
        driver.findElement(ORDER_FEED_BUTTON).click();
    }

    public void clickLogo() {
        driver.findElement(LOGO_BUTTON).click();
    }

    public void clickProfile() {
        driver.findElement(ACCOUNT_BUTTON).click();
    }
}
