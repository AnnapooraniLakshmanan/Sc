package object_repository_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class InventoryPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()=' Add Item']")
	private WebElement addItemBtn;
	
	@FindBy(xpath = "//label[text()='Item Name *']/following-sibling::input")
	private WebElement itemName;
	
	@FindBy(xpath = "//button[text()='Add Item']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//button[text()='Assign']")
	private WebElement assignBtn;
	
	@FindBy(xpath = "//label[text()='Assign To *']/following-sibling::input")
	private WebElement assignToBtn;
	
	@FindBy(xpath = "//button[text()='Cancel']/preceding-sibling::button")
	private WebElement asgnBtn;

	public WebElement getAddItemBtn() {
		return addItemBtn;
	}

	public WebElement getItemName() {
		return itemName;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getAssignBtn() {
		return assignBtn;
	}

	public WebElement getAssignToBtn() {
		return assignToBtn;
	}

	public WebElement getAsgnBtn() {
		return asgnBtn;
	}
	
	
    public void InventoryManagement(String name,String depname) throws InterruptedException
    {
    	webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(addItemBtn).click();
		webutil.waitForVisibility(itemName).sendKeys(name);
		webutil.waitForVisibility(submitBtn).click();
		Thread.sleep(6000);
		webutil.waitForVisibility(driver.findElement(By.xpath("//table/tbody/tr/td/div[text()='"+name+"']/../following-sibling::td[7]/div/button[text()='Assign']"))).click();
		webutil.waitForVisibility(assignToBtn).sendKeys(depname);
		webutil.waitForVisibility(asgnBtn).click();
    
    }

}
