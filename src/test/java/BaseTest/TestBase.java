package BaseTest;

import driver.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import driver.AppiumServer;
import utilities.PropertyReader;

public class TestBase {

    public AppiumDriver driver;
    public static String loadPropertyFile = "Android.properties";
    static String filePath = "/home/gfg19539@gfg.geeksforgeeks.org/IdeaProjects/QATestApp/src/main/resources/properties/Android.Properties";

    public void setup(){
        if (driver == null) {
            if (loadPropertyFile.startsWith("Android")) {
                AppiumServer.startServer();
                PropertyReader.readPropertyFileData(filePath);
                driver = MobileDriverFactory.getDriver("android");
            }
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            AppiumServer.stopServer();
        }
    }
}
