import PageObject.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

        protected WebDriver driver;

        @BeforeEach
        void setUpChrome() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.get("https://qa-stellarburgers.education-services.ru/");
        }
/*
    @BeforeEach
    void setUpYandex() {
        YandexOptions options = new YandexOptions();
        // options.addArguments("--headless");
        driver = new YandexDriver(options);
        driver.get("https://qa-scooter.education-services.ru/");
    }
*/
    @AfterEach
        void teardown() {
            if (driver != null) {
                driver.quit();
            }
        }

}