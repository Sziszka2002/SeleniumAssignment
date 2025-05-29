import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.sql.Driver;

public class LoggedOutPage extends PageBase
{
    private By LoginBarLocator = By.xpath("//*[@id=\"topbar\"]");

    public LoggedOutPage(WebDriver driver)
    {
        super(driver);
    }

    public Boolean isLoggedOut()
    {
        WebElement LoginBar = waitAndReturnElement(profileLocator);
        return LoginBar.isDisplayed();
    }
}
