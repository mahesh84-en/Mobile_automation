package maheshAppium.AppiumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBaseTest {
	
	@Test
	public void browserTest()
	{
		driver.get("http://www.google.com");
		driver.getTitle();
		
		//scrolling and put some assertions
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("kjfdkfhkdjh"))).build().perform();
		String ele_text = driver.findElement(By.xpath("dlfdkjhf")).getText();
		Assert.assertEquals(ele_text, "QA Engineer");
		
	}

}
