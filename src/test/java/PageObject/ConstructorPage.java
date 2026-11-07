package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorPage extends BasePage {

    public static final By BUNS_TAB = By.xpath("//div[span[text()='Булки']]");
    public static final By SAUCES_TAB = By.xpath("//div[span[text()='Соусы']]");
    public static final By FILLINGS_TAB = By.xpath("//div[span[text()='Начинки']]");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBunsTab() {
        return driver.findElement(BUNS_TAB);
    }

    public WebElement getSaucesTab() {
        return driver.findElement(SAUCES_TAB);
    }

    public WebElement getFillingsTab() {
        return driver.findElement(FILLINGS_TAB);
    }

    public boolean isSelected(WebElement tab) {
        return tab.getAttribute("class").contains("noselect");
    }

    public void clickBuns() {
        if (isSelected(getBunsTab())) {
            getBunsTab().click();
        }
    }

    public void clickSauces() {
        if (isSelected(getSaucesTab())) {
            getSaucesTab().click();
        }
    }

    public void clickFillings() {
        if (isSelected(getFillingsTab())) {
            getFillingsTab().click();
        }
    }

}
