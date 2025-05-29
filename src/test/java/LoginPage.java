import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;


public class LoginPage extends PageBase
{
    private By emailLocator = By.xpath("//*[@id=\"CustomerEmail\"]");
    private By passwordLocator = By.xpath("//*[@id=\"CustomerPassword\"]");
    private By loginButtonLocator = By.xpath("//*[@id=\"loginButton\"]");

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver.get("https://shop.biotechusa.hu/account/login");
    }
    
    public LoggedPage login(String userName, String password)
    {
        WebElement emailInput = waitAndReturnElement(emailLocator);
        emailInput.sendKeys(userName);

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
        passwordInput.sendKeys(password);

        waitAndReturnElement(loginButtonLocator).click();
        return new LoggedPage(this.driver);
    }

}
