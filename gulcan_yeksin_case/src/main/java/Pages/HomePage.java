package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    BasePage basePage = new BasePage(driver);


    @FindBy(id = "wt-cli-accept-all-btn")
    WebElement allCookiesAccept;

    @FindBy(id = "cookie-law-info-bar")
    WebElement cookieBar;
    
    public void closeCookie(){
        basePage.waitUntilElementIsVisible(allCookiesAccept);
        allCookiesAccept.click();
        basePage.waitUntilElementIsDisappear(cookieBar);
    }

    public String getTitleHomePage()
    {
        String Title=driver.getTitle();

        return Title;
    }
}
