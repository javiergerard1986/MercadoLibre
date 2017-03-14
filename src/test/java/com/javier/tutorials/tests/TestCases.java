package com.javier.tutorials.tests;

import org.testng.annotations.Test;
import com.javier.tutorials.pages.LoginPage;
import junit.framework.Assert;

public class TestCases extends BaseTest{
	
	//----------------------------
	//ATTRIBUTES
	//----------------------------
	LoginPage loginPage;
	
	
	//----------------------------
	//TESTS
	//----------------------------
	@Test (priority = 1)
	public void testLogin() {
		
		loginPage = homePage.navigateToLoginPage();
		Assert.assertTrue("Error: The user is not in the Login page", loginPage.checkThatUserIsOnLoginPage());
		
		homePage = loginPage.login(properties.getProperty("USERNAME"), properties.getProperty("PASSWORD"));
		Assert.assertTrue("Error: The user is not logged in", homePage.checkThatUserIsLoggedIn());
		
	}
	
	@Test (priority = 2)
	public void testLogOut() {
	
		loginPage = homePage.navigateToLoginPage();
		Assert.assertTrue("Error: The user is not in the Login page", loginPage.checkThatUserIsOnLoginPage());
		
		homePage = loginPage.login(properties.getProperty("USERNAME"), properties.getProperty("PASSWORD"));
		Assert.assertTrue("Error: The user is not logged in", homePage.checkThatUserIsLoggedIn());
		
		homePage = homePage.logout();
		Assert.assertTrue("Error: The user is not logged out", homePage.checkThatUserIsLoggedOut());
		
	}
	
}