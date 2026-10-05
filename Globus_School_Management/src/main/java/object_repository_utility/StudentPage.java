package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class StudentPage {

	WebDriver driver;
	WebDriverUtility util;

	public StudentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Add Student']")
	private WebElement addStudentBtn;

	@FindBy(xpath = "//input[contains(@placeholder,'Search by name')]")
	private WebElement searchStuNmBar;

	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private WebElement stuAdmNo;
	
	@FindBy(xpath = "//h1[@class='text-2xl font-bold']")
	private WebElement stuName;

	public WebElement getStuName() {
		return stuName;
	}

	public WebElement getAddStudentBtn() {
		return addStudentBtn;
	}

	public WebElement getSearchStuNmBar() {
		return searchStuNmBar;
	}

	public WebElement getStuDetailsAftrSearch() {
		return stuAdmNo;
	}
	
	public String getStuAdmisNo(String fn)
	{
		util=new WebDriverUtility(driver);
		util.waitForVisibility(searchStuNmBar).sendKeys(fn);
		String adminNo=util.waitForVisibility(stuAdmNo).getText();
		return adminNo;
	}

}
