package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class AddNewStudentPage {
	WebDriver driver;
	public AddNewStudentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='admissionNo']")
	private WebElement admissionNoTxt;
	
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstNameTxt;
	
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//input[@name='dateOfBirth']")
	private WebElement dateOfBirthTxt;
	
	@FindBy(xpath = "//select[@name='gender']")
	private WebElement genderDrpdwn;
	
	@FindBy(xpath = "//label[text()='Class *']/following-sibling::select")
	private WebElement classIdDrpdwn;
	
	@FindBy(xpath = "//select[@name='sectionId']")
	private WebElement sectionDrpdwn;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement CancelBtn;
	
	@FindBy(xpath = "//button[text()='Add Student']")
	private WebElement addStudentBtn;
	
	public WebElement getDateOfBirthTxt() {
		return dateOfBirthTxt;
	}

	
    public WebElement getAdmissionNoTxt() {
		return admissionNoTxt;
	}

	public WebElement getFirstNameTxt() {
		return firstNameTxt;
	}

	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getGenderDrpdwn() {
		return genderDrpdwn;
	}

	public WebElement getClassIdDrpdwn() {
		return classIdDrpdwn;
	}

	public WebElement getSectionDrpdwn() {
		return sectionDrpdwn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getAddStudentBtn() {
		return addStudentBtn;
	}
	
	public void addNewStudent(String adno,String fn,String ln,String email,String dob,String gender,String cls,String section) throws InterruptedException
	{
		StudentPage sp=new StudentPage(driver);
		WebDriverUtility util=new WebDriverUtility(driver);
		util.waitForClickable(sp.getAddStudentBtn()).click();
		util.waitForVisibility(admissionNoTxt).sendKeys(adno);
		util.waitForVisibility(firstNameTxt).sendKeys(fn);
		util.waitForVisibility(lastNameTxt).sendKeys(ln);
		util.waitForVisibility(emailTxt).sendKeys(email);
		util.waitForVisibility(dateOfBirthTxt).sendKeys(dob);
		util.waitForVisibility(genderDrpdwn);
		util.selectByVisibleText(genderDrpdwn, gender);
		util.waitForVisibility(classIdDrpdwn);
		util.selectByVisibleText(classIdDrpdwn,cls);
		util.waitForVisibility(sectionDrpdwn);
		Thread.sleep(4000);
		util.selectByVisibleText(sectionDrpdwn,section);
		util.waitForClickable(addStudentBtn).click();
	}

}
