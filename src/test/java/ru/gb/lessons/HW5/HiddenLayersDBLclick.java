package ru.gb.lessons.HW5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class HiddenLayersDBLclick extends   BasicTest{
    @Test
    void HiddenLayersDBLclickTest() {

        webDriver.get("http://uitestingplayground.com/hiddenlayers");

        webDriver.manage().window().setSize(new Dimension(1500, 720));

        webDriver.findElement(By.xpath("//button[@id='greenButton'] ")).click();
        webDriver.findElement(By.xpath("//button[@id='blueButton'] ")).click();


    }
}
