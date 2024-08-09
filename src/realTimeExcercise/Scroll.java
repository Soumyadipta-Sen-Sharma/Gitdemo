package realTimeExcercise;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> totalList = driver.findElements(By.xpath("//div[@class = 'tableFixHead']//td[4]"));
		int sum = 0;
		for(int i = 0; i<totalList.size(); i++)
		{
			sum = sum + Integer.parseInt(totalList.get(i).getText());
		}
		System.out.println(sum);
		String displayedSum = driver.findElement(By.xpath("//div[@class = 'totalAmount']")).getText();
		System.out.println(displayedSum);
		String[] displayedSum00 = displayedSum.split(":");
		Integer displayedSumNumber = Integer.parseInt(displayedSum00[1].trim());
		/*String[] displayedSum00 = displayedSum.split("[");
		String[] displayedSum01 = displayedSum00[1].split("]");*/
		Assert.assertEquals(sum, displayedSumNumber);

	}

}
