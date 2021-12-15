package ru.gb.lessons.HW6PageObject.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lessons.HW6PageObject.BasicView;

import static org.assertj.core.api.Assertions.assertThat;

public class TextInputPage extends BasicView {
    public TextInputPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='newButtonName']")
    WebElement textInput;

    @FindBy(xpath = "//button[@id='updatingButton']")
    WebElement updateButtonTextButton;

    public TextInputPage inputText(String text){
        textInput.sendKeys(text);
        return new TextInputPage(webDriver);
    }
    @Step("Подтвеждаем ввод текста, нажатием на кнопку")
    public TextInputPage submitTextClick(){
        updateButtonTextButton.click();
        return new TextInputPage(webDriver);
    }
    @Step("Проверяем что текст кнопки изменился на {0}")
    public TextInputPage checkNewText(String text){
        assertThat(webDriver.findElement(By.xpath("//button[@id='updatingButton']")).getText()).isEqualTo(text);
        return new TextInputPage(webDriver);
    }
}
