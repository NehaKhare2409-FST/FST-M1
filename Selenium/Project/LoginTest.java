package examplesTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set path to geckodriver (FirefoxDriver)
        //System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");

        // Initialize Firefox browser
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginToWordPress() throws InterruptedException {
        // Navigate to WordPress admin login page
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        // Enter Username
        WebElement usernameInput = driver.findElement(By.id("user_login"));
        usernameInput.sendKeys("root");

        // Enter Password
        WebElement passwordInput = driver.findElement(By.id("user_pass"));
        passwordInput.sendKeys("pa$$w0rd");

        // Click Login
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();

        // Small wait (for page to load)
        Thread.sleep(3000);

        // Verify you are logged in by checking Dashboard title
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Dashboard"), "Login failed or Dashboard not loaded.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
