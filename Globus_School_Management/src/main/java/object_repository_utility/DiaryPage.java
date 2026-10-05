package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class DiaryPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public DiaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='+ Add Entry']")
	private WebElement addEntryBtn;
	
	@FindBy(xpath = "//label[text()='Class (optional)']/following-sibling::select")
	private WebElement selClsDrpdwn;
	
	@FindBy(xpath = "//label[text()='Subject (optional)']/following-sibling::input")
	private WebElement subj;
	
	@FindBy(xpath = "//label[text()='Content']/following-sibling::textarea")
	private WebElement txtArea;
	
	@FindBy(xpath = "//button[text()='Save Entry']")
	private WebElement submit;
	
	@FindBy(xpath = "//label[text()='Class']/following-sibling::select")
	private WebElement ClsDrpdwnOut;
	
	@FindBy(xpath = "//div[contains(@class,'p-12 text-center')]")
	private WebElement verify;

	public WebElement getAddEntryBtn() {
		return addEntryBtn;
	}

	public WebElement getSelClsDrpdwn() {
		return selClsDrpdwn;
	}

	public WebElement getSubj() {
		return subj;
	}

	public WebElement getTxtArea() {
		return txtArea;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getClsDrpdwnOut() {
		return ClsDrpdwnOut;
	}

	public WebElement getVerify() {
		return verify;
	}
	
	public void addNewDiaryEntry(String sub,String txt,String txtAr)
	{
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(addEntryBtn).click();
		webutil.waitForVisibility(subj).sendKeys(sub);
		webutil.waitForVisibility(selClsDrpdwn);
		webutil.selectByVisibleText(selClsDrpdwn, txt);
		webutil.waitForVisibility(txtArea).sendKeys(txtAr);
		webutil.waitForVisibility(submit).click();
	}
	
}
