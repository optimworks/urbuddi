package com.urbuddi.testcases;

import java.io.FileInputStream;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.urbuddi.steps.UrbuddiSteps;
import com.urbuddi.utilities.CsvDataReader;
import com.urbuddi.utilities.CsvDataWriter;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityRunner.class)
@Concurrent(threads = "4")
public class ResourceTrackingTestCase {
	@Managed
	WebDriver driver;

	@Steps
	UrbuddiSteps urbuddy;

	CsvDataReader csvDataReader = new CsvDataReader();
	List<String[]> data = csvDataReader
			.readDataFromCsv("D:\\urbuddi_git\\urbuddi\\Urbuddi\\src\\test\\resources\\data.csv");
	String username = data.get(1)[0];
	String password = data.get(1)[1];
	String employeeID = data.get(1)[4];
	String allocateddate = data.get(2)[0];
	String serialid = data.get(2)[1];
	String model = data.get(2)[2];

	@TestData(columnNames = "Username,Password,, employeeID, allocateddate, serialid, model")

	@Qualifier
	public String qualifier() {
		return " - " + " Username = " + username + " and " + " password = " + password + " EmployeeID = " + employeeID
				+ " allocateddate	= " + allocateddate + " serialid	= " + serialid + " model= " + model;
	}

	@Title("Launch Urbuddi Application")
	@Before
	public void launchApplicationURL() {
		urbuddy.launchURL();
		urbuddy.verifyIsLoginPageDisplayed();
		urbuddy.inputCredentials(username, password);
		urbuddy.clickOnLoginButton();
		urbuddy.verifyIsHomePageDisplayed();
	}

	@Title("Launch Urbuddi Application")
	@Test
	public void resourceTrackingAddResource() {
		Random objGenerator = new Random();
		int randomNumber = objGenerator.nextInt(1000);
		int randomNumber1 = objGenerator.nextInt(10);
		String RandomEmployeeID = employeeID + randomNumber;
		urbuddy.clickResourceTrackingMenuOption();
		urbuddy.verifyResourceTrackingPage();
		urbuddy.addResource(RandomEmployeeID, allocateddate, serialid, model);
	}
}
