package ru.gb.lessons.HW6PageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.HW6PageObject.BasicView;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientDelayPage extends BasicView {

    @FindBy (id = "ajaxButton")
    private WebElement StartTestButton;

    public ClientDelayPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ClientDelayPage click() {
        StartTestButton.click();
        return new ClientDelayPage(webDriver);
    }

    public ClientDelayPage waitForIt() {
        new WebDriverWait(webDriver, 17, 1000)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//p[contains(text(), 'Data calculated on the client side.')]"))));
        return new ClientDelayPage(webDriver);
    }

    public ClientDelayPage checkText(){
        assertThat(webDriver.findElement(By.xpath("//p[contains(text(), 'Data calculated on the client side.')]")).getText())
                .isEqualTo("Data calculated on the client side.");
        return new ClientDelayPage(webDriver);
    }

}
