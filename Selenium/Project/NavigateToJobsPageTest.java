package examplesTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigateToJobsPageTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set path to GeckoDriver executable
        //System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");

        // Launch Firefox browser
        driver = new FirefoxDriver();
    }

    @Test
    public void navigateToJobsPage() {
        // a. Open the site
        driver.get("https://alchemy.hguy.co/jobs/");

        // c & d. Click the "Jobs" link in the navigation bar
        driver.findElement(By.cssSelector("a[href='https://alchemy.hguy.co/jobs/jobs/']")).click();


        // e. Verify page title contains "Jobs"
        String pageTitle = driver.getTitle();
        System.out.println("Page Title after click: " + pageTitle);

        // Expected title part (modify if exact differs)
        Assert.assertTrue(pageTitle.contains("Jobs"), "Title does not contain 'Jobs'");
    }

    @AfterTest
    public void teardown() {
        // f. Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
