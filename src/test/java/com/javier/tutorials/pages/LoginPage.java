package com.javier.tutorials.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends BasePage{

	//--------------------------
	//ATTRIBUTES
	//--------------------------
	@FindBy(how = How.CSS, using = "#user_id")
	private WebElement txtUsername;
	
	@FindBy(how = How.CSS, using = "#password")
	private WebElement txtPassword;
	
	@FindBy(how = How.CSS, using = "#link_ayuda")
	private WebElement lnkForgotPassword;
	
	@FindBy(how = How.CSS, using = "#remember_me")
	private WebElement chkRememberMe;
	
	@FindBy(how = How.CSS, using = "#signInButton")
	private WebElement btnSignIn;
	
	
	//-----------------------------------
	//CONTRUCTORS
	//-----------------------------------
	/**
	 * Page Constructor
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {

		super(driver);

	}
	
	
	//--------------------------
	//VOIDS AND FUNCTIONS
	//--------------------------
	/**
	 * Method to login into the system
	 * @param username (String)
	 * @param password (String)
	 * @return HomePage
	 * @author javier.gerard
	 */
	public HomePage login(String username, String password){
		
		Reporter.log("Providing username");
		txtUsername.sendKeys(username);
		
		Reporter.log("Providing password");
		txtPassword.sendKeys(password);
		
		Reporter.log("Clicking on login button");
		btnSignIn.click();
		
		return PageFactory.initElements(driver, HomePage.class);
		
	}
	
	/**
	 * Method to check that the user is in the Login Page
	 * @return boolean - If user is in login page it will return true, if not false
	 * @author javier.gerard
	 */
	public boolean checkThatUserIsOnLoginPage(){
		
		return driver.getCurrentUrl().contains("/login") && isElementPresent(txtUsername) && isElementPresent(txtPassword)
				&& isElementPresent(lnkForgotPassword) && isElementPresent(chkRememberMe) && isElementPresent(btnSignIn);
		
	}
	
}