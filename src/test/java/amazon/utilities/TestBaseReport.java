package amazon.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBaseReport {

    protected WebDriver driver;
    protected Actions actions;
    protected ExtentReports extentReports; //extent report'a ilk atamayi yaparv
    protected ExtentHtmlReporter extentHtmlReporter; // Html raporu duzenler
    protected ExtentTest extentTest;


    @BeforeSuite
    public void beforeSuite() {

        //Create extent report
        extentReports = new ExtentReports(); // Raporlamayi baslatir

        // Report PATH= creates the html report right under test-output
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        String currentDate = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/report/" + "testReport " + currentDate + ".html";

        //Attach html and extent reports
        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz, filePath ile dosya yolunu belirliyoruz.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        // Add custom information
        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome"); // chrome, firefox
        extentReports.setSystemInfo("QA Engineer", "Yunus");
        extentHtmlReporter.config().setDocumentTitle("Report");
        extentHtmlReporter.config().setReportName("TestNG Reports");
        extentHtmlReporter.config().setDocumentTitle("Son Test " + new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date()));//test doc uzerinde tarih yazili olacak

    }

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) { // Testimiz fail olursa if block calisacak ve screenshot alacak.
            String screenShotLocation = ReusableMethods.getScreenshot(Driver.getDriver(), result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenShotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }

    }

    @AfterSuite
    public void afterSuite() {

        extentReports.flush();
    }
}
