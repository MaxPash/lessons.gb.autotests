package ru.gb.lessons.HW6PageObject.Pages;

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

    public MouseOverClickPage click(int clickTimes){
        for (int i = 0; i < clickTimes; i++) {
            TargetButton.click();
        }return new MouseOverClickPage (webDriver);
    }

    public MouseOverClickPage checkAmountOfClicks(int clickTimes) {
        assertThat(webDriver.findElement(By.xpath("//span[@id='clickCount']"))
                .getText()).isEqualTo("" + clickTimes + "");
        return this;
    }
}
