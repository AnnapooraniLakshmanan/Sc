package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class BulkOperationsPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public BulkOperationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='flex items-center gap-2']")
	private WebElement SmplJSONData;

	@FindBy(xpath = "//button[text()='Use Template']")
	private WebElement useTemplateBtn;

	@FindBy(xpath = "//button[text()='Import']")
	private WebElement importBtn;

	@FindBy(xpath = "//div[text()='Import Complete']")
	private WebElement importComplt;

	public WebElement getImportBtn() {
		return importBtn;
	}

	public WebElement getSmplJSONData() {
		return SmplJSONData;
	}

	public WebElement getUseTemplateBtn() {
		return useTemplateBtn;
	}

	public WebElement getImportComplt() {
		return importComplt;
	}

	public void importRecordsInBulkOp() throws InterruptedException {
		webutil = new WebDriverUtility(driver);
		driver.navigate().to("https://globuslms.globusdemos.com/bulk-operations");
		webutil.waitForVisibility(SmplJSONData).click();
        webutil.waitForVisibility(useTemplateBtn).click();
		webutil.waitForClickable(importBtn).click();

	}

}
