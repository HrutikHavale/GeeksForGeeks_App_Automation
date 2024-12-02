package Screens;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomeScreen {

    static AppiumDriver driver;

    public WelcomeScreen(AppiumDriver driver){
        WelcomeScreen.driver =driver;
    }
    private final By continueBtn = AppiumBy.id("free.programming.programming:id/next_btn");
    private final By skipBtn = AppiumBy.id("free.programming.programming:id/skip_btn");

    public  void clickOnContinueBtn(){
        driver.findElement(continueBtn).click();
    }

    public  LoginScreen clickOnSkipBtn(){

        driver.findElement(skipBtn).click();
        return new LoginScreen(driver);
    }
}
