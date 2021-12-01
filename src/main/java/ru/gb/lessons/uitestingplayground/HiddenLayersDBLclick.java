package ru.gb.lessons.uitestingplayground;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HiddenLayersDBLclick {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();

        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriver.get("http://uitestingplayground.com/hiddenlayers");

        webDriver.manage().window().setSize(new Dimension(1500, 720));

        webDriver.findElement(By.xpath("//button[@id='greenButton'] ")).click();
        webDriver.findElement(By.xpath("//button[@id='blueButton'] ")).click();

        Thread.sleep(5000);
    }
}
