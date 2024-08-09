import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class checkBoxAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id = 'checkBoxOption1']")).isSelected());
		driver.findElement(By.cssSelector("input[id = 'checkBoxOption1']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id = 'checkBoxOption1']")).isSelected());
		driver.findElement(By.cssSelector("input[id = 'checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id = 'checkBoxOption1']")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type = 'checkbox']")).size());
				

	}

}
