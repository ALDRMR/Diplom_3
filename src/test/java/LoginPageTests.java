import PageObject.ConstructorPage;
import PageObject.ForgotPasswordPage;
import PageObject.LoginPage;
import PageObject.RegisterPage;
import org.junit.jupiter.api.*;

public class LoginPageTests extends BaseTest {

//    Регистрация
//    Проверь:
//    Успешную регистрацию.
//    Ошибку для некорректного пароля. Минимальный пароль — шесть символов.

//    Вход
//    Проверь:
//    вход по кнопке «Войти в аккаунт» на главной,
//    вход через кнопку «Личный кабинет»,
//    вход через кнопку в форме регистрации,
//    вход через кнопку в форме восстановления пароля.

//    Переход в личный кабинет
//    Проверь переход по клику на «Личный кабинет».

//    Выход из аккаунта
//    Проверь выход по кнопке «Выйти» в личном кабинете.

    private ConstructorPage constructorPage;

    @BeforeEach
    void setUp() {
        constructorPage = new ConstructorPage(driver);
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void shouldGoToLoginPageFromConstructorPage() {
        constructorPage.getLoginToAccountButton().click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isHeaderDisplayed();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»,")
    public void shouldGoToLoginPageFromHeader() {
        constructorPage.clickProfile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isHeaderDisplayed();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации,")
    public void shouldGoToLoginPageFromRegistrationForm() {
        constructorPage.clickProfile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getRegisterButton().click();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getLoginButton().click();
        LoginPage loginPageAgain = new LoginPage(driver);
        loginPageAgain.isHeaderDisplayed();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля.")
    public void shouldGoToLoginPageFromForgotPasswordForm() {
        constructorPage.clickProfile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getForgotPasswordButton().click();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.isHeaderDisplayed();
        forgotPasswordPage.getLoginButton().click();
        LoginPage loginPageAgain = new LoginPage(driver);
        loginPageAgain.isHeaderDisplayed();
    }

    @Test
    @Disabled
    //@DisplayName("Успешную регистрацию.")
    public void shouldLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickProfile();
        loginPage.login("test@yandex.ru","123456");

        ConstructorPage constructorPage = new ConstructorPage(driver);

        Assertions.assertTrue(
                constructorPage.isHeaderDisplayed(),
                "заголовок ConstructorPage не отображается!");
    }

    @Test
    @DisplayName("Ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shouldGetErrorOnShortPassword() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickProfile();
        loginPage.login("test@yandex.ru","12345");

        org.junit.jupiter.api.Assertions.assertTrue(
                loginPage.isPasswordErrorDisplayed(),
                "Сообщение об ошибке пароля не отображается!"
        );

        org.junit.jupiter.api.Assertions.assertEquals(
                "Некорректный пароль",
                loginPage.getPasswordErrorText()
        );
    }
}
