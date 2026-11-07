import PageObject.ConstructorPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("Раздел «Конструктор», переходы по вкладкам Булки Соусы Начинки")
    public void shouldChangeConstructorTabs() {

        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickConstructor();

        constructorPage.clickFillings();
        assertTrue(constructorPage.isSelected(constructorPage.getFillingsTab()),
                "Вкладка Начинки не выбрана после клика");

        constructorPage.clickSauces();
        assertTrue(constructorPage.isSelected(constructorPage.getSaucesTab()),
                "Вкладка Соусы не выбрана после клика");

        constructorPage.clickBuns();
        assertTrue(constructorPage.isSelected(constructorPage.getBunsTab()),
                "Вкладка Булки не выбрана после клика");

    }

}
