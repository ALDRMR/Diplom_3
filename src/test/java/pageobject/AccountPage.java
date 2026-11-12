package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public static final By LOGOUT_BUTTON = By.xpath("//button[text()='Выход']");

    @Step("Клик по кнопке Выход в личном кабинете")
    public void clickLogout() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

}
