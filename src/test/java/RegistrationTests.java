import PageObject.ProfilePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTests extends BaseTest {

//    Регистрация
//    Проверь:
//    Успешную регистрацию.
//    Ошибку для некорректного пароля. Минимальный пароль — шесть символов.

    @Test
    //@DisplayName("Успешную регистрацию.")
    public void shouldLogin() {

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickProfile();
        profilePage.login("test@yandex.ru","123456");

        //
    }

    @Test
    @DisplayName("Ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shouldGetErrorOnShortPassword() {

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickProfile();
        profilePage.login("test@yandex.ru","12345");

        org.junit.jupiter.api.Assertions.assertTrue(
                profilePage.isPasswordErrorDisplayed(),
                "Сообщение об ошибке пароля не отображается!"
        );

        org.junit.jupiter.api.Assertions.assertEquals(
                "Некорректный пароль",
                profilePage.getPasswordErrorText()
        );
    }
}
