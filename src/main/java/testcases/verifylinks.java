package testcases;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class verifylinks {

	public static void main(String[] args) {

		//WebDriver driver = new FirefoxDriver();
		
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
//		Launch Chrome
		
		
		ChromeDriver driver = new ChromeDriver();
	

		driver.get("http://toolsqa.wpengine.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

		for (int i = 1; i<=links.size(); i=i+1)

		{

			System.out.println(links.get(i).getText());

		}

	}

}