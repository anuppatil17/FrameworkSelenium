package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import bsh.ParseException;

public class Test {
	static //WebDriver driver;
	WebDriver driver;

	public static void main(String[] args) throws ParseException 
	{
		System.setProperty("webdriver.chrome.driver", "C://Pract//SBIAppiumMobileAutomationFramework//tools//chromedriver.exe");
		driver = new ExecutionDriverImpl().getChromeDriver();
		driver.get("https://www.yahoo.com");
		
	}

}
