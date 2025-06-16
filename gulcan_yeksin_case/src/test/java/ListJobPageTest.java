import Pages.ListJobPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListJobPageTest extends BaseTest{


    @Test(priority = 1)
    public void testSelectJob() throws InterruptedException {

        ListJobPage listJobPage= new ListJobPage(driver);
        listJobPage.waitPageLoad();
        listJobPage.selectLocation("Istanbul, Turkiye");
    }

    @Test(priority = 2)
    public void testSelectDepartment() throws InterruptedException {

        ListJobPage listJobPage= new ListJobPage(driver);
        listJobPage.waitPageLoad();
        listJobPage.selectDepartment("Quality Assurance");

    }
    @Test(priority = 3)
    public void filterResult() throws InterruptedException {

        ListJobPage listJobPage= new ListJobPage(driver);
        listJobPage.waitPageLoad();
        Thread.sleep(5000);
        listJobPage.areJobListingsPresent();
        Thread.sleep(5000);
        Assert.assertEquals( listJobPage.verifyJobListingResults("Istanbul, Turkiye", "Quality Assurance","Quality Assurance"),true);
       // listJobPage.verifyJobListingResults("Istanbul, Turkiye", "Quality Assurance");
    }

}
