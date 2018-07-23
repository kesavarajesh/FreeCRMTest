package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil utils;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		Initialization();
		Thread.sleep(3000);
		utils=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage();	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		utils.switchToFrame("mainpanel");
		contactsPage=homePage.clickOnContactsLink();
		
		
	}
	
	@Test
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label not found");
	}
	
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException
	{
		//Thread.sleep(3000);
		contactsPage.selectContacts("Ankit Rajpot");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
