import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class MyTestcase {
	
	WebDriver  driver =new ChromeDriver() ;
	String url="https://global.almosafer.com/en"; 
	String ExpectedLanguage="en";
	String ExpectedCurrency="SAR";
	String ExpectedContactNumber="+966554400000";
	boolean QitafLogoIsThere=true;
	@BeforeTest
	public void setUp() {
		
		driver.get(url);
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));				
	    driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();
	}
	
	//test if the lang is en 
	@Test
	public void  checkThelang() {
		WebElement lang= driver.findElement(By.tagName("html"));
		String ActualLanguageOnWebsiteVlaue=lang.getAttribute("lang");
	    org.testng.Assert.assertEquals(ActualLanguageOnWebsiteVlaue,ExpectedLanguage);
	
	}
	@Test
	public void checkThecurrencyIsSAR() {
		
		String TheActualCurrency =driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		org.testng.Assert.assertEquals(TheActualCurrency ,ExpectedCurrency);
		
		
	}
	@Test
	public void checkContactNumberIsCorrect() {
		String TheActualContactNumber= driver.findElement(By.tagName("strong")).getText();
	    org.testng.Assert.assertEquals(TheActualContactNumber,ExpectedContactNumber);
		
	
	}
	
	@Test
	public void ckeckIfQitafLogoIsExist() {
		
       boolean  ActualQitafLogo= driver.findElement(By.xpath("//svg[@data-testid='Footer__QitafLogo']")).isDisplayed();
       org.testng.Assert.assertEquals( ActualQitafLogo,QitafLogoIsThere);
		
	}
	
	
	
	
	
	
}
