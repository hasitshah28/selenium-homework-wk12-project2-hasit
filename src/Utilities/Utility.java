package Utilities;

import basetest.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        driver.findElement(by).click();

    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        //    driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void verifyFromElement(By by, String text){
        String expextedMessage = text;
        WebElement actualelement = driver.findElement(by);
        String actualmessage = actualelement.getText();
        Assert.assertEquals(expextedMessage,actualmessage);
    }
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text); // Black colour text
    }
    public void selectByValueTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByValue(text);

    }

    public void selectByIndexFromDropDown(By by, int i) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(i);
    }

    public void closeBrowser() {
        driver.quit();
    }
    }

