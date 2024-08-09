package AjaxAndMouseInteractions;

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

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text() = 'Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text() = 'Click Here']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
	    String parentWidnow = it.next();
	    String childWindow = it.next();
	    driver.switchTo().window(childWindow);
	    String requiredText = driver.findElement(By.xpath("//h3")).getText();
	    System.out.println(requiredText);
	    driver.switchTo().window(parentWidnow);
	    String newText = driver.findElement(By.xpath("//h3")).getText();
	    System.out.println(newText);

	}

}