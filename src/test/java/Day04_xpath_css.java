import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day04_xpath_css {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void loginTest(){
//        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        Locate the elements of Username textbox, Password textbox, and Login button
//        Enter below username and password then click on login button
//        Username :  Admin
//        Password :  admin123
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        Assert the login is successful


//        Sign out from the page

    }

    @Test
    public void loginTestCss(){
//        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        Locate the elements of Username textbox, Password textbox, and Login button
//        Enter below username and password then click on login button
//        Username :  Admin
//        Password :  admin123
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

//        Assert the login is successful
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }


    @After
    public void tearDown(){
        driver.quit();
   }


    /*
     * How many locators are there?

     * What are they?

     * Which one do you prefer? Why?

     * What is difference between absolute xpath and relative xpath?

     * What is the difference between xpath and css selector?

     */


}
