package wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.DataInputProvider2;
import utils.DataInputProvider;
import utils.Reporter;

public class OpentapsWrappers extends GenericWrappers {
	
	protected String browserName;
	protected String dataSheetName;
	protected String cellvalue1;
	protected String dataRow;
	protected static String testCaseName;
	protected static String testDescription;
	protected static int rowCount;
//	protected static int sheetNum;
	protected static int startRowNum;
	protected int sheetNumber;
	
	public int rowcount;
	protected int colcount;
	public int startrownum;

	
	public int endrow;
	public int rowcountarraysize;
	protected int colcountarraysize;
	public int rowcountsize;


	
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException{
		Reporter.startResult();
		loadObjects();
	}

	@BeforeTest
		public void beforeTest(){
		
	}

	@BeforeMethod
	@Parameters("browserName")
	public synchronized void beforeMethod(){
		Reporter.startTestCase();
		invokeApp(browserName);
	}
	
//parallel testing using Ie and chrome - refer crossTesting.xml
// @BeforeMethod
//	@Parameters("browserName")
//  public void beforeMethod(String browserName) throws MalformedURLException{
//		Reporter.startTestCase();
//		invokeApp(browserName);
//	} 
 
//parallel testing using assigning differnt nodes - but not working
/*@BeforeMethod
	@Parameters({"browserName", "port"})
 public void beforeMethod(String browserName){
		Reporter.startTestCase();
		invokeApp(browserName ,port);
	} 
*/
 
	@AfterSuite
	public synchronized void afterSuite(){
		Reporter.endResult();
	}

	@AfterTest
	public void afterTest(){
	
		
	}
	
	@AfterMethod
	public void afterMethod(){
		quitBrowser();
	
	}
	
	// new entry
	/*@AfterClass
	public void afterMethod(){
		quitBrowser();
	}*/
	
	
	@DataProvider(name="fetchData", parallel=true)
	
	public Object[][] getData(){
		return DataInputProvider2.getSheet(dataSheetName, sheetNumber,colcountarraysize,endrow,startrownum,rowcountarraysize);
	}

}
