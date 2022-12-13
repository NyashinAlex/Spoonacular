package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage {

    private final SelenideElement
            emailField = $(".padded.shadow-box-api.col-lg-6 [type=\"text\"]"),
            passwordField = $("[type=\"password\"]"),
            buttonLogIn = $(".button.actionColor");

    @Step("Заполнение обязательных полей")
    public RegisterPage writerFields(String email, String password) {
        open("/food-api/console#Dashboard");
        emailField.setValue(email);
        passwordField.setValue(password);
        buttonLogIn.click();
        return this;
    }
}
