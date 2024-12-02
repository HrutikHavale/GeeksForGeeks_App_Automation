package TestCases;

import BaseTest.TestBase;
import Screens.CoursesScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ExcelManager;
import utilities.Snackbar_Error;
import utilities.WaitMethods;

public class CoursesTest extends TestBase {

    CoursesScreen courses;
    ExcelManager excel = new ExcelManager();

    String invalidName = excel.getCellData("CoursesRegistrationData","FullName",2);
    String countryCode = excel.getCellData("CoursesRegistrationData","CountryCode",2);
    String phoneNumber = excel.getCellData("CoursesRegistrationData","PhoneNumber",2);
    String graduationYear = excel.getCellData("CoursesRegistrationData","GraduationYear",2);
    String collegeOrOrganization = excel.getCellData("CoursesRegistrationData","College/Organization",2);
    String validName = excel.getCellData("CoursesRegistrationData","FullName",3);
    String invalidPhoneNumber = excel.getCellData("CoursesRegistrationData","PhoneNumber",3);
    String invalidGraduationYear = excel.getCellData("CoursesRegistrationData","GraduationYear",4);
    String invalidCollegeName = excel.getCellData("CoursesRegistrationData","College/Organization",2);
    String spaceInCollegeName = excel.getCellData("CoursesRegistrationData","CountryCode",2);

    @BeforeTest
    public void init(){
        setup();
        courses=new CoursesScreen(driver);
    }

    @Test(priority = 1)
    public void courseRegistrationWithInvalidName(){
        courses.clickCoursesTab().viewAllButton().clickRegisterButton().enterFullName(invalidName).clickStudentRadioButton().clickCountryCodeDropDown(countryCode).enterPhoneNumber(phoneNumber).enterGraduationYear(graduationYear).enterCollegeOrOrganizationName(collegeOrOrganization).clickSaveAndNextButton();
        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Invalid Name(Only Alphabet, space are allowed).");
    }

//    @Test(priority = 2)
//    public void courseRegistrationWithInvalidPhoneNumber(){
//        courses.enterFullName(validName).clickStudentRadioButton().clickCountryCodeDropDown(countryCode).enterPhoneNumber(invalidPhoneNumber).enterGraduationYear(graduationYear).enterCollegeOrOrganizationName(collegeOrOrganization).clickSaveAndNextButton();
//        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Invalid Phone Number");
//    }
//
//    @Test(priority = 3)
//    public void courseRegistrationWithInvalidGraduationYear(){
//        courses.enterFullName(validName).clickStudentRadioButton().clickCountryCodeDropDown(countryCode).enterPhoneNumber(phoneNumber).enterGraduationYear(invalidGraduationYear).enterCollegeOrOrganizationName(collegeOrOrganization).clickSaveAndNextButton();
//        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Invalid Graduation Year");
//    }
//
//    @Test(priority = 4)
//    public void courseRegistrationWithInvalidCollegeName(){
//        courses.enterFullName(validName).clickStudentRadioButton().clickCountryCodeDropDown(countryCode).enterPhoneNumber(phoneNumber).enterGraduationYear(graduationYear).enterCollegeOrOrganizationName(invalidCollegeName).clickSaveAndNextButton();
//        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Invalid College Name");
//    }
//
//    @Test(priority = 5)
//    public void courseRegistrationWithOnlySpaceInCollegeName(){
//        courses.enterFullName(validName).clickStudentRadioButton().clickCountryCodeDropDown(countryCode).enterPhoneNumber(phoneNumber).enterGraduationYear(graduationYear).enterCollegeOrOrganizationName(spaceInCollegeName).clickSaveAndNextButton();
//        Assert.assertEquals(Snackbar_Error.snackbarMsg(driver),"Invalid College Name");
//    }
//
//    @Test(priority = 6)
//    public void courseRegistrationWithValidData(){
//        courses.enterFullName(validName).clickStudentRadioButton().clickCountryCodeDropDown(countryCode).enterPhoneNumber(phoneNumber).enterGraduationYear(graduationYear).enterCollegeOrOrganizationName(collegeOrOrganization).clickSaveAndNextButton();
//        if (driver.findElement(courses.proceedToPayButton).isDisplayed()){
//            Assert.assertTrue(true);
//        }
//        else {
//            Assert.fail();
//        }
//    }
}
