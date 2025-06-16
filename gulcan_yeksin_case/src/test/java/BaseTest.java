import Pages.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
   public static WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void before()
    {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/File/chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://useinsider.com/");
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));


    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }


}
