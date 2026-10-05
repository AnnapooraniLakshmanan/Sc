package object_repository_utility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic_webdriverUtility.WebDriverUtility;

public class StaffDircetoryPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public StaffDircetoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='+ Add Staff Profile']")
	private WebElement addStfProf;
	
	@FindBy(xpath = "//label[text()='User ID *']/following-sibling::input")
	private WebElement userId;
	
	@FindBy(xpath = "//label[text()='Employee ID *']/following-sibling::input")
	private WebElement empId;
	
	@FindBy(xpath = "//label[text()='Designation *']/following-sibling::input")
	private WebElement desig;
	
	@FindBy(xpath = "//label[text()='Date of Joining *']/following-sibling::input")
	private WebElement dateOfJoining;
	
	@FindBy(xpath = "//button[text()='Create Profile']")
	private WebElement createProfBtn;
	
	@FindBy(xpath = "//div[contains(@class,'bg-card border')]/following::span[text()='ACADEMIC']")
	private List<WebElement> noOfTeachers ;

	public WebElement getAddStfProf() {
		return addStfProf;
	}

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getEmpId() {
		return empId;
	}

	public WebElement getDesig() {
		return desig;
	}

	public WebElement getDateOfJoining() {
		return dateOfJoining;
	}

	public WebElement getCreateProfBtn() {
		return createProfBtn;
	}

	public List<WebElement> getNoOfTeachers() {
		return noOfTeachers;
	}
	
	public void addStaff(String uid,String eid,String des,String doj) throws InterruptedException
	{
		
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibilityOfListEles(noOfTeachers);
		int bfrcunt = noOfTeachers.size();
		Reporter.log("No of Teachers before creating a new staff "+bfrcunt,true);
		webutil.waitForVisibility(addStfProf).click();
		webutil.waitForVisibility(userId).sendKeys(uid);
		webutil.waitForVisibility(empId).sendKeys(eid);
		webutil.waitForVisibility(desig).sendKeys(des);
		webutil.waitForVisibility(dateOfJoining).sendKeys(doj);
		webutil.waitForVisibility(createProfBtn).click();
		Thread.sleep(4000);
		int aftrcunt = noOfTeachers.size();
		Reporter.log("No of Teachers after creating a new staff "+aftrcunt,true);
	}
	
}
