package pageobject;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public static final By LOGIN_HEADER = By.xpath("//h2[text()='Вход']");

    public static final By EMAIL_FIELD = By.xpath("//input[@name='name']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@name='Пароль']");
    public static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");

    public static final By REGISTER_BUTTON = By.xpath("//a[text()='Зарегистрироваться']");
    public static final By FORGOT_PASSWORD_BUTTON = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return driver.findElement(LOGIN_HEADER).isDisplayed();
    }

    public WebElement getEmailField() {
        return driver.findElement(EMAIL_FIELD);
    }

    public WebElement getPasswordField() {
        return driver.findElement(PASSWORD_FIELD);
    }

    public WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }

    public WebElement getRegisterButton() {
        return driver.findElement(REGISTER_BUTTON);
    }

    public WebElement getForgotPasswordButton() {
        return driver.findElement(FORGOT_PASSWORD_BUTTON);
    }

    public void login(User user) {
        getEmailField().clear();
        getEmailField().sendKeys(user.getEmail());

        getPasswordField().clear();
        getPasswordField().sendKeys(user.getPassword());

        getLoginButton().click();
    }

}
