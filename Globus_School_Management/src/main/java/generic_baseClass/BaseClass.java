package generic_baseClass;

import java.io.IOException;
import java.sql.Connection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_fileUtility.FileUtility;
import object_repository_utility.DashboardPage;
import object_repository_utility.LoginPage;


public class BaseClass {

	public static WebDriver driver;
	
	Connection con;
	FileUtility prop = new FileUtility();
	

	

	//@Parameters("BROWSER")
	@BeforeClass(groups = { "smoke", "regression" })
	
	public void browserLaunching() throws IOException {
		String browser =prop.getDataFromProperties("browser");
		
		//String browser =System.getProperty("browsername",prop.getDataFromProperties("browser"));
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterClass(groups = { "smoke", "regression" })
	public void browserClosing() {
		driver.quit();
		

	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void loginToApp() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String url =prop.getDataFromProperties("url");
		lp.launchApp(url);

	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void logoutFromApp() throws InterruptedException {
		DashboardPage dp=new DashboardPage(driver);
		dp.signout();
	}

}
