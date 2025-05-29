import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;

public class PageBase
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected By profileLocator = By.xpath("//*[@id=\"profile-icon\"]");

    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    protected WebElement waitAndReturnElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    
    protected WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
}
