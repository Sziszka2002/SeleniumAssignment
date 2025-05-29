import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;


public class LoggedPage extends PageBase
{
    private By logutButtonLocator = By.xpath("//*[@id=\"side_menu\"]/a[10]");

    public LoggedPage(WebDriver driver)
    {
        super(driver);
        waitAndReturnElement(profileLocator);
    }

    public Boolean isLogged()
    {
        WebElement profileIcon = waitAndReturnElement(profileLocator);
        return profileIcon.isDisplayed();
    }

    public LoggedOutPage logOut()
    {
        //gomb nem mukodik Seleniummal
        driver.get("https://shop.biotechusa.hu/account/logout");
        return new LoggedOutPage(driver);
    }

}