package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class CertificatesPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public CertificatesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = " //button[.=' Generate Certificate']")
	private WebElement genCerBtn;
	
	@FindBy(xpath = "//label[text()='Student']/following-sibling::select")
	private WebElement stuNm;
	
	@FindBy(xpath = "//button[text()='Cancel']/preceding-sibling::button")
	private WebElement submit;
	
	@FindBy(xpath = "//button[text()='Bulk Merit Certs']")
	private WebElement bulkCerBtn;
	
	@FindBy(xpath = "//label[text()='Class']/following-sibling::select")
	private WebElement cls;
	
	@FindBy(xpath = "//label[text()='Academic Session']/following-sibling::select")
	private WebElement acSession;
	
	@FindBy(xpath = "//button[text()='Generate Merit Certs']")
	private WebElement genMeritBtn;
	
	@FindBy(xpath = "//label[text()='Title']/following-sibling::input")
	private WebElement title;
	
	public WebElement getCls() {
		return cls;
	}
	
	public WebElement getTitle() {
		return title;
	}

	public WebElement getGenCerBtn() {
		return genCerBtn;
	}

	public WebElement getStuNm() {
		return stuNm;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getBulkCerBtn() {
		return bulkCerBtn;
	}

	public WebElement getAcSession() {
		return acSession;
	}

	public WebElement getGenMeritBtn() {
		return genMeritBtn;
	}
	
	public void genCertificate(String name,String tit,String clss,String ses) throws InterruptedException
	{
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(genCerBtn).click();
		webutil.waitForVisibility(stuNm);
		Thread.sleep(4000);
		webutil.selectByContainsVisibleText(stuNm, name);
		webutil.waitForVisibility(title).sendKeys(tit);
		webutil.waitForVisibility(submit).click();
		webutil.waitForVisibility(bulkCerBtn).click();
		webutil.waitForVisibility(cls);
		webutil.selectByVisibleText(cls,clss);
		webutil.waitForVisibility(acSession);
		webutil.selectByVisibleText(acSession, ses);
		webutil.waitForVisibility(genMeritBtn).click();
		webutil.isAlertPresent();
	}
}
