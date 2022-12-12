package tests;

import com.codeborne.selenide.Configuration;
import config.WebDriverProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;

import static helper.Attach.getVideoUrl;

public class RegisterTests extends BaseTest{

    RegisterPage registerPage = new RegisterPage();

    @Test
    @DisplayName("Регистрация нового пользователя")
    void registerNewUser() {
        registerPage.writerFields();
        System.out.println(getVideoUrl());
    }
}
