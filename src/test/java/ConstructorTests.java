import pageobject.ConstructorPage;
import pageobject.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void shouldGoToConstructorOnConstructorClick() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickProfile();

        loginPage.clickConstructor();

        ConstructorPage constructorPage = new ConstructorPage(driver);

        Assertions.assertTrue(
                constructorPage.isHeaderDisplayed(),
                "заголовок ConstructorPage не отображается!");
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers.")
    public void shouldGoToConstructorOnLogoClick() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickProfile();

        loginPage.clickLogo();

        ConstructorPage constructorPage = new ConstructorPage(driver);

        Assertions.assertTrue(
                constructorPage.isHeaderDisplayed(),
                "заголовок ConstructorPage не отображается!");
    }

    @Test
    @DisplayName("Раздел «Конструктор», переходы по вкладкам Булки Соусы Начинки")
    public void shouldChangeConstructorTabs() {

        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickConstructor();

        constructorPage.clickFillings();
        assertTrue(
                constructorPage.isTabSelected(constructorPage.getFillingsTab()),
                "Вкладка Начинки не выбрана после клика");

        constructorPage.clickSauces();
        assertTrue(
                constructorPage.isTabSelected(constructorPage.getSaucesTab()),
                "Вкладка Соусы не выбрана после клика");

        constructorPage.clickBuns();
        assertTrue(
                constructorPage.isTabSelected(constructorPage.getBunsTab()),
                "Вкладка Булки не выбрана после клика");

    }

}
