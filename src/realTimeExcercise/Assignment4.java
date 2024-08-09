package realTimeExcercise;

import java.awt.Window;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkBox = driver.findElement(By.xpath("//label[@for = 'honda']"));
		String checkBoxText = checkBox.getText();
		checkBoxText.trim();
		checkBox.findElement(By.id("checkBoxOption3")).click();
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(checkBoxText);
		driver.findElement(By.xpath("//input[@name = 'enter-name']")).sendKeys(checkBoxText);
		driver.findElement(By.xpath("//input[@value= 'Alert']")).click();
		String alertText =  driver.switchTo().alert().getText();
		String[] alertTextArray = alertText.split(",");
		String[] alertText01 = alertTextArray[0].split(" ");
		String alertTextName = alertText01[1].trim();
	    Assert.assertEquals(alertTextName, checkBoxText);

	}

}
