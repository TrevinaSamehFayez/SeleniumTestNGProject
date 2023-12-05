import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart extends PageBase{
    public AddToCart(WebDriver driver) {
        super(driver);
    }

    private By button = By.xpath("/html/body/div[3]/div/div[1]/button");
    private WebElement buttonElement;

    private By selectColor = By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[3]/select");
    private WebElement selectColorElement;
    private By color = By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[3]/select/option[2]");
    private WebElement colorElement;

    private By selectSize = By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[4]/select");
    private WebElement selectSizeElement;

    private By size = By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[4]/select/option[3]");
    private WebElement sizeElement;

    private By cart = By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[6]/button");
    private WebElement cartElement;

    public void clickButton(){
        buttonElement = driver.findElement(button);
        click(buttonElement);
    }

    public void Cart(){
        selectColorElement = driver.findElement(selectColor);
        click(selectColorElement);
        colorElement = driver.findElement(color);
        click(colorElement);

        selectSizeElement = driver.findElement(selectSize);
        click(selectSizeElement);
        sizeElement = driver.findElement(size);
        click(sizeElement);

        cartElement = driver.findElement(cart);
        click(cartElement);

    }
}
