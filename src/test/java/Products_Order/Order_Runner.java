package Products_Order;
import Hepling_File.Setup_Page;
import Hepling_File.Attachments_Class;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class Order_Runner extends Setup_Page {
    Product_Order object1;
    Attachments_Class SS;
    @Test(enabled = true, priority = 0)
    public void Purchase_Backpack() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        object1 = new Product_Order(driver);
        SS = new Attachments_Class(driver);
        SS.readJSONArray(0);
        String nn3 = object1.Purchase_Backpack(SS.getUsername(), SS.getPassword());
        Assert.assertEquals(nn3, "THANK YOU FOR YOUR ORDER");
        System.out.println("Assertion Done ! Result::> " + nn3);
    }
}
