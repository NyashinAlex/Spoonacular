package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import config.WebDriverProvider;
import helper.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;

public class BaseTest {

    @BeforeAll
    static void openMainPage() {
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://spoonacular.com";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        WebDriverProvider.configure();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
//        Selenide.closeWebDriver();
    }
}
