package com.urbuddi.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.urbuddi.base.BasePage;
import com.urbuddi.locaters.AddEmployeeLocaters;
import com.urbuddi.locaters.LoginLocaters;

import net.serenitybdd.core.annotations.findby.By;

public class AddEmployeePage extends BasePage {
	AddEmployeeLocaters addEmployee;
	LoginLocaters login;

	public void clickOnAllEmployeesMenuOption() {

		click(addEmployee.AllEmployees_Menu);
	}

	public void verifyAllEmployeesPageIsDisplayed() {
		elementPresence(addEmployee.AllEmployees_Page);
	}

	public void clickOnAddEmployeeButton() {
		click(addEmployee.AddEmployee_Button);
	}

	public void VerifyAddEmployeepoup() {
		elementPresence(addEmployee.AddEmployee_poup);
	}

	public void createAddEmployeeRoles(int i, String Firstname, String Lastname, String EmployeeID, String Email,
			String password, String dob, String joiningDate, String Qualifications, String Department,
			String MobileNumber, String Designation, String Salary) throws InterruptedException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		click(addEmployee.AddEmployee_Submit);
		type(addEmployee.AddEmployee_Firstname, Firstname);
		type(addEmployee.AddEmployee_Lastname, Lastname);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type(addEmployee.AddEmployee_EmployeeID, EmployeeID);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type(addEmployee.AddEmployee_Email, Email);
		click(addEmployee.AddEmployee_Role_Dropdown);
		Thread.sleep(2000);
		click("css=#role option:nth-child(" + i + ")");
		type(addEmployee.AddEmployee_Password, password);
		type(addEmployee.AddEmployee_dob, dob);
		type(addEmployee.AddEmployee_joiningDate, joiningDate);
		type(addEmployee.AddEmployee_Qualifications, Qualifications);
		type(addEmployee.AddEmployee_Department, Department);
		click(addEmployee.AddEmployee_GenderDropdown);
		click(addEmployee.AddEmployee_Select_Gender);
		type(addEmployee.AddEmployee_MobileNumber, MobileNumber);
		click(addEmployee.AddEmployee_BloodGroup);
		click(addEmployee.AddEmployee_Select_BloodGroup);
		type(addEmployee.AddEmployee_Designation, Designation);
		type(addEmployee.AddEmployee_Salary, Salary);
		type(addEmployee.AddEmployee_Location, "hyderabad");
		click(addEmployee.AddEmployee_Certificates_Dropdown);
		click(addEmployee.AddEmployee_Select_Certificates_);
		click(addEmployee.AddEmployee_Submit);
	}

	public void Delete_Employee(String employeeid) {
		click("css=[id='" + employeeid + "']>path");
		elementPresence(addEmployee.AddEmployee_Delete_Popup);
		click(addEmployee.AddEmployee_Delete_Button);
	}
}
