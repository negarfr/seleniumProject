import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day03_Locators {
    /*  here is the test :
        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
     Locate the elements of Username textbox, Password textbox, and Login button
     Enter below username and password then click on login button
             Username :  Admin
             Password :  admin123
     Verify the login is successful
     Sign out from the page

     */
    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//system will wait for 15 sec in any case in this test
        driver.manage().window().maximize();
        driver.get(" https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
     @Test
        public void logInTest() {

//Locate the elements of email textbox, password textbox, and signin button
        WebElement usernameTextBox = driver.findElement(By.name("username")); // locate username by findElement Method
        WebElement passwordTexBox = driver.findElement(By.name("password"));
        WebElement loginTextBox = driver.findElement(By.tagName("button"));

//  Enter below username and password then click on login button
//                        Username :  Admin
//                        Password :  admin123
        usernameTextBox.sendKeys("Admin");
        passwordTexBox.sendKeys("admin123");
        loginTextBox.click();

//      Assert the login is successful  ==>first go to page put password and username and log in, the URL comes up as bellow URL
//      1. we can sue page url to do assertion
//      2. we can use a specific element for the page for assertion

        //  https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index  ====> Current Url
        boolean actualValue = driver.getCurrentUrl().contains("dashboard");// need to create our own Logic for Assertion, here we used Dashboard
        assertTrue(actualValue);


//      Sign out from the page
    }
    @After
    public void signout(){
        driver.quit();
    }
}

