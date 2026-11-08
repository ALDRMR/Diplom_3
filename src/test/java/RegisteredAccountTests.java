import model.User;
import pageobject.*;
import org.junit.jupiter.api.*;

public class RegisteredAccountTests extends BaseTest {

    LoginPage loginPageSecondTime;
    User user;

    @BeforeEach
    void setUp() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickProfile();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getRegisterButton().click();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.isHeaderDisplayed();

        user = new User("123456");
        registerPage.register(user);

        loginPageSecondTime = new LoginPage(driver);
        loginPageSecondTime.isHeaderDisplayed();
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете.")
    public void shouldLogOff() {
        loginPageSecondTime.login(user);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickProfile();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogout();
        LoginPage loginPageThirdTime = new LoginPage(driver);

        Assertions.assertTrue(
                loginPageThirdTime.isHeaderDisplayed(),
                "Тайтл страницы Вход не отображается");
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void shouldGoToLoginPageFromConstructorPage() {
        loginPageSecondTime.clickConstructor();
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.getLoginToAccountButton().click();

        LoginPage loginPageThirdTime = new LoginPage(driver);
        loginPageThirdTime.login(user);

        ConstructorPage constructorPageSecond = new ConstructorPage(driver);
        Assertions.assertTrue(
                !constructorPageSecond.isLoginButtonPresent(),
                "Кнопка Войти в аккаунт отображается, не авторизовались");
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»,")
    public void shouldGoToLoginPageFromHeader() {
        loginPageSecondTime.clickProfile();

        LoginPage loginPageThirdTime = new LoginPage(driver);
        loginPageThirdTime.login(user);

        ConstructorPage constructorPageSecond = new ConstructorPage(driver);
        Assertions.assertTrue(
                !constructorPageSecond.isLoginButtonPresent(),
                "Кнопка Войти в аккаунт отображается, не авторизовались");
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации,")
    public void shouldGoToLoginPageFromRegistrationForm() {
        loginPageSecondTime.getRegisterButton().click();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getLoginButton().click();

        LoginPage loginPageThirdTime = new LoginPage(driver);
        loginPageThirdTime.login(user);

        ConstructorPage constructorPageSecond = new ConstructorPage(driver);
        Assertions.assertTrue(
                !constructorPageSecond.isLoginButtonPresent(),
                "Кнопка Войти в аккаунт отображается, не авторизовались");
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля.")
    public void shouldGoToLoginPageFromForgotPasswordForm() {
        loginPageSecondTime.getForgotPasswordButton().click();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.getLoginButton().click();

        LoginPage loginPageThirdTime = new LoginPage(driver);
        loginPageThirdTime.login(user);

        ConstructorPage constructorPageSecond = new ConstructorPage(driver);
        Assertions.assertTrue(
                !constructorPageSecond.isLoginButtonPresent(),
                "Кнопка Войти в аккаунт отображается, не авторизовались");
    }

}
