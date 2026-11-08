package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public static final By PROFILE_TAB = By.xpath("//a[text()='Профиль']");

    public static final By LOGOUT_BUTTON = By.xpath("//button[text()='Выход']");

    public static final By NAME_FIELD = By.xpath("//div[label[text()='Имя']]/input");
    public static final By LOGIN_FIELD = By.xpath("//div[label[text()='Логин']]/input");
    public static final By PASSWORD_FIELD = By.xpath("//div[label[text()='Пароль']]/input");

    @Step("Клик по кнопке Выход в личном кабинете")
    public void clickLogout() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

}
