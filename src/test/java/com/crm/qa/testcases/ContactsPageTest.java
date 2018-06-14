package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ExcelUtility;
import com.crm.qa.util.TestUtil;
import com.qa.ExtentReportListner.ExtentReportListner;

public class ContactsPageTest extends TestBase{

	 LoginPage loginpage;
		HomePage homepage;
		ContactsPage contactspage;
		TestUtil testutil;
		ExcelUtility excelReader;
		
	public ContactsPageTest()
	{
		super();
	}
	 
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutil= new TestUtil(); 
		loginpage=new LoginPage();
		contactspage= new ContactsPage();
		excelReader=new ExcelUtility("/Users/Apple/eclipse-workspace/POM/src/main/java/com/crm/qa/testdata/TestData.xlsx");
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
	Assert.assertTrue(contactspage.verifyContactsLabel(),"Contacts Lable Missing");
	}
	
	/*@Test(priority=1)
	public  void getCRMTestData() 
	{      System.out.println("Before getCellData");
		  String FirstName=excelReader.getCellData("FreeCRM", "First Name", 1);
		  System.out.println(FirstName);
		
	}
	*/
	
	/*@Test(priority=2)
	public void saveNewContact()
	{
		homepage.clickOnNewContact();
		
		contactspage.createNewContact("Mr.", "Tom", "Peter", "Google");
		
	} */
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
