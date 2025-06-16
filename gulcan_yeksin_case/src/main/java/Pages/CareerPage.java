package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class CareerPage extends BasePage{

   public  WebDriver driver;

    public CareerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "career-our-location")
    WebElement locationsField;

    @FindBy(id = "career-find-our-calling")
    WebElement teamsField;

    @FindBy(css = "section[data-id='a8e7b90']")
    WebElement lifeatInsiderField;

    @FindBy(css = "a[href*='/open-positions/']")
    WebElement findYourDreamJobButton;

    public void waitForLoadingPage(){
        waitUntilElementIsVisible(teamsField);
        waitUntilElementIsVisible(locationsField);
        waitUntilElementIsVisible(lifeatInsiderField);
    }

    public Boolean locationFieldIsDisplayed(){
       return locationsField.isDisplayed();
    }
    public Boolean teamsFieldIsDisplayed(){
        return teamsField.isDisplayed();
    }
    public Boolean lifeatInsiderFieldIsDisplayed(){
        return lifeatInsiderField.isDisplayed();
    }

    public void clickFindYourDreamJobButton(){
        findYourDreamJobButton.click();
    }
}
