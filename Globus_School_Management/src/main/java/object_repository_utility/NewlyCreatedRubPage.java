package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class NewlyCreatedRubPage {

	WebDriver driver;
	WebDriverUtility webutil;

	public NewlyCreatedRubPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Assess Student']")
	private WebElement assessStuBtn;
	
	@FindBy(xpath = "//label[text()='Student ID *']/following-sibling::input")
	private WebElement stuId;
	
	@FindBy(xpath = "//div[text()='Excellent']")
	private WebElement excel;
	
	@FindBy(xpath = "//button[text()='Submit Assessment']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//span[contains(.,'MIS-')]")
	private WebElement validation;

	public WebElement getAssessStuBtn() {
		return assessStuBtn;
	}

	public WebElement getStuId() {
		return stuId;
	}

	public WebElement getExcel() {
		return excel;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getValidation() {
		return validation;
	}
	
	public void assessStudent(String admnNo)
	{
		webutil=new WebDriverUtility(driver);
		webutil.waitForVisibility(assessStuBtn).click();
		webutil.waitForVisibility(stuId).sendKeys(admnNo);
		webutil.waitForVisibility(excel).click();
		webutil.waitForClickable(submitBtn).click();
	}
}
