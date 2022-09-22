package testClass;

	import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
	import Listeners.TestNGListeners;

	public class DashBoardTest extends TestNGListeners {
		
		@Test(priority=3)
		public void searchItemstest()
		{
			test.info("searching the shares");
			db.searchItems();	
		}
		
		@Test(priority=4)
		public void buyshares()
		{
			test.info("Placing the order");
			db.buyshare();
			
			
		}
		
//		@Test(priority=5)
//		public void msgprint()
//		{
//	      db.errormessageprint();
//		}

		
	}
