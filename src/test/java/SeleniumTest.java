import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.text.Normalizer;

import org.junit.*;

public class SeleniumTest {

    private WebDriver driver;

    private static final String BASE_URL = "https://shop.biotechusa.hu/";

    private static final String[][] STATIC_PAGES = {
        {"/collections/all", "h1", "Osszes termek"},
        {"/collections/essence-kollekcio", "h1", "Essence kollekcio"}
    };

    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
    }

    @Test 
    public void testPageTitle() {
        MainPage mainPage = new MainPage(this.driver);
        String title = mainPage.getTitle();
        assertTrue("Title mismatch: " + title,
                    title.contains("BioTechUSA Webshop"));
    }

    @Test
    public void testContactPageLoading() {
        ContactPage contactPage = new ContactPage(this.driver);
        String titleText = contactPage.getPageTitle();
        assertTrue("Page title mismatch: " + titleText,
                    titleText.contains("lepj velunk kapcsolatba"));
    }
 
    @Test
    public void testLoginForm() {
        LoginPage loginPage = new LoginPage(this.driver);
        LoggedPage loggedPage = loginPage.login("balazsszibedek@gmail.com","Jelszo12345@");
        assertTrue(loggedPage.isLogged());
    } 
    
    @Test
    public void testLogout() {
        LoginPage loginPage = new LoginPage(this.driver);
        LoggedPage loggedPage = loginPage.login("balazsszibedek@gmail.com","Jelszo12345@");

        LoggedOutPage loggedOutPage = loggedPage.logOut();
        assertTrue(loggedOutPage.isLoggedOut());
    }
    
    @Test
    public void testSort() {
        LoginPage loginPage = new LoginPage(this.driver);
        LoggedPage loggedPage = loginPage.login("balazsszibedek@gmail.com","Jelszo12345@");

        MainPage mainPage = new MainPage(this.driver);

        mainPage.goToProducts();
        SortResultPage searchResultPage = mainPage.sortDescending();
        assertTrue("Result mismatch: ",searchResultPage.getResultText().contains("zone ferfi pulover"));
    }

    @Test
    public void testAllStaticPages() {
        for (String[] pageData : STATIC_PAGES) {
            String path = pageData[0];
            String selector = pageData[1];
            String expectedText = pageData[2];

            driver.get(BASE_URL + path);
            WebElement heading = driver.findElement(By.cssSelector(selector));
            String resultText = Normalizer.normalize(heading.getText(), Normalizer.Form.NFD)
                                        .replaceAll("\\p{M}", "");
            assertTrue("Result mismatch: " + path,
                resultText.contains(expectedText));
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
