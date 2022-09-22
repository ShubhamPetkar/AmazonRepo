package Listeners;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentReportGen {
		
	//to acess extent in other claass we have to defined it globally and defined it as static to avoid object creation in static area 
	static ExtentReports extent;
	public static ExtentReports extentReportGenerator()
	{
		//path of report
		String path =System.getProperty("user.dir")+"\\reports\\kitezerodhareport.html";
		
		//how report looks like
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		
		//theme
		reporter.config().setTheme(Theme.DARK);
		
		//name of report
		reporter.config().setReportName("Zerodha Execution report");
		
		//extra info. from our side
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project name", "Kite Zerodha");
		extent.setSystemInfo("Executed by", "Aniket Phatangare");
		extent.setSystemInfo("Environmen used", "Staging");
		
		return extent;
	}

	
}
