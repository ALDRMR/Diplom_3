import PageObject.MainPage;
import org.junit.jupiter.api.Test;

public class MainPageTests extends BaseTest {

    @Test
    public void testHeaderButtons() {
        MainPage page = new MainPage(driver);
        page.clickOrderButton();
        page.clickConstructor();
        page.clickLogo();
        page.clickOrderFeed();
    }

}
