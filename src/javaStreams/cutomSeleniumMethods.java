package javaStreams;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cutomSeleniumMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[@aria-label = 'Veg/fruit name: activate to sort column ascending']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
		List<String> elementList = list.stream().filter(s->s.getText().contains("Beans")).map(s->getPtice(s)).collect(Collectors.toList());
		elementList.stream().forEach(s->System.out.println(s));
		
	}

	private static String getPtice(WebElement s) {
		// TODO Auto-generated method stub
				
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
