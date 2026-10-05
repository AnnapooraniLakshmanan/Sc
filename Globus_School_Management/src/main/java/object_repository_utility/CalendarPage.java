package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class CalendarPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Add Event']")
	private WebElement addEvent;

	@FindBy(xpath = "//label[text()='Title *']/following-sibling::input")
	private WebElement titleTxt;

	@FindBy(xpath = "//button[text()='Save Event']")
	private WebElement saveBtn;

	@FindBy(xpath = "//label[text()='Start Date *']/following-sibling::input")
	private WebElement startDateTxt;

	@FindBy(xpath = "//div[@class='space-y-3']/div/div/following-sibling::p")
	private WebElement evntName;

	public WebElement getEvntName() {
		return evntName;
	}

	public WebElement getAddEvent() {
		return addEvent;
	}

	public WebElement getTitleTxt() {
		return titleTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDateTxt() {
		return startDateTxt;
	}

	public void addEvent(String title, String startdate) {
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(addEvent).click();
		webutil.waitForVisibility(titleTxt).sendKeys(title);
		webutil.waitForVisibility(startDateTxt).sendKeys(startdate);
		webutil.waitForClickable(saveBtn).click();
	}

}
