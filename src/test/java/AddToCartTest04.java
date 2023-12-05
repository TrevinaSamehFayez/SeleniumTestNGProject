import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class AddToCartTest04 extends TestBase{
    private Login login;
    private AddToCart add;
    @Test
    public void addToCart() throws IOException {
        test = extent.createTest("Add to cart", "This test case validates that the user can add products to the cart successfully");
        login = new Login(driver);
        add = new AddToCart(driver);
        login.setCheckbox();
        login.signIn(username, password);

        add.clickButton();
        String option_expected = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]")).getText();
        String option_actual = "   Classic Cheltenham";

        add.Cart();

        String expectedMessage = driver.findElement(By.xpath("/html/body/center[1]/h1")).getText();
        String actualMessage = "Added to Cart Successfully !!!";

        if((option_actual.equals(option_expected)) && (actualMessage.equals(expectedMessage))){
            test.log(Status.PASS, "Test passed for Adding products to cart successfully");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        }

        else{
            test.log(Status.FAIL, "Test failed for Adding products to cart successfully");
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }

        Assert.assertTrue(option_actual.contains(option_expected));
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}
