package ecommerceWebsite;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("learning");		
		driver.findElement(By.xpath("//input[@value = 'user']/following-sibling::span[@class = 'checkmark']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success']")));
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        WebElement staticDropDown = driver.findElement(By.xpath("//select[@class = 'form-control']"));
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        
        List<WebElement> items = driver.findElements(By.xpath("//button[@class = 'btn btn-info']"));
        
        for(int i = 0; i<items.size(); i++)
        {
        	items.get(i).click();
        }
        
        driver.findElement(By.xpath("//a[@class = 'nav-link btn btn-primary']")).click();

	}

 }

