package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends BasePage {

    public static final By BUNS_TAB = By.xpath("//div[span[text()='Булки']]");
    public static final By SAUCES_TAB = By.xpath("//div[span[text()='Соусы']]");
    public static final By FILLINGS_TAB = By.xpath("//div[span[text()='Начинки']]");

    public static final By ACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab_type_current')]");
    public static final By ACTIVE_TAB_TEXT = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

}
