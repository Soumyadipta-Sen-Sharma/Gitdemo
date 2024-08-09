import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dynamicDropDown2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@text='Chennai (MAA)']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@text='Hyderabad (HYD)'])[2]")).click();  //using index
		
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@text = 'Hyderabad (HYD)']")).click();   //using parent to child traversal
		
		/*String from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText();
		String to = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText();
		
		Thread.sleep(2000);
		
		System.out.println(from);
		System.out.println(to);   gettext not working for these drop downs */

	}

}
