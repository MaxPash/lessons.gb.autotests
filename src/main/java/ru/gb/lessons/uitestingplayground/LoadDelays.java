package ru.gb.lessons.uitestingplayground;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoadDelays {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();

        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriver.manage().window().setSize(new Dimension(1500, 900));

        webDriver.get("http://uitestingplayground.com/");

        webDriver.findElement(By.xpath("//a[text()='Load Delay'] ")).click();

        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Button Appearing After Delay']")))
                .click();

        Thread.sleep(5000);
    }
}
