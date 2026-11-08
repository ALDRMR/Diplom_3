import io.qameta.allure.Step;
import model.User;
import pageobject.*;
import org.junit.jupiter.api.*;

public class RegisteredAccountTests extends BaseTest {

    private User user;
    private LoginPage loginPage;
    private ConstructorPage constructorPage;

    @BeforeEach
    void setUp() {
        constructorPage = new ConstructorPage(driver);
        constructorPage.clickProfile();

        user = new User("123456");
        createUserWithAPI(user);

        loginPage = new LoginPage(driver);
        loginPage.isHeaderDisplayed();
    }

    @Step("Вход в аккаунт и проверка успешной авторизации")
    private void loginAndVerifySuccess() {
        loginPage.login(user);

        Assertions.assertFalse(
                constructorPage.isLoginButtonPresent(),
                "Кнопка Войти в аккаунт всё ещё отображается — авторизация не прошла"
        );
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    public void shouldGoToLoginPageFromConstructorPage() {
        loginPage.clickConstructor();
        constructorPage.getLoginToAccountButton().click();

        loginAndVerifySuccess();
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void shouldGoToLoginPageFromHeader() {
        loginPage.clickProfile();

        loginAndVerifySuccess();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void shouldGoToLoginPageFromRegistrationForm() {
        loginPage.getRegisterButton().click();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getLoginButton().click();

        loginAndVerifySuccess();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void shouldGoToLoginPageFromForgotPasswordForm() {
        loginPage.getForgotPasswordButton().click();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.getLoginButton().click();

        loginAndVerifySuccess();
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void shouldLogOff() {
        loginPage.login(user);
        constructorPage.clickProfile();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogout();

        Assertions.assertTrue(
                loginPage.isHeaderDisplayed(),
                "Заголовок страницы Вход не отображается"
        );
    }

}
