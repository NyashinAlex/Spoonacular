package tests;

import com.codeborne.selenide.Configuration;
import config.WebDriverProvider;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void openMainPage() {
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://spoonacular.com";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        WebDriverProvider.configure();
    }
}
