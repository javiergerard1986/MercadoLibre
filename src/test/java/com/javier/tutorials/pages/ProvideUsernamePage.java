package com.javier.tutorials.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProvideUsernamePage extends BasePage{

	//--------------------------
	//ATTRIBUTES
	//--------------------------
	@FindBy(how = How.ID, using = "user_id")
	private WebElement txtUsername;
	
	@FindBy(how = How.CSS, using = ".ui-button.ui-button--primary.auth-button.auth-button--user")
	private WebElement btnContinue;
	
	@FindBy(how = How.CSS, using = "#registration-link")
	private WebElement lnkCreateAccount;

	
	//-----------------------------------
	//CONTRUCTORS
	//-----------------------------------
	/**
	 * Page Constructor
	 * @param driver
	 */
	public ProvideUsernamePage(WebDriver driver) {

		super(driver);

	}
	
	
	//--------------------------
	//VOIDS AND FUNCTIONS
	//--------------------------
	/**
	 * Method to provide username in the login process
	 * @param username (String)
	 * @return ProvidePasswordPage
	 * @author javier.gerard
	 */
	public ProvidePasswordPage provideUsernameToLogin(String username){
		
		Reporter.log("Providing username");
		txtUsername.sendKeys(username);
		
		Reporter.log("Clicking on Continue button after provide username");
		btnContinue.click();
		
		return PageFactory.initElements(driver, ProvidePasswordPage.class);
		
	}
	
	/**
	 * Method to check that the user is in the ProvideUsername Page
	 * @return boolean - If user is on Provide Username page it will return true, if not false
	 * @author javier.gerard
	 */
	public boolean checkThatUserIsOnProvideUsernamePage(){
		
		return driver.getCurrentUrl().contains("/login") && isElementPresent(txtUsername) && isElementPresent(btnContinue)
				&& isElementPresent(lnkCreateAccount);
		
	}
	
}