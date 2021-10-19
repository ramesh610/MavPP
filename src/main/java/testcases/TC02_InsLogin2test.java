package testcases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.InsLogin;
//import pages.LoginPage;
//import utils.DataInputProvider2;
import wrappers.OpentapsWrappers;

public class TC02_InsLogin2test extends OpentapsWrappers {
	

@BeforeClass
	
	public void startTestCase(){
	
		browserName="chrome";
		testCaseName 	= "TC-IE";
		testDescription = "Login to Ins portal using Regression";
		dataSheetName="TC0021_InsLogin";
		sheetNumber = 1;
		startrownum=1;
		endrow=1;
		rowcountarraysize=1;
		colcountarraysize=11;
                           
			
	}
	
		
	@Test(dataProvider="fetchData")
//	@Test(dataProvider="fetchData" , groups={"step"} )

	//groups={"Regression"}
	public void loginForSuccess2(String email , String password, String vuserName,String quote, String zip , String quoteemail, String type ,String age, String year, String make, String model) 
	
	//public void loginforSuccess3(String[] data)
	{
      //  System.out.println("Data is: " + data);

		new InsLogin()
		
		//.isTextEnabled()
		.enterEmail(email)
		.enterPwd(password)
	//	.clickLogin()
		.verifyLoggedinUserName1(vuserName);
			
	}
	
	}

