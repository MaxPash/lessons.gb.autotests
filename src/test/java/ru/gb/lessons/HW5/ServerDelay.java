package ru.gb.lessons.HW5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;

public class ServerDelay extends BasicTest{
    @Test
    void LoadDelaysTest() {

        webDriver.get("http://uitestingplayground.com/");

        webDriver.findElement(By.xpath("//a[text()='Load Delay'] ")).click();

        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Button Appearing After Delay']")))
                .click();

        assertThat(webDriver.findElement(By.xpath("//button[@class='btn btn-primary']")).getText()).isEqualTo("Button Appearing After Delay");
    }
}
