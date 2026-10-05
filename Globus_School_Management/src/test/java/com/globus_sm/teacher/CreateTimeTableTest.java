package com.globus_sm.teacher;

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
import object_repository_utility.TimetablePage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class CreateTimeTableTest extends BaseClass
{
	@Test(groups = "integration")
	public void createTimeTableTest() throws EncryptedDocumentException, IOException
	{
		
		/*
		 * in dashboard page click timetable,there select class,sec, click daily
		 * calender set particular date,click generate until mathematics comes to p1
		 */
	ExcelUtility ex = new ExcelUtility();
	WebDriverUtility util = new WebDriverUtility(driver);
	String cls = ex.readDataFromExcel("Sheet1", 14, 0);
	String sec = ex.readDataFromExcel("Sheet1", 14, 1);
	String subj= ex.readDataFromExcel("Sheet1", 14, 2);
	DashboardPage dp = new DashboardPage(driver);
	util.waitForVisibility(dp.getTimetable()).click();
	TimetablePage tp = new TimetablePage(driver);
	tp.setTimetable(cls, sec, subj);
	String actual = util.waitForVisibility(tp.getSubj()).getText();
	Assert.assertEquals(actual, subj);
	UtilityClassObj.getTest().log(Status.INFO, "Subject added in timetable successfully!!!");
	}
}
