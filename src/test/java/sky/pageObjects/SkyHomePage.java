package sky.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SkyHomePage {

    @FindBy(how = How.CSS, using = "button[title=Agree]")
    public WebElement cookieAgree;

    @FindBy(how = How.CSS, using = ".primary-nav-list a[data-tracking-label=masthead_visit_primary_deals_link]")
    public  WebElement dealsLink;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
    public  WebElement signIn;

    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    public  WebElement username;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public  WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@id='signinButton']")
    public  WebElement clickSignIn;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Sorry, we did not recognise either your username or password')]")
    public  WebElement errorMessage;
//nav search
    @FindBy(how = How.CSS, using = "#masthead-search-toggle path")
    public  WebElement navSearchIcon;
//nav search text field
    @FindBy(how = How.CSS, using = ".search-tray input")
    public  WebElement SearchBox;
//nav search
    @FindBy(how = How.CSS, using = ".search-input-wrapper>button")
    public  WebElement searchIcon;
//editorial
    @FindBy(how = How.CSS, using = "#search-results-container > div.section-wrapper[data-test-id=\"editorial-section\"]")
    public  WebElement editorial;




}
