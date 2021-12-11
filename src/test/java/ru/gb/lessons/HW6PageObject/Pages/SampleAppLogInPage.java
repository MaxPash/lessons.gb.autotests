package ru.gb.lessons.HW6PageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lessons.HW6PageObject.BasicView;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleAppLogInPage extends BasicView {

    @FindBy(name = "UserName")
    private WebElement userNameInput;

    @FindBy(name = "Password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement submitButton;

    public SampleAppLogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SampleAppLogInPage login(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new SampleAppLogInPage(webDriver);
    }

    public SampleAppLogInPage checkUserName(String username) {
        assertThat(webDriver.findElement(By.id("loginstatus")).getText())
                .isEqualTo("Welcome, " + username + "!");
        return this;
    }



}
