package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class DashboardPage {

	WebDriver driver;
	WebDriverUtility webutil;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchbar;

	@FindBy(xpath = "//a[@href='/admission']")
	private WebElement admis;

	@FindBy(xpath = "//a[@href='/hostel']")
	private WebElement hostel;

	@FindBy(xpath = "//div[text()='Students']/following-sibling::button")
	private WebElement searchValue;

	@FindBy(xpath = "//a[@href='/dashboard']")
	private WebElement dashboard;

	@FindBy(xpath = "//a[@href='/students']")
	private WebElement students;

	@FindBy(xpath = "//a[@href='/timetable']")
	private WebElement timetable;

	@FindBy(xpath = "//a[@href='/library']")
	private WebElement library;

	@FindBy(xpath = "//a[@href='/lms']")
	private WebElement lms;

	@FindBy(xpath = "//a[@href='/users']")
	private WebElement users;

	@FindBy(xpath = "//a[@href='/id-cards']")
	private WebElement idcards;

	@FindBy(xpath = "//a[@href='/teacher-attendance']")
	private WebElement tchrAttdn;

	@FindBy(xpath = "//a[@href='/classes']")
	private WebElement classes;

	@FindBy(xpath = "//a[@href='/staff-directory']")
	private WebElement stfdir;

	@FindBy(xpath = "//a[@href='/calendar']")
	private WebElement calendar;

	@FindBy(xpath = "//a[@href='/assignments']")
	private WebElement assignments;

	@FindBy(xpath = "//a[@href='/diary']")
	private WebElement diary;

	@FindBy(xpath = "//button[text()='Sign Out']")
	private WebElement signout;

	@FindBy(xpath = "//a[@href='/meetings']")
	private WebElement meetings;

	@FindBy(xpath = "//a[@href='/payroll']")
	private WebElement payroll;

	@FindBy(xpath = "//a[@href='/inventory']")
	private WebElement inventory;

	@FindBy(xpath = "//a[@href='/certificates']")
	private WebElement certificates;
	
	@FindBy(xpath = "//a[@href='/bulk-operations']")
	private WebElement bulk; 
	
	public WebElement getBulk() {
		return bulk;
	}
	
	public WebElement getIdcards() {
		return idcards;
	}

	public WebElement getStfdir() {
		return stfdir;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getPayroll() {
		return payroll;
	}

	public WebElement getCertificates() {
		return certificates;
	}

	public WebElement getInventory() {
		return inventory;
	}

	public WebElement getpayroll() {
		return payroll;
	}

	public WebElement getMeetings() {
		return meetings;
	}

	public WebElement getSignOut() {
		return signout;
	}

	public WebElement getDiary() {
		return diary;
	}

	public WebElement getAssignments() {
		return assignments;
	}

	public WebElement getStfDir() {
		return stfdir;
	}

	public WebElement getHostel() {
		return hostel;
	}

	public WebElement getLibrary() {
		return library;
	}

	public WebElement getClasses() {
		return classes;
	}

	public WebElement getCalendar() {
		return calendar;
	}

	public WebElement getAdmis() {
		return admis;
	}

	public WebElement getDashboard() {
		return dashboard;
	}

	public WebElement getStudents() {
		return students;
	}

	public WebElement getTimetable() {
		return timetable;
	}

	public WebElement getlibrary() {
		return library;
	}

	public WebElement getLms() {
		return lms;
	}

	public WebElement getUsers() {
		return users;
	}

	public WebElement getIdCard() {
		return idcards;
	}

	public WebElement getTchrAttdn() {
		return tchrAttdn;
	}

	public WebElement getSearchbar() {
		return searchbar;
	}

	public WebElement getSearchValue() {
		return searchValue;
	}

	public void searchValue(String value) {
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(searchbar).sendKeys(value);
		webutil.waitForVisibility(searchValue).click();
	}

	public void signout() {
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(signout);
		webutil.mouseHover(signout);
		webutil.click(signout);
	}

}
