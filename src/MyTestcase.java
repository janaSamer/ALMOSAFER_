import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestcase extends TestData {

	MainPageTestCases TC = new MainPageTestCases();
	HotelPageTestCases HTC = new HotelPageTestCases();

	@BeforeTest
	public void setUp() {

		TheDeafultConfiguration();

	}

	@Test(description = "MainPageTest", priority = 1)
	public void checkThelanguage() {

		TC.CheckTheLanguageTest();
	}

	@Test(description = "MainPageTest", priority = 2)
	public void checkThecurrencyIsSAR() {

		TC.CheckTheCurrencyTest();
	}

	@Test(description = "MainPageTest", priority = 3)
	public void checkContactNumberIsCorrect() {

		TC.CheckContactNumberTest();

	}

	@Test(description = "MainPageTest", priority = 4)
	public void ckeckIfQitafLogoIsExist() {

		TC.ckeckIfQitafLogoIsExistTest();

	}

	@Test(description = "MainPageTest", priority = 5)
	public void checkIfHotelTabIsNotSelected() {

		TC.checkIfHotelTabIsNotSelectedTest();
	}

	@Test(description = "MainPageTest", priority = 6)
	public void changeTheLanguageOfWebsiteRandomly() {

		TC.changeTheLanguageOfWebsiteRandomlyTest();
	}

	@Test(description = "HotelPageTest", priority = 7)
	public void hotelSelection() {

		HTC.hotelSelectionTest();

	}

	@Test(description = "description=HotelPageTest", priority = 8)
	public void selectNumberOfPeopleRandomly() {

		HTC.selectNumberOfPeopleRandomlyTest();
	}

	@Test(description = "description=HotelPageTest", priority = 9)
	public void checkThePageIsFullyLoaded() {

		HTC.checkThePageIsFullyLoadedTest();
	}

	@Test(description = "description=HotelPageTest", priority = 10)
	public void checkIfItemsSortedFromLowestToHighest() {

		HTC.checkIfItemsSortedFromLowestToHighestTest();

	}

}
