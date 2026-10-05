package com.globus_sm.student;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_baseClass.BaseClass;
import generic_fileUtility.ExcelUtility;
import generic_webdriverUtility.JavaUtility;
import generic_webdriverUtility.WebDriverUtility;
import object_repository_utility.AddNewStudentPage;
import object_repository_utility.AdmissionPage;
import object_repository_utility.ClassesPage;
import object_repository_utility.DashboardPage;
import object_repository_utility.HostelPage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class StudentSystemTest extends BaseClass{
	
	@Test(groups = "system")
	public void studentSystemTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		/* in dashboard click admission add new enquiry */
		
		ExcelUtility ex=new ExcelUtility();
		WebDriverUtility util=new WebDriverUtility(driver);
		String  stu= ex.readDataFromExcel("Sheet1",18 ,0 );
		String  par= ex.readDataFromExcel("Sheet1",18 ,1 );
		String  phno= ex.readDataFromExcel("Sheet1",18 ,2 );
		String  cls= ex.readDataFromExcel("Sheet1", 18,3 );
		DashboardPage dp=new DashboardPage(driver);
		util.waitForVisibility(dp.getAdmis()).click();
		AdmissionPage ap=new AdmissionPage(driver);
		ap.addNewEnquiry(stu,par,phno,cls);
		
		/*cnvrt the enquiry to application by createApp*/
		Thread.sleep(4000);
		util.waitForVisibility(driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+stu+"']/following-sibling::td[.='Create Application']"))).click();
		String  fn= ex.readDataFromExcel("Sheet1",20 ,0 );
		String  ln= ex.readDataFromExcel("Sheet1",20 ,1 );
		String  dob= ex.readDataFromExcel("Sheet1",20 ,2 );
		String  gen= ex.readDataFromExcel("Sheet1", 20,3 );
		ap.createApplication(fn,ln,dob,gen);
		
		/*convert application to enroll*/
		
		util.waitForVisibility(ap.getAppBtn()).click();
		Thread.sleep(4000);
		util.waitForVisibility(driver.findElement(By.xpath("//table[@class='w-full text-sm']/tbody/tr/td[.='"+stu+" "+ln+"']/following-sibling::td/descendant::button[text()='Process']"))).click();
		util.waitForVisibility(ap.getEnrollBtn()).click();
		util.waitForVisibility(ap.getEnrollPgBtn()).click();
		String act = util.waitForVisibility(ap.getCreatedStuNm()).getText();
		String exx=stu+" "+ln;
		Assert.assertEquals(act, exx);
		
		/* To validate in class and section before adding a stu count in sec*/
		util.waitForVisibility(dp.getClasses()).click();
		ClassesPage cp=new ClassesPage(driver);
		Thread.sleep(4000);
		String actCount = cp.clsCheck();
		Reporter.log("Sec count bfr creating a stu "+actCount,true);
		
		/*Create a student in student page for the same enrolled stu*/
		util.waitForVisibility(dp.getStudents()).click();
		AddNewStudentPage asp = new AddNewStudentPage(driver);
		JavaUtility ju=new JavaUtility();
		int data=ju.generateRandomNumber();
		String  admno= ex.readDataFromExcel("Sheet1",22 ,0 )+data;
		String  email= ex.readDataFromExcel("Sheet1",22 ,1 );
		String  sec= ex.readDataFromExcel("Sheet1",22 ,2 );
		asp.addNewStudent(admno, fn, ln, email, dob, gen, cls, sec);
		
		/* To validate in class and section after stu creation*/
		Thread.sleep(4000);
		util.waitForVisibility(dp.getClasses()).click();
		String exCount = cp.clsCheck();
		Reporter.log("Sec count aftr creating a stu "+exCount,true);
		
		/* to allocate hostel room to the same student */
		util.waitForVisibility(dp.getHostel()).click();
		HostelPage hp = new HostelPage(driver);
		
		/* before allocating room */
		Thread.sleep(4000);
		String avlRoom = util.waitForVisibility(hp.getVerifi()).getText();
		Reporter.log("Room count bfr alloacting a stu "+avlRoom,true);
		String  room= ex.readDataFromExcel("Sheet1",23 , 0);
		
		hp.allocateHostel(admno,room);
		
		/* after allocating room */
		Thread.sleep(4000);
		String aftrRoom = util.waitForVisibility(hp.getVerifi()).getText();
		Reporter.log("Room count aftr alloacting a stu "+aftrRoom,true);
	}

}
