package com.globus_sm.teacher;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic_baseClass.BaseClass;
import generic_fileUtility.ExcelUtility;
import generic_webdriverUtility.JavaUtility;
import generic_webdriverUtility.UtilityClassObj;
import generic_webdriverUtility.WebDriverUtility;
import object_repository_utility.AddNewStudentPage;
import object_repository_utility.DashboardPage;
import object_repository_utility.LMSRubricPage;
import object_repository_utility.NewlyCreatedRubPage;
import object_repository_utility.StudentPage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class CreateRubricsThrLMSTest extends BaseClass {
	@Test(groups = "integration")
	public void createRubricsThrLMSTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		/* In dasboard go to lms content,create a ne rubrics and valiadate it */

		ExcelUtility ex = new ExcelUtility();
		WebDriverUtility util = new WebDriverUtility(driver);
		String title = ex.readDataFromExcel("Sheet1", 4, 1);
		String des = ex.readDataFromExcel("Sheet1", 5, 1);
		String criTitle = ex.readDataFromExcel("Sheet1", 6, 1);
		String exdes = ex.readDataFromExcel("Sheet1", 7, 1);
		String gddes = ex.readDataFromExcel("Sheet1", 8, 1);
		String needsImpDes = ex.readDataFromExcel("Sheet1", 9, 1);
		String insufDes = ex.readDataFromExcel("Sheet1", 10, 1);
		DashboardPage dp = new DashboardPage(driver);
		util.waitForVisibility(dp.getLms()).click();
		LMSRubricPage lcp = new LMSRubricPage(driver);
		lcp.createRubrics(title, des, criTitle, exdes, gddes, needsImpDes, insufDes);
		String actual = util.waitForVisibility(lcp.getCreatedRubs()).getText();
		Assert.assertEquals(actual, title);
		UtilityClassObj.getTest().log(Status.INFO, "Event got added successfully!!!");

		/* In dashboard click students and add a new student and get the student id */

		util.waitForVisibility(dp.getStudents()).click();
		AddNewStudentPage ap = new AddNewStudentPage(driver);
		JavaUtility ju = new JavaUtility();
		int data = ju.generateRandomNumber();
		String adno = ex.readDataFromExcel("Sheet1", 12, 0) + data;
		String fnn = ex.readDataFromExcel("Sheet1", 12, 1) + data;
		String ln = ex.readDataFromExcel("Sheet1", 12, 2);
		String email = ex.readDataFromExcel("Sheet1", 12, 3);
		String dob = ex.readDataFromExcel("Sheet1", 12, 4);
		String gender = ex.readDataFromExcel("Sheet1", 12, 5);
		String cls = ex.readDataFromExcel("Sheet1", 12, 6);
		String sec = ex.readDataFromExcel("Sheet1", 12, 7);
		ap.addNewStudent(adno, fnn, ln, email, dob, gender, cls, sec);

		// search the stu name and get the admission number

		StudentPage sp = new StudentPage(driver);
		Thread.sleep(4000);
		String fn = ex.readDataFromExcel("Sheet1", 12, 1);
		String adminNo = sp.getStuAdmisNo(fn);

	    //go to lms,click rubrics,select the newly created rubrics
		
		util.waitForVisibility(dp.getLms()).click();
		util.waitForVisibility(lcp.getRubrics()).click();
		util.waitForVisibility(lcp.getCreatedRubs()).click();
		
		//Assess stud with id and valiadte
		
		NewlyCreatedRubPage np=new NewlyCreatedRubPage(driver);
		np.assessStudent(adminNo);
		String act = util.waitForVisibility(np.getValidation()).getText();
		Assert.assertTrue(act.contains(adminNo));
		UtilityClassObj.getTest().log(Status.INFO, "Event got added successfully!!!");
		

	}
}
