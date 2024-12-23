package maheshAppium.AppiumBasics;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ecommerceApp extends Baseclass {
	
	@Test
	public void FillForm()
	{
		driver.findElement(By.id("jhdkjfdkj")).sendKeys("mahehsbabu");
		driver.hideKeyboard();
		driver.findElement(By.id("sfldjfld")).click();
		driver.findElement(AppiumBy.accessibilityId("mkdhfkjadhfjh")).click();
		WebElement india = driver.findElement(By.id("sjfbkadbf"));
		scroll_to_perticular_element("india");
		india.click();
		driver.findElement(By.id("skjfhdkjhf")).click();
		
	}
	
	@Test
	public void toast_messages()
	{
		driver.findElement(By.id("jhdkjfdkj")).sendKeys("mahehsbabu");
		driver.hideKeyboard();
		driver.findElement(By.id("sfldjfld")).click();
		driver.findElement(AppiumBy.accessibilityId("mkdhfkjadhfjh")).click();
		WebElement india = driver.findElement(By.id("sjfbkadbf"));
		scroll_to_perticular_element("india");
		india.click();
		String toast_message = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	    Assert.assertEquals(toast_message, "Please Enter correct crdentials");
	    
	}
	
	@Test
	public void add_to_cart()
	{
		FillForm();
		scroll_to_perticular_element("jordan 6 shoes");
		
		List<WebElement>  productcount = driver.findElements(By.id("djnfldshfljds"));
		
		for(int i=0; i<productcount.size(); i++)
		{
			if (productcount.get(i).getText().equalsIgnoreCase("jordan 6"))
			{
				driver.findElements(By.id("dlkfhdkjhf")).get(i).click();
			}
		}
		
		driver.findElement(By.id("djkfbdksjhfkjds")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("dgldsldslkf")), "text", "cart"));
		String last_prduct = driver.findElement(By.id("sdlfdslfj")).getText();
		Assert.assertEquals(last_prduct, "jordan t6");
		
		// check the cart product value suppose we are having the two products in the cart 
	    
		List<WebElement> cart_product_prices = driver.findElements(By.id("jshfkjdbf"));
		double total = 0.0;
		for(int i=0; i<cart_product_prices.size(); i++)
	    {
	    	String product_price = cart_product_prices.get(i).getText();
	    	total = total + Double.parseDouble(product_price);
	    
	    }
		String Cart_final_value = driver.findElement(By.id("dkjfhdfhdzkj")).getText();
		Assert.assertEquals(Cart_final_value, total);
		
		// hybrid app actions automating
		Thread.sleep(6000);
		
		Set<String> contexts = driver.getContextHandles();
	    for(String contaxtName : contexts)
	    {
	    	System.out.println(contaxtName);
	    }
	    
	    // switching to browser app
	    driver.context("web_view: adlfnkldflkdnlfk");
	    
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    
	    //switching back to native app
	    driver.context("NATIVE_APP");
	}

}
