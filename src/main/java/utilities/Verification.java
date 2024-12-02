package utilities;

import Screens.LogOutScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Verification {
  AppiumDriver driver;
    private final By profileButton = AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"free.programming.programming:id/navigation_bar_item_icon_view\"])[5]");
    private final By loginErrorSnackbar = AppiumBy.id("free.programming.programming:id/snackbar_text");

    LogOutScreen logout;

    public Verification(AppiumDriver driver) {
        this.driver = driver;
        this.logout = new LogOutScreen(driver);
    }

    public boolean profileButtonVisible(){
        try{
            WaitMethods.explicitWait(profileButton);
            return driver.findElement(profileButton).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean snackbarVisible(){
        try{
            WaitMethods.explicitWait(loginErrorSnackbar);
            return driver.findElement(loginErrorSnackbar).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public void checkLoginStatus(){

        if(profileButtonVisible()){
            logout.logOut();
            Assert.assertTrue(true);
        } else  {
            Assert.fail();
        }

    }
    public void checkFailedLoginStatus(){
        if (snackbarVisible()){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
}
