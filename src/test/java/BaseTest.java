import apiclient.ApiUserClient;
import io.qameta.allure.Step;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.hamcrest.Matchers.equalTo;

public class BaseTest {

        protected WebDriver driver;

        protected ApiUserClient apiUserClient;
        protected String accessToken;

        @BeforeEach
        void setUpChrome() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

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
        @BeforeEach
        public void baseSetUp() {
            apiUserClient = new ApiUserClient();
            accessToken = null;
        }

        @AfterEach
        public void baseTearDown() {
            if (accessToken != null) {
                apiUserClient.deleteUser(accessToken)
                        .statusCode(202)
                        .body("success", equalTo(true));
            }
        }

        @AfterEach
        void teardown() {
            if (driver != null) {
                driver.quit();
                }
            }

        @Step("Создать пользователя {user.name}")
        public String createUserWithAPI(User user){
            return accessToken = apiUserClient.createUser(user)
                    .statusCode(200)
                    .body("success", equalTo(true))
                    .extract()
                    .path("accessToken");
        }

}