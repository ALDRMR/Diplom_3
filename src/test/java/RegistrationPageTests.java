import model.User;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import org.junit.jupiter.api.*;

public class RegistrationPageTests extends BaseTest {

    private ConstructorPage constructorPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @BeforeEach
    void setUp() {
        constructorPage = new ConstructorPage(driver);
        constructorPage.clickProfile();
        loginPage = new LoginPage(driver);
        loginPage.getRegisterButton().click();
        registerPage = new RegisterPage(driver);
        registerPage.isHeaderDisplayed();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void shouldRegister() {

        User user = new User("123456");
        registerPage.register(user);

        LoginPage loginPageAgain = new LoginPage(driver);

        Assertions.assertTrue(
                loginPageAgain.isHeaderDisplayed(),
                "Тайтл страницы Вход не отображается");
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shouldGetErrorOnShortPassword() {

        User user = new User("12345");
        registerPage.register(user);

        Assertions.assertTrue(
                registerPage.isPasswordErrorDisplayed(),
                "Сообщение об ошибке пароля не отображается!");
        Assertions.assertEquals(
                "Некорректный пароль",
                registerPage.getPasswordErrorText());
    }

}
