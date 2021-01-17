package sky.pages;


import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sky.pageObjects.SkyHomePage;
import sky.support.Storage;

import java.util.Set;


public class SkyShopHomePage  extends BasePage {
    private static final String HOME_PAGE = "http://sky.com";
    private static WebDriverWait wait = new WebDriverWait(driver, 10);
    private static Storage storage = Storage.getInstance();


    public  void openHomePage() throws InterruptedException {
        driver.get(HOME_PAGE);
        wait.until(ExpectedConditions.titleContains("Sky TV, Broadband & Mobile | News, Sports & Movies | Sky.com"));
        SkyHomePage skyHomePageObject = PageFactory.initElements(driver, SkyHomePage.class);
        storage.setStorageValue("skyHomePageObject", skyHomePageObject);

        Thread.sleep(2000);

        Actions action = new Actions(driver);
        for(int i=0;i<6;i++){
            action.sendKeys(Keys.TAB).build().perform();
        }
        action.sendKeys(Keys.ENTER).build().perform();
        //driver.switchTo().frame(1);

        //   skyHomePageObject.cookieAgree.click();
        //  skyHomePageObject.dealsLink.click();

    }

    public  void navigateToDealPage() {
        SkyHomePage skyHomePageObject = storage.getStorageValue("skyHomePageObject", SkyHomePage.class);
        //   skyHomePageObject.cookieAgree.click();
        skyHomePageObject.dealsLink.click();

        driver.getCurrentUrl();

    }

    public void login(String username, String password) {
        SkyHomePage skyHomePageObject = storage.getStorageValue("skyHomePageObject", SkyHomePage.class);
        wait.until(ExpectedConditions.elementToBeClickable(skyHomePageObject.signIn));
        skyHomePageObject.signIn.click();
        wait.until(ExpectedConditions.elementToBeClickable(skyHomePageObject.username));
        skyHomePageObject.username.sendKeys(username);
      //  wait.until(ExpectedConditions.elementToBeClickable(skyHomePageObject.password));
       // skyHomePageObject.password.click();
        skyHomePageObject.password.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(skyHomePageObject.clickSignIn));
        skyHomePageObject.clickSignIn.click();


    }

    public void assertLoginFailureMessage(String loginFailMessage) {
        SkyHomePage skyHomePageObject = storage.getStorageValue("skyHomePageObject", SkyHomePage.class);
        Assert.assertTrue(skyHomePageObject.errorMessage.isDisplayed());

    }

    public void searchForSky(String searchTerm) {
        SkyHomePage skyHomePageObject = storage.getStorageValue("skyHomePageObject", SkyHomePage.class);
        skyHomePageObject.navSearchIcon.click();
        skyHomePageObject.SearchBox.sendKeys(searchTerm);
        Assert.assertTrue(skyHomePageObject.editorial.isDisplayed());

    }
    public void checkEditorial() {
        SkyHomePage skyHomePageObject = storage.getStorageValue("skyHomePageObject", SkyHomePage.class);
        Assert.assertTrue(skyHomePageObject.editorial.isDisplayed());
    }

    @After
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}





