package pageobject;

import io.qameta.allure.Step;
import model.User;
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

    public static final By PASSWORD_ERROR_MESSAGE = By.xpath("//p[text()='Некорректный пароль']");

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

    @Step("Проверить отображение текста Некорректный пароль")
    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(PASSWORD_ERROR_MESSAGE).isDisplayed();
    }

    public String getPasswordErrorText() {
        return driver.findElement(PASSWORD_ERROR_MESSAGE).getText();
    }

    @Step("Зарегистрировать пользователя: имя={user.name}, email={user.email}")
    public void register(User user) {
        getNameField().sendKeys(user.getName());
        getEmailField().sendKeys(user.getEmail());
        getPasswordField().sendKeys(user.getPassword());
        getRegisterButton().click();
    }

}
