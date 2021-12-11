package ru.gb.lessons.HW5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;

public class FindElementByClass extends BasicTest {
    @Test
    void FindElementByClassTest() {

        webDriver.get("http://uitestingplayground.com/classattr");

        webDriver.findElement(By.xpath("//button[contains(@class, 'btn-primary')]")).click();

        assertThat(webDriver.switchTo().alert().getText()).isEqualTo("Primary button pressed");

        webDriver.switchTo().alert().accept();

    }
}
