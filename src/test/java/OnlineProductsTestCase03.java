import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class OnlineProductsTestCase03 extends TestBase{
    private OnlineProducts product;
    @Test
    public void checkProducts() throws IOException {
        test = extent.createTest("Online Products", "This test case validates that the different shoe types are shown to the user correctly");
        product = new OnlineProducts(driver);
        product.clickProducts();

        product.formalProducts();
        String expectedFormalText = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]")).getText();
        String actualFormalText = "   Classic Cheltenham";

        product.sportsProducts();
        String expectedSportsText = driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[1]/td[1]")).getText();
        String actualSportsText = "   Ultimate";

        product.sneakersProducts();
        String expectedSneakersText = driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[1]")).getText();
        String actualSneakersText = "   Archivo";

        if((actualFormalText.equals(expectedFormalText)) && (actualSportsText.equals(expectedSportsText)) && (actualSneakersText.equals(expectedSneakersText))) {

            test.log(Status.PASS, "Test passed for Showing the correct types of Formal Shoes");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        }

        else{
            test.log(Status.FAIL, "Test failed for Showing the correct types of shoes in products page");
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }

        Assert.assertTrue(actualFormalText.contains(expectedFormalText));
        Assert.assertTrue(actualSportsText.contains(expectedSportsText));
        Assert.assertTrue(actualSneakersText.contains(expectedSneakersText));
    }
}
