package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.AppiumDriver;

public class ExecutionDriver
{
	private ExecutionDriver(){}
	private static WebDriver driver;
	private static AppiumDriver appiumdriver;
	
	public static WebDriver getInstanceWeb(String sDriver, String url)
	{
		String projectpath = System.getProperty("user.dir");
		WebDriver driver = null;
		switch(sDriver.toLowerCase())
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectpath + "//tools//chromedriver.exe");
			driver = new ExecutionDriverImpl().getChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get(url);
			driver.manage().window().maximize();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectpath + "//tools//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.get(url);
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectpath + "//tools//geckodriver.exe");
			driver = new ExecutionDriverImpl().getFirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.get(url);
			//driver.manage().window().maximize();
			break;
		case "safari":
			System.setProperty("webdriver.safari.noinstall", "true"); 
			driver.manage().deleteAllCookies();
			//System.setProperty("webdriver.chrome.driver", "C://Pract//SBIAppiumMobileAutomationFramework//tools//IEDriverServer.exe");
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.get(url);
			//driver = new ExecutionDriverImpl().getChromeDriver();
			break;
		/*case "invisible":
			HtmlUnitDriver driver = new HtmlUnitDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://google.com");
			break;
	*/
			
		}
		
		return driver;
	}




	
	}
