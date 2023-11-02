package com.urbuddi.locaters;

import net.serenitybdd.core.pages.PageObject;

public class AddEmployeeLocaters extends PageObject {
	public String AllEmployees_Menu = "xpath=//p[text()=\"All Employees\"]";

	public String AllEmployees_Page = "xpath=//header[text()=\"All Employees\"]";
	public String AddEmployee_Button = "xpath=//*[text()=\"Add Employee\"]";
	public String AddEmployee_poup = "xpath=//h3[text()=\"Add Employee\"]";
	public String AddEmployee_Firstname = "css=#firstName";
	public String AddEmployee_Lastname = "css=[name=\"lastName\"]";
	public String AddEmployee_EmployeeID = "css=[placeholder=\"Employee ID\"]";
	public String AddEmployee_Email = "css=[name=\"email\"]";
	public String AddEmployee_Role_Dropdown = "css=#role";
	public String AddEmployee_select_Role = "css=#role option:nth-child(1)";
	public String AddEmployee_Password = "css=#password";
	public String AddEmployee_dob = "css=#dob";
	public String AddEmployee_joiningDate = "css=#joiningDate";
	public String AddEmployee_Qualifications = "css=#qualifications";
	public String AddEmployee_Department = "css=#department";
	public String AddEmployee_GenderDropdown = "css=#gender";
	public String AddEmployee_Select_Gender = "xpath=//option[text()=\"Male\"]";
	public String AddEmployee_MobileNumber = "css=#mobilenumber";
	public String AddEmployee_BloodGroup = "css=#bloodGroup";
	public String AddEmployee_Select_BloodGroup = "xpath=//option[text()=\"A+\"]";
	public String AddEmployee_Designation = "css=#designation";
	public String AddEmployee_Salary = "css=#salary";
	public String AddEmployee_Location = "css=#location";
	public String AddEmployee_Certificates_Dropdown = "xpath=//button[text()=\"Certificates \"]";
	public String AddEmployee_Select_Certificates_ = "xpath=//*[text()=\"10th\"]";

	public String AddEmployee_Scroll = "xpath=//div[contains(@class,\"horizontal-scroll-container\")]/..";
	public String AddEmployee_hamburger_icon = "css=.hamburger-icon";
	public String AddEmployee_Cancel_Icon = "css=.close-icon";

	public String AddEmployee_Submit = "xpath=//*[text()=\"Submit\"]";
	public String AddEmployee_Delete_Popup = "xpath=//h4[text()=\"Delete\"]";
	public String AddEmployee_Delete_Button = "xpath=//button[text()=\"Delete\"]";

	

}
