package pageObjects1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends BasePage1 {
	
	public loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	
@FindBy(xpath="//input[@name='email']") 
WebElement emailID;

@FindBy(xpath="//input[@name='password']") 
WebElement password1;

@FindBy(xpath="//input[@type='submit']") 
WebElement login;



public void emailvalues(String email)
{
	emailID.sendKeys(email);
}

public void passwordvalues(String password)
{
	password1.sendKeys(password);
}

public void loginbutton()
{
	login.click();
}

}
