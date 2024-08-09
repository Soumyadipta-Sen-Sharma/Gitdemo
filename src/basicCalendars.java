import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class basicCalendars {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[text = 'Chennai (MAA)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@text = 'Kolkata (CCU)']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		//driver.findElement(By.id("Div1")).getAttribute("style");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("enable disable is working as intended");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Return date calendar element is not enabling even upon selecting 'round trip'");
			Assert.assertTrue(false);
		}
		

	}

}
