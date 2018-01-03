package testcases;
//import java.io.File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import java.io.File;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest 
{
	//public static WebDriver driver;
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	@BeforeSuite
	
	public void beforeSuite() throws Exception
	{
		//extent=new ExtentReports("F:\\BDD\\selenumWebDriver\\target\\Testoutput.html", true);
		//extent.loadConfig(new File("F:\\BDD\\selenumWebDriver\\src\\test\\resources\\extent-config.xml"));
		//extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/TestReport.html", true);
		//extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		//ExtentTest logger;
	}
	
	@AfterSuite
	
	public void afterSuite() throws Exception
	{
		//extent.flush();
		
		//extent.close();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception
	{
        //below line is just to append the date format with the screenshot name to avoid duplicate names		
        	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        	TakesScreenshot ts = (TakesScreenshot) driver;
        	File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
        	File finalDestination = new File(destination);
        	FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        	return destination;
}
	
	
	

}
