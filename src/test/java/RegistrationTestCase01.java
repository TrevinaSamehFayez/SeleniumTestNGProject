import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class RegistrationTestCase01 extends TestBase{
    private Login login;
    private Registration register;

    @Test()
    public void Reg() throws IOException {
        test = extent.createTest("Register","This test case validates that the user can register in the web application");
        login = new Login(driver);
        register = new Registration(driver);
        login.setCheckbox();
        login.register();
        register.userRegistration("Trevina", "Sameh", "venasameh123@gmail.com", "01273452942", username, password);

        String expected = driver.findElement(By.xpath("/html/body/center[1]/h1")).getText();
        String actual = "User Registered Successfully !!!";
        Assert.assertTrue(actual.contains(expected));

        if(actual.equals(expected)){
            test.log(Status.PASS, "Test passed for Registration");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        }

        else{
            test.log(Status.FAIL, "Test failed for Registration");
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }

    }
}
