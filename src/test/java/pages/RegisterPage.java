package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage {

    private final SelenideElement
            emailField = $("[type=\"text\"]",0),
            passwordField = $("[type=\"password\"]");
//            passwordRepeatField = $(".padded.shadow-box-api.col-lg-6 [placeholder=\"repeat password\"]");

    @Step("Заполение обязательных полей")
    public RegisterPage writerFields() {
        open("/food-api/console#Dashboard");
        emailField.setValue("test@test.ru");
        passwordField.setValue("test@test.ru");
//        passwordRepeatField.setValue("test@test.ru");
        return this;
    }
}
