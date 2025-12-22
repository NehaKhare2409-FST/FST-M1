package examplesTestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitleWithFirefox {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set GeckoDriver path (update to your actual path)
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");

        // Launch Firefox browser
        driver = new FirefoxDriver();
    }

    @Test
    public void verifyTitle() {
        // Navigate to the Job Board application
        driver.get("https://alchemy.hguy.co/jobs/");

        // Get actual page title
        String actualTitle = driver.getTitle();

        // Print actual title to console
        System.out.println("Page Title: " + actualTitle);

        // Expected title
        String expectedTitle = "Alchemy Jobs – Job Board Application";

        // Assertion - check title exactly matches expected
        Assert.assertEquals(actualTitle, expectedTitle, "Title did NOT match!");
    }

    @AfterTest
    public void teardown() {
        // Close the browser
        if(driver != null) {
            driver.quit();
        }
    }
}
