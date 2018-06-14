package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase {
    LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	public HomePageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp()               
	{
		initialization();
		testutil= new TestUtil();
		loginpage=new LoginPage();
		contactspage= new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String title=homepage.verifyHomePageTitle();
		Assert.assertEquals(title,"CRMPRO");
	}
	@Test(priority=2)
	public void verifyUsername() {
		
		testutil.switchToFrame();

		Assert.assertTrue(homepage.validateUserName());
	}
	@Test(priority=3)
	public void clickOnContactTest()
	{
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
