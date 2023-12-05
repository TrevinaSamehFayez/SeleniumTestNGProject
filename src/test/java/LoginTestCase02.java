import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class LoginTestCase02 extends TestBase{

    private Login login;

    @Test
    public void LogIn() throws IOException {
        test = extent.createTest("Login", "This test case validates that the user can login to his account successfully");
        login = new Login(driver);
        login.setCheckbox();
        login.signIn(username, password);

        String expected = driver.findElement(By.xpath("/html/body/p[1]")).getText();
        String actual = "          Hi, Robert Dunnett";

        if(actual.equals(expected)){
            test.log(Status.PASS, "Test passed for login successfully");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        }

        else{
            test.log(Status.FAIL, "Test failed for login");
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }

        Assert.assertTrue(actual.contains(expected));
    }
}