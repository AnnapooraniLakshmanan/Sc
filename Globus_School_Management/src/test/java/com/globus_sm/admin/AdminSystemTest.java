package com.globus_sm.admin;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_baseClass.BaseClass;
import generic_fileUtility.ExcelUtility;
import generic_webdriverUtility.WebDriverUtility;
import object_repository_utility.CertificatesPage;
import object_repository_utility.DashboardPage;
import object_repository_utility.InventoryPage;
import object_repository_utility.MeetingsPage;
import object_repository_utility.PayrollPage;

@Listeners(generic_listenerUtility.ListenerImp.class)
public class AdminSystemTest extends BaseClass{
	@Test(groups = "system")
	public void studentSystemTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		/* in dashboard click meetings and add new meeting*/
		
		ExcelUtility ex=new ExcelUtility();
		WebDriverUtility util=new WebDriverUtility(driver);
		String  tit= ex.readDataFromExcel("Sheet1",33 ,0);
		String  date= ex.readDataFromExcel("Sheet1",33 ,1);
		DashboardPage dp=new DashboardPage(driver);
		util.waitForVisibility(dp.getMeetings()).click();
		MeetingsPage mp=new MeetingsPage(driver);
		String actual = util.waitForVisibility(mp.getVerify()).getText();
		mp.newMeeting(tit, date);
		Thread.sleep(4000);
		String exx = util.waitForVisibility(mp.getVerify()).getText();
		Assert.assertEquals(actual,exx);
		
		/* in dashboard click inventory and add new item and assign it*/
		util.waitForVisibility(dp.getInventory()).click();
		InventoryPage ip=new InventoryPage(driver);
		String  name= ex.readDataFromExcel("Sheet1",34,0);
		String  deptname= ex.readDataFromExcel("Sheet1",34,1);
		ip.InventoryManagement(name,deptname);
		
		/* in dashboard click certificates and add new certificate */
		util.waitForVisibility(dp.getCertificates()).click();
		CertificatesPage cp=new CertificatesPage(driver);
		String  nm= ex.readDataFromExcel("Sheet1",32,0);
		String  titt= ex.readDataFromExcel("Sheet1",32,1);
		String  clls= ex.readDataFromExcel("Sheet1",32,2);
		String  ses= ex.readDataFromExcel("Sheet1",32,3);
		cp.genCertificate(nm,titt,clls,ses);
		
		/* in dashboard click payroll and generate monthly payroll */
		util.waitForVisibility(dp.getpayroll()).click();
		PayrollPage pp=new PayrollPage(driver);
		pp.payroll();
		
		
	}
}
