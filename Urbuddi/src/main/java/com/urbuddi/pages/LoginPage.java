package com.urbuddi.pages;

import com.urbuddi.base.BasePage;

public class LoginPage extends BasePage {
	String LoginTile = "css=[class^='login-card']";
	String OptimworksLogo = "css=[class='company-logo']";
	String LoginButton = "css=[type='submit']";
	String EmailField = "css=[type='email']";
	String PasswordField = "css=[type='password']";
	String WelcomeText = "xpath=//h1[text()='Welcome to urBuddi']";
	String Profile = "css=[class*='profile-icon-container']";
	String OWHeaderLogo = "css=.company-logo-header";
	String Homemenu = "xpath=//*[text()='Home']/..";
	String RequiredUsername = "css=.input-element+p";
	String RequiredPassword = "css=.password-container+p";

	public void verifyIsLoginPageDisplayed() {
		elementPresence(LoginTile);
		elementPresence(OptimworksLogo);
		elementPresence(LoginButton);
	}

	public void inputCredentials(String email, String password) {
		type(EmailField, email);
		type(PasswordField, password);
	}

	public void clickOnLoginButton() {
		click(LoginButton);
	}

	
	  public void verifyIsHomePageDisplayed() {
		  elementPresence(WelcomeText);
	  elementPresence(Profile);
	  elementPresence(Homemenu);
	  getAttributeContainsText(Homemenu, "class", "active"); 
	  }
	  
	  public void verifyIsRequiredTextDisplayed() {
	  verifyElementContainsText(RequiredUsername, "required");
	  verifyElementContainsText(RequiredPassword, "required"); }
	 
}
