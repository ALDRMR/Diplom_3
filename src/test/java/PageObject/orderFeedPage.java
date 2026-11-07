package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderFeedPage extends BasePage {

    private final By orderButton = By.cssSelector("button[class^='button_button'][class*='size_large']");

    public orderFeedPage(WebDriver driver) {
        super(driver);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
