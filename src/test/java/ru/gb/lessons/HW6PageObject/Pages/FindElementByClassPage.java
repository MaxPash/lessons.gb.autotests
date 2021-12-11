package ru.gb.lessons.HW6PageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lessons.HW6PageObject.BasicView;

import static org.assertj.core.api.Assertions.assertThat;

public class FindElementByClassPage extends BasicView {

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    private WebElement StartTestButton;

    public FindElementByClassPage(WebDriver webDriver) {
        super(webDriver);
    }

    public FindElementByClassPage startTestClick(){
        StartTestButton.click();
        return new FindElementByClassPage(webDriver);
    }

    public FindElementByClassPage checkAlertText(){
        assertThat(webDriver.switchTo().alert().getText()).isEqualTo("Primary button pressed");
        return new FindElementByClassPage(webDriver);
    }
}
