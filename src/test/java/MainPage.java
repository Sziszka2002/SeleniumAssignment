import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import javax.naming.directory.SearchResult;

import java.net.MalformedURLException;

public class MainPage extends PageBase
{
    private By productLocator = By.xpath("//*[@id=\"AccessibleNav\"]/li[1]/a");
    private By sorterLocator = By.xpath("//*[@id=\"SortBy\"]");

    public MainPage(WebDriver driver)
    {
        super(driver);
        this.driver.get("https://shop.biotechusa.hu/");
    }

    public String getTitle()
    {
        return this.driver.getTitle();
    }

    public void goToProducts()
    {
        waitAndReturnElement(productLocator).click();
    }

    public SortResultPage sortDescending()
    {
        WebElement sorterInput = waitAndReturnElement(sorterLocator);
        Select sortBySelect = new Select(sorterInput);
        sortBySelect.selectByValue("title-descending");
        return new SortResultPage(this.driver);    
    }
}
