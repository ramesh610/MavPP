
// not required

package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

//import com.sun.jna.platform.unix.X11.Screen;

public class WrapperMethods {

	static RemoteWebDriver driver ;
	//int sCount = 1;

	// Deepesh - 06/26/2016
	//Intitalizing the driver

	public void launchDriver(String URL, String browser){
		if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//Screenshot Method

	public void Screenshot() {

		//Take snapshot
		File ScreenShot = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(ScreenShot, new File("./Snapshots/snap"+ System.currentTimeMillis() +".jpeg"));
		} catch (IOException e) {
			System.out.println("IOException catched");
		}
		

	}

	//Method to find element by CLASSNAME and click

	public void clickByClassName(String className) {

		try {
			driver.findElementByClassName(className).click();
		} 
		catch (NoSuchElementException e) {
			System.out.println("The element with classname - "+className+ " not found.");		
		}
		finally
		{
			Screenshot();		
		}

	}	

	//Dropdown methods - by Value
	//Method to select a dropdown value using Value and locator as 'ID'

	public void selectByValue_UsingId(String id, String Value) {

		try {
			Select dropdown = new Select(driver.findElementById(id));
			List<WebElement> allOptions = dropdown.getOptions();
			dropdown.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.err.println("The dropdown with id - "+id+ " not found.");	
		}
		finally
		{
			Screenshot();		
		}
	}

	//Method to select a dropdown value using Value and locator as 'Name'

	public void selectByValue_UsingName(String name, String Value) {

		try {
			Select dropdown = new Select(driver.findElementByName(name));
			List<WebElement> allOptions = dropdown.getOptions();
			dropdown.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.err.println("The dropdown with name - "+name+ " not found.");	
		}
		finally
		{
			Screenshot();		
		}
	}

	//Method to select a dropdown value using Value and locator as 'className'

	public void selectByValue_UsingclassName(String className, String Value) {

		try {
			Select dropdown = new Select(driver.findElementByClassName(className));
			List<WebElement> allOptions = dropdown.getOptions();
			dropdown.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.err.println("The dropdown with classname - "+className+ " not found.");	
		}
		finally
		{
			Screenshot();		
		}
	}

	//Method to select a dropdown value using Value and locator as 'TagName'

	public void selectByValue_UsingTagName(String TagName, String Value) {

		try {
			Select dropdown = new Select(driver.findElementByTagName(TagName));
			List<WebElement> allOptions = dropdown.getOptions();
			dropdown.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.err.println("The dropdown with TagName - "+TagName+ " not found.");	
		}
		finally
		{
			Screenshot();		
		}
	}		

	//Method to select a dropdown value using Value and locator as 'TagName'

	public void selectByValue_Usingxpath(String xpath, String Value) {

		try {
			Select dropdown = new Select(driver.findElementByXPath(xpath));
			List<WebElement> allOptions = dropdown.getOptions();
			dropdown.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.err.println("The dropdown with xpath - "+xpath+ " not found.");	
		}
		finally
		{
			Screenshot();		
		}
	}	

	//Method to select a dropdown value using Value and locator as 'CSS'

	public void selectByValue_UsingCSS(String CSS, String Value) {

		try {
			Select dropdown = new Select(driver.findElementByCssSelector(CSS));
			List<WebElement> allOptions = dropdown.getOptions();
			dropdown.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.err.println("The dropdown with xpath - "+CSS+ " not found.");	
		}
		finally
		{
			Screenshot();		
		}
	}	

	//Govind - 06/26/2016
	//Dropdown methods - by visibleText

	//Method to select a dropdown value using visibleText and locator as 'NAME'

	public boolean selectbyvisibletext_Byname(String name, String value) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByName(name));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+name+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using visibleText and locator as 'ID'

	public boolean selectbyvisibletext_Byid(String id, String value) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementById(id));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+id+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using visibleText and locator as 'className'

	public boolean selectbyvisibletext_Byclassname(String classname, String value) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByClassName(classname));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+classname+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using visibleText and locator as 'TAGNAME'

	public boolean selectbyvisibletext_Bytagname(String tagname, String value) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByTagName(tagname));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+tagname+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using visibleText and locator as 'XPATH'

	public boolean selectbyvisibletext_Byxpath(String xpath, String value) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByXPath(xpath));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+xpath+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using visibleText and locator as 'CSS'

	public boolean selectbyvisibletext_Bycss(String css, String value) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByClassName(css));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+css+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Mastaan - 06/26/2016
	//Dropdown methods - by index

	//Method to select a dropdown value using index and locator as 'NAME'

	public boolean selectbyindex_Byname(String name, int indexNumber) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByName(name));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByIndex(indexNumber);

			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with name :"+name+" is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using index and locator as 'ID'

	public boolean selectbyindex_Byid(String id,int indexNumber) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementById(id));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByIndex(indexNumber);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+id+"is not available");
		}
		finally{
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using index and locator as 'ID'

	public boolean selectbyindex_Byclassname(String classname, int indexNumber) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByClassName(classname));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByIndex(indexNumber);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+classname+"is not available");
		}
		finally{
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using index and locator as 'TAGNAME'

	public boolean selectbyindex_Bytagname(String tagname, int indexNumber) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByTagName(tagname));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByIndex(indexNumber);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+tagname+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using index and locator as 'XPATH'

	public boolean selectbyindex_Byxpath(String xpath, int indexNumber) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByXPath(xpath));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByIndex(indexNumber);
			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+xpath+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//Method to select a dropdown value using index and locator as 'CSS'

	public boolean selectbyindex_Bycss(String css, int indexNumber) {
		boolean flag= false;
		
		try {
			Select dropdown1 = new Select(driver.findElementByClassName(css));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByIndex(indexNumber);

			int size=alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :"+css+"is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		return flag;

	}

	//SivaGanesh - 06/26/2016
	//Enter Text

	//SendKeys By Id
	public void enterTextById(String id, String idValue) 
	{
		try {
			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys(idValue);
		} catch (NoSuchElementException e) {
			System.out.println("The Element with id : "+id+" is not available");
		}
		finally {
			//File imj =driver.getScreenshotAs(OutputType.FILE);

			//FileUtils.copyFile(imj, new File("./Snapshots/snap1.jpeg"));
		}
	}

	//SendKeys By Name
	public void enterTextByName(String name, String nameValue) 
	{
		try {
			driver.findElementByName(name).clear();
			driver.findElementByName(name).sendKeys(nameValue);
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Name : "+name+" is not available");
		}
		finally {
			//File imj =driver.getScreenshotAs(OutputType.FILE);

			//FileUtils.copyFile(imj, new File("./Snapshots/snap1.jpeg"));
		}
	}

	//SendKeys By ClassName
	public void enterTextByClass(String className, String classValue) 
	{
		try {
			driver.findElementByClassName(className).clear();
			driver.findElementByClassName(className).sendKeys(classValue);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with ClassName : "+className+" is not available");
		}
		finally {
			//File imj =driver.getScreenshotAs(OutputType.FILE);

			//FileUtils.copyFile(imj, new File("./Snapshots/snap1.jpeg"));
		}
	}

	//SendKeys By Xpath
	public void enterByTextXpath(String xPath, String xPathvalue) 
	{
		try {
			driver.findElementByXPath(xPath).clear();
			driver.findElementByXPath(xPath).sendKeys(xPathvalue);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with Xpath : "+xPath+" is not available");
		}
		finally {
			//File imj =driver.getScreenshotAs(OutputType.FILE);

			//FileUtils.copyFile(imj, new File("./Snapshots/snap1.jpeg"));
		}
	}

	//SendKeys By TagName
	public void enterTextByTagName(String tagName, String tagValue) 
	{
		try {
			driver.findElementByTagName(tagName).clear();
			driver.findElementByTagName(tagName).sendKeys(tagValue);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with LinkText : "+tagName+" is not available");
		}
		finally {
			//File imj =driver.getScreenshotAs(OutputType.FILE);

			//FileUtils.copyFile(imj, new File("./Snapshots/snap1.jpeg"));
		}
	}

	//Deepesh - 06/26/2016
	//Switch Windows

	//Switch to specific window by passing the window handle

	public void switchWindow(String winHandle) {

		try {
			driver.switchTo().window(winHandle);
		} catch (NoSuchWindowException e) {
			System.err.println("Target Window -"+winHandle+" not found");		}

		finally{
			Screenshot();
		}
	}

	//Deepesh - 06/26/2016
	//Switch Frames

	//Switch to frames using ID
	
	public void switchToFramesUsingId(String iframeID) {

		try {
			driver.switchTo().frame(iframeID);
		} catch (NoSuchFrameException e) {
			System.err.println("The Frame with id :"+iframeID+"is not available");
		}
		finally{
			Screenshot();
		}
	}

	//Switch to frames using WebElement
	
	public void switchToFramesUsingWebElement(String WebElement) {

		try {
			driver.switchTo().frame(WebElement);
		} catch (NoSuchFrameException e) {
			System.err.println("The Frame with webElement :"+WebElement+"is not available");
		}
		finally{
			Screenshot();
		}
	}

	//Switch to frames using Index

	public void switchToFramesUsingIndex(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.err.println("The Frame with index :"+index+"is not available");
		}
		finally{
			Screenshot();
		}
	}

	
	//Naresh - 06/26/2016
	//Click on any item

	//Click on webelement using ID

	public void clickbyID(String id) 
	{
		try {
			driver.findElementById(id).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with id" + id +"is not found");
		}
		finally{
			Screenshot();
		}
	}

	//Click on webelement using Name

	public void clickbyName(String name) 
	{
		try {
			driver.findElementByName(name).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with name:" + name +"is not found");
		}
		finally{
			Screenshot();
		}
	}

	//Click on webelement using LinkText

	public void clickbyLinkText(String linktext) 
	{
		try {
			
			driver.findElementByLinkText(linktext).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with linktext:" + linktext +"is not found");

		}
		finally{
			Screenshot();
		}
	}

	//Click on webelement using TagName

	public void clickbyTagname(String tagname) 
	{
		try {
			driver.findElementByTagName(tagname).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with tagname:" + tagname +"is not found");
		}
		finally{
			Screenshot();
		}
	}

	//Click on webelement using ClassName


	//Click on webelement using Xpath

	public void clickbyXpath(String xpath) 
	{
		try {
			driver.findElementByXPath(xpath).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with xpath:" + xpath +"is not found");
		}
		finally{
			Screenshot();
		}
	}

	
	//Browser level actions

	//Verify Title

	public boolean verifyTitle(String Title) 
	{
		boolean flg = false;
		try {
			String expectedTitle = driver.getTitle();
			if(expectedTitle.contains(Title))
			{
				System.out.println("Title is matching here..");
				return flg = true;
			}
			else
			{
				System.out.println("Oops..Title is not matching here");
				return flg = true;
			}
		} catch (Exception e) {
			System.err.println("Couldn't get the title of the webpage..");
		}
		finally
		{
			Screenshot();

		} return flg;

	}

	//Quit browser

	public void quitBrowser() 
	{
		try {
			driver.quit();

		} catch (WebDriverException e) {
			System.out.println("Unable to quit the browser...");
		}
		finally{
			Screenshot();
		}
	}

	//Close browser

	public void closeBrowser() 
	{
		try {
			driver.close();

		} catch (WebDriverException e) {
			System.out.println("Unable to close the browser...");
		}
		finally{
			Screenshot();
		}
	}

	//get URL of the current window

	public void getURLcurrent() 
	{
		try {
			driver.getCurrentUrl();

		} catch (WebDriverException e) {
			System.out.println("Unable to get the current URL from the window...");
		}
		finally{
			Screenshot();
		}
	}

	//Deepesh - 06/26/2016
	//Verify Text  equals

	//Verify the given text by EQUALS using the locator 'XPATH' and return boolean

	public boolean verifyTextEqualsByXpath(String Xpath, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByXPath(Xpath).getText();
			if (ActualText.equals(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with Xpath - "+Xpath+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by EQUALS using the locator 'ID' and return boolean

	public boolean verifyTextEqualsById(String ID, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementById(ID).getText();
			if (ActualText.equals(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with ID - "+ID+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by EQUALS using the locator 'Name' and return boolean

	public boolean verifyTextEqualsByName(String Name, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByName(Name).getText();
			if (ActualText.equals(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with Name - "+Name+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by EQUALS using the locator 'ClassName' and return boolean

	public boolean verifyTextEqualsByClassName(String ClassName, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByClassName(ClassName).getText();
			if (ActualText.equals(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with ClassName - "+ClassName+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by EQUALS using the locator 'TagName' and return boolean

	public boolean verifyTextEqualsByTagName(String TagName, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByTagName(TagName).getText();
			if (ActualText.equals(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with TagName - "+TagName+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by EQUALS using the locator 'CSSSelector' and return boolean

	public boolean verifyTextEqualsByCSS(String CSS, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByCssSelector(CSS).getText();
			if (ActualText.equals(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with CSS - "+CSS+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by EQUALS using the locator 'LinkText' and return boolean

	public boolean verifyTextEqualsByLinkText(String linkText, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByLinkText(linkText).getText();
			if (ActualText.equals(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with linkText - "+linkText+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}


	//Janice - 06/26/2016
	//Verify Text  contains

	//Verify the given text by contains using the locator 'XPATH' and return boolean

	public boolean verifyTextContainsByXpath(String Xpath, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByXPath(Xpath).getText();
			if (ActualText.contains(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with Xpath - "+Xpath+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by contains using the locator 'ID' and return boolean

	public boolean verifyTextContainsById(String ID, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementById(ID).getText();
			if (ActualText.contains(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with ID - "+ID+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by contains using the locator 'Name' and return boolean

	public boolean verifyTextContainsByName(String Name, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByName(Name).getText();
			if (ActualText.contains(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with Name - "+Name+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by contains using the locator 'ClassName' and return boolean

	public boolean verifyTextContainsByClassName(String ClassName, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByClassName(ClassName).getText();
			if (ActualText.contains(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with ClassName - "+ClassName+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by contains using the locator 'TagName' and return boolean

	public boolean verifyTextContainsByTagName(String TagName, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByTagName(TagName).getText();
			if (ActualText.contains(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with TagName - "+TagName+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by contains using the locator 'CSSSelector' and return boolean

	public boolean verifyTextContainsByCSS(String CSS, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByCssSelector(CSS).getText();
			if (ActualText.contains(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with CSS - "+CSS+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}

	//Verify the given text by contains using the locator 'LinkText' and return boolean

	public boolean verifyTextContainsByLinkText(String linkText, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByLinkText(linkText).getText();
			if (ActualText.contains(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with linkText - "+linkText+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
	}


	//SivaGanesh - 06/26/2016
	//Get text method

	//Wrapper for getTextBy Id
	
	public String getTextById(String id) {
		String str=null;
		try {
			str = driver.findElementById(id).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Id : "+id+" is not available");
		}
		finally
		{
			Screenshot();
			}
		return str;
	}
	
	//Wrapper for getTextBy Name
	
	public String getTextByName(String name) {
		String str=null;
		try {
			str = driver.findElementByName(name).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Name : "+name+" is not available");
		}
		finally
		{
			Screenshot();
		}
		return str;
	}
	
	//Wrapper for getTextBy ClassName
	
	public String getTextByclassName(String className) {
		String str=null;
		try {
			str = driver.findElementByClassName(className).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The Element with ClassName : "+className+" is not available");
		}
		finally
		{
			Screenshot();
		}
		return str;
	}
	
	//Wrapper for getTextBy TagName
	
	public String getTextByTagName(String tagName) {
		String str=null;
		try {
			str = driver.findElementByTagName(tagName).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The Element with TagName : "+tagName+" is not available");
		}
		finally
		{
			Screenshot();
		}
		return str;
	}
	
	//Wrapper for getTextBy LinkText
	
	public String getTextByLinkText(String linkText) {
		String str=null;
		try {
			str = driver.findElementByLinkText(linkText).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The Element with LinkText : "+linkText+" is not available");
		}
		finally
		{
			Screenshot();
		}
		return str;
	}


	//Wrapper for getTextBy Xpath
	
	public String getTextByXpath(String xpath) {
		String str = null;
		try {
			str = driver.findElementByXPath(xpath).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Xpath : "+xpath+" is not available");
		}
		finally
		{
			Screenshot();
		}
		return str;
	}

  //Alert Options
               
                //Switching to alert
               
                public void SwitchToAlert() {
                                try {
                                                driver.switchTo().alert();
                                } catch (NoAlertPresentException e) {
                                                System.err.println("issue with handling alert");
                                }
                                finally
                                {
                                                Screenshot();
                                }
                }
 
                //GetText from alert
 
                public String GetTextFromAlert() {
                                String AlertText = null;
                                try {
                                                AlertText = driver.switchTo().alert().getText();
                                } catch (NoAlertPresentException e) {
                                                System.err.println("issue with handling alert");
                                }
                                finally
                                {
                                                Screenshot();
                                }
                                return AlertText;
                }
 
                //Accept alert
 
                public void AcceptAlert() {
                                try {
                                                driver.switchTo().alert().accept();
                                } catch (NoAlertPresentException e) {
                                                System.err.println("issue with handling alert");
                                }
                                finally
                                {
                                                Screenshot();
                                }
                }
 
                //Dismiss Alert
               
                public void DismissAlert() {
                                try {
                                                driver.switchTo().alert().dismiss();
                                                } catch (NoAlertPresentException e) {
                                                System.err.println("issue with handling alert");
                                }
                                finally
                                {
                                                Screenshot();
                                }
                }
 
                //Send keys to Alert
               
                public void SendKeysToAlert(String Text) {
                                try {
                                                driver.switchTo().alert().sendKeys(Text);
                                                } catch (NoAlertPresentException e) {
                                                System.err.println("issue with handling alert");
                                }
                                finally
                                {
                                                Screenshot();
                                }
                }

            	public void switchtowindows() {
            		

            		try {
            			Set<String> whandles = driver.getWindowHandles();
            			
            			//switch to the secondwindow
            			for (String whandle : whandles) {
            				driver.switchTo().window(whandle);
            	//get url of the secondwindow
            			     //System.out.println(driver.getCurrentUrl());
            				 //System.out.println(driver.getTitle());
            				//driver.close();
            				  
            			}
            		} catch (NoSuchWindowException e) {
            			// TODO Auto-generated catch block
            			System.out.println("The window you are trying access is not available");
            		}
            		finally{
            			//Take snapshot
            			Screenshot();
            		}
            		}
                public String getParentWindowHandle() {
                	
                	
                	String ParentWindow= null;;
            		try {
            			ParentWindow = driver.getWindowHandle();
            		} catch (NoSuchWindowException e) {
            			// TODO Auto-generated catch block
            			System.out.println("The window you are trying access is not available");
            		}
            		finally{
            			Screenshot();
            		}
                			return ParentWindow;
                			
                }

                
            	public void switchToParentWindow() 
            	{
            		
            	try {
            		String ParentWindow = null;
            	driver.switchTo().window(ParentWindow);
            		
            	} catch (NoSuchWindowException e) {
            		// TODO Auto-generated catch block
            		System.out.println("The window you are trying access is not available");
            	}
            	finally{
            		Screenshot();
            	}
            			//return ParentWindow;
            		
            		}
            	public String getattributebyXPath(String xpath, String att)
        		{
        			String str=null;
					try {
						str = driver.findElementByXPath(xpath).getAttribute(att);
					} catch (NoSuchElementException e) {
						System.out.println("The Element xpat : "+xpath+" is not available");
					}
					finally
					{
						Screenshot();
					}
					return str;
        		}
  
            	public boolean verifygetattributebyXPath(String Xpath, String att, String Text) {
            		boolean flag = false;
            		try {
            			String ActualText = driver.findElementByXPath(Xpath).getAttribute(att);
            			if (ActualText.equals(Text)){
            				System.out.println("Text matches!");
            			}
            			else {
            				System.out.println("Text doesnt match.");
            			}
            		} catch (NoSuchElementException e) {
            			System.err.println("The element with Xpath - "+Xpath+" not found.");	
            		}
            		finally
            		{
            			Screenshot();
            		}
            		return flag;
            	}
            	public void clickByLinkTextVerifyWindowClosed(String linktext){
            		try {
            			Screenshot();
            			driver.findElementByLinkText(linktext).click();
            			driver.getCurrentUrl();
            		} catch (NoSuchElementException e) {
            			System.out.println("Element with linktext:" + linktext +"is not found");

            		}
            		catch(NoSuchWindowException e){
            			System.out.println("Window closed-verified");
            		}
            			
            			
            		}
            	public String getattributebyid(String id, String value)
        		{
        			String str=null;
					try {
						str = driver.findElementById(id).getAttribute(value);
					} catch (NoSuchElementException e) {
						System.out.println("The Element xpat : "+id+" is not available");
					}
					finally
					{
						Screenshot();
					}
					return str;
        		}
            		
            	
                public String getWindowHandle() {
                	
                	
                	String ParentWindow= null;;
            		try {
            			ParentWindow = driver.getWindowHandle();
            		} catch (NoSuchWindowException e) {
            			// TODO Auto-generated catch block
            			System.out.println("The window you are trying access is not available");
            		}
            		finally{
            			Screenshot();
            		}
                			return ParentWindow;
                			
                }

                
               
            

            	

            		public void login_opentaps() {

            			
            			enterTextById("username", "DemoSalesManager");
            			enterTextById("password", "crmsfa");
            			clickByClassName("decorativeSubmit");
            			clickbyLinkText("CRM/SFA");
            			clickbyLinkText("Leads");
            			
            			
            			

            			

            		}

            		public String getattributevalue(String xpath, String att)
            		{
            			String str= null;
            			try {
            				str = driver.findElementByXPath(xpath).getAttribute(att);
            			} catch (NoSuchElementException e) {
            				System.err.println("The element with Xpath - "+xpath+" not found.");	
            			}
            			finally
            			{
            				Screenshot();
            			}
            			return str;
            		}

            	           	}

