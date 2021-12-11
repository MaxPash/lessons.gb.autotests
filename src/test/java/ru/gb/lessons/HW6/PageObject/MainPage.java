package ru.gb.lessons.HW6.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasicView{
    
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
