package com.urbuddi.pages;

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
}
