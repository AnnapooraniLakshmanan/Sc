package com.globus_sm.student;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic_baseClass.BaseClass;
import generic_fileUtility.ExcelUtility;
import generic_webdriverUtility.JavaUtility;
import generic_webdriverUtility.UtilityClassObj;
import generic_webdriverUtility.WebDriverUtility;
import object_repository_utility.DashboardPage;
import object_repository_utility.LibraryPage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class LibraryManagementTest extends BaseClass{
	
	@Test(groups = "integration")
	public void libraryManagementTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		/* in dashboard click library,add a new book and validate it */
		
		ExcelUtility ex=new ExcelUtility();
		WebDriverUtility util=new WebDriverUtility(driver);
		JavaUtility ju=new JavaUtility();
		int data=ju.generateRandomNumber();
		String title = ex.readDataFromExcel("Sheet1", 16, 0)+data;
		String auth = ex.readDataFromExcel("Sheet1", 16, 1);
		String isbn = ex.readDataFromExcel("Sheet1", 16, 2);
		DashboardPage dp=new DashboardPage(driver);
		util.waitForVisibility(dp.getlibrary()).click();
		LibraryPage lp=new LibraryPage(driver);
		lp.libraryAddAndReturnBook(title, auth, isbn);
		
		
		String actual=util.waitForVisibility(lp.getBookName()).getText();
		Reporter.log("actual is "+actual,true);
		Reporter.log("title is "+title,true);
		Assert.assertNotEquals(actual,title);
		UtilityClassObj.getTest().log(Status.INFO, "Booked got added successfully!!!");
		
		/* to return a overdued book and validate it */
		
		 lp.overDue(); 
		 UtilityClassObj.getTest().log(Status.INFO,"Booked got returned successfully!!!");
		 
		
	}

}
