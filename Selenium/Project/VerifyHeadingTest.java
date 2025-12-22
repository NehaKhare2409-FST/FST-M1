package examplesTestNG;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyHeadingTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set GeckoDriver path (update this to your actual path)
        //System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");

        // Launch Firefox
        driver = new FirefoxDriver();
    }

    @Test
    public void verifyHeadingText() {
        // Navigate to the job board
        driver.get("https://alchemy.hguy.co/jobs/");

        // Locate the heading element using robust XPath
        WebElement headingElement = driver.findElement(
            By.xpath("//*[contains(text(),'Welcome to Alchemy Jobs')]")
        );

        // Get the heading text
        String actualHeading = headingElement.getText();
        System.out.println("Heading text is: " + actualHeading);

        // Expected heading text
        String expectedHeading = "Welcome to Alchemy Jobs";

        // Verify heading exactly matches expected
        Assert.assertEquals(actualHeading, expectedHeading, "Heading text did NOT match!");
    }

    @AfterTest
    public void teardown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
