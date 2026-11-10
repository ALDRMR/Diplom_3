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
    @DisplayName("Раздел «Конструктор», переход на вкладку Булки (по умолчанию активная)")
    public void shouldSelectBunsTab() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        // При переходе на Конструктор по умолчанию вкладка Булки
        constructorPage.clickFillings();
        constructorPage.clickBuns();

        assertTrue(
                constructorPage.isTabSelected(constructorPage.getBunsTabButton()),
                "Вкладка Булки не выбрана после клика");
    }


    @Test
    @DisplayName("Раздел «Конструктор», переход на вкладку Соусы")
    public void shouldSelectSaucesTab() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSauces();

        assertTrue(
                constructorPage.isTabSelected(constructorPage.getSaucesTabButton()),
                "Вкладка Соусы не выбрана после клика");
    }

    @Test
    @DisplayName("Раздел «Конструктор», переход на вкладку Начинки")
    public void shouldSelectFillingsTab() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickFillings();

        assertTrue(
                constructorPage.isTabSelected(constructorPage.getFillingsTabButton()),
                "Вкладка Начинки не выбрана после клика");
    }

}
