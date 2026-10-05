package object_repository_utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic_webdriverUtility.WebDriverUtility;

public class AssignmentsPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public AssignmentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Create Assignment']")
	private WebElement crtAssBtn;

	@FindBy(xpath = "//label[text()='Title ']/following-sibling::input")
	private WebElement title;

	@FindBy(xpath = "//label[text()='Total Marks ']/following-sibling::input")
	private WebElement totalMarks;

	@FindBy(xpath = "//label[text()='Subject ID ']/following-sibling::input")
	private WebElement subjId;

	@FindBy(xpath = "//label[text()='Class ID ']/following-sibling::input")
	private WebElement clsId;

	@FindBy(xpath = "//label[text()='Due Date ']/following-sibling::input")
	private WebElement dueDate;

	@FindBy(xpath = "//label[text()='Academic Session ID ']/following-sibling::input")
	private WebElement sessonId;

	@FindBy(xpath = "//button[text()='Cancel']/following-sibling::button")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[text()='Total Assignments']/preceding-sibling::div")
	private WebElement verify;

	public WebElement getsessonId() {
		return sessonId;
	}

	public WebElement getCrtAssBtn() {
		return crtAssBtn;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getTotalMarks() {
		return totalMarks;
	}

	public WebElement getSubjId() {
		return subjId;
	}

	public WebElement getClsId() {
		return clsId;
	}

	public WebElement getDueDate() {
		return dueDate;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getVerify() {
		return verify;
	}

	public void createAssignment(String tit, String mark, String subj, String clssid, String date, String sessid)
			throws InterruptedException {
		webutil = new WebDriverUtility(driver);
		Thread.sleep(4000);
		String bfrass = webutil.waitForVisibility(verify).getText();
		Reporter.log("No of assignments before creating a new assignment" + bfrass, true);
		webutil.waitForVisibility(crtAssBtn).click();
		webutil.waitForVisibility(title).sendKeys(tit);
		webutil.waitForVisibility(totalMarks).sendKeys(mark);
		webutil.waitForVisibility(subjId).sendKeys(subj);
		Actions a = new Actions(driver);
		Thread.sleep(4000);
		webutil.waitForVisibility(clsId);
		a.moveToElement(clsId).perform();
		a.click(clsId);
		a.sendKeys(clssid, Keys.TAB, Keys.TAB, "05-10-2026 16:05");

		webutil.waitForVisibility(sessonId).sendKeys(sessid);
		webutil.waitForVisibility(submitBtn).click();
		Thread.sleep(4000);
		String aftrass = webutil.waitForVisibility(verify).getText();
		Reporter.log("No of assignments after creating a new assignment" + aftrass, true);

	}
}
