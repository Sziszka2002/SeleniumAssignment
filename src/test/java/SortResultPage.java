import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.text.Normalizer;

public class SortResultPage extends PageBase
{
    private By productName = By.xpath("//*[@id=\"product-1\"]/div/div/div[2]/p/a");

    public SortResultPage(WebDriver driver)
    {
        super(driver);
        waitAndReturnElement(profileLocator);
    }

    public String getResultText()
    {
        WebElement result = waitAndReturnElement(productName);
        String resultText = Normalizer.normalize(result.getText(), Normalizer.Form.NFD)
                                         .replaceAll("\\p{M}", "")
                                         .toLowerCase();
        return resultText;
    }

}
