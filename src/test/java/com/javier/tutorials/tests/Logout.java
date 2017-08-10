package com.javier.tutorials.tests;

import org.testng.annotations.Test;

import com.javier.tutorials.pages.ProvidePasswordPage;
import com.javier.tutorials.pages.ProvideUsernamePage;
import junit.framework.Assert;

public class Logout extends BaseTest{
	
	//----------------------------
	//ATTRIBUTES
	//----------------------------
	private ProvideUsernamePage provideUsernamePage;
	private ProvidePasswordPage providePasswordPage;

	
	//----------------------------
	//TESTS
	//----------------------------
	@Test (priority = 1)
	public void testLogOut() {
	
		provideUsernamePage = homePage.navigateToLoginPage();
		Assert.assertTrue("Error: The user is not on the Provide Username page", provideUsernamePage.checkThatUserIsOnProvideUsernamePage());
		
		providePasswordPage = provideUsernamePage.provideUsernameToLogin(properties.getProperty("USERNAME"));
		Assert.assertTrue("Error: The user is not on the Provide Password page", providePasswordPage.checkThatUserIsOnProvidePasswordPage());
		
		homePage = providePasswordPage.providePasswordToLogin(properties.getProperty("PASSWORD"));
		Assert.assertTrue("Error: The user is not on the Home page", homePage.checkThatUserIsLoggedIn());
		
		homePage = homePage.logout();
		Assert.assertTrue("Error: The user is not logged out", homePage.checkThatUserIsLoggedOut());
		
	}
	
}