package com.urbuddi.steps;

import com.urbuddi.pages.AddEmployeePage;

import com.urbuddi.pages.LoginPage;
import com.urbuddi.pages.LogoutPage;
import com.urbuddi.pages.ResourceTrackingPage;
import com.urbuddi.pages.YourProfilePage;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class UrbuddiSteps {
	LoginPage login;
	YourProfilePage profile;
	AddEmployeePage AddEmployee;
	
	LogoutPage logout;
	ResourceTrackingPage resourcetracking;

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

	@Step
	public void clickAllEmployeesMenuOption() {
		AddEmployee.clickOnAllEmployeesMenuOption();
	}

	@Step
	public void userLogout() {
		logout.logoutuser();
	}

	@Step
	public void verifyAllEmployeePage() {
		AddEmployee.verifyAllEmployeesPageIsDisplayed();
	}

	@Step
	public void clickOnAllEmployeeButton() {
		AddEmployee.clickOnAddEmployeeButton();
	}

	@Step
	public void verifyAddEmployeepoup() {
		AddEmployee.VerifyAddEmployeepoup();
	}

	@Step
	public void createEmployeeRoles(int i, String Firstname, String Lastname, String EmployeeID, String Email,
			String password, String dob, String joiningDate, String Qualifications, String Department,
			String MobileNumber, String Designation, String Salary) {
		AddEmployee.createAddEmployeeRoles(i, Firstname, Lastname, EmployeeID, Email, password, dob, joiningDate,
				Qualifications, Department, MobileNumber, Designation, Salary);
	}

	@Step
	public void loginToCreatedRoleAccount(String email, String password) {
		login.verifyIsLoginPageDisplayed();
		login.inputCredentials(email, password);
	}

	@Step
	public void verifyUserProfileDetails(String fullname) {
		profile.verifyUserProfileDetails(fullname);
	}

	@Step
	public void getDobText(String Dob) {
		profile.getDobText(Dob);
	}

	@Step
	public void clickEmploymentDetailsTab() {
		profile.clickEmploymentDetailsTab();
	}

	@Step
	public void getEmploymentIdText(String getEmploymentId) {
		profile.getEmploymentIdText(getEmploymentId);
	}

	@Step
	public void getUserRoleText(String role) {
		profile.getUserRoleText(role);
	}

	@Step
	public void clickOnOthersTab() {
		profile.clickOnOthersTab();
	}

	@Step
	public void updatePassword(String currentpassword, String latestPassword) {
		profile.updatePassword(currentpassword, latestPassword);
	}

	@Step
	public void editProfile(String contactname, String mobilenumber) {
		profile.editProfile(contactname, mobilenumber);
	}

	@Step
	public void addSkill(String skillname) {
		profile.addSkill(skillname);
	}

	@Step
	public void clickResourceTrackingMenuOption() {
		resourcetracking.resourceTrackingMenuOption();
	}

	@Step
	public void verifyResourceTrackingPage() {
		resourcetracking.verifyResourceTrackingHeader();
	}

	@Step
	public void addResource(String employeeid, String allocateddate, String serialid, String model) {
		resourcetracking.addResource(employeeid, allocateddate, serialid, model);
	}

}
