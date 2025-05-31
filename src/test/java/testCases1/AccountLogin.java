package testCases1;

import org.testng.annotations.Test;

import pageObjects1.HomePage1;
import pageObjects1.loginpage;

public class AccountLogin extends BaseClass1 {
	
@Test (groups= {"Master","Regression"})
	public void account_login()
	{
		  logger.debug("Started with Homepage validation");

	        HomePage1 hp = new HomePage1(driver);
	        hp.clickMyAccount();
	        hp.clickLogin();
	        logger.debug("Clicked on My Account");
	        
	        loginpage l=new loginpage(driver);
	        l.emailvalues(p.getProperty("email"));
	        l.passwordvalues(p.getProperty("password"));
	        l.loginbutton();

	        
	}
}
