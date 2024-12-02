package TestCases;

import BaseTest.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Scroll;

public class JobsTest extends TestBase {

    private final String visibleText = "Java Developer";
    @BeforeTest
    public void init() {
        setup();
    }

    @Test
    public void clickAlert() throws Exception {
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"free.programming.programming:id/cardTitleFirst\" and @text=\"Jobs For You\"]")).click();

//        List<WebElement> jobNames = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"free.programming.programming:id/jobTitle\"]"));
//        for (WebElement jobs:jobNames){
//
//            if(jobs.getText().equalsIgnoreCase("Python Developer Trainee")){
//              jobs.click();
//            }
        Scroll.scrollDown(visibleText);
        //driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"free.programming.programming:id/jobTitle\" and @text=\"" +visibleText+"\"]")).click();
        }
    }

