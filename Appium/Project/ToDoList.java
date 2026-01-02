package activities;



import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ToDoList {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // 1. Set Appium desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Android_Emulator");
        options.setAutomationName("UiAutomator2");

        // 2. Path to your ToDo app (.apk file)
        options.setApp("C:\\Users\\0035IR744\\Downloads\\ts-todo-list-v1.apk");


        // 3. Initialize Appium driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void addTasksToDoList() throws InterruptedException {
        // 4. Tasks to add
        String[] tasks = {
            "Complete Activity 1 with priority high",
            "Complete Activity 2 with priority medium",
            "Complete Activity 3 with priority low"
        };

        for (String task : tasks) {
            // 5. Click "Add New Task" button
            driver.findElement(AppiumBy.id("com.app.todolist:id/fab_new_task")).click();

            // 6. Enter task title text
            WebElement titleInput = driver.findElement(AppiumBy.id("com.app.todoapp:id/titleEditText"));
            titleInput.sendKeys(task);

            // 7. Click "Save" button to save new task
            driver.findElement(AppiumBy.id("com.app.todoapp:id/saveButton")).click();

            // 8. Optional pause to allow UI to update
            Thread.sleep(1000);
        }

        // 9. Get list of all task entries from UI
        List<WebElement> allTasks = driver.findElements(AppiumBy.id("com.app.todoapp:id/taskNameTextView"));

        // 10. Assert at least 3 tasks have been added
        Assert.assertTrue(allTasks.size() >= 3, "At least 3 tasks should be present in list");

        // 11. Optional: verify each specific task text appears
        boolean found1 = allTasks.stream().anyMatch(e -> e.getText().contains("Complete Activity 1"));
        boolean found2 = allTasks.stream().anyMatch(e -> e.getText().contains("Complete Activity 2"));
        boolean found3 = allTasks.stream().anyMatch(e -> e.getText().contains("Complete Activity 3"));

        Assert.assertTrue(found1 && found2 && found3, "All specified tasks should be present");
    }

    @AfterClass
    public void teardown() {
        // 12. Quit driver when done
        if (driver != null) {
            driver.quit();
        }
    }
}

