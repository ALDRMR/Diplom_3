package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final WebDriver driver;

    private final By constructorButton = By.xpath("//nav//a[contains(., 'Конструктор')]");
    private final By orderFeedButton = By.xpath("//nav//a[contains(., 'Лента Заказов')]");
    private final By profileButton = By.xpath("//nav//a[contains(., 'Личный Кабинет')]");

    private final By logoButton = By.cssSelector("div[class^='AppHeader_header__logo'] > a");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    public void clickOrderFeed() {
        driver.findElement(orderFeedButton).click();
    }

    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    public void clickPersonalAccount() {
        driver.findElement(profileButton).click();
    }
}
