package TestCases;

import BaseTest.TestBase;
import ExtentReport.ExtentListeners;
import Screens.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ExcelManager;
import utilities.Snackbar_Error;
import utilities.WaitMethods;
@Listeners(ExtentListeners.class)

public class SignupTest extends TestBase {

    LoginScreen login;
    SignupScreen signup;
    ExcelManager excel = new ExcelManager();

    String validEmail1 = excel.getCellData("SignupData","Email",2);
    String organisation1 = excel.getCellData("SignupData","Institute/Organisation",2);
    String validPassword = excel.getCellData("SignupData","Password",2);
    String validConfirmPassword = excel.getCellData("SignupData","ConfirmPassword",2);
    String invalidEmail1 = excel.getCellData("SignupData","Email",2);
    String registeredEmail = excel.getCellData("SignupData","Institute/Organisation",2);
    String emptyEmail = excel.getCellData("SignupData","Password",2);
    String emptyOrganisation = excel.getCellData("SignupData","ConfirmPassword",2);
    String pwdLessThan8 = excel.getCellData("SignupData","ConfirmPassword",2);
    String pwdMoreThan15 = excel.getCellData("SignupData","ConfirmPassword",2);
    String pwdWithoutDigits = excel.getCellData("SignupData","ConfirmPassword",2);
    String pwdWithoutSpecialChar = excel.getCellData("SignupData","ConfirmPassword",2);
    String pwdWithoutUpperCase = excel.getCellData("SignupData","ConfirmPassword",2);
    String pwdWithoutLowerCase = excel.getCellData("SignupData","ConfirmPassword",2);
    String invalidConfirmPwd = excel.getCellData("SignupData","ConfirmPassword",2);
    String emptyPassword = excel.getCellData("SignupData","ConfirmPassword",2);
    String emptyConfirmPassword = excel.getCellData("SignupData","ConfirmPassword",2);

    @BeforeTest
    public void init() {
        setup();
        login = new LoginScreen(driver);
        signup = new SignupScreen(driver);
    }

    @Test (priority = 1)
    public void signupWithValidData(){
        login.clickOnSignupScreenBtn();
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(validPassword).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
       if(driver.findElement(By.id("free.programming.programming:id/welcome")).isDisplayed()){
           Assert.assertTrue(true);
       }
    }

    @Test (priority = 2)
    public void signupWithInvalidEmail(){
        login.clickOnSignupScreenBtn();
        signup.enterEmail(invalidEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(validPassword).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Invalid email address");
    }

    @Test (priority = 3)
    public void signupWithAlreadyRegisteredMail(){
        signup.enterEmail(registeredEmail).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(validPassword).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"User / Email already exists");
    }

    @Test (priority = 4)
    public void signupWithEmptyMail(){
        signup.enterEmail(emptyEmail).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(validPassword).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Invalid email address");
    }

    @Test (priority = 5)
    public void signupWithEmptyInstitute(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(emptyOrganisation).enterSignupPassword(validPassword).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Institute can't be empty");
    }

    @Test (priority = 6)
    public void signupWithPasswordLessThan8Characters(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(pwdLessThan8).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Password must be minimum 8 characters and maximum 15 characters long");
    }

    @Test (priority = 7)
    public void signupWithPasswordMoreThan15Characters(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(pwdMoreThan15).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Password must be minimum 8 characters and maximum 15 characters long");
    }

    @Test (priority = 8)
    public void signupWithPasswordWithoutDigit(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(pwdWithoutDigits).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Password should have at least one digit");
    }

    @Test (priority = 9)
    public void signupWithPasswordWithoutSpecialChar(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(pwdWithoutSpecialChar).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Password should have at least one special character");
    }

    @Test (priority = 10)
    public void signupWithPasswordWithoutUppercase(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(pwdWithoutUpperCase).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Password should have at least one uppercase character");
    }

    @Test (priority = 11)
    public void signupWithPasswordWithoutLowercase(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(pwdWithoutLowerCase).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Password should have at least one lowercase character");
    }

    @Test (priority = 12)
    public void signupWithPasswordAndConfirmPasswordMisMatch(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(validPassword).enterConfirmPassword(invalidConfirmPwd).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Password didn't match");
    }

    @Test (priority = 13)
    public void signupWithEmptyPassword(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(validPassword).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Password must be minimum 8 characters and maximum 15 characters long");
    }

    @Test (priority = 14)
    public void signupWithEmptyConfirmPassword(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(emptyPassword).enterConfirmPassword(validConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Password didn't match");
    }

    @Test (priority = 15)
    public void signupWithoutSelectingPrivacyPolicy(){
        signup.enterEmail(validEmail1).enterInstitutionOrOrganisation(organisation1).enterSignupPassword(validPassword).enterConfirmPassword(emptyConfirmPassword).clickOnSignupBtn();
        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"You must accept our privacy policy");
    }

    @AfterTest
    public void tearDown()  {
        tearDown();
    }
 }
