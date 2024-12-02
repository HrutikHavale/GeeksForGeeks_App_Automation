package TestCases;

import BaseTest.TestBase;
import ExtentReport.ExtentListeners;
import Screens.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ExcelManager;
import utilities.Snackbar_Error;
import utilities.Verification;
import utilities.WaitMethods;

@Listeners(ExtentListeners.class)
public class LoginTest extends TestBase {

    WelcomeScreen welcome;
    LoginScreen login;
    ForgotPasswordScreen forgot;
    ExcelManager excel = new ExcelManager();
    LogOutScreen logout;
    Verification verify;

    String validMail1 = excel.getCellData("LoginData","UserName",2);
    String validPassword1= excel.getCellData("LoginData","Password",2);
    String validMail2 = excel.getCellData("LoginData","UserName",3);
    String invalidPassword1= excel.getCellData("LoginData","Password",3);
    String InvalidMail1 = excel.getCellData("LoginData","UserName",4);
    String ValidPassword2= excel.getCellData("LoginData","Password",4);
    String InvalidMail2 = excel.getCellData("LoginData","UserName",5);
    String invalidPassword2= excel.getCellData("LoginData","Password",5);
    String validUserName = excel.getCellData("LoginData","UserName",6);
    String validPassword3= excel.getCellData("LoginData","Password",6);
    String invalidUserName = excel.getCellData("LoginData","UserName",7);
    String validPassword2= excel.getCellData("LoginData","Password",7);
    String validUserName2 = excel.getCellData("LoginData","UserName",8);
    String invalidPassword3= excel.getCellData("LoginData","Password",8);
    String emptyEmail = excel.getCellData("LoginData","UserName",9);
    String validPassword4= excel.getCellData("LoginData","Password",9);
    String validEmail = excel.getCellData("LoginData","UserName",10);
    String emptyPassword= excel.getCellData("LoginData","Password",10);
    String unRegisteredEmail = excel.getCellData("LoginData","UserName",11);
    String UnRegisteredPassword= excel.getCellData("LoginData","Password",11);
   // private final By visibilityOfLoginButton = AppiumBy.id("free.programming.programming:id/logInButton");

    @BeforeTest
    public void init() {
        setup();
        WaitMethods.implicitWait();
        welcome = new WelcomeScreen(driver);
        login = new LoginScreen(driver);
        forgot = new ForgotPasswordScreen(driver);
        logout = new LogOutScreen(driver);
        verify= new Verification(driver);
    }

    @Test(priority = 1)
    public void loginWithValidEmailAndValidPassword(){
        login.enterEmailOrUserName(validMail1).enterLoginPassword(validPassword1).clickOnContinueBtn();
        verify.checkLoginStatus();
    }

    @Test(priority = 2)
    public void loginWithValidEmailAndInvalidPassword(){
        login.enterEmailOrUserName(validMail2).enterLoginPassword(invalidPassword1).clickOnContinueBtn();
        verify.checkFailedLoginStatus();
    }

    @Test(priority = 3)
    public void loginWithInvalidEmailAndValidPassword(){
        login.enterEmailOrUserName(InvalidMail1).enterLoginPassword(ValidPassword2).clickOnContinueBtn();
        verify.checkFailedLoginStatus();
    }

    @Test(priority = 4)
    public void loginWithInvalidEmailAndInvalidPassword(){
        login.enterEmailOrUserName(InvalidMail2).enterLoginPassword(invalidPassword2).clickOnContinueBtn();
        verify.checkFailedLoginStatus();
    }

    @Test(priority = 5)
    public void loginWithValidUserNameAndValidPassword(){
       // wait.explicitWait(visibilityOfLoginButton);
        login.enterEmailOrUserName(validUserName).enterLoginPassword(validPassword3).clickOnContinueBtn();
        verify.checkLoginStatus();
    }

    @Test(priority = 6)
    public void loginWithInvalidUserNameAndValidPassword(){
        login.enterEmailOrUserName(invalidUserName).enterLoginPassword(validPassword2).clickOnContinueBtn();
        verify.checkFailedLoginStatus();

    }

    @Test(priority = 7)
    public void loginWithValidUserNameAndInvalidPassword(){
        login.enterEmailOrUserName(validUserName2).enterLoginPassword(invalidPassword3).clickOnContinueBtn();
        verify.checkFailedLoginStatus();

    }
    @Test(priority = 8)
    public void loginWithEmptyEmailAndValidPassword(){
        login.enterEmailOrUserName(emptyEmail).enterLoginPassword(validPassword4).clickOnContinueBtn();
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Please enter your username / email");
       // Assert.assertEquals(driver.findElement(AppiumBy.id("free.programming.programming:id/textinput_error")).getText(),"Please enter your username / email");

    }
    @Test(priority = 9)
    public void loginWithValidUserNameAndEmptyPassword() throws InterruptedException {
        login.enterEmailOrUserName(validEmail).enterLoginPassword(emptyPassword).clickOnContinueBtn();
        Thread.sleep(5000);
        Assert.assertEquals(Snackbar_Error.errorMsg(driver),"Please enter your password");
       // Assert.assertEquals(driver.findElement(AppiumBy.id("free.programming.programming:id/textinput_error")).getText(),"Please enter your password");

    }
    @Test(priority = 10)
    public void loginWithUnRegisteredEmailAndPassword(){
        login.enterEmailOrUserName(unRegisteredEmail).enterLoginPassword(UnRegisteredPassword).clickOnContinueBtn();
        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Incorrect Login Credentials");
       // Assert.assertEquals(driver.findElement(AppiumBy.id("free.programming.programming:id/snackbar_text")).getText(),"Incorrect Login Credentials");
    }

    @AfterTest
    public void tearDown()  {
        tearDown();
    }
}
