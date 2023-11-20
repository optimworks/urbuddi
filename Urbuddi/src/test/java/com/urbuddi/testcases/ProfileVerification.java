package com.urbuddi.testcases;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.urbuddi.steps.UrbuddiSteps;
import com.urbuddi.utilities.CsvDataReader;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;

@RunWith(SerenityRunner.class)
public class ProfileVerification {
	@Managed
	WebDriver driver;
	String randomEmail;
	String password;
	String fullname;
	String username;
	String dob;
	String mobileNumber;
	String RandomEmployeeID;
	String latestpassword;

	@Steps
	UrbuddiSteps urbuddy;
	CsvDataReader csvDataReader = new CsvDataReader();
	List<String[]> data = csvDataReader
			.readDataFromCsv("D:\\urbuddi_git\\urbuddi\\Urbuddi\\src\\test\\resources\\datawriter.csv");

	@TestData(columnNames = "Email, password,fullname ,mobileNumber,RandomEmployeeID,latestpassword")

	@Qualifier
	public String qualifier() {
		return " - " + " RandomEmail = " + randomEmail + " and " + " Password = " + password + " fullname = " + fullname
				+ " dob= " + dob + " dob	= " + dob + " mobileNumber	= " + mobileNumber + " RandomEmployeeID	= "
				+ RandomEmployeeID + " latestpassword= " + latestpassword;
	}
	
	@Title("Launch Urbuddi Application")
	@Before
	public void launchApplicationURL() {

		urbuddy.launchURL();
	}
	@Title("Created Roles Profile Verification")
	@Test
	public void profileVerification() {
		for(int i=1;i<=4;i++) {

		urbuddy.loginToCreatedRoleAccount(randomEmail, password);
		urbuddy.clickOnLoginButton();
		urbuddy.goToYourProfile();
		urbuddy.verifyIsProfilePageDisplayed();
		urbuddy.verifyUserProfileDetails(fullname);
		//urbuddy.getDobText(dob);
		urbuddy.editProfile(fullname, mobileNumber);
		urbuddy.clickEmploymentDetailsTab();
		urbuddy.getEmploymentIdText(RandomEmployeeID);
		urbuddy.addSkill(fullname);
		urbuddy.clickOnOthersTab();
		urbuddy.updatePassword(password, latestpassword);
		urbuddy.userLogout();
		}
	}
}
