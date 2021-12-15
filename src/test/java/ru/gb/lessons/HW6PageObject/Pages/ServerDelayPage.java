package ru.gb.lessons.HW6PageObject.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.HW6PageObject.BasicView;

import static org.assertj.core.api.Assertions.assertThat;

public class ServerDelayPage extends BasicView {

    public ServerDelayPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Ожидаем загрузки страницы")
    public ServerDelayPage waitForIt() {
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Button Appearing After Delay']")));
                return new ServerDelayPage(webDriver);
    }
    @Step("Проверяем что текст кнопки: Button Appearing After Delay")
    public ServerDelayPage checkButtonText() {
        assertThat(webDriver.findElement(By.xpath("//button[@class='btn btn-primary']")).getText()).isEqualTo("Button Appearing After Delay");
        return new ServerDelayPage(webDriver);
    }
}
