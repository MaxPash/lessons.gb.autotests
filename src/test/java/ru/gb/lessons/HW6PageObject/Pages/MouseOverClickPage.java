package ru.gb.lessons.HW6PageObject.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lessons.HW6PageObject.BasicView;

import static org.assertj.core.api.Assertions.assertThat;

public class MouseOverClickPage extends BasicView {

    @FindBy(xpath = "//a[text()='Click me']")
    WebElement TargetButton;

    public MouseOverClickPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликнуть на элемент с предварительным наведением мыши {0} раз")
    public MouseOverClickPage click(int clickTimes){
        for (int i = 0; i < clickTimes; i++) {
            TargetButton.click();
        }return new MouseOverClickPage (webDriver);
    }
    @Step("Проверить что счетчик нажатий равен {0}")
    public MouseOverClickPage checkAmountOfClicks(int clickTimes) {
        assertThat(webDriver.findElement(By.xpath("//span[@id='clickCount']"))
                .getText()).isEqualTo("" + clickTimes + "");
        return this;
    }
}
