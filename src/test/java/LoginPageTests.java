import pageobject.ConstructorPage;
import pageobject.LoginPage;
import org.junit.jupiter.api.*;

public class LoginPageTests extends BaseTest {

    private ConstructorPage constructorPage;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        constructorPage = new ConstructorPage(driver);
        constructorPage.clickProfile();
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет».")
    public void shouldLogin() {
        loginPage.isHeaderDisplayed();
    }

}
