package maheshAppium.AppiumBasics;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Maps;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends iosBaseTest {
	
	@Test
	public void ios_basics_locators()
	{
		// xpath, classname, ios, iosClassChain, iosprecateString
		driver.findElement(AppiumBy.accessibilityId("dlkfldfld")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/tagname['label == 'text'']"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUiElementCell")).sendKeys("ios automation");
        driver.findElement(AppiumBy.accessibilityId("sklfhdalhf")).click();
	}
	
	@Test
	public void precate_string()
	{
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'dkjfnsdkjfldj' and label == 'confirm/cancel' and label BEGINSWITH[C] 'Confimrm' and label ENDSWITH 'MAHESH' ")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'confirm'")).click();
		String pop_text = driver.findElement(AppiumBy.iOSNsPredicateString("label BEGINSWITH 'a MESSAGE'")).getText();
		Assert.assertEquals("A message is not correct", pop_text);
		}
	
	@Test
	public void ios_gestures()
	{
		// longpress
		WebElement ele;
		Map<String, Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration", 5);
		driver.executeScript("mobile: touchAndHold",params);
		
		
		//scrolling on ios
		Map<String, Object> param = new HashMap<>();
		param.put("element", ((RemoteWebElement)ele).getId());
		param.put("direction", "down");
		driver.executeScript("mobile: Scroll", param);
		
		//drop downs in ios
		driver.findElement(AppiumBy.accessibilityId(".asmkdalkfj")).sendKeys("62");
		driver.findElement(AppiumBy.accessibilityId(".asmkdalkfj")).sendKeys("62");
		driver.findElement(AppiumBy.accessibilityId(".asmkdalkfj")).sendKeys("62");
		String drop_text = driver.findElement(AppiumBy.accessibilityId(".asmkdalkfj")).getText();
		Assert.assertEquals(drop_text, "62");
		
		//sliding
		WebElement slider  = driver.findElement(AppiumBy.iOSClassChain("%%/dkghkdjshklds"));
		slider.sendKeys("1%");
		
		String elewe = driver.findElement(AppiumBy.iOSNsPredicateString(drop_text)).getAttribute("value");		
		Assert.assertEquals(elewe, "100");
		slider.sendKeys("0%");
		String elewerdsg = driver.findElement(AppiumBy.iOSNsPredicateString(drop_text)).getAttribute("value");		
		Assert.assertEquals(elewerdsg, "0");
		
	}
	
	@Test
	public void direct_activity()
	{
		// swiping
		Map<String, Object> par = new HashMap<>();	
		par.put("bundleId", "com.photos.ios");
		driver.executeScript("mobile: launchApp", par);
		for(int i=0; i<Maps.size();i++)
		{
		Map<String, Object> para2 = new HashMap<>();
		para2.put("element", ((RemoteWebDriver)ele).getId());
		para2.put("direction", "left");
		String before_photo_time_stamp = driver.findElement(AppiumBy.iOSNsPredicateString("dlkfjdslkfj")).getAttribute("name");
		driver.executeScript("mobile: swipe", para2);
		String after_photo_time_stamp = driver.findElement(AppiumBy.iOSNsPredicateString("dlkfjdslkfj")).getAttribute("name");
		Assert.assertNotEquals(before_photo_time_stamp, after_photo_time_stamp);
		} 
		driver.navigate().back();
		}
	

}
