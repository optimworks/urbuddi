package com.urbuddi.testcases;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.urbuddi.steps.StepClass;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;

//@RunWith(SerenityRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "4")
@UseTestDataFrom(value = "C:\\Urbuddi\\src\\test\\resources\\testdata\\data.csv")
public class UrbuddiTestCase extends PageObject {

	@Managed
	WebDriver driver;
	public String username;
	public String password;
	public String firstname	;
	public String lastname;
	public String employeeID;	
	public String email;
	public String dob	;
	public String joiningDate;
	public String qualifications;	
	public String department;
	public String mobileNumber;	
	public String designation;
	public String salary	;


	@Steps
	StepClass stepclass;

	@TestData(columnNames = "Username,Password,Firstname, Lastname, EmployeeID, Email, dob, joiningDate, Qualifications, Department, MobileNumber, Designation, Salary")

	@Qualifier
	public String qualifier() {
		return " - " + " Username = " + username + " and " + " Password = " + password + " Firstname = " + firstname +" Lastname = " + lastname +" EmployeeID = " + employeeID+" Email= " + email+" dob	= " + dob	+" joiningDate	= " + joiningDate	+" Qualifications	= " + qualifications+" Department= " + department+" MobileNumber= " + mobileNumber	+" Designation= " + designation	+" Salary	= " + salary+"should display ";
	}

	@Title("Login with empty creds")
	@Test
	public void verifyLoginWithEmptyCreds() {
		stepclass.launchURL();
		stepclass.verifyIsLoginPageDisplayed();
		stepclass.clickOnLoginButton();
		stepclass.verifyIsRequiredTextDisplayed();
	}

	@Title("Login with valid username and valid password")
	@Test
	public void verifyLoginWithValidCreds() {
		stepclass.launchURL();
		stepclass.verifyIsLoginPageDisplayed();
		stepclass.inputCredentials(username, password);
		stepclass.clickOnLoginButton();
		stepclass.verifyIsHomePageDisplayed();
	}

	@Title("ADD Employee with employee details")
	@Test
	public void ADDEmployee()  {
		open();
		stepclass.verifyIsLoginPageDisplayed();
		stepclass.inputCredentials(username, password);
		stepclass.clickOnLoginButton();
		stepclass.verifyIsHomePageDisplayed();
		for(int i=1;i<=4;i++) {
		stepclass.AllEmployees_Menu();
		stepclass.Verify_AllEmployee_Page();
		stepclass.Click_on_AllEmployee();
		stepclass.AddEmployes_Details(i,firstname, lastname, employeeID, email,password, dob, joiningDate, qualifications, department, mobileNumber, designation, salary);	
		}

	}

}
