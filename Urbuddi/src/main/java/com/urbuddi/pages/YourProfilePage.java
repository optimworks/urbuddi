package com.urbuddi.pages;

import org.junit.Assert;

import com.urbuddi.base.BasePage;

public class YourProfilePage extends BasePage {
	String YourProfileMenu = "css=[href*='profile'] li";
	String ProfilePic = "css=.profile-pic-container";
	String CoverPic = "css=.cover-pic";
	String EmploymentDetails = "xpath=//button[text()='Employment Details']";
	String EmployeeID = "xpath=//label[text()='Employee ID']";
	String Role = "xpath=//label[text()='Role']";
	String RoleValue = "xpath=//label[text()='Role']//following-sibling::p";
	String Homemenu = "xpath=//*[text()='Home']/..";
	String AllEmployeesMenu = "css=[href*='allemployees'] li";
	String LeaveManagementMenu = "css=[href*='leave_management'] li";
	String SalaryManagementMenu = "css=[href*='salary'] li";
	String PayslipMenu = "css=[href*='payslip'] li";
	String ResourceTrackingMenu = "css=[href*='resource_tracking'] li";
	String ReimbursementMenu = "css=[href*='resource_tracking'] li";
	String ExpenditureMenu = "css=[href*='expenditure'] li";
	String LogoutButton = "button[class*='logout']";
	String PersonalInfoTab = "xpath=//*[text()=\"Personal Info\"]";
	String FullNameGettext = "xpath=(//*[text()=\"Full Name\"]/following::p)[1]";
	String DobGettext = "xpath=(//*[text()=\"Full Name\"]/following::p)[3]";
	String EmploymentTab = "xpath=//*[text()=\"Employment Details\"]";
	String EmploymentId = "xpath=(//*[text()=\"Employee ID\"]/following::p)[1]";
	String UserRole = "xpath=//*[text()=\"Role\"]/following::p)[1]";
	String OthersTab = "xpath=//*[text()=\"Others\"]";
	String PasswordText = "xpath=//*[text()=\"Password Reset\"]";
	String CurrentPassword = "css=[name=\"currentPassword\"]";
	String NewPassword = "css=[name=\"NewPassword\"]";
	String PasswordResetSubmitButton = "css=[type=\"submit\"]";
	String EditProfile = "xpath=//*[text()=\"Edit Profile\"]";
	String AccountDetailsText = "xpath=//*[text()=\"Account Details\"]";
	String EmergencyContactName = "css=#emergencyContactName";
	String Emergencymobilenumber = "css=#emergencymobilenumber";
	String ProfileEditSubmitButton = "xpath=//*[text()=\"Submit\"]";
	String SkillsTab = "xpath=//*[text()=\"Skills\"]";
	String AddSkillButton = "css=.addSkillsBtn";
	String AddSkillsPopup = "xpath=//*[text()=\"Add Skills\"]";
	String SkillName = "css=#skillName";
	String SkillRating = "css=#skillRating";
	String AddSkillSubmitButton = "xpath=//*[text()=\"Submit\"]";

	public void goToYourProfile() {
		click(YourProfileMenu);
	}

	public void verifyIsProfilePageDisplayed() {
		elementPresence(ProfilePic);
		elementPresence(CoverPic);
		getAttributeContainsText(YourProfileMenu, "class", "active");
	}

	public void goToEmploymentDetails() {
		click(EmploymentDetails);
	}

	public void verifyAreEmploymentDetailsDisplayed() {
		getAttributeContainsText(EmploymentDetails, "class", "active");
		elementPresence(EmployeeID);
		elementPresence(Role);
	}

	public String getRole() {
		return getElementText(RoleValue);
	}

	public void verifyAdminMenuItems() {
		elementPresence(Homemenu);
		elementPresence(YourProfileMenu);
		elementPresence(AllEmployeesMenu);
		elementPresence(LeaveManagementMenu);
		elementPresence(SalaryManagementMenu);
		elementPresence(PayslipMenu);
		elementPresence(ResourceTrackingMenu);
		elementPresence(ReimbursementMenu);
		elementPresence(ExpenditureMenu);
		elementPresence(LogoutButton);
	}

	public void verifyLeadMenuItems() {
		elementPresence(Homemenu);
		elementPresence(YourProfileMenu);
		elementPresence(LeaveManagementMenu);
		elementPresence(PayslipMenu);
		elementPresence(ReimbursementMenu);
		elementPresence(LogoutButton);
		elementNotPresence(AllEmployeesMenu);
		elementNotPresence(SalaryManagementMenu);
		elementNotPresence(ResourceTrackingMenu);
		elementNotPresence(ExpenditureMenu);
	}

	public void verifyHRMenuItems() {
		elementPresence(Homemenu);
		elementPresence(YourProfileMenu);
		elementPresence(AllEmployeesMenu);
		elementPresence(LeaveManagementMenu);
		elementPresence(PayslipMenu);
		elementPresence(ResourceTrackingMenu);
		elementPresence(ReimbursementMenu);
		elementPresence(ExpenditureMenu);
		elementPresence(LogoutButton);
		elementNotPresence(SalaryManagementMenu);
	}

	public void verifyEmployeeMenuItems() {
		elementPresence(Homemenu);
		elementPresence(YourProfileMenu);
		elementPresence(LeaveManagementMenu);
		elementPresence(PayslipMenu);
		elementPresence(ReimbursementMenu);
		elementPresence(LogoutButton);
		elementNotPresence(AllEmployeesMenu);
		elementNotPresence(SalaryManagementMenu);
		elementNotPresence(ResourceTrackingMenu);
		elementNotPresence(ExpenditureMenu);
	}

	public void verifyUserProfileDetails(String fullname) {
		elementPresence(PersonalInfoTab);
		elementPresence(FullNameGettext);
		String Fullnaname = getText(FullNameGettext);
		Assert.assertEquals(Fullnaname, fullname);
	}

	public void getDobText(String DOB) {
		elementPresence(DobGettext);
		String dob = getText(DobGettext);
		Assert.assertEquals(dob, DOB);
	}

	public void clickEmploymentDetailsTab() {
		click(EmploymentTab);
	}

	public void getEmploymentIdText(String employmentId) {
		elementPresence(EmploymentId);
		String EmpId = getText(EmploymentId);
		Assert.assertEquals(EmpId, employmentId);
	}

	public void getUserRoleText(String userRole) {
		elementPresence(UserRole);
		String Role = getText(UserRole);
		Assert.assertEquals(Role, userRole);
	}

	public void clickOnOthersTab() {
		click(OthersTab);
	}

	public void updatePassword(String currentpassword, String latestPassword) {
		elementPresence(PasswordText);
		type(CurrentPassword, currentpassword);
		type(NewPassword, latestPassword);
		click(PasswordResetSubmitButton);
	}

	public void editProfile(String contactname, String mobilenumber) {
		click(EditProfile);
		elementPresence(AccountDetailsText);
		type(EmergencyContactName, contactname);
		type(Emergencymobilenumber, mobilenumber);
		click(ProfileEditSubmitButton);
	}

	public void addSkill(String skillname) {
		click(SkillsTab);
		click(AddSkillButton);
		elementPresence(AddSkillsPopup);
		type(SkillName, skillname);
		type(SkillRating, "1");
		click(AddSkillSubmitButton);
	}

}
