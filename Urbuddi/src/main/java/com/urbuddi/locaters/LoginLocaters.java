package com.urbuddi.locaters;

import net.serenitybdd.core.pages.PageObject;

public class LoginLocaters extends PageObject {
	public String LoginTile = "css=[class^='login-card']";
	public String OptimworksLogo = "css=[class='company-logo']";
	public String LoginButton = "css=[type='submit']";
	public String EmailField = "css=[type='email']";
	public String PasswordField = "css=[type='password']";
	public String WelcomeText = "xpath=//h1[text()='Welcome to urBuddi']";
	public String Profile = "css=[class*='profile-icon-container']";
	public String OWHeaderLogo = "css=.company-logo-header";
	public String Homemenu = "xpath=//*[text()='Home']/..";
	public String RequiredUsername = "css=.input-element+p";
	public String RequiredPassword = "css=.password-container+p";
	public String InvalidErrorMsg = "css=.err-msg-display";
	public String LogoutButton = "css=button[class*='logout']";

}
