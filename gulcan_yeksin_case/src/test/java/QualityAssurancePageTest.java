import Pages.QualityAssurancePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QualityAssurancePageTest extends BaseTest {

    @Test
    public void openQualityAssurancePage() {
        QualityAssurancePage qualityAssurancePage = new QualityAssurancePage(driver);
        qualityAssurancePage.openQaPage();
        qualityAssurancePage.waitPageLoad();
        Assert.assertEquals("https://useinsider.com/careers/open-positions/",qualityAssurancePage.getUrl());

    }
}
