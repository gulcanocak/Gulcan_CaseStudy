package Pages;

import Pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ListJobPage extends BasePage {

    public WebDriver driver;

    public ListJobPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "page-head")
    WebElement pageHeadSection;

    @FindBy(id = "career-position-filter")
    WebElement jobFilterSection;

    @FindBy(id = "select2-filter-by-location-container")
    WebElement locationFilterDropdown;

    @FindBy(id = "select2-filter-by-location-results")
    WebElement locationFilterResults;

    @FindBy(xpath = "//li[@id='select2-filter-by-location-result-vxql-Istanbul, Turkey']")  //deprecated
    WebElement istanbulLocationOption;

    @FindBy(id = "select2-filter-by-department-container")
    WebElement filterDepartmentDropdown;

    @FindBy(id = "select2-filter-by-department-results")
    WebElement departmentFilterResults;

    @FindBy(xpath = "//li[@id='select2-filter-by-department-result-7oh6-Quality Assurance']")  //deprecated
    WebElement qaDepartmentOption;

    @FindBy(css = "span ul li")
    List<WebElement> dropdownItems;

    @FindBy(id = "career-position-list")
    WebElement jobListSection;

    @FindBy(id = "pagination")
    WebElement paginationSection;

    @FindBy(css = ".position-list-item")
    List<WebElement> jobListingItems;

    public void waitPageLoad() {
        waitUntilElementIsVisible(pageHeadSection);
        waitUntilElementIsVisible(jobFilterSection);
        waitUntilElementIsVisible(filterDepartmentDropdown);
        waitUntilElementIsVisible(jobListSection);
        waitUntilElementIsVisible(paginationSection);
    }

    public void selectLocation(String locationSelection) throws InterruptedException {
        waitUntilClickable(locationFilterDropdown);
        Thread.sleep(5000);
        clickElement(locationFilterDropdown);
        waitUntilElementIsVisible(locationFilterResults);
        waitUntilAllElementIsVisible(dropdownItems);
        waitUntilAllElementClickable(dropdownItems);
        waitUntilElementIsVisible(locationFilterResults);
        Thread.sleep(5000);

        List<WebElement> filteredDepartments = dropdownItems.stream()
                .filter(opt -> opt.getText().equals(locationSelection))
                .collect(Collectors.toList());

        if (filteredDepartments.isEmpty()) {
            throw new NoSuchElementException("Location not Found : " + locationSelection);
        }
        WebElement locationtoToSelect = filteredDepartments.get(0);
        waitUntilClickable(locationtoToSelect);
        clickElement(locationtoToSelect);
    }

    public void Scroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> jobCards = new ArrayList<>();
        int previousCount = 0;

        while (true) {
            js.executeScript("window.scrollTo(0, 600);");
            Thread.sleep(2000);
            jobCards = driver.findElements(By.cssSelector(".job-listing-item"));

            if (jobCards.size() == previousCount) {
                break;
            }
            previousCount = jobCards.size();
        }
    }

    public void selectDepartment(String departmant) throws InterruptedException {
        waitUntilClickable(filterDepartmentDropdown);
        Thread.sleep(5000);
        clickElement(filterDepartmentDropdown);
        waitUntilElementIsVisible(departmentFilterResults);
        waitUntilAllElementIsVisible(dropdownItems);
        waitUntilAllElementClickable(dropdownItems);
        Thread.sleep(5000);

        List<WebElement> filteredDepartments = dropdownItems.stream()
                .filter(opt -> opt.getText().equals(departmant))
                .collect(Collectors.toList());

        if (filteredDepartments.isEmpty()) {
            throw new NoSuchElementException("Location not Found : " + departmant);
        }
        WebElement departmenttoToSelect = filteredDepartments.get(0);
        waitUntilClickable(departmenttoToSelect);
        clickElement(departmenttoToSelect);
    }

    public boolean areJobListingsPresent() throws InterruptedException {
        Scroll();
        waitUntilAllElementIsVisible(jobListingItems);
        return jobListingItems != null && !jobListingItems.isEmpty();
    }

    public boolean verifyJobListingResults(String locationSelection, String departmentSelection, String position) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".position-list-item")));

        List<String> jobDepartment = new ArrayList<>();
        Boolean areJobPositionsCorrect;
        Boolean areJobLocationsCorrect;
        Boolean positionCorrection;
        Thread.sleep(5000);

        //For Department
        for (WebElement item : driver.findElements(By.cssSelector(".position-list-item"))) {
            try {
                String department = item.findElement(By.cssSelector(".position-department")).getText();
                jobDepartment.add(department);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                System.out.println("Could not get Element: " + e.getMessage());
            }
        }

        if (jobDepartment.isEmpty()) {
            areJobLocationsCorrect = true;
        } else {
            areJobLocationsCorrect = jobDepartment.stream()
                    .allMatch(dept -> dept.equals(departmentSelection));
        }

        //For Location

        List<String> jobLocation = new ArrayList<>();

        for (WebElement item : driver.findElements(By.cssSelector(".position-list-item"))) {
            try {
                String department = item.findElement(By.cssSelector(".position-location")).getText();
                jobLocation.add(department);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                System.out.println("Could not get Element: " + e.getMessage());
            }
        }
        if (jobDepartment.isEmpty()) {
            areJobPositionsCorrect = true;
        } else {
            areJobPositionsCorrect = jobDepartment.stream()
                    .allMatch(dept -> dept.equals(departmentSelection));
        }

        //**********

        List<String> jobPosition = new ArrayList<>();

        for (WebElement item : driver.findElements(By.cssSelector(".position-list-item"))) {
            try {
                String positionTitle = item.findElement(By.cssSelector(".position-title")).getText();
                jobPosition.add(positionTitle);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                System.out.println("Element alınamadı: " + e.getMessage());
                // Gerekirse burada yeniden deneme veya log ekleyebilirsiniz.
            }
        }
        if (jobPosition.isEmpty()) {
            positionCorrection = true;
        } else {
            positionCorrection = jobDepartment.stream()
                    .allMatch(dept -> dept.contains(position));
        }


        return areJobPositionsCorrect && areJobLocationsCorrect && positionCorrection;

    }

}