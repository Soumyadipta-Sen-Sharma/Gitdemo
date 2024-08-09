import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@text = 'Chennai (MAA)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@text = 'Hyderabad (HYD)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		if(driver.findElement(By.xpath("//div[@id = 'Div1']")).getAttribute("style").contains("0.5"))
		{
			Assert.assertTrue(true);
			System.out.println("Calendar UI is disabled as expected");
		}
		else
		{
			Assert.assertFalse(false);
			System.out.println("Calendar UI is not disabled as expected");
		}
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i = 0; i<4; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		//String passengersValidation = driver.findElement(By.id("divpaxinfo")).getText();
		
		/*if(passengersValidation == "5 Adult")
		{
			Assert.assertTrue(true);
			System.out.println("The Passengers count has been updated correctly");
		}
		else
		{
			System.out.println("The passengers count is not correct");
			Assert.assertTrue(false);
		}*/
		
		String passengerCount = driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println(passengerCount);
		Assert.assertEquals(passengerCount, "5 Adult");
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByValue("INR");
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		if(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("menuselection").contains("false"))
		{
			System.out.println("final submission completed");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("final submission not completed");
			Assert.assertTrue(false);
		}
		

	}

}
