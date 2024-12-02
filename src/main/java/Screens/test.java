package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class test {
    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.manage().deleteAllCookies();
        driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-08/10/2024&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
        // driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        List<WebElement> prices =driver.findElements(By.xpath("//div[@class='makeFlex align-items-center gap-x-10 airline-info-wrapper']//p[contains(text(),'IndiGo')]/ancestor::div[@class='makeFlex']/parent::div/div[@class='priceSection priceLockPersuasionExists ']//span[@class=' fontSize18 blackFont']"));
        for (WebElement all: prices){
            System.out.println(all.getText());
        }

//        WebElement element=  driver.findElement(By.xpath("//h2[@class=\"HomePageSectionHeader_homePageSectionHeader_heading__HVYsv\"and text()='Web Development']"));
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
       // jse.executeScript("window.scrollBy(0,500)");

//        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

//        try {Thread.sleep(3000);}
//        catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        jse.executeScript("window.scrollBy(0,-500)");
       // jse.executeScript("arguments[0].scrollIntoView();",element);

        //  String url = driver.getCurrentUrl();
//        System.out.println(url);
//        String handle = driver.getWindowHandle();
//        System.out.println(handle);

//        WebElement source = driver.findElement(By.id("box1"));
//        WebElement target = driver.findElement(By.id("box101"));
//
//        Actions actions = new Actions(driver);
//        actions.clickAndHold(source).moveToElement(target).release().build().perform();
//
//       // driver.findElement(By.xpath("//a[text()='Drag And Drop scripts from DHTMLGoodies.com']")).click();
//        driver.navigate().to("https://www.geeksforgeeks.org/python-programming-language-tutorial/");
//        String firstHandle = driver.getWindowHandle();
//        System.out.println(firstHandle);
//
//        driver.findElement(By.xpath("//div[text()='DSA to Development: A Complete Guide']")).click();
//
//        String SecondHandle = driver.getWindowHandle();
//        System.out.println(SecondHandle);
//
//        Set<String> bothHandles = driver.getWindowHandles();
//        for (String sepHandles : bothHandles) {
//            System.out.println("bothHandles  " + sepHandles);
//        }
//
//        driver.close();
//        String closeHandle = driver.getWindowHandle();
//        System.out.println(closeHandle);

//            if (firstHandle.equals(sepHandles)){
//        }else {
//                driver.switchTo().window(sepHandles);
//            }

//       driver.quit();
//        driver.close();
//        System.out.println("closed");
//        Set<String> handles2 = driver.getWindowHandles();
//        for (String sepHandles1 : handles2) {
//            System.out.println("After Close " + sepHandles1);
//            if (firstHandle.equals(sepHandles1)) {
//            } else {
//                driver.switchTo().window(sepHandles1);
//            }
//            driver.findElement(By.id("course_applynow_header")).click();
//
//        }
    }
}
