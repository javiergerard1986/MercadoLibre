package com.javier.tutorials.tests;

import org.testng.annotations.BeforeMethod;

import com.javier.tutorials.pages.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

	//----------------------------
	//ATTRIBUTES
	//----------------------------
	protected WebDriver driver;
	protected DesiredCapabilities caps;
	protected InputStream confFile = null;
	protected Properties properties = new Properties();
	protected HomePage homePage;

	
	//----------------------------
	//TESTS
	//----------------------------
	@BeforeMethod
	protected void beforeMethod() throws Exception{
	
		Reporter.log("Initializing driver Home Page");
		loadPropertiesFile();
		initializeDriver();
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		
	}
	
	@AfterMethod
	protected void afterMethod() {
		
		Reporter.log("Closing driver");
		driver.quit();
		
	}
	
	/**
	 * Method to load the properties file
	 * @throws Exception
	 * @author javier.gerard
	 */
	public void loadPropertiesFile() throws Exception{
		
		confFile = new FileInputStream("config.properties");
		properties.load(confFile);
		
	}
	
	/**
	 * Method to initialize driver
	 * @author javier.gerard
	 */
	private void initializeDriver(){
		
		System.setProperty("webdriver.gecko.driver", "browserDrivers/geckodriver.exe");
		caps = DesiredCapabilities.firefox();
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		Reporter.log("Navigating to MercadoLibre");
		driver.get(properties.getProperty("BASE_URL"));
		
	}
	
}