package ru.gb.lessons.HW5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class TextInput extends BasicTest{
    private String sendedText = "MyButton";

    @Test
    void TextInputTest() {


        webDriver.get("http://uitestingplayground.com/textinput/");

        webDriver.findElement(By.xpath("//input[@id='newButtonName']")).sendKeys(sendedText);

        webDriver.findElement(By.xpath("//button[@id='updatingButton']")).click();

        assertThat(webDriver.findElement(By.xpath("//button[@id='updatingButton']")).getText()).isEqualTo(sendedText);


    }
}
