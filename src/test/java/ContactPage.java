import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.text.Normalizer;

public class ContactPage extends PageBase
{
    private By titleLocator = By.xpath("//*[@id=\"content__pages\"]/section[1]/div/div/div/h1");

    public ContactPage(WebDriver driver)
    {
        super(driver);
        this.driver.get("https://biotechusa.hu/kapcsolat/#");
    }

    public String getPageTitle()
    {
        WebElement pageTitle = waitAndReturnElement(titleLocator);
        String pageTitleText = Normalizer.normalize(pageTitle.getText(), Normalizer.Form.NFD)
                                         .replaceAll("\\p{M}", "")
                                         .toLowerCase();
        return pageTitleText;
    }
}
