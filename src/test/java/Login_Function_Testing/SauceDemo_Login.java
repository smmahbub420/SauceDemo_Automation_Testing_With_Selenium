package Login_Function_Testing;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
public class SauceDemo_Login {
    WebDriver driver;
    @FindBy(id = "user-name")
    WebElement UserName;
    @FindBy(id = "password")
    WebElement PassWord;
    @FindBy(id = "login-button")
    WebElement loginbtn;
    @FindBy(xpath = "//span[contains(.,'Products')]")
    WebElement AssertGet;
    @FindBy(xpath = "//h3[@data-test='error'][contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    WebElement Error;
    public SauceDemo_Login(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }
    public String Login_with_valid_credentials(String username, String password) throws IOException, ParseException, InterruptedException {

        UserName.sendKeys(username);
        PassWord.sendKeys(password);
        loginbtn.click();
        Thread.sleep(2000);
        return AssertGet.getText();
    }
    public String Login_with_Invalid_credentials(String username, String password) throws IOException, ParseException, InterruptedException {

        UserName.sendKeys(username);
        PassWord.sendKeys(password);
        loginbtn.click();
        Thread.sleep(2000);
        return Error.getText();
    }
}
