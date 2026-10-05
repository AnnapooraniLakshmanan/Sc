package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic_webdriverUtility.WebDriverUtility;

public class PayrollPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public PayrollPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[.=' Generate Monthly Payroll']")
	private WebElement genPayrollBtn;
	
	@FindBy(xpath = "//button[.='Generate']")
	private WebElement genBtn;
	
	@FindBy(xpath = "//button[text()='Approve']")
	private WebElement approveBtn;
	
	@FindBy(xpath = "//button[.='Mark Paid']")
	private WebElement markPaidBtn;
	
	@FindBy(xpath = "//span[text()='PAID']")
	private WebElement paidBtn;
	
	@FindBy(xpath = " //button[.=' Salary Structures']")
	private WebElement salstruBtn;

	public WebElement getGenPayrollBtn() {
		return genPayrollBtn;
	}

	public WebElement getGenBtn() {
		return genBtn;
	}

	public WebElement getApproveBtn() {
		return approveBtn;
	}

	public WebElement getMarkPaidBtn() {
		return markPaidBtn;
	}

	public WebElement getPaidBtn() {
		return paidBtn;
	}

	public WebElement getSalstruBtn() {
		return salstruBtn;
	}
	
	
	
	public void payroll() throws InterruptedException
	{
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(genPayrollBtn).click();
		webutil.waitForVisibility(genBtn).click();
		webutil.isAlertPresent();
		Thread.sleep(4000);
		webutil.waitForVisibility(approveBtn).click();
		webutil.waitForVisibility(markPaidBtn).click();
		webutil.waitForVisibility(paidBtn);
		Assert.assertTrue(paidBtn.isDisplayed());
	}
}
