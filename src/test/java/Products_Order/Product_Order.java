package Products_Order;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
public class Product_Order {
    WebDriver driver;
    @FindBy(id = "user-name")
    WebElement UserName;
    @FindBy(id = "password")
    WebElement PassWord;

    @FindBy(id = "login-button")
    WebElement loginbtn;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement Addcardbtn;
    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement CartIconBtn;
    @FindBy(id = "checkout")
    WebElement chekotbtn;
    @FindBy(id = "first-name")
    WebElement namefld;
    @FindBy(id = "last-name")
    WebElement lastfld;
    @FindBy(id = "postal-code")
    WebElement postal_codefld;
    @FindBy(id = "continue")
    WebElement continuebtn;
    @FindBy(id = "finish")
    WebElement finishbtn;

    @FindBy(xpath = "//h2[contains(.,'THANK YOU FOR YOUR ORDER')]")
    WebElement CompleteAsstersion;

    public Product_Order(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }
    public String Purchase_Backpack(String username, String password) throws IOException, ParseException, InterruptedException {
        UserName.sendKeys(username);
        PassWord.sendKeys(password);
        loginbtn.click();
        Thread.sleep(2000);
        Addcardbtn.click();
        CartIconBtn.click();
        chekotbtn.click();
        Thread.sleep(2000);
        namefld.sendKeys("Mahbub");
        lastfld.sendKeys("Alam");
        postal_codefld.sendKeys("4585");
        Thread.sleep(2000);
        continuebtn.click();
        Thread.sleep(2000);
        finishbtn.click();
        Thread.sleep(2000);
        return CompleteAsstersion.getText();
    }

}
