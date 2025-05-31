package testCases1;

import org.testng.annotations.Test;

import pageObjects1.HomePage1;
import pageObjects1.loginpage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass1{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
	//	try {
	
		//Home page
			HomePage1 hp=new HomePage1(driver);
			hp.clickMyAccount();
			hp.clickLogin(); //Login link under MyAccount
				
			//Login page
			loginpage lp=new loginpage(driver);
			lp.emailvalues(email);
			lp.passwordvalues(password);
			lp.loginbutton(); //Login button 
	
	}}
