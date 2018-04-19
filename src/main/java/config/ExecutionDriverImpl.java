package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.appium.java_client.AppiumDriver;


public class ExecutionDriverImpl implements InterfaceExecutionDriver {

	
	@Override
	public WebDriver getChromeDriver() {
		WebDriver driver = new ChromeDriver();
	    
		return driver; 
		
	}

	@Override
	public WebDriver getInternetExplorerDriver() {
		WebDriver driver = new InternetExplorerDriver();
		return driver; 
	}

	@Override
	public WebDriver getFirefoxDriver() {
		WebDriver driver = new FirefoxDriver();
		return driver; 
	}

	@Override
	public AppiumDriver getAppiumDriver() {
		AppiumDriver driver;
		return null;
	}

	

}
