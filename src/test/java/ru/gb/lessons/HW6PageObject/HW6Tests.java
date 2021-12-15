package ru.gb.lessons.HW6PageObject;

import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.HW5.BasicTest;
import ru.gb.lessons.HW6PageObject.Pages.*;

public class HW6Tests extends BasicTest {

    private final Faker faker = new Faker();
    String password = "pwd";
    private String text = "MyButton";

    @Test
    @DisplayName("Ожидание загрузки элемента")
    @Description("В этом тесте проверяется ожидание загрузки элемента на стороне клиента")
    @Severity(SeverityLevel.TRIVIAL)
    void ClientDelayTest() {
        webDriver.get("http://uitestingplayground.com/clientdelay");

        new ClientDelayPage(webDriver)
            .click()
            .waitForIt()
            .checkText();
    }

    @Test
    @DisplayName("Найти элемент по частичному тексту атрибута")
    @Severity(SeverityLevel.TRIVIAL)
    void FindElementByClassTest() {
        webDriver.get("http://uitestingplayground.com/classattr");

        new FindElementByClassPage(webDriver)
                .startTestClick()
                .checkAlertText();
    }

    @Test
    @DisplayName("Клик на элемент с предварительным наведением мыши")
    @Severity(SeverityLevel.TRIVIAL)
    void MouseOverClickTest() {
        webDriver.get("http://uitestingplayground.com/mouseover");

        int amountOfClicks = 5;

        new MouseOverClickPage(webDriver)
                .click(amountOfClicks)
                .checkAmountOfClicks(amountOfClicks);
    }

    @Test
    @DisplayName("Тест авторизации")
    @Severity(SeverityLevel.TRIVIAL)
    void LogInTest() {
        String name = faker.name().username();

        webDriver.get("http://uitestingplayground.com/sampleapp");

        new SampleAppLogInPage(webDriver)
                .login(name, password)
                .checkUserName(name);
    }

    @Test
    @DisplayName("Ожидание загрузки страницы")
    @Severity(SeverityLevel.TRIVIAL)
    void ServerDelayTest() {
        webDriver.get("http://uitestingplayground.com/");

        new MainPage(webDriver)
                .startServerDelayTest();
        new ServerDelayPage(webDriver)
                .waitForIt()
                .checkButtonText();
    }

    @Test
    @DisplayName("Ввод в текстовое поле")
    @Description("В этом тесты мы вводим текст в тестовое поле подтвеждаем и проверяем изменение текста кнопки")
    @Severity(SeverityLevel.TRIVIAL)
    void TextInputTest() {
        webDriver.get("http://uitestingplayground.com/textinput/");

        new TextInputPage(webDriver)
                .inputText(text)
                .submitTextClick()
                .checkNewText(text);
    }
}
