package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.CareerPage;


import java.time.Duration;
import java.util.List;

public class BasePage {

    public static WebDriver driver;
    public BasePage(WebDriver webDriver)
    {
        this.driver = webDriver;
        PageFactory.initElements(this.driver, this);
    }


   @FindBy(linkText = "Company")
    WebElement menuCompany;

    @FindBy(linkText = "Careers")
    WebElement subMenuCareers;

    public void clickElement(WebElement element){

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void waitUntilElementIsVisible(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }
    public void waitUntilElementIsDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitUntilClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilAllElementIsVisible(List<WebElement> findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for(WebElement element : findBy){
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }
    public void waitUntilAllElementClickable(List<WebElement> findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (WebElement element : findBy) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

    }
    public void openCareersPage(){
        waitUntilClickable(menuCompany);
        menuCompany.click();
        waitUntilClickable(subMenuCareers);
        subMenuCareers.click();
    }

}
