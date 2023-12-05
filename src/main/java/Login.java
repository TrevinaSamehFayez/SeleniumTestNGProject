import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends PageBase{
    public Login(WebDriver driver) {
        super(driver);
    }

    private By checkbox = By.xpath("//input[@type='checkbox']");
    private WebElement checkboxElement;

    private By signIn = By.xpath("/html/body/div/nav/div/ul/a[2]/li");
    private WebElement signInElement;

    private By username = By.xpath("//input[@id='usr']");
    private WebElement usernameElement;

    private By password = By.xpath("//input[@id='pwd']");
    private WebElement passwordElement;

    private By loginButton = By.xpath("//input[@type='submit']");
    private WebElement loginButtonElement;

    private By registerButton = By.xpath("//button[@id='NewRegistration']");
    private WebElement registerButtonElement;

    public void setCheckbox(){
        checkboxElement = driver.findElement(checkbox);
        click(checkboxElement);

        signInElement = driver.findElement(signIn);
        click(signInElement);
    }
    public void signIn(String user, String pass){

        usernameElement = driver.findElement(username);
        enterText(usernameElement, user);

        passwordElement = driver.findElement(password);
        enterText(passwordElement, pass);

        loginButtonElement = driver.findElement(loginButton);
        click(loginButtonElement);
    }

    public void register(){
        registerButtonElement = driver.findElement(registerButton);
        click(registerButtonElement);
    }

}

