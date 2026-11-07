package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public static final By EMAIL_FIELD = By.xpath("//input[@name='name']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@name='Пароль']");
    public static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        super(driver);
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

    public void login(String email, String password) {
        getEmailField().clear();
        getEmailField().sendKeys(email);

        getPasswordField().clear();
        getPasswordField().sendKeys(password);

        getLoginButton().click();
    }

    public static final By PASSWORD_ERROR_MESSAGE = By.cssSelector("p.input__error");

        public boolean isPasswordErrorDisplayed() {
        try {
            return driver.findElement(PASSWORD_ERROR_MESSAGE).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String getPasswordErrorText() {
        return driver.findElement(PASSWORD_ERROR_MESSAGE).getText();
    }


}
