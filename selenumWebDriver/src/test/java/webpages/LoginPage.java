package webpages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	 WebDriver driver;
	
	@FindBy(name="username")
	
	WebElement userNametxt;
	
	@FindBy(name="password")
	
	WebElement passwordtxt;
	
	@FindBy(name="SignIn")
	
	WebElement submitbtn;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String value)
	{
		userNametxt.sendKeys(value);
	}
	
	public void setPassword(String value)
	
	{
		passwordtxt.sendKeys(value);
	}
	
	public void submitclick()
	{
		submitbtn.click();
	}
	

	
	

}
