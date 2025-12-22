package examplesTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifySecondHeadingTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        
        driver = new FirefoxDriver();
    }

    @Test
    public void verifySecondHeading() {
        // Navigate to the job board site
        driver.get("https://alchemy.hguy.co/jobs/");

        // Locate the second heading element (likely <h2>)
        WebElement secondHeading = driver.findElement(By.xpath("//h2[normalize-space(text())='Quia quis non']"));

        // Get text
        String actualText = secondHeading.getText();
        System.out.println("Second heading text: " + actualText);

        // Verify it matches expected
        String expectedText = "Quia quis non";
        Assert.assertEquals(actualText, expectedText, "Second heading DOES NOT match expected!");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
