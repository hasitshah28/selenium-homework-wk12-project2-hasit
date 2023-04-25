package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

        // 1. create class "TopMenuTest"
        // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
        // 1.2 This method should click on the menu whatever name is passed as parameter.
        //   Write the following Test:
        public void selectMenu(String menu) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']//div"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']//div"));
        }

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException{
        // 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        Thread.sleep(2000);
        selectMenu("Show AllDesktops");
        // 1.3 Verify the text ‘Desktops’
        verifyFromElement(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");

    }

    @Test
        // 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));

         //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        // 2.3 Verify the text ‘Laptops & Notebooks’
        verifyFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
    }

    @Test
        //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Components']"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");

        //3.3 Verify the text ‘Components’
        verifyFromElement(By.xpath("//h2[text()='Components']"),"Components");
    }
    @After
    public void tearDown() {
         closeBrowser();
    }
}
