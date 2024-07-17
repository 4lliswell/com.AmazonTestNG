package amazon.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBaseReport {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeSuite
    public void beforeSuite() {

        extentReports = new ExtentReports();

        String currentDate = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/" + "testReport " + currentDate + ".html";

        extentHtmlReporter = new ExtentSparkReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("QA Engineer", "Yunus");
        extentHtmlReporter.config().setDocumentTitle("Report");
        extentHtmlReporter.config().setReportName("TestNG Reports");
        extentHtmlReporter.config().setDocumentTitle("Son Test " + new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date()));
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            String screenShotLocation = ReusableMethods.getScreenshot(Driver.getDriver(), result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenShotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }
    }

    @AfterSuite
    public void afterSuite() {

        extentReports.flush();
    }

}
