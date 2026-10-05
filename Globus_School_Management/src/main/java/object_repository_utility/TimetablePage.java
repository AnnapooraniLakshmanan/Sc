package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class TimetablePage {
	WebDriver driver;
	WebDriverUtility webutil;

	public TimetablePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='1. Select Class']")
	private WebElement selectClsBtn;

	@FindBy(xpath = "//label[text()='Class']/following-sibling::select")
	private WebElement clsDrpDwn;

	@FindBy(xpath = "//label[text()='Section']/following-sibling::select")
	private WebElement secDrpDwn;

	@FindBy(xpath = "//button[text()='Daily Calendar']")
	private WebElement dailyCal;

	@FindBy(xpath = "//button[text()='14']")
	private WebElement date;
	
	@FindBy(xpath = "//button[text()='7']")
	private WebElement delDate;

	@FindBy(xpath = "//p[contains(normalize-space(.),'P1')]/../following-sibling::div/p")
	private WebElement subj;

	@FindBy(xpath = "//button[text()='Regenerate']")
	private WebElement regenBtn;
	
	@FindBy(xpath = "//button[text()=' Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//button[text()='Next: Assign Teachers ']")
	private WebElement assignTeachBtn;
	
	@FindBy(xpath = "//button[text()='Skip ']")
	private WebElement skipBtn;
	
	@FindBy(xpath = "//button[text()=' Auto-Generate Timetable']")
	private WebElement autoGenBtn;
	
	
	public WebElement getSelectClsBtn() {
		return selectClsBtn;
	}

	public WebElement getClaDrpDwn() {
		return clsDrpDwn;
	}

	public WebElement getSelectDrpDwn() {
		return secDrpDwn;
	}

	public WebElement getDailyCal() {
		return dailyCal;
	}

	public WebElement getDate() {
		return date;
	}
	
	public WebElement getDelDate() {
		return delDate;
	}

	public WebElement getSubj() {
		return subj;
	}

	public WebElement getRegenBtn() {
		return regenBtn;
	}
	

	public WebElement getClsDrpDwn() {
		return clsDrpDwn;
	}

	public WebElement getSecDrpDwn() {
		return secDrpDwn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getAssignTeachBtn() {
		return assignTeachBtn;
	}

	public WebElement getSkipBtn() {
		return skipBtn;
	}

	public WebElement getAutoGenBtn() {
		return autoGenBtn;
	}

	public void setTimetable(String value,String secval,String exsubj) {
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(selectClsBtn).click();
        webutil.selectByVisibleText(clsDrpDwn, value);
        webutil.selectByVisibleText(secDrpDwn, secval);
        webutil.waitForVisibility(dailyCal).click();
        webutil.waitForVisibility(delDate).click();
        webutil.waitForVisibility(deleteBtn).click();
        webutil.acceptAlert();
        webutil.waitForVisibility(assignTeachBtn).click();
        webutil.waitForVisibility(skipBtn).click();
        webutil.waitForVisibility(autoGenBtn).click();
        webutil.waitForVisibility(date).click();
        while(true)
        {
        	if((webutil.waitForVisibility(subj).getText()).equals(exsubj))
        		break;
        	webutil.waitForVisibility(regenBtn).click();
        }
        
	}

}
