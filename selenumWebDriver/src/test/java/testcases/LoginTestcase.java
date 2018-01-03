package testcases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import webpages.LoginPage;

public class LoginTestcase extends BaseTest 
{
	private WebDriver driver;
	
	private LoginPage login;
	
	//ExtentTest logger;
	
	@BeforeClass
	
	public void init()
	{
		/*logger=extent.startTest("Login Test case");
		
		logger.assignAuthor("Sudheer");
		
		logger.assignCategory("Smoke");
		*/
		
		
	}
	
	@Test
	
	@Parameters("browserName")
	
	public void Launch_browser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("firefox"))
		 {
				
			System.setProperty("webdriver.gecko.driver", "");
			
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
			
		{
			System.setProperty("webdriver.ie.driver", "E:\\Softwares\\IEDriverServer.exe");
			
			driver=new InternetExplorerDriver();
			
		}
		
		
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "");
			
			driver=new ChromeDriver();
			
		}
		
		else
			
		{
			//logger.log(LogStatus.FAIL, "Invalid browser Name");
		}
		
		driver.manage().window().maximize();
		
		//logger.log(LogStatus.PASS, "Maximize the browser");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
			
			
	@Test (dependsOnMethods="Launch_browser")
	
	public void Login() throws IOException
	{
	
		login=new LoginPage(driver);
		
		driver.get("http://localhost/loginpage.html");
		
		//logger.log(LogStatus.PASS, "navigate to the page http://localhost/loginpage.html");
		
		//logger.log(LogStatus.PASS, logger.addScreenCapture(takeScreenshot("home")));
		
		//logger.addScreenCapture(takeScreenshot("Homepage"));
		
		login.setUserName("sudheer");
		
		//logger.log(LogStatus.PASS, "set user name as sudheer");
		
		//logger.log(LogStatus.PASS, logger.addScreenCapture(takeScreenshot("userName")));
		
		//logger.addScreenCapture(takeScreenshot("userName"));
				
		login.setPassword("Welcome1");
		
		//logger.log(LogStatus.PASS, "set password as welcome1");
		
		//logger.log(LogStatus.PASS,logger.addScreenCapture(takeScreenshot("password")));
		
		//logger.addScreenCapture(takeScreenshot("password"));
		
		login.submitclick();
		
		//logger.log(LogStatus.PASS, "click on submit button");
		
		//logger.log(LogStatus.PASS, logger.addScreenCapture(takeScreenshot("submit")));
		
		//logger.addScreenCapture(takeScreenshot("submit"));
	
	}
	
	@AfterClass
	
	public void tearDown()
	{
		
		driver.quit();
		
		//logger.log(LogStatus.PASS, "close the browser");
		
		//extent.endTest(logger);
	}

	public String takeScreenshot(String imageName) throws IOException
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils. copyFile(src, new File(System.getProperty("user.dir")+"//images//"+imageName+".png"));
		
		return System.getProperty("user.dir")+"//images//"+imageName+".png";
		
	}
	
	
	
	
	
}
