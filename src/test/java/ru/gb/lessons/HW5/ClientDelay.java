package ru.gb.lessons.HW5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientDelay extends BasicTest{
    @Test
    void ClientDelayTest() {
        webDriver.get("http://uitestingplayground.com/clientdelay");

        webDriver.findElement(By.id("ajaxButton")).click();

        new WebDriverWait(webDriver, 17, 1000)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//p[contains(text(), 'Data calculated on the client side.')]"))))
                .click();

        assertThat(webDriver.findElement(By.xpath("//p[contains(text(), 'Data calculated on the client side.')]")).getText()).isEqualTo("Data calculated on the client side.");

    }
}
