package com.globus_sm.admin;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic_baseClass.BaseClass;
import generic_fileUtility.ExcelUtility;
import generic_webdriverUtility.UtilityClassObj;
import generic_webdriverUtility.WebDriverUtility;
import object_repository_utility.CalendarPage;
import object_repository_utility.DashboardPage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class AddEventTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void addEventTest() throws EncryptedDocumentException, IOException
	{
		/*
		 * In dashboard click calendar there create a new event and validate the new
		 * event got scheduled correctly
		 */
		
		ExcelUtility ex=new ExcelUtility();
		WebDriverUtility util=new WebDriverUtility(driver);
		String  title= ex.readDataFromExcel("Sheet1",2 ,1 );
		String  startDate= ex.readDataFromExcel("Sheet1",3 ,1 );
		DashboardPage dp=new DashboardPage(driver);
		util.waitForVisibility(dp.getCalendar()).click();
		CalendarPage cp=new CalendarPage(driver);
		cp.addEvent(title, startDate);
		String actualName=util.waitForVisibility(cp.getEvntName()).getText();
		Assert.assertEquals(actualName,title);
		UtilityClassObj.getTest().log(Status.INFO,"Event got added successfully!!!");
	}
	

}
