package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final WebDriver driver;

    private final By constructorButton = By.cssSelector("nav a[href='/']:has(p)");
    private final By orderFeedButton = By.cssSelector("a[href='/feed']");
    private final By logo = By.cssSelector("div[class*='logo'] a");
    private final By personalAccountButton = By.cssSelector("a[href='/account']");

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
        driver.findElement(logo).click();
    }

    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }
}
