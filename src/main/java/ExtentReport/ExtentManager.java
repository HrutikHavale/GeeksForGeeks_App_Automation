package ExtentReport;

import BaseScreen.ScreenBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance(String fileName){
        ExtentSparkReporter reporter=new ExtentSparkReporter(fileName);
        reporter.config().setReportName(fileName);
        reporter.config().setDocumentTitle("Test Results");

        extent= new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Hrutik_Havale");
        extent.setSystemInfo("Automatin_Name","App_Automation");

        return extent;
    }

    public static String screenshotName;

    public static void captureScreenShot(){
        TakesScreenshot screenshot =(TakesScreenshot) ScreenBase.driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        Date d=new Date();
        screenshotName=d.toString().replace(":","_").replace(" ","-")+".jpg";
        try{
            FileHandler.copy(source,new File("src/Screenshots/"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
