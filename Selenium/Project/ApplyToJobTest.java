package examplesTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ApplyToJobTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void applyForBankingJob() {

        // a. Open site and navigate to Jobs page
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.findElement(By.linkText("Jobs")).click();

        // b. Search for Banking jobs
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("search_keywords"))
        );
        searchBox.clear();
        searchBox.sendKeys("Banking");

        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

        // Wait until results are shown
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.className("showing_jobs"), "Found"
        ));

        // c. Click the first job listed (Senior Banking)
        List<WebElement> jobs = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector("ul.job_listings li.job_listing a")
                )
        );

        jobs.get(0).click();   // Click first "Senior Banking"

        // d. Click Apply button and print email
        WebElement applyButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("application_button"))
        );
        applyButton.click();

        WebElement emailDetails = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("application_details"))
        );

        System.out.println("==== Application Email ====");
        System.out.println(emailDetails.getText());
    }

    // e. Close browser
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
