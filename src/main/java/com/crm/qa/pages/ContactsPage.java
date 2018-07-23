package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsTableText;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//a[contains(text(), 'Ankit Rajpot')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']
	
	public boolean verifyContactsLabel()
	{
		return contactsTableText.isDisplayed();
	}
	
	public void selectContacts(String contactName)
	{
		driver.findElement(By.xpath("//a[contains(text(), '" + contactName +"')]//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
}
