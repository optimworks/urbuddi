package com.urbuddi.pages;

import com.urbuddi.base.BasePage;
import com.urbuddi.locaters.LoginLocaters;

public class LoginPage extends BasePage {
	LoginLocaters login;

	public void verifyIsLoginPageDisplayed() {
		elementPresence(login.LoginTile);
		elementPresence(login.OptimworksLogo);
		elementPresence(login.LoginButton);
	}

	public void inputCredentials(String email, String password) {
		type(login.EmailField, email);
		type(login.PasswordField, password);
	}

	public void clickOnLoginButton() {
		click(login.LoginButton);
	}

	public void verifyIsHomePageDisplayed() {
		elementPresence(login.WelcomeText);
		elementPresence(login.Profile);
		elementPresence(login.Homemenu);
		getAttributeContainsText(login.Homemenu, "class", "active");
	}

	public void verifyIsRequiredTextDisplayed() {
		verifyElementContainsText(login.RequiredUsername, "required");
		verifyElementContainsText(login.RequiredPassword, "required");
	}

	public void verifyIsInvalidCredTextDisplayed() {
		elementVisible(login.InvalidErrorMsg);
		verifyElementContainsText(login.InvalidErrorMsg, "Invalid credentials");
	}

	public void clickOnLogoutButton() {
		click(login.LogoutButton);
	}
}
