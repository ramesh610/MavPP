package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import utils.Reporter;
import wrappers.OpentapsWrappers;

//import utils.DataInputProvider2;

public class InsLogin extends OpentapsWrappers {
	
	String InsLogin= "login-form:email";
	public InsLogin() {
		
		if(!verifyTitle("InsuranceWeb: Home"))
		{
	//	Reporter.reportStep("This is NOT login page", "FAIL");
	//	Reporter.reportStep("The title of the page:"+driver.getTitle(), "FAIL");
		}

	}

		

	public InsLogin enterEmail(String email){
		
		enterById(prop.getProperty("InsLogin.Email.Id"), email);
		
		
		return this;
	}
	
	public InsLogin entermailText(){
		
		verifyTextField(prop.getProperty("InsLogin.Email.Id"));
		return this;
		
		
	}
	
	public InsLogin enterPwd(String password){
		enterById(prop.getProperty("InsLogin.Password.Id"), password);
		return this;
	}
	
	
	// Click Login
		public InsLogin clickLogin(){
			clickById(prop.getProperty("InsLogin.Login.Id"));
			return this;
		} 
		
		public InsLogin verifyLoggedinUserName1(String vuserName){
			
			clickById(prop.getProperty("InsLogin.Login.Id"));
			
			
			try{
			Assert.assertEquals("John Smith", vuserName);
			
			
			Reporter.reportStep("The text is: "+vuserName+" contains the value :"+vuserName, "PASS");
		}
		catch(AssertionError e){
			Reporter.reportStep("The text: "+vuserName+" did not contain the value :"+vuserName, "FAIL");
			System.out.println("failed");
		}
		
		return this;
}
		public InsLogin verifyLoggedinUserName(String vuserName){
			verifyTextByXpath(prop.getProperty("InsLogin.USName.Xpath"), vuserName);
			return this;  
		}  
		 
		public InsLogin verifyLoggedinUserName2(String vuserName){
			verifyTextContainsByXpathA(prop.getProperty("InsLogin.USName.Xpath"), vuserName);
			return this;  
		} 
		public InsLogin autoQuote(String quote){
			selectById(prop.getProperty("InsLogin.selectquote.Id"), quote);
			return this;
			
		}
		
		public InsLogin enterZip(String zip){
			
			enterById(prop.getProperty("InsLogin.zip.Id"),zip);
			return this;
		}
		
		public InsLogin enterquoteEmail(String Email1){
			
			enterById(prop.getProperty("InsLogin.quoteEmail.Id"),Email1);
			return this;
		}
		
		public InsLogin instype(){
			
			clickById(prop.getProperty("InsLogin.type.Id"));
			return this;
		}
		
		
		public InsLogin insnext(){
			
			clickById(prop.getProperty("InsLogin.next.Id"));
			return this;
			
		}
		
		public InsLogin enterAge(String age) throws FileNotFoundException{
		
		
			enterById(prop.getProperty("InsLogin.age.Id"), age);
			return this;
			
		}	
		
		public InsLogin enterGender(){
			
			clickById(prop.getProperty("InsLogin.gender.Id"));
			return this;
			
		}	
		
		
		public InsLogin enterDriving(){
			
			clickById(prop.getProperty("InsLogin.driving.Id"));
			return this;
			
		}
		
		
		public InsLogin insquotenext(){
			
			clickById(prop.getProperty("InsLogin.quotenext.Id"));
			return this;
			
		}
		
		
		public InsLogin vehYear(String year){
			
			enterById(prop.getProperty("InsLogin.quoteyear.Id"), year);
			return this;
			
		}
		
		// click by xpath
		
		public InsLogin vehmake(){
			clickByXpath(prop.getProperty("InsLogin.Make.Xpath"));
			return this;
			
		}
		
	
		
		public InsLogin vehmake2(String make){
			selectById(prop.getProperty("InsLogin.selectquote.Id"), make);
			return this;
			
		}
		
		public InsLogin vehmakeSelect(){
		
			mouseOverByXpath(prop.getProperty("InsLogin.SelectMake.Xpath"));
			return this;
		}
		
		public InsLogin vehmodel(){
			clickByXpath(prop.getProperty("InsLogin.Model.Xpath"));
			return this;
			
		}
	
		public InsLogin getAuto(){
			
			getTextByXpath(prop.getProperty("InsLogin.Get.Xpath"));
			return this;
			
		}
		
		public InsLogin vehmodelSelect(){
			
			mouseOverByXpath(prop.getProperty("InsLogin.SelectModel.Xpath"));
			return this;
		}
		
		
		
		
		public InsLogin vehFin(){
			
			clickById(prop.getProperty("InsLogin.Finan.Id"));
			return this;
			
		}
		
		
		public InsLogin insquotenext1(){
			
			clickById(prop.getProperty("InsLogin.autoquonext.Id"));
			return this;
			
		}

		
		public InsLogin instantquote(){
			getTextByXpath(prop.getProperty("InsLogin.Instantquote.Xpath"));
			return this;
		}
		
		
		/*public InsLogin clickLoginForFailure1(){
			clickByClassName(prop.getProperty("InsLogin.Login.Id"));
			return this;
		}  */
		

		public InsLogin getErrorMessage1(){
			System.out.println(getTextByXpath("//*[@id='login-messages']/table"));
			return this;
		}

	
	/*	public InsLogin getErrorMessage2(String vuserName){
			try{
			Assert.assertEquals("John Smith", vuserName);
			
			
			Reporter.reportStep("The text: isis"+vuserName+" contains the value :"+vuserName, "PASS");
		}
		catch(AssertionError e){
			Reporter.reportStep("The text: "+vuserName+" did not contain the value :"+vuserName, "FAIL");
			System.out.println("failed");
		} 
		
		return this;
}		*/
		
		public InsLogin selectAuto(String automobiletype)  {
			
		String xpath =prop.getProperty("AddUserPage.SelectAutotype.xpath");
	String xpathval=String.format(xpath, automobiletype);
		clickByXpath(xpathval);
	//		clickByXpath1(prop.getProperty("AddUserPage.SelectRole.xpath"));
		return this; 
					
		}	
		
		public InsLogin enterGender1(String gender)  {
		String xpath =prop.getProperty("AddUserPage.SelectGender.xpath");
			String xpathval=String.format(xpath, gender);
			clickByXpath(xpathval);
				//clickByXpath1(prop.getProperty("AddUserPage.SelectGender.xpath"));
			return this; 
						
			}	
		
		
		
		public InsLogin enterDriving1(String drivingrecord)  {
			String xpath =prop.getProperty("AddUserPage.SelectDrecord.xpath");
			String xpathval=String.format(xpath, drivingrecord);
			clickByXpath(xpathval);
			//	clickByXpath1(prop.getProperty("AddUserPage.SelectRole.xpath"));
			return this; 
						
			}	
		
		public InsLogin vehFin1(String vehFin)  {
			String xpath =prop.getProperty("AddUserPage.SelectVehFin.xpath");
			String xpathval=String.format(xpath, vehFin);
			clickByXpath(xpathval);
			//	clickByXpath1(prop.getProperty("AddUserPage.SelectRole.xpath"));
			return this; 
						
			}	
		
		
		
		public InsLogin vehmake1(String vehmake)  {
			String xpath =prop.getProperty("AddUserPage.SelectVehmake.xpath");
			String xpathval=String.format(xpath, vehmake);
			clickByXpath(xpathval);
			//	clickByXpath1(prop.getProperty("AddUserPage.SelectRole.xpath"));
			return this; 
						
			}	
		
		
		public InsLogin vehmodelSelect1(String vehmodel)  {
			String xpath =prop.getProperty("AddUserPage.SelectVehmodel.xpath");
			String xpathval=String.format(xpath, vehmodel);
			clickByXpath(xpathval);
			//	clickByXpath1(prop.getProperty("AddUserPage.SelectRole.xpath"));
			return this; 
						
			}	
		
		public InsLogin verifyusdprice(String price){
			verifyTextContainsByXpath(prop.getProperty("AddUserPage.price.xpath"), price);
			return this;  
		} 
		
		
		
		public void verifyusdprice1(String price1) {
			
			Assert.assertEquals("Your Instant Quote is USD 1.200,00 every twelve months", price1);
		}
		
}






