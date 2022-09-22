package testClass;

	import java.io.IOException;
	import org.testng.Assert;
	import org.testng.annotations.Test;

import Listeners.TestNGListeners;
import utility.ReadDataFromPropFile;

	public class LoginTest extends TestNGListeners{
		@Test(priority=1)
		
		public void validatelogin() throws IOException
		{
			lpa.loginToApplication(ReadDataFromPropFile.readConfigData("Username"),ReadDataFromPropFile.readConfigData("Password"));
				
//			Enter credential for extent report
			test.info("Entered creds are: "+ReadDataFromPropFile.readConfigData("Username")+" "+ReadDataFromPropFile.readConfigData("Password"));
		
		}
		
		@Test(priority=2)
		public void validatetitle()
		{
			String actualtitle=lpa.titleOfPage();
			String expectedtitle="Amazon.com. Spend less. Smile more.";
			test.info("Title of the page validated");
			Assert.assertEquals(actualtitle, expectedtitle ,"Expected Title is not Matching");

			boolean xyz = expectedtitle.contains("amazon");
			Assert.assertTrue(xyz);
			
			
			//lpa.titleOfPage();
		}
	}

