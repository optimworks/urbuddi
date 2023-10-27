package com.urbuddi.steps;

import com.urbuddi.pages.LoginPage;
import com.urbuddi.pages.YourProfilePage;

import net.thucydides.core.annotations.Step;

public class UrbuddiSteps {
	LoginPage login;
	YourProfilePage profile;

	@Step
	public void launchURL() {
		login.open();
	}

	@Step
	public void verifyIsLoginPageDisplayed() {
		login.verifyIsLoginPageDisplayed();
	}

	@Step
	public void inputCredentials(String email, String password) {
		login.inputCredentials(email, password);
	}

	@Step
	public void clickOnLoginButton() {
		login.clickOnLoginButton();
	}

	@Step
	public void verifyIsHomePageDisplayed() {
		login.verifyIsHomePageDisplayed();
	}

	@Step
	public void verifyIsRequiredTextDisplayed() {
		login.verifyIsRequiredTextDisplayed();
	}

	@Step
	public void goToYourProfile() {
		profile.goToYourProfile();
	}

	@Step
	public void verifyIsProfilePageDisplayed() {
		profile.verifyIsProfilePageDisplayed();
	}

	@Step
	public void verifyAreEmploymentDetailsDisplayed() {
		profile.verifyAreEmploymentDetailsDisplayed();
	}

	@Step
	public String getRole() {
		return profile.getRole();
	}

	@Step
	public void verifyAdminMenuItems() {
		profile.verifyAdminMenuItems();
	}

	@Step
	public void verifyLeadMenuItems() {
		profile.verifyLeadMenuItems();
	}

	@Step
	public void verifyHRMenuItems() {
		profile.verifyHRMenuItems();
	}

	@Step
	public void verifyEmployeeMenuItems() {
		profile.verifyEmployeeMenuItems();
	}

	@Step
	public void goToEmploymentDetails() {
		profile.goToEmploymentDetails();
	}

	@Step
	public void verifyIsInvalidCredTextDisplayed() {
		login.verifyIsInvalidCredTextDisplayed();
	}
	
	@Step
	public void clickOnLogoutButton() {
		login.clickOnLogoutButton();
	}
}
