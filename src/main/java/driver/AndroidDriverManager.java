package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utilities.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager implements MobileDriver{
    private static AppiumDriver driver;
    private static String filePath ="/home/gfg19539@gfg.geeksforgeeks.org/IdeaProjects/GeeksForGeeks/src/test/resources/properties/Android.properties";

    private static final String deviceName = PropertyReader.readPropertyFileData(filePath).getProperty("emulator_device.name");
    private static final String pVersion = PropertyReader.readPropertyFileData(filePath).getProperty("emulator_platform.version");
    private static final String appPackage = PropertyReader.readPropertyFileData(filePath).getProperty("application.package ");
    private static final String appActivity=PropertyReader.readPropertyFileData(filePath).getProperty("application.activity");
    private static final String platformName=PropertyReader.readPropertyFileData(filePath).getProperty("platform.name");
    private static final String automationName=PropertyReader.readPropertyFileData(filePath).getProperty("automationName");
    private static final String PORT_Number = PropertyReader.readPropertyFileData(filePath).getProperty("appium.server.port");


    @Override
    public AppiumDriver createDriver() {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName(deviceName)
                .setPlatformName(platformName)
                .setPlatformVersion(pVersion)
                .setAppPackage(appPackage)
                .setAppActivity(appActivity)
                .setAutomationName(automationName);
        try {
            driver = new AndroidDriver(new URL("http://localhost:"+PORT_Number), options);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
            return driver;
    }
}
