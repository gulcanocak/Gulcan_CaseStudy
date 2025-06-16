package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualityAssurancePage extends BasePage {
    WebDriver driver;

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href*='department']")
    WebElement seeQaJobsBtn;

    @FindBy(id = "page-head")
    WebElement pageHeadSection;


    public void waitPageLoad() {
        waitUntilElementIsVisible(pageHeadSection);

    }

    public void openQaPage() {
        WebElement buttonPath = driver.findElement(By.xpath("//a[contains(text(),'View Role')]"));
        clickElement(buttonPath);
    }

    public String getUrl() {
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
}
