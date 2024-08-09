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

public class CallendarUIHanding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		String monthNumber = "6";
		String date = "15";
		String year = "2027";
		String[] expectedList = {monthNumber,date,year};
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		/*driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);*/
		driver.findElement(By.xpath("//div[@class = 'react-date-picker__inputGroup']")).click();
		driver.findElement(By.xpath("//button[@class = 'react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[@class = 'react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[text() = '"+year+"']")).click();
		driver.findElements(By.xpath("//button[@class = 'react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text() = '"+date+"']")).click();
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i = 0; i<actualList.size(); i++)
		{
			System.out.println(actualList.get(i).getAttribute("value"));
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
		

	}

}
