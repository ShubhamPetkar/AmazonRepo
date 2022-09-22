package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	// ScreenShot.capture
	// Modified method of screenshot containing automatic system path:
	public static String captureWithPath(WebDriver driver, String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\captureScreenShot\\" + filename + ".png";
		File destination = new File(path);
		FileHandler.copy(source, destination);
		return path;

	}
}
