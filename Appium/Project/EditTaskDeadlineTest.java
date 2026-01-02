package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditTaskDeadlineTest {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\0035IR744\\Downloads\\ts-todo-list-v1.apk");

        // Set any additional required capabilities here
        options.setDeviceName("Android_Emulator");

        // To accept any activity start like splash
        options.setCapability("appWaitActivity", "*");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void editTaskAddDeadline() throws InterruptedException {
        // 1. Wait a little if needed
        Thread.sleep(2000);

        // 2. Locate the first task element
        WebElement firstTask = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.example.todoapp:id/taskNameTextView'][1]"));

        // 3. Long press the first task to enter edit mode
        new TouchAction(driver)
                .longPress(LongPressOptions.longPressOptions()
                              .withElement(ElementOption.element(firstTask))
                              .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();

        // 4. Wait for edit screen
        Thread.sleep(1000);

        // 5. Locate deadline field and click it
        driver.findElement(AppiumBy.id("com.example.todoapp:id/deadlineButton")).click();

        // 6. Compute next Saturday date
        LocalDate today = LocalDate.now();
        LocalDate nextSaturday = today.plusDays((6 - today.getDayOfWeek().getValue() + 7) % 7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String deadlineText = formatter.format(nextSaturday);

        // 7. Send next Saturday date into date input
        WebElement dateInput = driver.findElement(AppiumBy.id("com.app.todoapp:id/deadlineEditText"));
        dateInput.clear();
        dateInput.sendKeys(deadlineText);

        // 8. Save edited task
        driver.findElement(AppiumBy.id("com.app.todoapp:id/saveButton")).click();

        // 9. Wait for save
        Thread.sleep(1000);

        // 10. Locate the deadline text shown in the list (or task detail)
        WebElement shownDeadline = driver.findElement(AppiumBy.id("com.app.todoapp:id/taskDeadlineTextView"));

        // 11. Assert the correct deadline is displayed
        Assert.assertTrue(shownDeadline.getText().contains(deadlineText),
                "Deadline should contain next Saturday date: " + deadlineText);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
