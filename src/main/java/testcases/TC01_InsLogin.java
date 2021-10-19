package testcases;


import java.io.FileNotFoundException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.InsLogin;

//import utils.DataInputProvider2;
import wrappers.OpentapsWrappers;
import testcases.TC02_InsLogin2test;




public class TC01_InsLogin extends OpentapsWrappers {

	@BeforeClass
	
	public void startTestCase(){
	//	browserName 	= "chrome"; - this should be commented for cross browser testing refer crossteting.xml
		browserName 	= "chrome";
	//browserName 	= "internet explorer";
		//dataSheetName 	= "TC002_InsLogin";
	//	port = "5555";
		testCaseName 	= "TC01- 28112017 chrome (parallel)";
		testDescription = "Login to Insurance Automobile using POM framework";
		dataSheetName   = "TC0021_InsLogin";
		sheetNumber     = 0;
		startrownum     = 2;
		endrow          = 2;
		rowcountarraysize=1;  // how many iteration
		colcountarraysize=15;
		 
			
	}

		
	@Test(dataProvider="fetchData" , groups="Regression" )
//	@Test(dataProvider="fetchData" , dependsOnGroups = { "step" } )

	public void loginForSuccess(String email , String password, String vuserName,String quote, String zip , String quoteemail, String automobiletype ,String age,
			String gender, String drivingrecord, String year, String vehmake, String vehmodel, String vehFin,String price1) throws FileNotFoundException {
		//if(dataRow.equals("TC02")){
		
	//	browserName 	= "chrome";

		new InsLogin()
		
		//.isTextEnabled()
		.enterEmail(email)
		.enterPwd(password)
	//	.clickLogin()
		.verifyLoggedinUserName1(vuserName)
		.autoQuote(quote)
		.enterZip(zip)
		.enterquoteEmail(quoteemail)
		//.instype()
		.selectAuto(automobiletype)
		.insnext()
		.enterAge(age)
		.enterGender1(gender)
		.enterDriving1(drivingrecord)
		.insquotenext()
		.vehYear(year)
		.vehmake()
		.vehmake1(vehmake)
	//	.vehmakeSelect()
		.vehmodel()
		.vehmodelSelect1(vehmodel)
		.getAuto()
		.vehFin1(vehFin)
		.insquotenext1()
		.instantquote()
		
		.verifyusdprice(price1);
		
	
	}
	
	
}
