package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import screenshot_helper.ScreenShooter;

public class ExtentReportListener implements ITestListener {

    private ExtentTest test;
    private ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {
        String pathToReportFolder = System.getProperty("user.dir") + "/target/spark-reports/Report.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(pathToReportFolder);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setEncoding("utf-8");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName(), result.getMethod().getDescription());
        test.assignCategory(result.getMethod().getGroups());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.addScreenCaptureFromBase64String(ScreenShooter.takeScreenShot(), result.getName());
        test.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "PASSED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
