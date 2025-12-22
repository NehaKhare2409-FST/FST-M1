package examplesTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PostJobTest {

    WebDriver driver;
    WebDriverWait wait;

    String jobTitle = "Selenium Automation Engineer";
    String hardCodedEmail = "nha.k@gmail.com";

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().window().maximize();
    }

    @Test
    public void createJobListing() {

        // 1. Open jobs site
        driver.get("https://alchemy.hguy.co/jobs");

        // 2. Click "Post a Job"
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Post a Job"))).click();

        // 3. Fill in email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_email")))
            .sendKeys(hardCodedEmail);

        // 4. Job title
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_title")))
            .sendKeys(jobTitle);

        // 5. Location
        driver.findElement(By.id("job_location")).sendKeys("Remote");

        // 6. Enter description inside TinyMCE iframe
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("job_description_ifr")));

        WebElement editorBody = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body#tinymce"))
        );

        // Activate and type text
        editorBody.click();
        editorBody.clear();
        editorBody.sendKeys("This is a Selenium automation job posting.");

        // Switch back to main page
        driver.switchTo().defaultContent();

        // 7. Job type
        new Select(driver.findElement(By.id("job_type")))
                .selectByVisibleText("Full Time");

        // 8. Application URL
        driver.findElement(By.id("application")).sendKeys("https://example.com/apply");

        // 9. Company details
        driver.findElement(By.id("company_name")).sendKeys("Alchemy Corp");
        driver.findElement(By.id("company_website")).sendKeys("https://alchemy.hguy.co");

        // 10. Click Preview
        wait.until(ExpectedConditions.elementToBeClickable(By.name("submit_job"))).click();

        // 11. Wait for a Submit Listing button with flexible locator
        WebElement submitBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//input[@value='Submit Listing' or contains(@value,'Submit')]" +
                    " | //button[normalize-space() = 'Submit Listing' or contains(text(),'Submit')]"
                )
            )
        );

        // Scroll and click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

        // 12. Verify posted job
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Jobs"))).click();

        WebElement postedJob = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[text()='" + jobTitle + "']")
                )
        );

        Assert.assertTrue(postedJob.isDisplayed(),
                "Job listing was NOT created successfully");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
