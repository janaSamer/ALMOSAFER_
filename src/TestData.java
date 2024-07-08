import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestData {

	 protected static WebDriver driver;

	String url = "https://global.almosafer.com/en";
	String ExpectedEnglishLanguage = "en";
	String ExpectedArabicLanguage = "ar";
	String ExpectedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	boolean ExpectedQitafLogoValue = true;
	Random rand = new Random();

	@BeforeSuite
	public void setup() {
		if (driver== null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			
		}
	}
	
	@AfterSuite
	public void tearDown() {
		if (driver !=null ) {
			driver.quit();
			driver=null;
		}
		
		
	}
	
	public void TheDeafultConfiguration() {

		driver.get(url);
		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();

	}

}
