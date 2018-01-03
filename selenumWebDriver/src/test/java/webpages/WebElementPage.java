package webpages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testcases.BaseTest;

public class WebElementPage extends BaseTest
{
	WebDriver driver;
	
	@FindBy(name="firstname")
	
	WebElement firstNameTxt;
	
	@FindBy(name="lastname")
	
	WebElement lastNameTxt;
	
	@FindBy(name="Saluation")
	
	WebElement saluationSelect;
	
	@FindBy(xpath="//input[@type='submit']")
	
	WebElement submitBtn;
	
	public WebElementPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void selectSaluation(String value)
	{
		
		Select saluation=new Select(saluationSelect);
		
		saluation.selectByValue(value);
		
	}
	
	public void setFirstName(String value)
	{
		
		firstNameTxt.sendKeys(value);
	}
	
	
	public void setLastName(String value)
	{
		lastNameTxt.sendKeys(value);
	}
	
	
	public void selectGender(String value)
	{
		
		if(value.equalsIgnoreCase("male"))
			
			driver.findElement(By.xpath("//input[@type='radio' and @value='male']")).click();
		
		else if(value.equalsIgnoreCase("female"))
			
			driver.findElement(By.xpath("//input[@type='radio' and @value='female']")).click();
		
		else
			
			driver.findElement(By.xpath("//input[@type='radio' and @value='other']")).click();
		
	}
	
	public void submitbtn()
	{
		submitBtn.click();
	}
	
	
	
	
	

}
