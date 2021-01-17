package sky.support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver webdriver;

    private static String browser = ConfigHelper.valueFor("browser");
    ;

    public synchronized static WebDriver getCurrentDriver() {


        if (webdriver == null) {
            webdriver = createWebDriver();
            webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return webdriver;
    }
/////
public static void checkPageIsReady() throws InterruptedException {


    JavascriptExecutor js = (JavascriptExecutor) webdriver;


    while (true) {
        if ((Boolean) (js.executeScript("return jQuery.active == 0"))) {
            break;
        }
        Thread.sleep(100);
    }


    //This loop will rotate for 25 times to check If page Is ready after every 1 second.
    //You can replace your value with 25 If you wants to Increase or decrease wait time.
    for (int i = 0; i < 25; i++) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        //To check page ready state.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            break;
        }
    }
}
    /////

    private static WebDriver createWebDriver() {

        setDriverFileProperty(browser);

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                return new ChromeDriver(chromeOptions);

            case "firefox":
                return new FirefoxDriver();

            default:
                throw new WebDriverException("No browser specified");
        }
    }

    private static void setDriverFileProperty(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
                break;
            default:
                throw new WebDriverException("No browser specified");
        }
    }
}
