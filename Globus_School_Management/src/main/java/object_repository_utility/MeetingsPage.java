package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class MeetingsPage {
	
	WebDriver driver;
	WebDriverUtility webutil;

	public MeetingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='New Meeting']")
	private WebElement newMeetingBtn;
	
	@FindBy(xpath = "//label[text()='Title *']/following-sibling::input")
	private WebElement meetTitle;
	
	@FindBy(xpath = "//label[text()='Meeting Date *']/following-sibling::input")
	private WebElement meetDate;
	
	@FindBy(xpath = "//button[text()='Create Meeting Minutes']")
	private WebElement submit;
	
	@FindBy(xpath = "//button[text()='New Meeting']/preceding-sibling::button")
	private WebElement verify;

	public WebElement getNewMeetingBtn() {
		return newMeetingBtn;
	}

	public WebElement getMeetTitle() {
		return meetTitle;
	}

	public WebElement getMeetDate() {
		return meetDate;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getVerify() {
		return verify;
	}
	
	public void newMeeting(String tit,String date)
	{
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(newMeetingBtn).click();
		webutil.waitForVisibility(meetTitle).sendKeys(tit);
		webutil.waitForVisibility(meetDate).sendKeys(date);
		webutil.waitForVisibility(submit).click();
	}

}
