package tests;

import com.github.javafaker.Faker;
import helper.CheckStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.RegisterPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterTests extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    CheckStep checkStep = new CheckStep();
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
        checkStep.successAuth(email);
    }

    @CsvSource(value = {
            "emailRandom, passwordRandom",
            ", passwordRandom",
            "emailRandom,",
            ","
    })
    @ParameterizedTest(name = "Невозможность авторизации несуществующего пользователя - разные проверки")
    void unsuccessfulAuthUser() {
        registerPage.writerFields(emailRandom, passwordRandom);
        checkStep.unsuccessfulAuth();
    }
}