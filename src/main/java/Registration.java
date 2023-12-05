import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Registration extends PageBase{
    public Registration(WebDriver driver) {
        super(driver);
    }


    private By check = By.xpath("//select[@id='Salutation']");
    private WebElement checkElement;
    private By salutation = By.xpath("/html/body/center/div/form/div/div[1]/div/select/option[3]");
    private WebElement salutationElement;

    private By firstName = By.xpath("//input[@id='firstname']");
    private WebElement firstNameElement;

    private By lastName = By.xpath("//input[@id='lastname']");
    private WebElement lastNameElement;

    private By emailID = By.xpath("//input[@id='emailId']");
    private WebElement emailIDElement;

    private By mobile = By.xpath("//input[@id='contactNumber']");
    private WebElement mobileElement;

    private By userName = By.xpath("//input[@id='usr']");
    private WebElement userNameElement;

    private By password = By.xpath("//input[@id='pwd']");
    private WebElement passwordElement;

    private By submit = By.xpath("//input[@type='submit']");
    private WebElement submitElement;
    public void userRegistration(String fname, String lname, String email, String num, String usr, String pwd){

        checkElement = driver.findElement(check);
        click(checkElement);

        salutationElement = driver.findElement(salutation);
        click(salutationElement);

        firstNameElement = driver.findElement(firstName);
        enterText(firstNameElement, fname);

        lastNameElement = driver.findElement(lastName);
        enterText(lastNameElement, lname);

        emailIDElement = driver.findElement(emailID);
        enterText(emailIDElement, email);

        mobileElement = driver.findElement(mobile);
        enterText(mobileElement, num);

        userNameElement = driver.findElement(userName);
        enterText(userNameElement, usr);

        passwordElement = driver.findElement(password);
        enterText(passwordElement, pwd);

        submitElement = driver.findElement(submit);
        click(submitElement);


    }
}

