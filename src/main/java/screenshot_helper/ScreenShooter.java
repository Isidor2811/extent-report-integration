package screenshot_helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static driverFactory.DriverFactory.getDriver;

public class ScreenShooter {

    public static String takeScreenShot() {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BASE64);
    }

}
