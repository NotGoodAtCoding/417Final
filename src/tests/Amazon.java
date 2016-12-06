package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Automato;

import static org.junit.Assert.assertTrue;

public class Amazon {

    private class AmazonTestDriver extends Automato {
        protected AmazonTestDriver(){
            super("https://www.amazon.com/", "chrome");
        }
    }

    private AmazonTestDriver driver;

    @Before
    public void setup(){
        driver = new AmazonTestDriver();
        driver.milliSleep(250);
    }

    @After
    public void tearDown(){
        driver.quitDriver();
    }

    @Test
    public void testNewUserRegistrationNoUsername(){

        driver.click("id=nav-link-yourAccount");
        driver.click("id=createAccountSubmit");

        driver.sendKeys("id=continue", "test");
        driver.sendKeys("id=ap_email", "test@gmail.com");
        driver.sendKeys("id=ap_password", "testtest");
        driver.sendKeys("id=ap_password_check", "testtest");

        driver.click("id=continue");

        assertTrue(driver.exists("xpath=//div[@class = 'a-alert-content' and contains(text(), 'Enter your name')]"));
    }

    @Test
    public void testNewUserRegistrationNoEmail(){

        driver.click("id=nav-link-yourAccount");
        driver.click("id=createAccountSubmit");

        driver.sendKeys("id=ap_customer_name", "test");
        driver.sendKeys("id=ap_password", "testtest");
        driver.sendKeys("id=ap_password_check", "testtest");

        driver.click("id=continue");

        assertTrue(driver.exists("xpath=//div[@id='auth-email-missing-alert']/div/div"));
    }

    @Test
    public void testNewUserRegistrationMisMatchedPasswords(){

        driver.click("id=nav-link-yourAccount");
        driver.click("id=createAccountSubmit");

        driver.sendKeys("id=ap_customer_name", "test");
        driver.sendKeys("id=ap_email", "test@gmail.com");
        driver.sendKeys("id=ap_password", "kajshdkja");
        driver.sendKeys("id=ap_password_check", "testtest");

        driver.click("id=continue");

        assertTrue(driver.exists("xpath=//div[@id='auth-password-mismatch-alert']/div/div"));
    }

    @Test
    public void testNewUserRegistrationShortPassword(){

        driver.click("id=nav-link-yourAccount");
        driver.click("id=createAccountSubmit");

        driver.sendKeys("id=ap_customer_name", "test");
        driver.sendKeys("id=ap_email", "test@gmail.com");
        driver.sendKeys("id=ap_password", "test");
        driver.sendKeys("id=ap_password_check", "test");

        driver.click("id=continue");

        assertTrue(driver.exists("xpath=//div[@id='auth-password-invalid-password-alert']/div/div"));
    }
}
