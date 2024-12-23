package maheshAppium.AppiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iosBaseTest {
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		// start the appium server programitically
				service = new AppiumServiceBuilder().withAppiumJS(new File("tell the locations of nodejs"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				
				XCUITestOptions options = new XCUITestOptions();
				options.setDeviceName("iphone 13 pro");
				options.setApp("copy the and paste the path of the xcatalog");
				options.setPlatformVersion("15.5");
				// appium- webdriver agent -- ios devices
				options.setWdaLaunchTimeout(Duration.ofSeconds(15));
				
				driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tear_down_appium() {
		// stoping the server
				driver.quit();
				service.stop();
		
	}
	
	 


}
