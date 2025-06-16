import Pages.BasePage;
import Pages.CareerPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareerPageTest extends BaseTest {

    @Test(priority = 1)
    public void TeamsFieldControl() {
    CareerPage careerPage = new CareerPage(driver);
        careerPage.openCareersPage();
        careerPage.waitForLoadingPage();
        Assert.assertEquals(true,careerPage.locationFieldIsDisplayed());
        Assert.assertEquals(true,careerPage.teamsFieldIsDisplayed());
        Assert.assertEquals(true,careerPage.lifeatInsiderFieldIsDisplayed());
        careerPage.clickFindYourDreamJobButton();
    }
}
