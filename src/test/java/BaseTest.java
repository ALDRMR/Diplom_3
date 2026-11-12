import apiclient.ApiUserClient;
import driver.WebDriverCreator;
import io.qameta.allure.Step;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.hamcrest.Matchers.equalTo;

public class BaseTest {

        protected WebDriver driver;

        protected ApiUserClient apiUserClient;
        protected String accessToken;

        @BeforeEach
        public void driverSetUp() {
            driver = WebDriverCreator.createWebDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.get("https://qa-stellarburgers.education-services.ru/");
        }

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
        void driverTeardown() {
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