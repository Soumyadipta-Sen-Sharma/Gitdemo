
package ecommerceWebsite;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] itemsNeeded = { "Cucumber", "Beetroot", "Brocolli"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");		
		addItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//img[@alt = 'Cart']")).click();
		driver.findElement(By.xpath("//div[@class = 'cart-preview active']//div[@class = 'action-block']//button[@type = 'button']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class = 'promoCode']")));
		driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class = 'promoInfo']")).getText());
		
}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));		
		for (int i = 0; i < products.size(); i++) 
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemsNeededList = Arrays.asList(itemsNeeded);			
			
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
				{
					break;
				}
			}
		}

	}
	}
