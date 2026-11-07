import PageObject.ConstructorPage;
import PageObject.ForgotPasswordPage;
import PageObject.LoginPage;
import PageObject.RegisterPage;
import org.junit.jupiter.api.*;

public class RegisteredAccountTests extends BaseTest {

//    Регистрация
//    Проверь:
//    Успешную регистрацию.

//    Вход
//    Проверь:
//    вход по кнопке «Войти в аккаунт» на главной,
//    вход через кнопку «Личный кабинет»,
//    вход через кнопку в форме регистрации,
//    вход через кнопку в форме восстановления пароля.

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


}
