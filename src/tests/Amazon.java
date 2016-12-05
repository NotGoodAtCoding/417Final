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
    }

    @After
    public void tearDown(){
        driver.quitDriver();
    }

    @Test
    public void testNewUserRegistration(){

        driver.click("id=nav-link-yourAccount");
        driver.click("id=createAccountSubmit");

        driver.sendKeys("id=ap_email", "test@gmail.com");
        driver.sendKeys("id=ap_password", "testtest");
        driver.sendKeys("id=ap_password_check", "testtest");

        driver.click("id=continue");

        assertTrue(driver.exists("xpath=//div[@class = 'a-alert-content' and contains(text(), 'Enter your name')]"));
    }
}
