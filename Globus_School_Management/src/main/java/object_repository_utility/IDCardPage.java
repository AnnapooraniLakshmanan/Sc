package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic_webdriverUtility.WebDriverUtility;

public class IDCardPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public IDCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Generate ID Card']")
	private WebElement genIDCardBtn;
	
	@FindBy(xpath = "//label[text()='User ID']/../div/input")
	private WebElement userId;
	
	@FindBy(xpath = "//label[text()='Card Type']/../select")
	private WebElement selDrpdwn;
	
	@FindBy(xpath = "//button[text()='Generate']")
	private WebElement genBtn;
	
	@FindBy(xpath = "//div[@class='flex gap-3 items-center']/span")
	private WebElement verify;

	public WebElement getGenIDCardBtn() {
		return genIDCardBtn;
	}

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getSelDrpdwn() {
		return selDrpdwn;
	}

	public WebElement getGenBtn() {
		return genBtn;
	}

	public WebElement getVerify() {
		return verify;
	}
	
	public void genIdCard(String uid,String txt) throws InterruptedException
	{
		webutil = new WebDriverUtility(driver);
		Thread.sleep(4000);
		String bfrcards = webutil.waitForVisibility(verify).getText();
		Reporter.log("No of ID before creating a new ID "+bfrcards,true);
		webutil.waitForVisibility(genIDCardBtn).click();
		webutil.waitForVisibility(userId).sendKeys(uid);
		webutil.waitForVisibility(selDrpdwn);
		webutil.selectByVisibleText(selDrpdwn, txt);
		webutil.waitForVisibility(genBtn).click();
		Thread.sleep(4000);
		String aftrcards = webutil.waitForVisibility(verify).getText();
		Reporter.log("No of ID after creating a new ID "+aftrcards,true);
	}
}
