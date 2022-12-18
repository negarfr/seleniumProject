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

public class Day05_RadioButton {



    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
    }
    @Test
    public void test() throws InterruptedException {

    // click on Yello bottun
    Thread.sleep(3000); // to see the process
    WebElement yellow = driver.findElement(By.id("yellow"));
    yellow.click();

    // Assert yellow button
    assertTrue(yellow.isSelected());

    // click on black  bottun
    Thread.sleep(3000);
    WebElement  black = driver.findElement(By.id("black"));
    black.click();;

    // Assert that Yellow is selected
    assertTrue(black.isSelected());

    }

@After
    public void tearDown(){
        driver.quit();
}

}
