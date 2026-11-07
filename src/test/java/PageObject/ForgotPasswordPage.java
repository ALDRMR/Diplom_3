package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    public static final By RESTORE_PASSWORD_HEADER = By.xpath("//h2[text()='Восстановление пароля']");
    public static final By LOGIN_BUTTON = By.cssSelector("a[href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return driver.findElement(RESTORE_PASSWORD_HEADER).isDisplayed();
    }

    public WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }

}
