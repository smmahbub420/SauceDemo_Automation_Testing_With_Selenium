package Login_Function_Testing;
import Hepling_File.Setup_Page;
import Hepling_File.Attachments_Class;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
public class SauceDemo_Runner extends Setup_Page {
    SauceDemo_Login object;
    Attachments_Class SS;
    @Test(enabled = true, priority = 0)
    public void Login_with_valid_credentials() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        object = new SauceDemo_Login(driver);
        SS = new Attachments_Class(driver);
        SS.readJSONArray(0);
        String R = object.Login_with_valid_credentials(SS.getUsername(), SS.getPassword());
        Assert.assertEquals(R, "PRODUCTS");
        System.out.println("Result -> " + R);
    }
    @Test(enabled = true, priority = 1)
    public void Login_with_Invalid_credentials() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        object = new SauceDemo_Login(driver);
        SS = new Attachments_Class(driver);
        SS.readJSONArray(1);
        String R1 = object.Login_with_Invalid_credentials(SS.getUsername(), SS.getPassword());
        Assert.assertEquals(R1, "Epic sadface: Username and password do not match any user in this service");
        System.out.println("Result ->" + R1);
    }
}
