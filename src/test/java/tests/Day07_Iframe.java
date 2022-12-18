package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day07_Iframe extends TestBase {
/*                                   ====Iframe====
• Iframe is used to embed a new map, video, page on a page. It kind of creates a page within a page
• Selenium cannot directly see the elements inside an iframe if there is an iframe on a page.
◦ When there is an iframe, we must first switch() to the iframe

★There are 3 ways to switch to iframe : by index, id/name, or web element

• driver.switchTo().frame(index of the iframe);//index start from 0
• driver.switchTo().frame(“id or name of the iframe");
• driver.switchTo().frame(WebElement of the iframe);//WebElement using any locators like xpath,..
• Switching back to parent / default frame:

◦ driver.switchTo().parentFrame(); to get back to parent frame.let you go only 1 upper level.
◦ driver.switchTo().defaultContent(); to get back to main/most upper page. Let you go multiple upper level .
◦ driver.findElements(By.tagName(“iframe”)); returns the total number of iframe on a page
 */

/* TEST Case:
Create a class: IFrame
Create a method: iframeTest
Go to https://the-internet.herokuapp.com/iframe
Verify the Bolded text contains “Editor”
Locate the text box
Delete the text in the text box
Type “This text box is inside the iframe”
Verify the text Elemental Selenium text is displayed on the page
 */
    @Test
    public void iframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        // Verify the Bolded text contains “Editor”   ===> this header is outside the IFrame that is why we do not need to switch to IFrame
        String header = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(header.contains("Editor"));

        // Locate the text box     ===> NOTE : THIS IS INSIDE THE IFRAME SO WE NEED TO SWITCH

        // GETTING INSIDE THE FRAME == > THERE ARE TREE WAYS
        driver.switchTo().frame(0); //INDEX
//      driver.switchTo().frame("mce_0_ifr"); // ID or NAME ==> PREFERRED ONE
//      driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))); // WEBELEMENT OF IFRAME
        WebElement box = driver.findElement(By.xpath("//p"));

        // Delete the text in the text box
        box.clear();//clear() is used to delete the text is the elements

        //Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");

        //  SO FAR DRIVER IS IN THE IFRAME BUT Elemental Selenium text IS OUTSIDE OF THE FRAME
//        GETTING OUT OF THE FRAME
        driver.switchTo().parentFrame();
//        ALTERNATIVELY WE CAN USE defaultContent()
//        Verify the text Elemental Selenium text is displayed on the page
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());


    }
    /*
    What might be the reason for your test case to fail?:

    1- There may be wait problem. The page may be very slow. Internet maybe not fast enough.
    2- Put some more wait. We can use explicit wait in selenium(we will learn later)
    3- Locator might be incorrect.  ==> Double check locator and fix if needed
    4- Data issue. Typo in our expected values.
    5- If there is any documentation issue, we can talk to BA to fix the document and then we can use correct expected values

    6- Maybe there is an iframe on the page ==>  We first need to switch to the frame

    It may be a real bug that is caused by the latest codes ==> We discuss the issue with the team then raise a bug ticket if needed
     */

}
