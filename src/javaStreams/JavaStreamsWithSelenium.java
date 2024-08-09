package javaStreams;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaStreamsWithSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		SoftAssert a = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[@aria-label = 'Veg/fruit name: activate to sort column ascending']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
		List<String> originalList = list.stream().map(s->s.getText()).collect(Collectors.toList());
		originalList.forEach(s->System.out.println(s));
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		a.assertTrue(originalList.equals(sortedList), "The list in the table is not sorted properly : ");
		a.assertAll();

	}

}
