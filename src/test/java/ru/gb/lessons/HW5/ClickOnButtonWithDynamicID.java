package ru.gb.lessons.HW5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class ClickOnButtonWithDynamicID extends BasicTest{

    @Test
    void ClickOnButtonWithDynamicIDTest() {

        webDriver.get("http://uitestingplayground.com/dynamicid");

        webDriver.manage().window().setSize(new Dimension(1500, 720));

        webDriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

    }
}
