package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage{

    public static final By REGISTER_HEADER = By.xpath("//h2[text()='Регистрация']");

    public static final By NAME_FIELD = By.xpath("//div[label[text()='Имя']]/input");
    public static final By EMAIL_FIELD = By.xpath("//div[label[text()='Email']]/input");
    public static final By PASSWORD_FIELD = By.xpath("//input[@name='Пароль']");
    public static final By REGISTER_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    public static final By LOGIN_BUTTON = By.cssSelector("a[href='/login']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return driver.findElement(REGISTER_HEADER).isDisplayed();
    }

    public WebElement getNameField() {
        return driver.findElement(NAME_FIELD);
    }

    public WebElement getEmailField() {
        return driver.findElement(EMAIL_FIELD);
    }

    public WebElement getPasswordField() {
        return driver.findElement(PASSWORD_FIELD);
    }

    public WebElement getRegisterButton() {
        return driver.findElement(REGISTER_BUTTON);
    }

    public WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }

    public void register(String name, String email, String password) {
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getRegisterButton().click();
    }

}
