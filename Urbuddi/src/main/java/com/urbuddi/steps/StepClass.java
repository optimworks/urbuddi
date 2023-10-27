package com.urbuddi.steps;

import com.urbuddi.pages.AddEmployeePage;
import com.urbuddi.pages.LoginPage;

import net.thucydides.core.annotations.Step;

public class StepClass {
	AddEmployeePage AddEmployee;
	LoginPage login;
	@Step
	public void AllEmployees_Menu()  {
		AddEmployee.click_On_AllEmployees_Menu();
	}
	
	
	
	  @Step public void Verify_AllEmployee_Page() {
	  AddEmployee.Verify_All_Employees_Page_IsDisplayed(); }
	  
	  
	  @Step public void Click_on_AllEmployee() {
	  AddEmployee.click_On_Add_Employee_Button(); }
	  
	  
	  @Step public void Verify_AddEmployee_poup() {
	  AddEmployee.Verify_Add_Employee_poup(); }
	  
	  
	  @Step public void AddEmployes_Details(int i,String Firstname,String Lastname,String EmployeeID,String Email,String password,String dob,String joiningDate,String Qualifications,String Department,String MobileNumber,String Designation,String Salary) 
	  { 
		  AddEmployee.Add_Employee_Details(i, Firstname, Lastname, EmployeeID, Email, password,dob, joiningDate, Qualifications, Department, MobileNumber, Designation, Salary);
	  }
	 
	

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
	
	
	
	
	
	
	
	
	
	
	
}
