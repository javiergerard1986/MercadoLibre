package com.javier.tutorials.pages;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	//-----------------------------------
	//ATTRIBUTES
	//-----------------------------------
	protected WebDriver driver;
	protected InputStream confFile = null;
	protected Properties properties = new Properties();
		
		
	//-----------------------------------
	//CONTRUCTORS
	//-----------------------------------
	public BasePage (WebDriver driver){
			
		this.driver = driver;
			
	}
	
	//-----------------------------------
	//VOID AND FUNCTIONS
	//-----------------------------------
	/**
	 * Method to verify if element is present
	 * @param element (WebElement) this is the webElement to check if is present
	 * @return boolean - If element is present it will return true, if not, false
	 * @author Javier_Gerard
	 */
	 protected boolean isElementPresent(WebElement element) {

		try{
		
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.visibilityOf(element));
			
			return true;
			
		}catch(TimeoutException ex){
			
			return false;
		
		}
		
	 }
	
}