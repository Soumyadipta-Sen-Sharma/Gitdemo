package nls_Search;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NLP_Search {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		SoftAssert s = new SoftAssert();
		driver.get("https://www.gaadibazaar.in/");
		FileInputStream fis = new FileInputStream("E:\\Read Excel\\Test Cases.xls");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);
		
		for(int i = 1; i<9; i++)
		{
			Row row = sheet.getRow(i);
			
				Cell cell = row.getCell(0);
				RichTextString searchText = cell.getRichStringCellValue();
				String actualSearchText = searchText.getString();
				Cell cell1 = row.getCell(1);
				RichTextString city = cell1.getRichStringCellValue();
				String actualCity = city.getString();
				driver.findElement(By.id("homeSearch")).sendKeys(actualSearchText);
				driver.findElement(By.xpath("//button[@class = 'find-vehcile-btn']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'f-11 lit-black-color']")));
				//driver.getCurrentUrl();
				s.assertTrue(driver.getCurrentUrl().contains(actualCity), "Wrong City for search query " + actualSearchText);
				Cell cell2 = row.getCell(2);
				RichTextString vehicleType = cell2.getRichStringCellValue();
				String actualVehicleType = vehicleType.getString();
				s.assertTrue(driver.getCurrentUrl().contains(actualVehicleType), "Wrong Vehicle Type for search query " + actualSearchText);
				if(row.getCell(3) != null && row.getCell(3).getCellType() != CellType.BLANK)
				{
					List<WebElement> prices = driver.findElements(By.xpath("//span[@class = 'bold f-14 pad-right-2']"));
					for(WebElement price : prices)
					{
						String displayedPrice = price.getText();
						//int diplayedPriceInteger = Integer.parseInt(displayedPrice);
						String[] displayedPriceArray = displayedPrice.split("₹");
						String[] displayedPriceArray1 = displayedPriceArray[1].split("L");
						float displayedPriceInteger = Float.parseFloat(displayedPriceArray1[0]);
						Cell cell3 = row.getCell(3);
						float actualPrice = (float)cell3.getNumericCellValue();
						Cell cell4 = row.getCell(5);
						String actualPriceRange = cell4.getStringCellValue();
						if(actualPriceRange == "under")
						{
							s.assertTrue(actualPrice >= displayedPriceInteger, "The price range is not maintained for search query " + actualSearchText);							
						}
						else if(actualPriceRange == "above")
						{
							s.assertTrue(actualPrice <= displayedPriceInteger, "The price range is not maintained for search query " + actualSearchText);
						}
					}
				}
				
				
				driver.navigate().back();
				driver.findElement(By.id("homeSearch")).clear();
							
			
		}
		s.assertAll();

	}

}
