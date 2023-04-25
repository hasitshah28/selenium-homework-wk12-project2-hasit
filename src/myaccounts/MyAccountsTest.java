package myaccounts;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


     //1.1 create method with name "selectMyAccountOptions" it has one parameter name
    //Create the class MyAccountsTest
    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    //1.2 This method should click on the options whatever name is passed as parameter.
    // (Hint: Handle List of Element and Select options)
    public void selectMyAccountOptions(String option) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(option)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
        }

    }

    @Test
        //    1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        selectMyAccountOptions("Register");
        //“Register”
        // 1.3 Verify the text “Register Account”.
        verifyFromElement(By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");
    }

    @Test
    //    2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        verifyFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");
    }

    @Test
        //    3. Test name verifyThatUserRegisterAccountSuccessfully()
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.name("firstname"), "Gabbar");
        //3.4 Enter Last Name
        sendTextToElement(By.name("lastname"), "Singh");
        //3.5 Enter Email
        sendTextToElement(By.name("email"), "qwe1232567@gmail.com");
//3.6 Enter Telephone
        sendTextToElement(By.name("telephone"), "1234567890");
//3.7 Enter Password
        sendTextToElement(By.id("input-password"), "qwe123");
//3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "qwe123");
//3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("(//input[@type='radio'])[2]"));
//3.10 Click on Privacy Policy check box
        clickOnElement(By.name("agree"));
//3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@type='submit']"));
//3.12 Verify the message “Your Account Has Been Created!”
        verifyFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");
//3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
//3.14 Clickr on My Account Link.
        clickOnElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]"));
//3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
//            3.16 Verify the text “Account Logout”
        verifyFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
//            3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
//    4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
//4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
//4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
//4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "qwe12325@gmail.com");
//4.5 Enter Password
        sendTextToElement(By.name("password"), "qwe123");
//4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
//4.7 Verify text “My Account”
        verifyFromElement(By.xpath("//h2[contains(text(),'My Account')]"), "My Account");
//            4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
//4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
//            4.10 Verify the text “Account Logout”
        verifyFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
//            4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
