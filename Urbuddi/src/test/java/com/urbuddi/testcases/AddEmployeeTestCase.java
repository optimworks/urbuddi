package com.urbuddi.testcases;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.ibm.icu.impl.Row;
import com.urbuddi.locaters.LoginLocaters;

import com.urbuddi.steps.UrbuddiSteps;
import com.urbuddi.utilities.CsvDataReader;
import com.urbuddi.utilities.CsvDataWriter;
import com.urbuddi.utilities.RoleCredsLoader;

import ch.qos.logback.classic.db.names.ColumnName;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityRunner.class)
public class AddEmployeeTestCase {
	private CsvDataWriter csvDataWriter;
	@Managed
	WebDriver driver;
	@Steps
	UrbuddiSteps urbuddy;
	CsvDataReader csvDataReader = new CsvDataReader();
	List<String[]> data = csvDataReader
			.readDataFromCsv("D:\\urbuddi_git\\urbuddi\\Urbuddi\\src\\test\\resources\\data.csv");
	String username = data.get(1)[0];
	String password = data.get(1)[1];
	String firstname = data.get(1)[2];
	String lastname = data.get(1)[3];
	String employeeID = data.get(1)[4];
	String email = data.get(1)[5];
	String dob = data.get(1)[6];
	String joiningDate = data.get(1)[7];
	String qualifications = data.get(1)[8];
	String department = data.get(1)[9];
	String mobileNumber = data.get(1)[10];
	String designation = data.get(1)[11];
	String salary = data.get(1)[12];

	@TestData(columnNames = "Username,Password,Firstname, Lastname, EmployeeID, Email, dob, joiningDate, Qualifications, Department, MobileNumber, Designation, Salary,data.csv.get(1).get(1)")

	@Qualifier
	public String qualifier() {
		return " - " + " Username = " + username + " and " + " Password = " + password + " Firstname = " + firstname
				+ " Lastname = " + lastname + " EmployeeID = " + employeeID + " Email= " + email + " dob	= " + dob
				+ " joiningDate	= " + joiningDate + " Qualifications	= " + qualifications + " Department= "
				+ department + " MobileNumber= " + mobileNumber + " Designation= " + designation + " Salary	= " + salary
				+ "should display ";
	}

	@Title("Launch Urbuddi Application")
	@Before
	public void launchApplicationURL() {
		urbuddy.launchURL();
	}

	@Title("Login with valid credentials")
	@Test
	public void createAddEmployeeRoles() {
		this.csvDataWriter = new CsvDataWriter("D:\\urbuddi_git\\urbuddi\\Urbuddi\\src\\test\\resources\\data.csv");
		for (int i = 1; i <= 4; i++) {
			urbuddy.verifyIsLoginPageDisplayed();
			urbuddy.inputCredentials(username, password);
			urbuddy.clickOnLoginButton();
			urbuddy.verifyIsHomePageDisplayed();
			Random objGenerator = new Random();
			int randomNumber = objGenerator.nextInt(1000);
			int randomNumber1 = objGenerator.nextInt(10);
			int skillrating = randomNumber1;
			String RandomEmail = email + randomNumber + "@yopmail.com";
			String RandomEmployeeID = employeeID + randomNumber;
			String[] newData = { RandomEmployeeID };
			csvDataWriter.writeDataToCsv(newData);
			String latestpassword = password + randomNumber;
			String fullname = firstname + " " + lastname;
			urbuddy.clickAllEmployeesMenuOption();
			urbuddy.verifyAllEmployeePage();
			urbuddy.clickOnAllEmployeeButton();
			urbuddy.createEmployeeRoles(i, firstname, lastname, RandomEmployeeID, RandomEmail, password, dob,
					joiningDate, qualifications, department, mobileNumber, designation, salary);
			urbuddy.userLogout();
			urbuddy.loginToCreatedRoleAccount(RandomEmail, password);
			urbuddy.clickOnLoginButton();
			urbuddy.goToYourProfile();
			urbuddy.verifyIsProfilePageDisplayed();
			urbuddy.verifyUserProfileDetails(fullname);
			urbuddy.getDobText(dob);
			urbuddy.editProfile(fullname, mobileNumber);
			urbuddy.clickEmploymentDetailsTab();
			urbuddy.getEmploymentIdText(RandomEmployeeID);
			urbuddy.addSkill(fullname);
			urbuddy.clickOnOthersTab();
			urbuddy.updatePassword(password, latestpassword);
			urbuddy.userLogout();
		}
	}
}