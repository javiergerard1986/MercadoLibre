package com.javier.tutorials.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends BasePage{

	//--------------------------
	//ATTRIBUTES
	//--------------------------
	@FindBy(how = How.CSS, using = ".option-register")
	private WebElement btnRegister;
	
	@FindBy(how = How.CSS, using = ".option-login.nav-header-lnk-login")
	private WebElement btnLogin;
	
	@FindBy(how = How.CSS, using = ".nav-header-user>label")
	private WebElement btnAccount;
	
	@FindBy(how = How.XPATH, using = "//nav[@class='nav-header-user-layer']//a[text()='Salir']")
	private WebElement btnLogout;
	
	@FindBy(how = How.CSS, using = ".nav-icon-notifications")
	private WebElement btnNotifications;
	
	@FindBy(how = How.CSS, using = ".nav-icon-bookmarks")
	private WebElement btnLike;
	
	
	//-----------------------------------
	//CONTRUCTORS
	//-----------------------------------
	/**
	 * Page Constructor
	 * @param driver
	 */
	public HomePage(WebDriver driver) {

		super(driver);

	}
		
	
	//--------------------------
	//VOIDS AND FUNTCIONS
	//--------------------------
	/**
	 * Method to navigate to the Login page
	 * @return LoginPage
	 * @author javier.gerard
	 */
	public ProvideUsernamePage navigateToLoginPage(){
		
		Reporter.log("Clicking on Login button");
		btnLogin.click();
		
		return PageFactory.initElements(driver, ProvideUsernamePage.class);
		
	}
	
	/**
	 * Method to logout from the MercadoLibre system
	 * @return HomePage
	 * @author javier.gerard
	 */
	public HomePage logout(){
		
		Reporter.log("Clicking on My Account button");
		btnAccount.click();
		
		Reporter.log("Clicking on Logout button");
		btnLogout.click();
		
		return this;
		
	}
	
	/**
	 * Method to check that the user is Logged In
	 * @return boolean - If user is in Home page and is logged in it will return true. If not, false
	 * @author javier.gerard
	 */
	public boolean checkThatUserIsLoggedIn(){
		
		Reporter.log("Checking that user is logged in");
		return btnAccount.getText().equals("GEJA2653444") && isElementPresent(btnNotifications) && isElementPresent(btnLike);
		
	}
	
	/**
	 * Method to check that the user is Logged Out
	 * @return boolean - If user is in Home page and is not login it will return true. If not, false
	 * @author javier.gerard
	 */
	public boolean checkThatUserIsLoggedOut(){
		
		Reporter.log("Checking that user is log out");
		return btnLogin.getText().equals("Ingresa") && isElementPresent(btnRegister);
		
	}
	
}