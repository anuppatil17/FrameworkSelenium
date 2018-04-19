package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.AppiumDriver;

public class ExecutionDriver {

	/**
	 * Author : Virkam Kapale Date : Nov 2017 This method would create the
	 * instance of the browser for the Automation script execution
	 * 
	 */
	private ExecutionDriver() {
	}

	public static WebDriver getInstanceWeb(String sDriver, String url) {
		String projectpath = System.getProperty("user.dir");
		WebDriver driver = null;
		switch (sDriver.toLowerCase()) {
		case "chrome":
			try{
			System.setProperty("webdriver.chrome.driver", projectpath + "//tools//chromedriver.exe");
			driver = new ExecutionDriverImpl().getChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			}catch (Exception e) {
				System.out.println("error"+e);
				// TODO: handle exception
			}
			break;
		case "ie":
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability("allow-blocked-content", true);
			capabilities.setCapability("allowBlockedContent", true);
			System.setProperty("webdriver.ie.driver", projectpath + "//tools//IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.get(url);
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.bin",
					"C:\\Users\\vikapale\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver",
					projectpath + "//tools//geckodriver.exe");
			driver = new ExecutionDriverImpl().getFirefoxDriver();
			driver.get(url);
			break;
		case "safari":
			System.setProperty("webdriver.safari.noinstall", "true");
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		}

		return driver;
	}

}
