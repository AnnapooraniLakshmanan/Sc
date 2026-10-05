package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class ClassesPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public ClassesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Class 1']/../../preceding-sibling::button")
	private WebElement cls1Btn;
	
	@FindBy(xpath = "//div[.='Section A']/following-sibling::div")
	private WebElement noOfStu;

	public WebElement getCls1Btn() {
		return cls1Btn;
	}

	public WebElement getNoOfStu() {
		return noOfStu;
	}
	
	public String clsCheck()
	{
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(cls1Btn).click();
		String data = webutil.waitForVisibility(noOfStu).getText();
		return data;
	}
}
