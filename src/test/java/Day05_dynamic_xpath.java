import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_dynamic_xpath {      /* Test case:
                                          _ verify if 2username :Admin" is text is displayed on the page
                                          _ if "Password : admin123" text is displayed on the page
                                                            */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void dynamicXpath(){

     //   Dynamic==>         1. XPATH = //*[.=TEXT OF THE ELEMENT']
    // first part of test  _ verify if "username :Admin" is text is displayed on the page

 //      "//[.='Username : Admin']"   ===> return the element whose text = username :Admin
        WebElement userNameText = driver.findElement(By.xpath("//*[.='Username : Admin']"));
        Assert.assertTrue(userNameText.isDisplayed());

    // second part of test ; _ if "Password : admin123" text is displayed on the page
        WebElement passwordText = driver.findElement(By.xpath("//*[.='Password : admin123']"));
        Assert.assertTrue(passwordText.isDisplayed());

    //   Dynamic==>         2. XPATH = //[(text()='TEXT OF THE ELEMENT')]
        WebElement userNameText01 = driver.findElement(By.xpath("//*[(text()='Username : Admin')]"));
        Assert.assertTrue(userNameText01.isDisplayed());


    }















}
