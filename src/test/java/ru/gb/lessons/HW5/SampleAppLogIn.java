package ru.gb.lessons.HW5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import com.github.javafaker.Faker;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleAppLogIn extends BasicTest{

    private final Faker faker = new Faker();
    private final String password = "pwd";


    @Test
    void SampleAppLogInTest()  {
        String name = faker.name().username();

        webDriver.get("http://uitestingplayground.com/sampleapp");

        webDriver.findElement(By.name("UserName")).sendKeys(name);
        webDriver.findElement(By.name("Password")).sendKeys(password);
        webDriver.findElement(By.id("login")).click();

        assertThat(webDriver.findElement(By.id("loginstatus")).getText()).isEqualTo("Welcome, " + name + "!");
      

    }


}
