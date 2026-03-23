import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstTest {

    public AndroidDriver driver;

    @BeforeTest
    public void setDriver() throws MalformedURLException {

        String appiumServerUrl = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL(appiumServerUrl),dc);
    }

    @Test
    public void TC_1(){
     //   AppiumBy.accessibilityId("Accessibility").findElement(driver).click();
        MobileBy.AccessibilityId("Accessibility").findElement(driver).click();
        MobileBy.AccessibilityId("Accessibility Node Querying").findElement(driver).click();
        try {

            WebElement checkbox = driver.findElement(By.xpath("\t\n" +
                    "(//android.widget.CheckBox[@resource-id=\"io.appium.android.apis:id/tasklist_finished\"])[3]"));

            if(!checkbox.isSelected()){
                checkbox.click();
            }

        } catch (Exception e) {

            System.out.println("Popup checkbox not displayed");

        }
        driver.navigate().back();
        MobileBy.AccessibilityId("Accessibility Node Provider").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Accessibility Service").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Custom View").findElement(driver).click();
        driver.navigate().back();
     //   driver.navigate().back();
    }
    @Test
    public void TC_2(){
        String text = MobileBy.AccessibilityId("Custom View").findElement(driver).getText();
        Assert.assertEquals(text,"Custom View","Custom View Displayed");
        driver.navigate().back();
    }

    @Test
    public void TC_3() {
        MobileBy.AccessibilityId("Animation").findElement(driver).click();
        MobileBy.AccessibilityId("Bouncing Balls").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Cloning").findElement(driver).click();
        MobileBy.AccessibilityId("Run").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Custom Evaluator").findElement(driver).click();
        MobileBy.AccessibilityId("Play").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Events").findElement(driver).click();
        MobileBy.AccessibilityId("Play").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Loading").findElement(driver).click();
        MobileBy.AccessibilityId("Run").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Reversing").findElement(driver).click();
        MobileBy.AccessibilityId("Play").findElement(driver).click();
        MobileBy.AccessibilityId("Reverse").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Seeking").findElement(driver).click();
        MobileBy.AccessibilityId("Run").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("View Flip").findElement(driver).click();
        MobileBy.AccessibilityId("Flip").findElement(driver).click();
        driver.navigate().back();
        MobileBy.AccessibilityId("Default Layout Animations").findElement(driver).click();
        int i = 1;
        while (i<=3){
            MobileBy.AccessibilityId("Add Button").findElement(driver).click();
            i++;
        }
        driver.navigate().back();
        MobileBy.AccessibilityId("Layout Animations").findElement(driver).click();
        driver.navigate().back();
        //driver.navigate().back();
    }


    @AfterTest
    public void close(){
        driver.quit();
        }
}
