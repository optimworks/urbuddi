package com.urbuddi.testcases;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.urbuddi.steps.UrbuddiSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom("D:\\Projects\\Automation\\Serenity\\Urbuddi\\src\\test\\resources\\LoginTestData.csv")
@RunWith(SerenityParameterizedRunner.class)
public class LoginTestCase {

	private String username;
	private String password;

	Faker faker = new Faker();
	private String iusername = faker.name().firstName().toLowerCase() + "@yopmail.com";
	private String ipassword = "Password" + faker.number().numberBetween(1, 1000);

	@Managed
	WebDriver driver;

	@Steps
	UrbuddiSteps urbuddy;

	@TestData(columnNames = "Username, Password")
	@Qualifier
	public String qualifier() {
		return " - " + " Username = " + username + " and " + " Password = " + password + " should display ";
	}

	@Before
	public void launchURL() {
		urbuddy.launchURL();
		urbuddy.verifyIsLoginPageDisplayed();
	}

	@Title("Login with valid username and valid password")
	@Test
	public void loginWithValidCreds() {
		urbuddy.inputCredentials(username, password);
		urbuddy.clickOnLoginButton();
		urbuddy.verifyIsHomePageDisplayed();
		urbuddy.goToYourProfile();
		urbuddy.verifyIsProfilePageDisplayed();
		urbuddy.goToEmploymentDetails();
		urbuddy.verifyAreEmploymentDetailsDisplayed();

		if (urbuddy.getRole() == "Admin") {
			urbuddy.verifyAdminMenuItems();
		} else if (urbuddy.getRole() == "HR") {
			urbuddy.verifyHRMenuItems();
		} else if (urbuddy.getRole() == "Lead") {
			urbuddy.verifyLeadMenuItems();
		} else if (urbuddy.getRole() == "Employee") {
			urbuddy.verifyEmployeeMenuItems();
		}
	}

	@Title("Login with empty creds")
	@Test
	public void loginWithEmptyCreds() {
		urbuddy.clickOnLoginButton();
		urbuddy.verifyIsRequiredTextDisplayed();
	}

	@Title("Login with invalid creds")
	@Test
	public void loginWithInvalidCreds() {
		urbuddy.inputCredentials(iusername, ipassword);
		urbuddy.clickOnLoginButton();
		urbuddy.verifyIsInvalidCredTextDisplayed();
	}

	@Title("Logout from the user account")
	@Test
	public void logout() {
		urbuddy.inputCredentials(username, password);
		urbuddy.clickOnLoginButton();
		urbuddy.verifyIsHomePageDisplayed();
		urbuddy.clickOnLogoutButton();
		urbuddy.verifyIsLoginPageDisplayed();
	}
}
