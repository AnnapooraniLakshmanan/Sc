package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class AdmissionPage {
	
	WebDriver driver;
	WebDriverUtility webutil;

	public AdmissionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='New Enquiry']")
	private WebElement newEnqBtn;
	
	@FindBy(xpath = "//label[text()='Student Name *']/following-sibling::input")
	private WebElement stuName;

	@FindBy(xpath = "//label[text()='Parent / Guardian Name *']/following-sibling::input")
	private WebElement parentName;

	
	@FindBy(xpath = "//label[text()='Parent Phone *']/following-sibling::input")
	private WebElement parentPhno;

	
	@FindBy(xpath = "//label[text()='Class Applied For *']/following-sibling::input")
	private WebElement cls;
	
	@FindBy(xpath = "//button[text()='Submit Enquiry']")
	private WebElement subEnqBtn;
	
	@FindBy(xpath = "//label[text()='First Name *']/following-sibling::input")
	private WebElement fn;

	
	@FindBy(xpath = "//label[text()='Last Name *']/following-sibling::input")
	private WebElement ln;
	
	@FindBy(xpath = "//label[text()='Date of Birth *']/following-sibling::input")
	private WebElement dob;
	
	@FindBy(xpath = "//label[text()='Gender *']/following-sibling::select")
	private WebElement gender;
	
	@FindBy(xpath = "//button[text()='Cancel']/following-sibling::button[text()='Create Application']")
	private WebElement createAppBtn;
	
	@FindBy(xpath = "//button[text()='Applications']")
	private WebElement appBtn;
	
	@FindBy(xpath = "//button[text()='ENROLLED']")
	private WebElement enrollBtn;
	
	@FindBy(xpath = "//button[text()='Enrolled']")
	private WebElement enrollPgBtn;
	
	@FindBy(xpath = "(//table/tbody/tr/td[2])[1]")
	private WebElement createdStuNm;

	public WebElement getNewEnqBtn() {
		return newEnqBtn;
	}

	public WebElement getStuName() {
		return stuName;
	}

	public WebElement getParentName() {
		return parentName;
	}

	public WebElement getParentPhno() {
		return parentPhno;
	}

	public WebElement getCls() {
		return cls;
	}

	public WebElement getSubEnqBtn() {
		return subEnqBtn;
	}

	public WebElement getFn() {
		return fn;
	}

	public WebElement getLn() {
		return ln;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getCreateAppBtn() {
		return createAppBtn;
	}

	public WebElement getAppBtn() {
		return appBtn;
	}

	public WebElement getEnrollBtn() {
		return enrollBtn;
	}

	public WebElement getEnrollPgBtn() {
		return enrollPgBtn;
	}

	public WebElement getCreatedStuNm() {
		return createdStuNm;
	}
	
	
	

	public void addNewEnquiry(String stu,String par,String phn,String clss)
	{
	webutil = new WebDriverUtility(driver);
	webutil.waitForVisibility(newEnqBtn).click();
	webutil.waitForVisibility(stuName).sendKeys(stu);
	webutil.waitForVisibility(parentName).sendKeys(par);
	webutil.waitForVisibility(parentPhno).sendKeys(phn);
	webutil.waitForVisibility(cls).sendKeys(clss);
	webutil.waitForVisibility(subEnqBtn).click();
	}
	
	public void createApplication(String firstn,String lastn,String date,String txt)
	{
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(fn).sendKeys(firstn);
		webutil.waitForVisibility(ln).sendKeys(lastn);
		webutil.waitForVisibility(dob).sendKeys(date);
		webutil.waitForVisibility(gender);
		webutil.selectByVisibleText(gender,txt);
		webutil.waitForVisibility(createAppBtn).click();
	}
	
}
