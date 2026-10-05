package com.globus_sm.student;

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
import object_repository_utility.DashboardPage;
import object_repository_utility.StudentPage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class SearchStudentTest extends BaseClass{

@Test(groups = "smoke")
public void searchStudentTest() throws EncryptedDocumentException, IOException
{
	/*
	 * Search a particular student name in the search bar present in the
	 * dashboard page and click the returned value u shld navigate to that
	 * particular student page
	 */	
	ExcelUtility ex=new ExcelUtility();
	WebDriverUtility util=new WebDriverUtility(driver);
	String value = ex.readDataFromExcel("Sheet1", 0, 1);
	DashboardPage dp=new DashboardPage(driver);
	dp.searchValue(value);
	StudentPage sp=new StudentPage(driver);
	String actual=util.waitForVisibility(sp.getStuName()).getText();
	Assert.assertTrue(actual.contains(value));
	UtilityClassObj.getTest().log(Status.INFO,"Relavant student info got displayed!!!");
}

}
