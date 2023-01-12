package amazon.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    public static void locateUzerindeBekle ( WebElement webElement ){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(webElement).perform();
    }

    public static void yukleneneKadarBekle ( WebElement webElement){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public static void javaScriptExcecuter(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()",element);
    }

    public static String getScreenshot(WebDriver driver, String name) throws IOException {

        // Screenshot dosya ismi icin suanki tarihi String olarak aliyoruz.
        String date = formatCurrentDate(" yyyy.MM.dd_HH.mm.ss"); // asagida olusturdugumuz methodu kullandik.

        // Screenshot alip file objesine atiyoruz.
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Kaydedilecek dosyanin yolunu belirtiyoruz.
        String target = System.getProperty("user.dir")+ "\\test-output\\screenshot\\"+name+date+".png";

        File targetFile = new File(target);
        FileUtils.copyFile(source,targetFile);

        return target;
    }

    public static String formatCurrentDate(String pattern){

        return new SimpleDateFormat(pattern).format(new Date());
    }


}
