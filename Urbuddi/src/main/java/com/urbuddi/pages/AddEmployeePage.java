package com.urbuddi.pages;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.urbuddi.base.BasePage;

public class AddEmployeePage extends BasePage {
	Random objGenerator = new Random();
	int randomNumber = objGenerator.nextInt(1000);

	
	String AllEmployees_Menu = "xpath=//p[text()=\"All Employees\"]";

	String AllEmployees_Page = "xpath=//header[text()=\"All Employees\"]";
	String AddEmployee_Button = "xpath=//*[text()=\"Add Employee\"]";
	String AddEmployee_poup = "xpath=//h3[text()=\"Add Employee\"]";
	String AddEmployee_Firstname = "css=#firstName";
	String AddEmployee_Lastname = "css=[name=\"lastName\"]";
	String AddEmployee_EmployeeID = "css=[placeholder=\"Employee ID\"]";
	String AddEmployee_Email = "css=[name=\"email\"]";
	String AddEmployee_Role_Dropdown = "css=#role";
	// String AddEmployee_select_Role = "css=#role option:nth-child(1)";
	String AddEmployee_Password = "css=#password";
	String AddEmployee_dob = "css=#dob";
	String AddEmployee_joiningDate = "css=#joiningDate";
	String AddEmployee_Qualifications = "css=#qualifications";
	String AddEmployee_Department = "css=#department";
	String AddEmployee_GenderDropdown = "css=#gender";
	String AddEmployee_Select_Gender = "xpath=//option[text()=\"Male\"]";
	String AddEmployee_MobileNumber = "css=#mobilenumber";
	String AddEmployee_BloodGroup = "css=#bloodGroup";
	String AddEmployee_Select_BloodGroup = "xpath=//option[text()=\"A+\"]";
	String AddEmployee_Designation = "css=#designation";
	String AddEmployee_Salary = "css=#salary";
	String AddEmployee_Location = "css=#location";
	String AddEmployee_Certificates_Dropdown = "xpath=//button[text()=\"Certificates \"]";
	String AddEmployee_Select_Certificates_ = "xpath=//*[text()=\"10th\"]";
	String AddEmployee_Submit = "xpath=//*[text()=\"Submit\"]";
	String AddEmployee_Delete_Popup = "xpath=//h4[text()=\"Delete\"]";
	String AddEmployee_Delete_Button = "xpath=//button[text()=\"Delete\"]";

	public void click_On_AllEmployees_Menu() {
		
		

		click(AllEmployees_Menu);
	}

	public void Verify_All_Employees_Page_IsDisplayed() {
		elementPresence(AllEmployees_Page);
	}

	public void click_On_Add_Employee_Button() {
		click(AddEmployee_Button);
	}

	public void Verify_Add_Employee_poup() {
		elementPresence(AddEmployee_poup);
	}

	public void Add_Employee_Details(int i, String Firstname, String Lastname, String EmployeeID, String Email,
			String password, String dob, String joiningDate, String Qualifications, String Department,
			String MobileNumber, String Designation, String Salary) {
		String RandomEmail = Email + randomNumber + "@yopmail.com";
		String RandomEmployeeID = EmployeeID + randomNumber;


		type(AddEmployee_Firstname, Firstname);
		type(AddEmployee_Lastname, Lastname);
		type(AddEmployee_EmployeeID, RandomEmployeeID);
		type(AddEmployee_Email, RandomEmail);
		click(AddEmployee_Role_Dropdown);
		click("css=#role option:nth-child(" + i + ")");
		type(AddEmployee_Password, password);
		type(AddEmployee_dob, dob);
		type(AddEmployee_joiningDate, joiningDate);
		type(AddEmployee_Qualifications, Qualifications);
		type(AddEmployee_Department, Department);
		click(AddEmployee_GenderDropdown);
		click(AddEmployee_Select_Gender);
		type(AddEmployee_MobileNumber, MobileNumber);
		click(AddEmployee_BloodGroup);
		click(AddEmployee_Select_BloodGroup);
		type(AddEmployee_Designation, Designation);
		type(AddEmployee_Salary, Salary);
		type(AddEmployee_Location, "hyderabad");
		click(AddEmployee_Certificates_Dropdown);
		click(AddEmployee_Select_Certificates_);
		click(AddEmployee_Submit);
		

	}
	public void Delete_employee(String EmployeeID) {
		
		String RandomEmployeeID = EmployeeID + randomNumber;
		click("css=# "+RandomEmployeeID+">path ");
		//wait_until_click("xpath=//*[@id="+RandomEmployeeID+"] ");
		textvisiblie(AddEmployee_Delete_Popup);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(AddEmployee_Delete_Button);
	}
	

}
