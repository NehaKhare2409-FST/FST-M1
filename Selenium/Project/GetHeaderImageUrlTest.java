package examplesTestNG;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetHeaderImageUrlTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set path to GeckoDriver
        //System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");

        // Launch Firefox
        driver = new FirefoxDriver();
    }

    @Test
    public void printHeaderImageUrl() {
        // Open the Job Board website
        driver.get("https://alchemy.hguy.co/jobs/");

        // Locate the header image element
        // Example: find first img in header — update if required based on actual HTML
        WebElement headerImage = driver.findElement(By.xpath("//header//img"));

        // Get the "src" attribute = URL of the image
        String imageUrl = headerImage.getAttribute("src");

        // Print URL to the console
        System.out.println("Header image URL: " + imageUrl);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
