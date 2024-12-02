package Screens;

import BaseScreen.ScreenBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utilities.Scroll;

public class LogOutScreen extends ScreenBase {

    private final  By profileButton = AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"free.programming.programming:id/navigation_bar_item_icon_view\"])[5]");
    private final By logOutButton = AppiumBy.id("free.programming.programming:id/logOutButton");
    AppiumDriver driver;
    private final String visibleText = "Logout";

    public LogOutScreen(AppiumDriver driver){
        this.driver =driver;
    }

    public void logOut(){
     driver.findElement(profileButton).click();
     Scroll.scrollDownAndClick(visibleText);
     driver.findElement(logOutButton).click();
    }
}
