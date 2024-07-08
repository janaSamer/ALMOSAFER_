import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelPageTestCases extends TestData {

	public void hotelSelectionTest() {

		WebElement hotelTab = driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-hotels"));

		hotelTab.click();

		if (driver.getCurrentUrl().contains(ExpectedEnglishLanguage)) {

			String[] englishCites = { "Dubai", "Jeddah", "Riyadh" };

			int randomIndex = rand.nextInt(englishCites.length);

			WebElement searchTab = driver
					.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));

			searchTab.sendKeys(englishCites[randomIndex]);

		} else if (driver.getCurrentUrl().contains(ExpectedArabicLanguage)) {

			String[] arabicCites = { "دبي  ", "جدة " };

			int randomIndex = rand.nextInt(arabicCites.length);

			WebElement searchTab = driver.findElement(By.cssSelector("input[placeholder='البحث عن فنادق أو وجهات']"));

			searchTab.sendKeys(arabicCites[randomIndex]);

		}
	}
		public void selectNumberOfPeopleRandomlyTest() {
			

			driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-hotels")).click();

			int randomIndex = rand.nextInt(2);

			Select mySelector = new Select(driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi")));

			mySelector.selectByIndex(randomIndex);

			driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']")).click();
			
			
			
		}

	  public void checkThePageIsFullyLoadedTest() {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

			WebElement resultTab = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']")));

			boolean ActualResult = resultTab.getText().contains("found") || resultTab.getText().contains("وجدنا");

			boolean ExpectedResult = true;

			assertEquals(ActualResult, ExpectedResult);

		  
		  
		  
	  }
	  public void checkIfItemsSortedFromLowestToHighestTest() {
		  
		  WebElement LowestPriceButton = driver
					.findElement(By.xpath("//button[@data-testid='HotelSearchResult__sort__LOWEST_PRICE']"));

			LowestPriceButton.click();

			WebElement priceContainer = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));

			List<WebElement> prices = priceContainer.findElements(By.className("Price__Value"));

			String theFirstItemPrice = prices.get(0).getText();

			String theLastItemPrice = prices.get(prices.size() - 1).getText();

			int firstItemPrice = Integer.parseInt(theFirstItemPrice);

			int lastItemPrice = Integer.parseInt(theLastItemPrice);

			boolean ActualResult = lastItemPrice > firstItemPrice;

			boolean ExpectedResult = true;

			assertEquals(ActualResult, ExpectedResult);
	  }
	  
}
