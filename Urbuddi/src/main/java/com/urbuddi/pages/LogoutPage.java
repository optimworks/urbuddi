package com.urbuddi.pages;

import com.urbuddi.base.BasePage;

public class LogoutPage extends BasePage {
	
	public String AllEmployees_Page = "xpath=//*[text()=\"Logout\"]";
	public void logoutuser() {
		
		 click(AllEmployees_Page);
	}

}
