package testcases;
import java.io.File;
import java.io.IOException;
//import java.io.File;
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

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

//import webpages.LoginPage;
//import com.relevantcodes.extentreports.LogStatus;
import webpages.WebElementPage;

public class WebElementTestcase extends BaseTest
{
	private WebDriver driver;
	
	WebElementPage objWebElement;
	
	//ExtentTest logger;
	
	@BeforeClass
	
	public void init()
	{
		
		/*logger=extent.startTest("WebElementTestcase");
		
		logger.assignAuthor("Sudheer");
		
		logger.assignCategory("Smoke");*/
		
	}
	
	
	@Test
	
	@Parameters("browserName")
	
	public void launch(String browserName)
	
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
	
	@Test (dependsOnMethods="launch")
	
	public void WebElement()
	{
		
		objWebElement=new WebElementPage(driver);
		
		driver.get("http://localhost/WebElement.html");
		
		//logger.log(LogStatus.PASS, "Navigate to the page http://localhost/WebElement.html");
		
		objWebElement.selectSaluation("Miss.");
		
		//logger.log(LogStatus.PASS, "Select saluation as miss");
		
		objWebElement.setFirstName("abc");
		
		//logger.log(LogStatus.PASS, "set fist name as abc");
		
		objWebElement.setLastName("def");
		
		//logger.log(LogStatus.PASS, "set last name as def");
		
		objWebElement.selectGender("other");
		
		//logger.log(LogStatus.PASS, "select gender as other");
		
		objWebElement.submitbtn();
		
		//logger.log(LogStatus.PASS, "click on submit button");
		
		
	}
	
	@AfterClass
	
	public void closeBrowser()
	{
		
		driver.quit();
		
		//extent.endTest(logger);
		
	}
	
	public String takeScreenshot(String imageName) throws IOException
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils. copyFile(src, new File("C:/selenium/error.png"));
		
		return System.getProperty("user.dir")+"//images//"+imageName+".png";
		
	}



}