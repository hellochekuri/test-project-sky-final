package sky.pages;

import io.cucumber.java.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import sky.support.DriverFactory;

public class BasePage {

     static WebDriver driver = DriverFactory.getCurrentDriver();
//java script for wait statement
     private static void checkPageIsReady() throws InterruptedException {

          JavascriptExecutor js = (JavascriptExecutor) driver;


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


}
