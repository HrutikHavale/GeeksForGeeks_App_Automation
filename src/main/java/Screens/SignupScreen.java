package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SignupScreen {

    AppiumDriver driver;

    public SignupScreen(AppiumDriver  driver){
            this.driver=driver;
    }

    private final By signupsEmailTextField = AppiumBy.id("free.programming.programming:id/editTextEmail");
    private final By institutionOrOrganisation = AppiumBy.id("free.programming.programming:id/editTextInstitute");
    private final By signupsPasswordTextField = AppiumBy.id("free.programming.programming:id/editTextPassword");
    private final By signupsConfirmPasswordTextField = AppiumBy.id("free.programming.programming:id/editTextConfirmPassword");
    private final By checkBoxPrivacyPolicy = AppiumBy.id("free.programming.programming:id/policyCheckBox");
    private final By signupBtn = AppiumBy.id("free.programming.programming:id/buttonSignup");
    private final By alreadyHaveAnAccountLoginBtn = AppiumBy.id("free.programming.programming:id/signupCardView");

    public SignupScreen enterEmail(String Email){
        driver.findElement(signupsEmailTextField).sendKeys(Email);
        return this;
    }

    public SignupScreen enterInstitutionOrOrganisation(String organisation){
        driver.findElement(institutionOrOrganisation).sendKeys(organisation);
        return this;
    }

    public SignupScreen enterSignupPassword(String Password){
        driver.findElement(signupsPasswordTextField).sendKeys(Password);
        return this;
    }

    public SignupScreen enterConfirmPassword(String confirmPassword){
        driver.findElement(signupsConfirmPasswordTextField).sendKeys(confirmPassword);
        return this;
    }

    public SignupScreen selectPrivacyPolicy(){
        driver.findElement(checkBoxPrivacyPolicy).click();
        return this;
    }
    public void clickOnSignupBtn(){
        driver.findElement(signupBtn).click();
    }
}
