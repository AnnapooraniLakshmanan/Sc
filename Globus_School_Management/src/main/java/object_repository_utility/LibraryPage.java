package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class LibraryPage {

	WebDriver driver;
	WebDriverUtility webutil;

	public LibraryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webutil = new WebDriverUtility(driver);
	}

	@FindBy(xpath = " //button[.=' Add Book']")
	private WebElement addBkBtn;

	@FindBy(xpath = "//label[text()='Title *']/following-sibling::input")
	private WebElement title;

	@FindBy(xpath = "//label[text()='Author *']/following-sibling::input")
	private WebElement author;

	@FindBy(xpath = "//label[text()='ISBN']/following-sibling::input")
	private WebElement isbn;

	@FindBy(xpath = "//button[text()='Add Book']")
	private WebElement addBkSvBtn;

	@FindBy(xpath = "//table[@class='w-full text-sm']/tbody/tr/td[1]/div")
	private WebElement bookName;

	@FindBy(xpath = "//button[contains(text(),'Overdue')]")
	private WebElement ovrDue;

	@FindBy(xpath = "//table/tbody/tr/td[last()]")
	private WebElement returnBtn;

	@FindBy(xpath = "//button[text()='Overdue (5)']")
	private WebElement bfrReturn;

	@FindBy(xpath = "//button[text()='Overdue (4)']")
	private WebElement aftrReturn;

	public WebElement getAddBkBtn() {
		return addBkBtn;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getAuthor() {
		return author;
	}

	public WebElement getIsbn() {
		return isbn;
	}

	public WebElement getAddBkSvBtn() {
		return addBkSvBtn;
	}

	public WebElement getBookName() {
		return bookName;
	}

	public WebElement getOvrDue() {
		return ovrDue;
	}

	public WebElement getReturnBtn() {
		return returnBtn;
	}

	public WebElement getBfrReturn() {
		return bfrReturn;
	}

	public WebElement getAftrReturn() {
		return aftrReturn;
	}

	public void libraryAddAndReturnBook(String tit, String auth, String isb) {

		webutil.waitForVisibility(addBkBtn).click();
		webutil.waitForVisibility(title).sendKeys(tit);
		webutil.waitForVisibility(author).sendKeys(auth);
		webutil.waitForVisibility(isbn).sendKeys(isb);
	    webutil.waitForVisibility(addBkSvBtn).click();
	    webutil.isAlertPresent();
	    webutil.waitForVisibility(addBkSvBtn).click();
	}

	public void overDue() throws InterruptedException {
		Thread.sleep(4000);
		webutil.waitForVisibility(ovrDue).click();
		webutil.waitForVisibility(returnBtn).click();
		webutil.isAlertPresent();
		
		
	}

}
