package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.*;

public class Q04 {

    // ...Practice 4...
    // Create chrome driver by using @Before annotation and WebDriverManager
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculator under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Assert the result
    // Print the result
    // Close the browser by using @After annotation

    WebDriver driver;

    @Before
    public void setUp() {
        // Create chrome driver by using @Before annotation and WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {

// Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        //    //Select 'divide' operation
        WebElement functionDropDown = driver.findElement(By.id("function"));
        new Select(functionDropDown).selectByVisibleText("divide");

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");
        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("4");
        // Click on Calculate
        driver.findElement(By.id("calculate")).click();
        // Get the result
        String result = driver.findElement(By.id("answer")).getText();
        // Assert the result
        assertEquals("10",result);
        // Print the result
        System.out.println("result = " + result);
        // Close the browser by using @After annotation

    }
    @Test
    public void divisionTest(){
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        //Select 'divide' operation
        WebElement functionDropDown = driver.findElement(By.id("function"));
        new Select(functionDropDown).selectByVisibleText("divide");


        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("2");


        // Click on Calculate
        driver.findElement(By.id("calculate")).click();

        // Get the result
        String result = driver.findElement(By.id("answer")).getText();

        // Assert the result
        assertEquals("3",result);

        // Print the result
        System.out.println("result = " + result);

    }


    @After
    public void tearDown() {
    driver.quit();

    }

    public static class AutomationTester {

         /*
            ===========Approach for Automation========

        1) I read the acceptance criteria very very carefully
        2) I then create my test case
        3) Then I do "Manual Testing" FIRST helps us to undrestand THE APPLICATION
        4) If all above good, I start complete my automation script
        4) If I find any bug/defect, then I talk to dev. Dev fixes the issue, then I reset.If all is good then start my AUTOMATION
        5) when Automation is complete, I prepare the report for the user story. In fact, My Automation script generate html
        reports for us, I upload those reports to the JIRA.
        for my MANUAL test cases, I manually take screenshots and prepare reports and attach them to the JIRA.
    -------------------------------------------------
        WHAT DO WE DO WHEN OUR TEST CASE PASS ?
        - Prepare report and upload to JIRA
    --------------------------------------------------
        WHAT DO YOU DO WHEN YOUR TEST CASE FAILS?
        -Retest to make sure from the failure.It can be data issue, typo, documentation issue or is can be a real bug.
        -If that is a bug, then talk to the dev and let them fix the bug.
        -After the fix, we retest. when test cases passes we upload to JIRA
    ------------------------------------------------
        WHAT DO YOU DO WHEN YOU FIND A BUG ?
        -Retest to make sure from the failure.It can be data issue, typo, documentation issue or is can be a real bug.
        -If that is a bug, then talk to the dev and let them fix the bug.
        -After the fix, we retest. when test cases passes we upload to JIRA
    ------------------------------------------------
             */
        /*
         * How many locators are there? there are 8 Locators

         * What are they? id, name, className, tagName,linkText & partialLinkText AND Dynamic Locators are cssSelectors & xpath

         * Which one do you prefer? Why? they all be use case by case,if we do not choose the correct Locator, driver gets runtime exception:
           NoSuchElementException

         * What is difference between absolute xpath and relative xpath?
          1- in Xpath we use / but // in relative xpath
          2- can't skip a child in xpath but in relative we can skip
          3- in xpath we need to go one by one from parent to child but in relative xpath we can go to certain element
          4- Relative xpath is recommended to use because there are multiple ways to write dynamic xpath
          -xpath is not recommended to use coz it  can be broken we add new element

         * What is the difference between xpath and css selector?
          1- css is faster and better
          2- xpath navigates the target on the browser to locate but css directly locate the target
          3- xpath is more common to use
          4- xpath is easier to use with index
          5- css is more rial-able because its locators are the same in different browsers.
          6- they both have diff syntax
         */

    }
}