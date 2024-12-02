package driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServer {

   public static AppiumDriverLocalService service;
    public static void startServer(){

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
               // .usingDriverExecutable(new File("/usr/local/bin/node.exe"));

        service = AppiumDriverLocalService.buildService(builder);

        service.start();
    }

    public static void stopServer(){
        service.stop();
    }
}
