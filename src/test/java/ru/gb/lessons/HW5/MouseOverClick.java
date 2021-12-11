package ru.gb.lessons.HW5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;

public class MouseOverClick extends BasicTest{

    @Test
    void MouseOverClickTest() {

        webDriver.get("http://uitestingplayground.com/mouseover");

        webDriver.manage().window().setSize(new Dimension(1500, 720));

        webDriver.findElement(By.xpath("//a[text()='Click me']")).click();
        webDriver.findElement(By.xpath("//a[text()='Click me']")).click();

        assertThat(webDriver.findElement(By.xpath("//span[@id='clickCount']")).getText()).isEqualTo("2");
    }
}
