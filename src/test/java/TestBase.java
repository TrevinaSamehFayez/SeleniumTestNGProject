import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
public class TestBase{
    static ExtentTest test;
    static  ExtentReports extent = new ExtentReports();
    protected WebDriver driver;
    protected String username = "Vena";
    protected String password = "pwwd122A";
    @BeforeTest
    public void Setup() {
        driver = new FirefoxDriver();
        driver.navigate().to("https://anupdamoda.github.io/AceOnlineShoePortal/");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    public static String capture(WebDriver driver) throws IOException{
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../ExecImages/" + System.currentTimeMillis() + ".png");

        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;

    }

}
