package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterTests extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();

    String emailRandom, passwordRandom;

    @BeforeEach
    void genData() {
        emailRandom = faker.internet().emailAddress();
        passwordRandom = faker.random().toString();
    }

    //тестовая учетка
    String email = "nyashin1996@mail.ru", password = "Nn1031941";

    @Test
    @DisplayName("Авторизация существующего пользователя")
    void authUser() {
        registerPage.writerFields(email, password);

        open("/food-api/console#Profile");
        $("#apiConsoleRightSide p", 3).shouldBe(text(email));
    }

    @Test
    @DisplayName("Невозможность авторизации несуществующего пользователя")
    void unsuccessfulAuthUser() {
        registerPage.writerFields(emailRandom, passwordRandom);

        $(".awn-toast-label").shouldBe(text("Error"));
        $(".awn-toast-content").shouldBe(text("Login information incorrect."));
    }

    @Test
    @DisplayName("Невозможность авторизации - пустой email")
    void unsuccessfulAuthNotEmail() {
        registerPage.writerFields("", passwordRandom);

        $(".awn-toast-label").shouldBe(text("Error"));
        $(".awn-toast-content").shouldBe(text("Login information incorrect."));
    }

    @Test
    @DisplayName("Невозможность авторизации - пустой password")
    void unsuccessfulAuthNotPassword() {
        registerPage.writerFields(emailRandom, "");

        $(".awn-toast-label").shouldBe(text("Error"));
        $(".awn-toast-content").shouldBe(text("Login information incorrect."));
    }

    @Test
    @DisplayName("Невозможность авторизации - не заполнены поля")
    void unsuccessfulAuthNotWriterFields() {
        registerPage.writerFields("", "");

        $(".awn-toast-label").shouldBe(text("Error"));
        $(".awn-toast-content").shouldBe(text("Login information incorrect."));
    }
}