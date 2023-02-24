package Hepling_File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class Setup_Page {
    public WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void ScreenShot(ITestResult result) throws IOException {
        if (ITestResult.SUCCESS == result.getStatus()) {
            try {
                Attachments_Class util = new Attachments_Class(driver);
                util.takeScreenShot();
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
    }
    @AfterTest
    public void logout() {
        driver.close();
    }
}
