package com.globus_sm.teacher;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_baseClass.BaseClass;
import generic_fileUtility.ExcelUtility;
import generic_webdriverUtility.JavaUtility;
import generic_webdriverUtility.WebDriverUtility;
import object_repository_utility.AssignmentsPage;
import object_repository_utility.DashboardPage;
import object_repository_utility.DiaryPage;
import object_repository_utility.IDCardPage;
import object_repository_utility.StaffDircetoryPage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class TeacherSystemTest extends BaseClass {
	@Test(groups = "system")
	public void teacherSystemTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ExcelUtility ex = new ExcelUtility();
		WebDriverUtility util = new WebDriverUtility(driver);
		JavaUtility ju = new JavaUtility();
		int data = ju.generateRandomNumber();

		/* add a new staff in staff directory with validation */
		DashboardPage dp = new DashboardPage(driver);

		util.waitForVisibility(dp.getStfDir()).click();
		StaffDircetoryPage sp = new StaffDircetoryPage(driver);
		String uid = ex.readDataFromExcel("Sheet1", 26, 0) + data;
		String eid = ex.readDataFromExcel("Sheet1", 26, 1) + data;
		String des = ex.readDataFromExcel("Sheet1", 26, 2);
		String doj = ex.readDataFromExcel("Sheet1", 26, 3);
		sp.addStaff(uid, eid, des, doj);

		/*
		 * To generate an id card for the newly added staff with the same uid with
		 * validation
		 */

		util.waitForVisibility(dp.getIdCard()).click();
		IDCardPage ip = new IDCardPage(driver);
		String userId = ex.readDataFromExcel("Sheet1", 31, 0);
		String txt = ex.readDataFromExcel("Sheet1", 26, 4);
		ip.genIdCard(userId, txt);

		/* Added teacher going to create a new assignment with validation */
		util.waitForVisibility(dp.getAssignments()).click();
		AssignmentsPage ap = new AssignmentsPage(driver);
		String tit = ex.readDataFromExcel("Sheet1", 28, 0);
		String mark = ex.readDataFromExcel("Sheet1", 28, 1);
		String subj = ex.readDataFromExcel("Sheet1", 28, 2);
		String clsid = ex.readDataFromExcel("Sheet1", 28, 3);
		String date = ex.readDataFromExcel("Sheet1", 28, 4);
		String sessid = ex.readDataFromExcel("Sheet1", 28, 5);
		ap.createAssignment(tit, mark, subj, clsid, date, sessid);

		/* To add a diary to the particular class with validation */
		util.waitForVisibility(dp.getDiary()).click();
		DiaryPage dap = new DiaryPage(driver);
		String act = util.waitForVisibility(dap.getVerify()).getText();
		String sub = ex.readDataFromExcel("Sheet1", 29, 0);
		String cls = ex.readDataFromExcel("Sheet1", 29, 1);
		String txtArea = ex.readDataFromExcel("Sheet1", 29, 2);
		dap.addNewDiaryEntry(sub, cls, txtArea);
		Thread.sleep(4000);
		String exx = util.waitForVisibility(dap.getVerify()).getText();
		Assert.assertNotEquals(act, exx);
	}
}
