package ru.gb.lessons.HW6.PageObject;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.HW5.BasicTest;
import ru.gb.lessons.HW6.PageObject.Pages.*;

public class HW6Tests extends BasicTest {

    private final Faker faker = new Faker();
    String password = "pwd";
    private String text = "MyButton";

    @Test
    void ClientDelayTest() {
        webDriver.get("http://uitestingplayground.com/clientdelay");

        new ClientDelayPage(webDriver)
            .click()
            .waitForIt()
            .checkText();
    }

    @Test
    void FindElementByClassTest() {
        webDriver.get("http://uitestingplayground.com/classattr");

        new FindElementByClassPage(webDriver)
                .startTestClick()
                .checkAlertText();
    }

    @Test
    void MouseOverClickTest() {
        webDriver.get("http://uitestingplayground.com/mouseover");

        int amountOfClicks = 5;

        new MouseOverClickPage(webDriver)
                .click(amountOfClicks)
                .checkAmountOfClicks(amountOfClicks);
    }

    @Test
    void LogInTest() {
        String name = faker.name().username();

        webDriver.get("http://uitestingplayground.com/sampleapp");

        new SampleAppLogInPage(webDriver)
                .login(name, password)
                .checkUserName(name);
    }

    @Test
    void ServerDelayTest() {
        webDriver.get("http://uitestingplayground.com/");

        new MainPage(webDriver)
                .startServerDelayTest();
        new ServerDelayPage(webDriver)
                .waitForIt()
                .checkButtonText();
    }

    @Test
    void TextInputTest() {
        webDriver.get("http://uitestingplayground.com/textinput/");

        new TextInputPage(webDriver)
                .inputText(text)
                .submitTextClick()
                .checkNewText(text);
    }
}
