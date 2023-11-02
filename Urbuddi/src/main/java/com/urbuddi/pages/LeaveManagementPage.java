package com.urbuddi.pages;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import com.urbuddi.base.BasePage;

public class LeaveManagementPage extends BasePage {
	String LeaveManagementMenu = "css=[href*='leave_management'] li";
	String ApplyLeaveButton = "css=[class*='apply-leavs']";
	String UtilizedTile = "xpath=//p[normalize-space()='UTILIZED']/..";
	String BalanceTile = "xpath=//p[normalize-space()=' BALANCE']/..";
	String TotalTile = "xpath=//p[normalize-space()='TOTAL']/..";
	String LeavesLeftTile = "xpath=//p[normalize-space()='LEAVES LEFT']/..";
	String ApplyLeavePopUp = "css=.modal-container";
	String CloseButton = "css=.close-btn";
	String SubmitButton = "css=[type='submit']";
	String SelectDate = "css=#dateRange";
	String SelectYourLead = "id=hr";
	String ReasonForRequest = "id=reason";
	String LeaveWarning = "css=.warning-modal-container";
	String OkButton = "xpath=//button[text()='Ok']";

	public void goToLeaveManagementMenu() {
		click(LeaveManagementMenu);
	}

	public void verifyIsLeaveManagementPageDisplayed() {
		getAttributeContainsText(LeaveManagementMenu, "class", "active");
//		elementVisible(ApplyLeaveButton);
//		elementVisible(UtilizedTile);
//		elementVisible(BalanceTile);
//		elementVisible(TotalTile);
//		elementVisible(LeavesLeftTile);
	}

	public void clickOnApplyLeave() {
		click(ApplyLeaveButton);
	}

	public void handleLeaveWarningClickOk() {
		if (isElementVisible(LeaveWarning)) {
			click(OkButton);
		}
	}

	public void verifyIsApplyLeavePopUpDisplayed() {
		elementPresence(ApplyLeavePopUp);
		elementPresence(SubmitButton);
	}

	public void selectDate() {
		click(SelectDate);
		LocalDate currentDate = LocalDate.now();
		LocalDate tomorrow = currentDate.plus(1, ChronoUnit.DAYS);
		System.out.println("Current System Date and Time: " + currentDate);

		String[] parts = tomorrow.toString().split("-");

		String year = parts[0];
		String month = parts[1];
		String day = parts[2];
		String finalday = null;

		System.out.println("Year and Month: " + year);
		System.out.println("Day: " + month);
		System.out.println("Day: " + day);

		if (day.startsWith("0")) {
			finalday = day.substring(1);
		}

		String monthName = Month.of(Integer.parseInt(month)).name();

		String titleCaseMonth = monthName.substring(0, 1) + monthName.substring(1).toLowerCase();

		System.out.println("Numeric Month: " + month);
		System.out.println("Month Name: " + titleCaseMonth);

		String date = "xpath=//div[text()='" + finalday + "'][contains(@aria-label, '" + titleCaseMonth + "')]";

		click(date);
		click(date);
	}

	public void selectLead(String value) {
		selectByValue(SelectYourLead, value);
	}

	public void inputReasonForRequest(String reason) {
		type(ReasonForRequest, reason);
	}

	public void selectLeaveRequestType() {
		String RequestType = "css=#leave";
		click(RequestType);
	}

	public void clickOnSubmitButton() {
		click(SubmitButton);
	}

}
