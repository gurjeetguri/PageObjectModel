package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
LoginPage loginpage;
HomePage homepage;
	public LoginPageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp()               
	{
		System.out.println("Started Login page Setup");
		initialization();
		loginpage=new LoginPage();
		
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validatePageTittle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		
		Boolean logoFlag=loginpage.validatePageLogo();
		Assert.assertTrue(logoFlag);
		
	}
	
	@Test(priority=3)
	public void LoginTest() throws Exception 
	{
		//Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_2,TimeUnit.SECONDS);
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}

