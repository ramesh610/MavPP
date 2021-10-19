	package wrappers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.Select;
//import org.apache.commons.io.FileUtils;

import org.junit.Assert;
import utils.Reporter;


public class GenericWrappers {

	public static   RemoteWebDriver driver;  // working for parllerl
	
//	public ThreadLocal<RemoteWebDriver> d = new ThreadLocal<RemoteWebDriver>();
		
//	protected static RemoteWebDriver driver; // original
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;

	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
			//sUrl = null;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch only firefox and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Ramesh
	 * @param url - The url with http or https
	 * @throws MalformedURLException 
	 * 
	 */
	
	
	
	public boolean invokeApp(String browser) {
		boolean bReturn = false;
		try {
			
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();		
			Reporter.reportStep("The browser:" + browser + " launched successfully", "PASS");
			bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
		return bReturn;
	}

	
	
	
	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Ramesh
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	
	
	//ramesh change
	public boolean enterById(String idValue, String data1) {
		boolean bReturn = false;
		try {
			
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data1);	
			Reporter.reportStep("The Test Data: "+data1+" entered successfully in field :"+" and web element is : "+idValue, "PASS" );
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The Test Data: "+data1+" could not be entered in the field :"+idValue, "FAIL");
		}
		return bReturn;
	}

	//Ramesh is enabled
	
	public boolean TextIsEnabled(String idValue) {
		boolean bReturn = false;
		try {
			driver.findElement(By.id(idValue)).isEnabled();
			//driver.findElement(By.id(idValue)).sendKeys(data);	
			Reporter.reportStep("The field is enabled for user entry :"+idValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The field is enabled for user entry :"+idValue, "FAIL");
		}
		return bReturn;
	}
	
	
	public boolean enterByName(String idValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.name(idValue)).clear();
			driver.findElement(By.name(idValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+idValue, "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Ramesh
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				
				Reporter.reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				Reporter.reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			
		}catch (Exception e) {
			Reporter.reportStep("The title did not match", "FAIL");
		}

		return bReturn;
	}

	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Ramesh
	 */
	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}


		return bReturn;
	}
	
	//ramesh
	
	public boolean verifyTextById(String id, String text){
		boolean bReturn = false;;
		String sText = driver.findElementById(id).getText();
		if (driver.findElementById(id).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}


		return bReturn;
	}
	
	
	//Ramesh
	public boolean verifyTextField(String id){
		boolean bReturn = false;
		
		boolean status = driver.findElementById(id).isDisplayed();
		
		if(status)
		{
			Reporter.reportStep("The Text field is enabled " +status , "PASS");
	}
		else {
			
			Reporter.reportStep("The field is not enabled "+status , "FAIL");
		}
		return bReturn;
		
	}
	
	
	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Ramesh
	 */
	public void verifyTextContainsByXpath(String xpath, String text){
		//boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().contains(text))
		//Assert.assertEquals(xpath, text);
		{
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			//bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}


	//	return bReturn;
	}

	/**
	 * This method will close all the browsers
	 * @author Ramesh
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Reporter.reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}

	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Ramesh
	 */
	public boolean clickById(String id) {
		boolean bReturn = false;
		try{
			driver.findElement(By.id(id)).click();
			Reporter.reportStep("The element with id: "+id+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Ramesh
	 */
	public boolean clickByClassName(String classVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.className(classVal)).click();
			Reporter.reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Ramesh
	 */
	public boolean clickByName(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.name(name)).click();
			Reporter.reportStep("The element with name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Ramesh
	 */
	public boolean clickByLink(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.linkText(name)).click();
			Reporter.reportStep("The element with link name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Ramesh
	 */
	public boolean clickByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			Reporter.reportStep("The element : "+xpathVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	
	// Ramesh
	
	public boolean clickByXpath1( String xpathVal) {
		boolean bReturn = false;
		String value = null;
		try{
			
			String xpath = null;
			String xpathval=String.format(xpath, value);
			driver.findElement(By.xpath(xpathVal)).click();
			Reporter.reportStep("The element : "+xpathVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	
	
	
	
	
	
	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Ramesh
	 */
	public boolean mouseOverByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).click().build().perform();
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Ramesh
	 */
	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			Reporter.reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	
	//ramesh
	
	public String getTextById(String id){
		String bReturn = "";
		try{
			return driver.findElement(By.id(id)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+id+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Ramesh
	 */
	public boolean selectById(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			Reporter.reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
		return bReturn;
	}


	// Ramesh
	
	public boolean selectByXpath(String xpath, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.xpath(xpath))).selectByValue(value);;
			Reporter.reportStep("The element with id: "+xpath+" is selected with value :"+value, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
		return bReturn;
	}

	
	public void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File("./object.properties")));
	
	}
	
	/* This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param nameValue -  of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Ramesh
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterByXpath(String xpathValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+xpathValue, "FAIL");
		}
		return bReturn;
	}

	
	public boolean verifyTextContainsById(String id, String text){
		boolean bReturn = false;
		String sText = driver.findElementById(id).getText();
		if (driver.findElementById(id).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}


		return bReturn;
	}

	public boolean SwitchToAlert() {
		boolean bReturn = false;
         
                    if(driver.switchTo().alert() != null){
                        Reporter.reportStep("alert is success :", "PASS");
            			bReturn = true;      
                        
        }else{
			Reporter.reportStep("The alert is not success:", "FAIL");
        }
	
        return bReturn;
	}

	
	
	public boolean verifyTextContainsByXpathA(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		//if (driver.findElementByXPath(xpath).getText().trim().contains(text))
	//	if(sText==text)
		try{
		Assert.assertTrue(sText.contains(text));
					
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}catch(Exception e)
		{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}


	return bReturn;
	}
	
	
	
	public void windowHandle(){
		String handle= driver.getWindowHandle();
        System.out.println("the windos " +handle);
		
	}
	
	public static long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileHandler.copy(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}
	
	
	
	
	public void switchWindow(){
		
		for (String handle1 : driver.getWindowHandles()) {

        	System.out.println("the handle " +handle1);

        	driver.switchTo().window(handle1);

	}
}
}


/*
 if (browser.equalsIgnoreCase("firefox"))
		
		 {

			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.WINDOWS);
		
			

			driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(sUrl);
			
		//	driver.navigate();

			primaryWindowHandle = driver.getWindowHandle();		
			Reporter.reportStep("The browser:" + browser + " launched successfully", "PASS");
			bReturn = true;

		}
		
		
		else
		if (browser.equalsIgnoreCase("chrome"))
			
			try {

				DesiredCapabilities dc = DesiredCapabilities.chrome();
				dc.setBrowserName("chrome");
				dc.setPlatform(Platform.WINDOWS);
			
				

				driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.get(sUrl);
				
			//	driver.navigate();

				primaryWindowHandle = driver.getWindowHandle();		
				Reporter.reportStep("The browser:" + browser + " launched successfully", "PASS");
				bReturn = true;

 */















