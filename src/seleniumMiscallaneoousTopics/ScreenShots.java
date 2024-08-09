package seleniumMiscallaneoousTopics;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenShots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.co.in/");
		File src = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\screenshot.jpg"));
		

	}

}
