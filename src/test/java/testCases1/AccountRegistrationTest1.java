package testCases1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects1.AccountRegistrationPage1;
import pageObjects1.HomePage1;

public class AccountRegistrationTest1 extends BaseClass1 {

    @Test(groups= {"Sanity","Regression"})
    public void verify_account_registration() {
        logger.debug("Started with Homepage validation");

        HomePage1 hp = new HomePage1(driver);
        hp.clickMyAccount();
        logger.debug("Clicked on My Account");

        hp.clickRegister();
        logger.debug("Clicked on Register");

        AccountRegistrationPage1 regPage = new AccountRegistrationPage1(driver);
        logger.debug("Started with registration page validation");

        regPage.setFirstName(randomeString());
        regPage.setLastName(randomeString());
        regPage.setEmail(randomAlphaNumeric() + "@gmail.com");
        regPage.setTelephone("9876543210");
        regPage.setPassword("Test@1234");
        regPage.setConfirmPassword("Test@1234");
        regPage.setPrivacyPolicy();
        regPage.clickContinue();

        logger.debug("Completed entering registration details");

        // Assertion - verify registration success
       // String confirmationMsg = regPage.getConfirmationMsg();
       // Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!", "Registration failed or confirmation message did not match.");

        logger.debug("Account registration test completed successfully");
    }
}
