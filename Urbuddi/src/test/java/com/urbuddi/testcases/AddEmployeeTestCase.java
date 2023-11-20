package com.urbuddi.testcases;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.github.javafaker.Faker;
import com.ibm.icu.impl.Row;
import com.opencsv.exceptions.CsvException;
import com.urbuddi.base.BasePage;
import com.urbuddi.locaters.LoginLocaters;
import com.urbuddi.steps.UrbuddiSteps;
import com.urbuddi.utilities.CsvDataReader;
import com.urbuddi.utilities.CsvDataWriter;
import com.urbuddi.utilities.CsvWriter1;
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
public class AddEmployeeTestCase extends BasePage {
	private CsvDataWriter csvDataWriter;
//	private CsvWriter1 csvDataWriter1;
	Random randomnumber = new Random();
	@Managed
	WebDriver driver;

	@Steps
	UrbuddiSteps urbuddy;
	CsvDataReader csvDataReader = new CsvDataReader();
	List<String[]> data = csvDataReader
			.readDataFromCsv("D:\\urbuddi_git\\urbuddi\\Urbuddi\\src\\test\\resources\\datareader.csv");
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
	public void createAddEmployeeRoles() throws InterruptedException, CsvException {
		csvDataWriter = new CsvDataWriter("D:\\urbuddi_git\\urbuddi\\Urbuddi\\src\\test\\resources\\datawriter.csv");
		String[] headers = { "Email", "Password", "FullName","mobileNumber","RandomEmployeeID","latestpassword" };
		csvDataWriter.writeHeaders(headers);
		urbuddy.verifyIsLoginPageDisplayed();
		urbuddy.inputCredentials(username, password);
		urbuddy.clickOnLoginButton();
		urbuddy.verifyIsHomePageDisplayed();
		for (int i = 2; i <= 5; i++) {
			int randomInt = randomnumber.nextInt(1000);
			System.out.println("printing the ramdom employee 1" + randomInt);
			String RandomEmail = email + randomInt + "@yopmail.com";
			String RandomEmployeeID = employeeID + randomInt;
			String latestpassword = password + randomInt;
			String fullname = firstname + " " + lastname;
			String[] data = { RandomEmail, password,fullname ,mobileNumber,RandomEmployeeID,latestpassword};
			csvDataWriter.appendDataToNextRow(data);
			urbuddy.clickAllEmployeesMenuOption();
			urbuddy.verifyAllEmployeePage();
			urbuddy.clickOnAllEmployeeButton();
			urbuddy.createEmployeeRoles(i, firstname, lastname, RandomEmployeeID, RandomEmail, password, dob,
					joiningDate, qualifications, department, mobileNumber, designation, salary);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}