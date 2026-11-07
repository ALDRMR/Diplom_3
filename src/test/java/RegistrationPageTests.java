import PageObject.ConstructorPage;
import PageObject.LoginPage;
import PageObject.RegisterPage;
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
    @DisplayName("Успешную регистрацию.")
    public void shouldRegister() {

        registerPage.register("TESTER","test@yandex.ru","123456");

        ConstructorPage constructorPageAgain = new ConstructorPage(driver);

        Assertions.assertTrue(
                constructorPageAgain.isHeaderDisplayed(),
                "заголовок ConstructorPage не отображается, переход после регистрации не осуществлён");
    }

    @Test
    @DisplayName("Ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shouldGetErrorOnShortPassword() {
        registerPage.register("TESTER","test@yandex.ru","123");

        org.junit.jupiter.api.Assertions.assertTrue(
                registerPage.isPasswordErrorDisplayed(),
                "Сообщение об ошибке пароля не отображается!"
        );

        org.junit.jupiter.api.Assertions.assertEquals(
                "Некорректный пароль",
                registerPage.getPasswordErrorText()
        );
    }

}
