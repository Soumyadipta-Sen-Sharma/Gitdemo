package AjaxAndMouseInteractions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
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

public class ActionsMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'nav-tools']//a[@id = 'nav-link-accountList']")));
		WebElement move = driver.findElement(By.xpath("//div[@id = 'nav-tools']//a[@id = 'nav-link-accountList']"));
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		a.moveToElement(move).contextClick().build().perform();
	}

}
