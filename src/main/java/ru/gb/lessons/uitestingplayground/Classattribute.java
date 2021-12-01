package ru.gb.lessons.uitestingplayground;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Classattribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = WebDriverManager.chromedriver().create();

        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriver.get("http://uitestingplayground.com/classattr");

        webDriver.manage().window().setSize(new Dimension(1500, 720));

        //Не понятно как работает такой xpath по части атрибута и как кликнуть на всплывающее окно
        //webDriver.findElement(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")).click();

        Thread.sleep(5000);

    }
}
