import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlineProducts extends PageBase{

    public OnlineProducts(WebDriver driver) {
        super(driver);
    }

    private By checkbox = By.xpath("//input[@type='checkbox']");
    private WebElement checkboxElement;

    private By products = By.xpath("/html/body/div/nav/div/ul/a[3]/li");
    private WebElement productsElement;

    private By formal = By.xpath("/html/body/div[2]/center/div/i[1]");
    private WebElement formalElement;

    private By sports = By.xpath("/html/body/div[3]/center/div/i[1]");
    private WebElement sportsElement;

    private By sneakers = By.xpath("/html/body/div[4]/center/div/i[1]");
    private WebElement sneakersElement;


    public void clickProducts(){
        checkboxElement = driver.findElement(checkbox);
        click(checkboxElement);

        productsElement = driver.findElement(products);
        click(productsElement);
    }

    public void formalProducts(){
        formalElement = driver.findElement(formal);
        click(formalElement);
    }

    public void sportsProducts(){
        sportsElement = driver.findElement(sports);
        click(sportsElement);
    }

    public void sneakersProducts(){
        sneakersElement = driver.findElement(sneakers);
        click(sneakersElement);
    }

}
