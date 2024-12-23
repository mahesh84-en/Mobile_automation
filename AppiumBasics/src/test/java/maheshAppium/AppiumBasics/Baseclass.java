package maheshAppium.AppiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Baseclass {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		// start the appium server programitically
				service = new AppiumServiceBuilder().withAppiumJS(new File("tell the locations of nodejs"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				UiAutomator2Options options = new UiAutomator2Options();
				options.setChromedriverExecutable("provide chrome driver path here");
				options.setDeviceName("MaheshPahone");
				// if we want to run on the real devices use the command below instead of above command
				// options.setDeviceName("Android Device");
				options.setApp("//apk.link");
				
				
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tear_down_appium() {
		// stoping the server
				driver.quit();
				service.stop();
		
	}
	
	public void long_press_action(WebElement ele, int time)
	{
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "duration", time));
	}
	
	public void scroll_to_perticular_element(String scroll_text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new Uiselector()).scrollIntoView(text(\"scroll_text\")));"));
	}
	
	public void swipe_to(WebElement ele, String given_direction, double given_percemt)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "direction", given_direction, "percent", given_percemt));
	}
	
	public void landscape_mode(int degree) {
		DeviceRotation landscape  = new DeviceRotation(0,0,degree);
		driver.rotate(landscape);
	}

}
