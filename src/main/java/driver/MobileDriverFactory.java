package driver;

import io.appium.java_client.AppiumDriver;

public class MobileDriverFactory {
   public static AppiumDriver getDriver(String platformName){
       switch (platformName.toLowerCase()){
           case "android":
               return new AndroidDriverManager().createDriver();

           case "ios":
               return null;

           default:
               throw new IllegalArgumentException("Platform not supported: " + platformName);
       }
   }
}
