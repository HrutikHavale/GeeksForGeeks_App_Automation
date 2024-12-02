package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utilities.WaitMethods;

public class ForgotPasswordScreen  {
    AppiumDriver driver;

    public ForgotPasswordScreen(AppiumDriver driver){
        this.driver=driver;
    }

    private final By forgotPasswordBtn = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.programming.programming:id/forgotPassword\"]");
    private final By forgotPasswordsEmailOrUnTextField = AppiumBy.id("free.programming.programming:id/editTextEmail");
    private final By sendCodeBtn = AppiumBy.id("free.programming.programming:id/logInButton");
    private final By rememberPasswordLoginBtn = AppiumBy.id("free.programming.programming:id/login");
    final By visibilityOfElementOfForgotPasswordPage = AppiumBy.id("free.programming.programming:id/login");


    public void clickOnForgotPasswordBtn(){
        WaitMethods.explicitWait(visibilityOfElementOfForgotPasswordPage);
        driver.findElement(forgotPasswordBtn).click();

    }
}
