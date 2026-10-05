package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class HostelPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public HostelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[.=' Allocate Student']")
	private WebElement allctStu;
	
	@FindBy(xpath = "//label[text()='Student ID *']/following-sibling::input")
	private WebElement stuID;
	
	@FindBy(xpath = "//label[text()='Room *']/following-sibling::select")
	private WebElement selcRmDrpdwn;
	
	@FindBy(xpath = "//button[text()='Allocate']")
	private WebElement allcBtn;
	
	@FindBy(xpath = "//div[text()='125']/following-sibling::div[3]")
	private WebElement verifi;

	public WebElement getAllctStu() {
		return allctStu;
	}

	public WebElement getStuID() {
		return stuID;
	}

	public WebElement getSelcRmDrpdwn() {
		return selcRmDrpdwn;
	}

	public WebElement getAllcBtn() {
		return allcBtn;
	}

	public WebElement getVerifi() {
		return verifi;
	}
	
	public void allocateHostel(String sID,String blckVal)
	{
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(allctStu).click();
		webutil.waitForVisibility(stuID).sendKeys(sID);
		webutil.waitForVisibility(selcRmDrpdwn);
		webutil.selectByContainsVisibleText(selcRmDrpdwn, blckVal);
		//webutil.isAlertPresent();
		webutil.waitForVisibility(allcBtn).click();
	}
	
	

}
