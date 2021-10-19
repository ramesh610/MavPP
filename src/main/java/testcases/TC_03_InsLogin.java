package testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.InsLogin;
//import pages.LoginPage;
//import utils.DataInputProvider2;
import wrappers.OpentapsWrappers;

public class TC_03_InsLogin extends OpentapsWrappers {
	
@BeforeClass
	
	public void startTestCase1(){
	
		browserName="chrome";
		testCaseName 	= "TC03-firefox_Chrome_parallel";
		testDescription = "Login to Ins portal using Regression";
		dataSheetName="TC0021_InsLogin";
		sheetNumber = 1;
		startrownum=2;
		endrow=2;
		rowcountarraysize=1;
		colcountarraysize=11;
                           
			
	}
	
		
	@Test(dataProvider="fetchData")
	//@Test(dataProvider="fetchData" , groups={"step"} )

	//groups={"Regression"}
	public void loginForSuccess1(String email , String password, String vuserName,String quote, String zip , String quoteemail, String type ,String age, String year, String make, String model) {
		//if(dataRow.equals("TC02")){
		
		
		new InsLogin()
		
		//.isTextEnabled()
		.entermailText()
		.enterEmail(email)
		.enterPwd(password)
	//	.clickLogin()
		.verifyLoggedinUserName1(vuserName);
	
		
	}
	
	}

