package Screens;

import BaseScreen.ScreenBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginScreen extends ScreenBase {

    AppiumDriver driver;
    public LoginScreen(AppiumDriver  driver){
        //super(driver);
        this.driver=driver;
    }

    private final By loginsEmailOrUserNameTextField = AppiumBy.id("free.programming.programming:id/editTextEmail");
    private final By loginsPasswordTextField = AppiumBy.id("free.programming.programming:id/editTextPassword");
    private final By loginBtn = AppiumBy.id("free.programming.programming:id/logInButton");
    private final By signupScreenBtn = AppiumBy.id("free.programming.programming:id/singUp");

    public LoginScreen enterEmailOrUserName(String Username){
        driver.findElement(loginsEmailOrUserNameTextField).sendKeys(Username);
        return this;
    }

    public LoginScreen enterLoginPassword(String Password){
        driver.findElement(loginsPasswordTextField).sendKeys(Password);
        return this;
    }

    public void clickOnContinueBtn(){
        driver.findElement(loginBtn).click();
    }

    public void clickOnSignupScreenBtn(){
        driver.findElement(signupScreenBtn).click();
    }
}
