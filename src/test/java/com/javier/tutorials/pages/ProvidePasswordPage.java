package com.javier.tutorials.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProvidePasswordPage extends BasePage{

	//--------------------------
	//ATTRIBUTES
	//--------------------------
	@FindBy(how = How.CSS, using = "#password")
	private WebElement txtPassword;
	
	@FindBy(how = How.CSS, using = ".ui-button.ui-button--primary.auth-button.auth-button--password")
	private WebElement btnContinue;
	
	@FindBy(how = How.CSS, using = "#account-recovery-link")
	private WebElement lnkForgotPassword;
	
	
	//-----------------------------------
	//CONTRUCTORS
	//-----------------------------------
	/**
	 * Page Constructor
	 * @param driver
	 */
	public ProvidePasswordPage(WebDriver driver) {

		super(driver);

	}
	
	
	//--------------------------
	//VOIDS AND FUNCTIONS
	//--------------------------
	/**
	 * Method to provide password in the login process
	 * @param password (String)
	 * @return HomePage
	 * @author javier.gerard
	 */
	public HomePage providePasswordToLogin(String password){
		
		Reporter.log("Providing password");
		txtPassword.sendKeys(password);
		
		Reporter.log("Clicking on Continue button after provide password");
		btnContinue.click();
		
		return PageFactory.initElements(driver, HomePage.class);
		
	}
	
	/**
	 * Method to check that the user is in the Home Page
	 * @return boolean - If user is in home page it will return true, if not false
	 * @author javier.gerard
	 */
	public boolean checkThatUserIsOnProvidePasswordPage(){
		
		return driver.getCurrentUrl().contains("/login") && isElementPresent(txtPassword) 
				&& isElementPresent(btnContinue) && isElementPresent(lnkForgotPassword);
		
	}
	
}