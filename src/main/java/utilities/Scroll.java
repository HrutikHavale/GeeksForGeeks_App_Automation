package utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Scroll {
    public static AppiumDriver driver;

    public static void scrollDownAndClick(String visibleText){
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\").instance(0))";

        driver.findElement(new AppiumBy.ByAndroidUIAutomator(scrollElement)).click();
    }

    public static void scrollDown(String visibleText){
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\").instance(0))";

        driver.findElement(new AppiumBy.ByAndroidUIAutomator(scrollElement));
    }
}
