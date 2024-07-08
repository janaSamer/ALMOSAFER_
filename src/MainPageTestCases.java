import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPageTestCases extends TestData {

	public void CheckTheLanguageTest() {

		WebElement lang = driver.findElement(By.tagName("html"));
		String ActualLanguageOnWebsiteVlaue = lang.getAttribute("lang");
		org.testng.Assert.assertEquals(ActualLanguageOnWebsiteVlaue, ExpectedEnglishLanguage);
	}

	public void CheckTheCurrencyTest() {

		String TheActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		org.testng.Assert.assertEquals(TheActualCurrency, ExpectedCurrency);
	}

	public void CheckContactNumberTest() {

		String TheActualContactNumber = driver.findElement(By.tagName("strong")).getText();

		org.testng.Assert.assertEquals(TheActualContactNumber, ExpectedContactNumber);

	}

	public void ckeckIfQitafLogoIsExistTest() {

		WebElement QitafLogo = driver.findElement(By.cssSelector(".sc-fihHvN.eYrDjb"));

		boolean ActualValue = QitafLogo.findElement(By.tagName("svg")).isDisplayed();

		assertEquals(ActualValue, ExpectedQitafLogoValue);
	}

	public void checkIfHotelTabIsNotSelectedTest() {

		String ExpectedValue = "false";

		String ActualValue = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"))
				.getAttribute("aria-selected");

		org.testng.Assert.assertEquals(ExpectedValue, ActualValue);

	}

	public void changeTheLanguageOfWebsiteRandomlyTest() {
    	
    	

		String[] websiteLang = { "https://global.almosafer.com/en", "https://global.almosafer.com/ar" };

		int randomIndex = rand.nextInt(websiteLang.length);

		driver.get(websiteLang[randomIndex]);

		if (driver.getCurrentUrl().contains("en")) {

		WebElement lang = driver.findElement(By.tagName("html"));

		String ActuaLanguageOnTheWebsite = lang.getAttribute("lang");

		org.testng.Assert.assertEquals(ActuaLanguageOnTheWebsite, ExpectedEnglishLanguage);
    }
	}
}
