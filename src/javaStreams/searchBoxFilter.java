package javaStreams;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchBoxFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		SoftAssert a = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("Rice");
		List<WebElement> searchResult = driver.findElements(By.xpath("//tr//td[1]"));
		List<WebElement> searchResultList = searchResult.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		a.assertTrue(searchResultList.size()>0, " The search is not working");
		a.assertEquals(searchResult.size(), searchResultList.size());
		a.assertAll();

	}

}
