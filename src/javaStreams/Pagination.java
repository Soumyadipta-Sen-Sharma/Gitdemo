package javaStreams;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> price;
		do
		{
		  driver.findElement(By.xpath("//th[@aria-label = 'Veg/fruit name: activate to sort column ascending']")).click();
		  List<WebElement> elementList = driver.findElements(By.xpath("//tr//td[1]"));
		  price = elementList.stream().filter(s->s.getText().contains("Rice")).map(s->getPtice(s)).collect(Collectors.toList());
		  price.stream().forEach(s->System.out.println(s));
		  if(price.size()<1)
		  {
			  driver.findElement(By.xpath("//a[@aria-label = 'Next']")).click();
		  }
		}while(price.size()<1);
			

	}
	
	private static String getPtice(WebElement s)
	{
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();		
		return price;		
	}

}
