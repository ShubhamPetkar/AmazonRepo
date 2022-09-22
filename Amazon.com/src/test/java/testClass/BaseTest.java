package testClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashBoard;
import pages.LoginPageAdvance;

public class BaseTest {


	public static WebDriver driver;
	public LoginPageAdvance lpa;
	public DashBoard db;

	 
    @BeforeSuite
	public void intibrowser()
	{
//       System.setProperty("webdriver.chrome.driver", "E:\\Eclipse_2022\\Amazon.com\\Driver\\chromedriver.exe");
    
    	
    	WebDriverManager.chromedriver().setup();
    	
    	//to handle browser specific popup
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notification");
    	
    	//to mazimize brower by options class
    	options.addArguments("--start-maximized");
    	
    	////to run script in incognito mode
    	//options.addArguments("--incognito");
    	
    	////code will execute but it will not show us while running it will give directly result
    	//options.addArguments("--headless");

		driver = new ChromeDriver(options);
		
//        driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
	}
    
    @BeforeClass
    public void createobject()
    {
    	 
    	 db = new DashBoard(driver);
    	 lpa =new LoginPageAdvance(driver);
    }
    
//    @AfterSuite
//    public void closebrowser()
//    {
//    	driver.quit();
//    }

}
