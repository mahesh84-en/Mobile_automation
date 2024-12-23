package maheshAppium.AppiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class AndriodAppiumBasics extends Baseclass {
	
	@Test
	public void wifiSettingsName() 
	{
		
		
		driver.findElement(AppiumBy.accessibilityId("preference")).click();
		driver.findElement(By.xpath("//androp[@content_type='dskjfbds,jnf']")).click();
		driver.findElement(AppiumBy.accessibilityId("kjakfjhdk")).click();
		driver.findElement(By.xpath("(//relartinjb]][)[2]")).click();
		
		
		// how to extract text from apps
		
		String wifi_text = driver.findElement(By.id("fjsdfjbds")).getText();
		Assert.assertEquals(wifi_text, "WIFI settings");
		
		// Handling the pop ups in appium
		driver.findElement(By.id("ekjnsnksjd")).sendKeys("maheshbabu");
		driver.findElements(AppiumBy.className("ldkfnlkdsn")).get(2).click();
		
		// long press in apppium
		WebElement ele = driver.findElement(By.id("jihfdkj"));
		
		long_press_action(ele, 2000);
		
		String pop_up_text = driver.findElement(By.id("fksdfkjhfd")).getText();
		Assert.assertTrue(driver.findElement(By.id("fksdfkjhfd")).isDisplayed());
		Assert.assertEquals(pop_up_text, "Sample Menu");
		
	}
	
	
	
	@Test
	public void mobile_app_actions() {
		
		// scroll gesture
		
		 driver.findElement(By.xpath("skjfhdkjhfld")).click();
		 scroll_to_perticular_element("webview");
		 
		 
		// how to swipe in mobile
		 
		 WebElement imahe_attr = driver.findElement(By.xpath("//tagname [1]"));
		 String imah = imahe_attr.getAttribute("focusable");
		 Assert.assertEquals(imah, "True");
		 
		 swipe_to(imahe_attr, "left", 0.75);
		 
		 Assert.assertEquals(imah, "False");
		 String second_image = driver.findElement(By.xpath("hfodshfld")).getAttribute("focusable");
		 Assert.assertEquals(second_image, "True");
		 
		
	}
	
	@Test
	public void drag_and_drop()
	{
		// drag and drop actions of the app
		
		driver.findElement(AppiumBy.accessibilityId("kajjnfldajf")).click();
		WebElement source = driver.findElement(By.id("dkfhsdfh"));
		
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement)source).getId(), 
		    "endX" , 620, 
		    "endY" , 523
				));
	    String droped_text = driver.findElement(By.id("dfjdljf")).getText();
		Assert.assertEquals(droped_text, "dropped");
	}
	
	public void mislenious_topics()
	{
		// rotating to landscape mode
		
		landscape_mode(90);
		
		// copy and pasing to the app
		
		driver.setClipboardText("majhesjbau");
		driver.findElement(By.id("jashfkjda")).sendKeys(driver.getClipboardText());
		
		//android key events
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); // Enter, tabs
		driver.pressKey(new KeyEvent(AndroidKey.TAB));
		
		// opening the 3 rd or 4th or as per requirement page
		// app package and app activity
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "aslklkflajfljlkjldajfldjflk"));
	}

}
