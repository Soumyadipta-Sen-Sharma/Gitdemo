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

public class DriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Total number of links " + driver.findElements(By.tagName("a")).size());
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println("Total number of links in the footer " + footerDriver.findElements(By.tagName("a")).size());
        
        WebElement columnDriver = footerDriver.findElement(By.xpath("//div[@id = 'gf-BIG']//table[@class = 'gf-t']//tbody//tr//td[1]//ul"));
        int size = columnDriver.findElements(By.tagName("a")).size();
        System.out.println("Total number of links in the first column of the footer " + columnDriver.findElements(By.tagName("a")).size());
        
        for(int i = 1; i<size; i++)
        {
        	String contrilClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
        	columnDriver.findElements(By.tagName("a")).get(i).sendKeys(contrilClick);
        }
        
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while(it.hasNext())
        {
        	driver.switchTo().window(it.next());
        	System.out.println(driver.getTitle());
        }
	}

}
