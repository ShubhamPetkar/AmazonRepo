package pages;


	import java.time.Duration;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class DashBoard  {

		//xpath of search box	
			@FindBy(xpath="//*[@id='twotabsearchtextbox']") 
			WebElement SearchBox;
		
		//xpath of buy button	
		    @FindBy(xpath="//*[@class='eight columns text-right']//*[@class='button-outline button-blue']")
		    WebElement buybutton;
		    
		//xpath of final buy button
		   @FindBy(xpath="//*[@class='submit']")
		   WebElement finalbuybutton;
		   
		//print error message xpath of message
		   @FindBy(xpath="//*[@class='message']") 
		   WebElement errormessage;
		    
			WebDriver driver;
		//calling of constructor
			public DashBoard(WebDriver driver) 
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
		public void searchItems()
		{
			SearchBox.sendKeys("apple mobile phone 13");
	//we have to press enter button with the help of actions class
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}

		public void buyshare() 
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(buybutton));
			buybutton.click();
			finalbuybutton.click();
	    }
		
		public void errormessageprint()
		{
			String text=errormessage.getText();
			System.out.println(text);
		}
	}

