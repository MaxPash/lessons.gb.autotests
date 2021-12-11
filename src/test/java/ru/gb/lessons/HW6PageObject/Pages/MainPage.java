package ru.gb.lessons.HW6PageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lessons.HW6PageObject.BasicView;

public class MainPage extends BasicView {
    
    @FindBy (xpath = "//a[text()='Load Delay']")
    WebElement ServerDelayButton;
    
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    
    public ServerDelayPage startServerDelayTest(){
        ServerDelayButton.click();
        return new ServerDelayPage(webDriver);
    } 
}
