package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAdvance {

	//xpath of userid,password,login button
	@FindBy(xpath="//span[@class='nav-line-2 ']") 
	WebElement accountAndList;
	
	
	
	
		@FindBy(xpath="//*[@id='ap_email']") 
		WebElement username;
		
		@FindBy(xpath="//*[@id='continue']//*[@class='a-button-input']") 
		WebElement continueButton;
		
		
		@FindBy(xpath="//*[@id='ap_password']") 
		WebElement password;
		
		
	    @FindBy(xpath="//*[@id='signInSubmit']")
	    WebElement signInSumbit;

	    
		WebDriver driver;
		//calling of constructor
		public LoginPageAdvance(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		
//	public void accountandClick() {
//		
//		accountAndList.click();
//	}
//		
		
	public void loginToApplication(String Uname,String Pwd)
	{
		accountAndList.click();
		username.sendKeys(Uname);
		continueButton.click();
		
		password.sendKeys(Pwd);
		signInSumbit.click();	
	}

	public String titleOfPage() 
	{
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	}
