import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class angularPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class = 'form-group']//input[@name = 'name']")).sendKeys("Soumyadipta");
		driver.findElement(By.xpath("//div[@class = 'form-group']//input[@name = 'email']")).sendKeys("joyraj.ss@gmail.com");
		driver.findElement(By.xpath("//div[@class = 'form-group']//input[@type = 'password']")).sendKeys("test@1234");
		driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
		driver.findElement(By.xpath("//select[@class = 'form-control']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//select[@class = 'form-control']//option[1]")).click();
		WebElement dropDown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select abc = new Select(dropDown);
		abc.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@name = 'bday']")).sendKeys("02/06/1998");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).getText());		
		
		

	}

}
