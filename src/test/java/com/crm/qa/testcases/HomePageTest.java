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

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil utils;
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		Initialization();
		Thread.sleep(3000);
		loginPage=new LoginPage();	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		utils=new TestUtil();
	}
	
/*	@Test (priority=1)
	public void verifyHomePageTitleTest()
	{
		String pageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(pageTitle,"CRMPRO","HomePage Title didn't match");
		
	}
	
	@Test (priority=2)
	public void verifyUserNameTest()
	{
		utils.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyUserName(),"Username is not Matching");
	}
	*/
	@Test (priority=3)
	public void verifyContactsPageLinkTest()
	{
		utils.switchToFrame("mainpanel");
		contactsPage=homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
