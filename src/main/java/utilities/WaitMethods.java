package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitMethods {

    static AppiumDriver driver;
    private static String filePath ="/home/gfg19539@gfg.geeksforgeeks.org/IdeaProjects/GeeksForGeeks/src/test/resources/properties/Android.properties";
//    public WaitMethods(AppiumDriver driver){
//        this.driver=driver;
//    }

    static int implicitWaitTime =  Integer.parseInt(PropertyReader.readPropertyFileData(filePath).getProperty("implicit.wait"));
    static int explicitWaitTime = Integer.parseInt(PropertyReader.readPropertyFileData(filePath).getProperty("explicit.wait"));
    static int fluentWaitTime =Integer.parseInt(PropertyReader.readPropertyFileData(filePath).getProperty("fluent.wait"));
    static int pollingTime = Integer.parseInt(PropertyReader.readPropertyFileData(filePath).getProperty("polling.wait"));

    public static void implicitWait(){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
    }

    public static void explicitWait(By visibilityOfElement){
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(explicitWaitTime));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(visibilityOfElement));
    }

    public static void fluentWait(By visibilityOfElement){
        FluentWait<AppiumDriver> wait= new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(fluentWaitTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(visibilityOfElement));

    }

}
