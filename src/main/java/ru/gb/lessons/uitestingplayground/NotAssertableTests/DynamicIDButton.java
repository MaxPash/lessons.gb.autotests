package ru.gb.lessons.uitestingplayground.NotAssertableTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DynamicIDButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();

        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriver.get("http://uitestingplayground.com/dynamicid");

        webDriver.manage().window().setSize(new Dimension(1500, 720));

        webDriver.findElement(By.xpath("//*[text()='Playground']/following::button")).click();

        Thread.sleep(5000);
    }
}
