package Screens;

import BaseScreen.ScreenBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ExcelManager;
import utilities.Scroll;
import utilities.WaitMethods;

import java.util.List;

public class CoursesScreen extends ScreenBase {
    AppiumDriver driver;
    ExcelManager excel = new ExcelManager();

    public CoursesScreen(AppiumDriver driver){
        this.driver=driver;
    }

    String courseCategory = excel.getCellData("CoureseData","Category",5);
    String courseName = excel.getCellData("CoureseData","CourseName",3);

   private final By coursesTab = AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"free.programming.programming:id/navigation_bar_item_icon_view\"])[4]");
   private final By viewAllButton = AppiumBy.xpath("//android.widget.TextView[@text=\""+courseCategory+"\"]/..");
   private final By registerButton = AppiumBy.id("free.programming.programming:id/registerButton");
   private final By fullNameTextField = AppiumBy.id("free.programming.programming:id/nameEditText");
   private final By studentRadioButton = AppiumBy.id("free.programming.programming:id/studentRadioButton");
   private final By workingProfessionalRadioButton = AppiumBy.id("free.programming.programming:id/workingRadioButton");
   private final By countryCodeDropDown = AppiumBy.id("free.programming.programming:id/countrySpinner");
   private final By phoneNumberTextField = AppiumBy.id("free.programming.programming:id/mobileEditText");
   private final By graduationYearTextField = AppiumBy.id("free.programming.programming:id/graduationEditText");
   private final By collegeOrOrganizationNameTextField = AppiumBy.id("free.programming.programming:id/collegeEditText");
   private final By saveAndNextButton = AppiumBy.id("free.programming.programming:id/registerButton");
    private final By payFeeButton = AppiumBy.id("free.programming.programming:id/enroll");
    private final By couponCodeTextField = AppiumBy.id("free.programming.programming:id/enterCouponCode");
    private final By applyCouponButton = AppiumBy.id("free.programming.programming:id/applyCoupon");
    private final By totalAmount = AppiumBy.id("free.programming.programming:id/totalAmount");
   // private final By saveAndNextButton = AppiumBy.id("free.programming.programming:id/registerButton");
    private final By finalAmount = AppiumBy.id("free.programming.programming:id/courseOfferPrice");
    public final By proceedToPayButton = AppiumBy.id("free.programming.programming:id/paymentButton");
    private final By courseNameText = AppiumBy.id("free.programming.programming:id/courseName");
    private final By courseInstructorName = AppiumBy.id("free.programming.programming:id/authorName");


    public CoursesScreen clickCoursesTab(){
        driver.findElement(coursesTab).click();
        return this;
    }

    public CoursesScreen viewAllButton(){
        System.out.println(courseCategory);
        System.out.println(courseName);
        By locator =AppiumBy.id("free.programming.programming:id/tvCategory");
        List<WebElement> elements =driver.findElements(locator);
        for (WebElement we: elements){
            String text = we.getText();
            if (text.equals(courseCategory)){
                driver.findElement(viewAllButton).click();
            }
            else {
                Scroll.scrollDown(courseCategory);
                driver.findElement(viewAllButton).click();
            }
            System.out.println("view all clicked");
            if (driver.findElement(AppiumBy.xpath("//android.widget.TextView[ @text=\""+courseName+"\"]")).isDisplayed()){
                System.out.println("checking");
                driver.findElement(AppiumBy.xpath("//android.widget.TextView[ @text=\""+courseName+"\"]")).click();
            }
            else {
                Scroll.scrollDownAndClick(courseName);
            }
        }
        return this;
    }



    public CoursesScreen clickViewAllButton() {

        System.out.println(courseCategory);
        System.out.println(courseName);
//        if (!driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.programming.programming:id/tvCategory\" and @text=\""+courseCategory+"\"]")).isDisplayed()) {
        if (!driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.programming.programming:id/tvCategory\"]")).isDisplayed()) {

            System.out.println("entered");
            Scroll.scrollDown(courseCategory);
        }
        System.out.println("direct");
        driver.findElement(viewAllButton).click();
        if (!driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.programming.programming:id/courseName\" and @text=\""+courseName+"\"]")).isDisplayed()){
            Scroll.scrollDownAndClick(courseName);
    }
        else {
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.programming.programming:id/courseName\" and @text=\""+courseName+"\"]")).click();
        }
        return this;

    }

    public CoursesScreen clickRegisterButton(){
        WaitMethods.explicitWait(registerButton);
        driver.findElement(registerButton).click();
        return this;
    }

    public CoursesScreen enterFullName(String fullName){
        WaitMethods.fluentWait(fullNameTextField);
        driver.findElement(fullNameTextField).clear();
        driver.findElement(fullNameTextField).sendKeys(fullName);
        return this;
    }

    public CoursesScreen clickStudentRadioButton(){
        driver.findElement(studentRadioButton).click();
        return this;
    }

    public CoursesScreen clickWorkingProfessionalRadioButton(){
        driver.findElement(workingProfessionalRadioButton).click();
        return this;
    }

    public CoursesScreen clickCountryCodeDropDown(String countryCode){
        WaitMethods.explicitWait(countryCodeDropDown);
        driver.findElement(countryCodeDropDown).click();
        Scroll.scrollDownAndClick(countryCode);
        return this;
    }

    public CoursesScreen enterPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberTextField).clear();
        driver.findElement(phoneNumberTextField).sendKeys(String.valueOf(phoneNumber));
        return this;
    }

    public CoursesScreen enterGraduationYear(String graduationYear){
        driver.findElement(graduationYearTextField).clear();
        driver.findElement(graduationYearTextField).sendKeys(String.valueOf(graduationYear));
        return this;
    }

    public CoursesScreen enterCollegeOrOrganizationName(String collegeOrOrganizationName){
        driver.findElement(collegeOrOrganizationNameTextField).clear();
        driver.findElement(collegeOrOrganizationNameTextField).sendKeys(collegeOrOrganizationName);
        return this;
    }

    public void clickSaveAndNextButton(){
        driver.findElement(saveAndNextButton).click();
    }

    public CoursesScreen clickPayFeeButtonButton(){
        driver.findElement(payFeeButton).click();
        return this;
    }

    public CoursesScreen enterCouponCode(String couponCode){
        driver.findElement(couponCodeTextField).sendKeys(couponCode);
        return this;
    }

    public CoursesScreen clickApplyCouponButton(){
        driver.findElement(applyCouponButton).click();
        return this;
    }

    public CoursesScreen clickProceedToPayButton(){
        driver.findElement(proceedToPayButton).click();
        return this;
    }

    public String getCourseName(){
        return driver.findElement(courseNameText).getText();
    }

    public String getCourseInstructorName(){
        Scroll.scrollDown("Course Instructor");
        return driver.findElement(courseInstructorName).getText();
    }

    public String getTotalAmount(){
        return driver.findElement(totalAmount).getText();
    }

    public String getFinalAmount(){
        return driver.findElement(finalAmount).getText();
    }
}
