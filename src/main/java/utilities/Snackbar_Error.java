package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Snackbar_Error {

    static AppiumDriver driver;

    public static String snackbarMsg(AppiumDriver driver){
        return driver.findElement(By.id("free.programming.programming:id/snackbar_text")).getText();
    }

    public static String errorMsg(AppiumDriver driver){
        return driver.findElement(By.id("free.programming.programming:id/textinput_error")).getText();
    }
}
