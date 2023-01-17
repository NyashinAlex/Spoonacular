package helper;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckStep {

    @Step("Проверка, что пользователь верно авторизовался (по email)")
    public CheckStep successAuth(String email) {
        open("/food-api/console#Profile");
        $("#apiConsoleRightSide p", 3).shouldBe(text(email));
        return this;
    }
}
