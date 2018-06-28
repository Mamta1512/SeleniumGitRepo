package Selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	private WebDriver driver;
	private String url;
	private JavascriptExecutor js;
	
	@Before
	public void setUp()
	{
		url="https://learn.letskodeit.com/p/practice";
		System.setProperty("webdriver.chrome.driver", "C:/Users/ITSMEE/Downloads/Compressed/Selenium/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws Exception{
		driver.get(url);
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(5000);
		
		WebElement mouseHover=driver.findElement(By.id("mousehover"));
		Actions mouseAction=new Actions(driver);
		mouseAction.moveToElement(mouseHover).perform();
		Thread.sleep(5000);
		
		WebElement subElement=driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Reload']"));
		subElement.click();
			
		
	}

	@After
	public void tearDown()
	{
		
	}
}
