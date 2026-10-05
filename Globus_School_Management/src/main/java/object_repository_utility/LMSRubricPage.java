package object_repository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_webdriverUtility.WebDriverUtility;

public class LMSRubricPage {
	WebDriver driver;
	WebDriverUtility webutil;

	public LMSRubricPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Rubrics']")
	private WebElement rubrics;

	@FindBy(xpath = " //button[text()=' Create Rubric']")
	private WebElement creRubBtn;

	@FindBy(xpath = "//label[text()='Title *']/following-sibling::input")
	private WebElement titleTxt;

	@FindBy(xpath = "//label[text()='Description']/following-sibling::input")
	private WebElement description;

	@FindBy(xpath = "//input[contains(@placeholder,'Criterion title')]")
	private WebElement criTitleTxt;

	@FindBy(xpath = "//input[@value='Excellent']/../following-sibling::input")
	private WebElement excellentDes;

	@FindBy(xpath = "//input[@value='Good']/../following-sibling::input")
	private WebElement goodDes;

	@FindBy(xpath = "//input[@value='Needs Improvement']/../following-sibling::input")
	private WebElement needsImpDes;

	@FindBy(xpath = "//input[@value='Insufficient']/../following-sibling::input")
	private WebElement insuffDes;

	@FindBy(xpath = "//button[text()='Create Rubric']")
	private WebElement createRubBtn;

	@FindBy(xpath = "//h3[text()='ProjectPresentationRubric']")
	private WebElement createdRubs;

	public WebElement getCreatedRubs() {
		return createdRubs;
	}

	public WebElement getRubrics() {
		return rubrics;
	}

	public WebElement getCreRubBtn() {
		return creRubBtn;
	}

	public WebElement getTitleTxt() {
		return titleTxt;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getCriTitleTxt() {
		return criTitleTxt;
	}

	public WebElement getExcellentDes() {
		return excellentDes;
	}

	public WebElement getGoodDes() {
		return goodDes;
	}

	public WebElement getNeedsImpDes() {
		return needsImpDes;
	}

	public WebElement getInsuffDes() {
		return insuffDes;
	}

	public WebElement getCreateRubBtn() {
		return createRubBtn;
	}

	public void createRubrics(String title, String des, String crititle, String exdes, String gddes, String needdes,
			String indes) {
		webutil = new WebDriverUtility(driver);
		webutil.waitForVisibility(rubrics).click();
		webutil.waitForVisibility(creRubBtn).click();
		webutil.waitForVisibility(titleTxt).sendKeys(title);
		webutil.waitForVisibility(description).sendKeys(des);
		webutil.waitForVisibility(criTitleTxt).sendKeys(crititle);
		webutil.waitForVisibility(excellentDes).sendKeys(exdes);
		webutil.waitForVisibility(goodDes).sendKeys(gddes);
		webutil.waitForVisibility(needsImpDes).sendKeys(needdes);
		webutil.waitForVisibility(insuffDes).sendKeys(indes);
		webutil.waitForVisibility(createRubBtn).click();
	}
}
