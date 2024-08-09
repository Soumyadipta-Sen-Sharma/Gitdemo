package seleniumMiscallaneoousTopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinkIdentification {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SoftAssert a = new SoftAssert();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer = driver.findElement(By.xpath("//div[@id = 'gf-BIG']"));
		List<WebElement> links = footer.findElements(By.tagName("a"));
		for(WebElement link : links)
		{
			
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();
			System.out.println(link.getText() + "-" + resCode);
			a.assertTrue(resCode<400, "The link with the text " + link.getText() + " is getting " + resCode + " response code");			
		}
		a.assertAll();
		
		
		
		

	}

}
