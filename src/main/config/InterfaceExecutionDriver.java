package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.appium.java_client.AppiumDriver;

public interface InterfaceExecutionDriver {
	
	public WebDriver getChromeDriver();
	public WebDriver getInternetExplorerDriver();
	public WebDriver getFirefoxDriver();
	public AppiumDriver getAppiumDriver();
	//public WebDriver getInternetExplorerDriver();

}
