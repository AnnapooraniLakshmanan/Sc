package com.globus_sm.admin;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic_baseClass.BaseClass;
import generic_webdriverUtility.UtilityClassObj;
import generic_webdriverUtility.WebDriverUtility;
import object_repository_utility.BulkOperationsPage;
import object_repository_utility.DashboardPage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class BulkOperationsTest extends BaseClass
{
	@Test(groups = "smoke")
public void bulkOperationsTest() throws EncryptedDocumentException, IOException, InterruptedException
{
	/*
	 * In dashboard click bulk operations there paste the json txt into the paste
	 * text box and import it and validate those records imported completely
	 */ 
		
		WebDriverUtility util=new WebDriverUtility(driver);
		DashboardPage dp=new DashboardPage(driver);
		Thread.sleep(4000);
		util.waitForVisibility(dp.getBulk()).click();
		BulkOperationsPage bp=new BulkOperationsPage(driver);
		bp.importRecordsInBulkOp();
		String actual=util.waitForVisibility(bp.getImportComplt()).getText();
		Assert.assertEquals(actual,"Import Complete");
		UtilityClassObj.getTest().log(Status.INFO,"Bulk data got imported successfully!!!");
}
}
