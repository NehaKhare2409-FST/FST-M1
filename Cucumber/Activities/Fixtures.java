package stepDefinition;


import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

public class Fixtures extends BaseClass {
	
    @BeforeAll
    public static void setUp() {
        // Initialize Firefox Driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @AfterAll
    public static void tearDown() {
        // Close the browser
        driver.quit();
    }
}