package com.urbuddi.pages;

import java.util.Random;

import com.urbuddi.base.BasePage;
import com.urbuddi.locaters.AddEmployeeLocaters;
import com.urbuddi.locaters.LoginLocaters;

import net.bytebuddy.asm.Advice.OffsetMapping.Target;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class AddEmployeePage extends BasePage {
	AddEmployeeLocaters AddEmployee;
	LoginLocaters login;

	public void clickOnAllEmployeesMenuOption() {

		click(AddEmployee.AllEmployees_Menu);
	}

	public void verifyAllEmployeesPageIsDisplayed() {
		elementPresence(AddEmployee.AllEmployees_Page);
	}

	public void clickOnAddEmployeeButton() {
		click(AddEmployee.AddEmployee_Button);
	}

	public void VerifyAddEmployeepoup() {
		elementPresence(AddEmployee.AddEmployee_poup);
	}

	public void createAddEmployeeRoles(int i, String Firstname, String Lastname, String EmployeeID, String Email,
			String password, String dob, String joiningDate, String Qualifications, String Department,
			String MobileNumber, String Designation, String Salary) {
		type(AddEmployee.AddEmployee_Firstname, Firstname);
		type(AddEmployee.AddEmployee_Lastname, Lastname);
		type(AddEmployee.AddEmployee_EmployeeID, EmployeeID);
		type(AddEmployee.AddEmployee_Email, Email);
		click(AddEmployee.AddEmployee_Role_Dropdown);
		click("css=#role option:nth-child(" + i + ")");
		type(AddEmployee.AddEmployee_Password, password);
		type(AddEmployee.AddEmployee_dob, dob);
		type(AddEmployee.AddEmployee_joiningDate, joiningDate);
		type(AddEmployee.AddEmployee_Qualifications, Qualifications);
		type(AddEmployee.AddEmployee_Department, Department);
		click(AddEmployee.AddEmployee_GenderDropdown);
		click(AddEmployee.AddEmployee_Select_Gender);
		type(AddEmployee.AddEmployee_MobileNumber, MobileNumber);
		click(AddEmployee.AddEmployee_BloodGroup);
		click(AddEmployee.AddEmployee_Select_BloodGroup);
		type(AddEmployee.AddEmployee_Designation, Designation);
		type(AddEmployee.AddEmployee_Salary, Salary);
		type(AddEmployee.AddEmployee_Location, "hyderabad");
		click(AddEmployee.AddEmployee_Certificates_Dropdown);
		click(AddEmployee.AddEmployee_Select_Certificates_);
		click(AddEmployee.AddEmployee_Submit);

	}

	public WebElementFacade fileInputField(String locator) {
		return find(locator);
	}

	public void uploadFile(String locator, String filePath) {
		element(fileInputField(locator)).sendKeys(filePath);
	}

	public void Delete_Employee(String employeeid) {
		click("css=[id='" + employeeid + "']>path");
		elementPresence(AddEmployee.AddEmployee_Delete_Popup);
		click(AddEmployee.AddEmployee_Delete_Button);
	}
}
