import Pages.BasePage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class HomePageTest extends BaseTest{

    HomePage homePage;

    @Test(priority=1)
    public void testHomePage()
    {
        homePage = new HomePage(driver);
        homePage.closeCookie();
        homePage.getTitleHomePage();
        String actualHomePageTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
        Assert.assertEquals(actualHomePageTitle,homePage.getTitleHomePage());
    }

}
