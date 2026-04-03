package Tests;

import Base.APK_Automation;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class TestRunner extends APK_Automation {

    @Test
    public void TC_1(){
        // Click Accessibility
        getDriver().findElement(MobileBy.AccessibilityId("Accessibility")).click();
        getDriver().findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();

        try {
            WebElement checkbox = getDriver().findElement(By.xpath(
                    "(//android.widget.CheckBox[@resource-id='io.appium.android.apis:id/tasklist_finished'])[3]"
            ));
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        } catch (Exception e) {
            System.out.println("Popup checkbox not displayed");
        }

        getDriver().navigate().back();
        getDriver().findElement(MobileBy.AccessibilityId("Accessibility Node Provider")).click();
        getDriver().navigate().back();
        getDriver().findElement(MobileBy.AccessibilityId("Accessibility Service")).click();
        getDriver().navigate().back();
        getDriver().findElement(MobileBy.AccessibilityId("Custom View")).click();
        getDriver().navigate().back();
    }

    @Test
    public void TC_2(){
        // Click Accessibility
        getDriver().findElement(MobileBy.AccessibilityId("Accessibility")).click();
        String text = getDriver().findElement(MobileBy.AccessibilityId("Custom View")).getText();
        Assert.assertEquals(text, "Custom View", "Custom View Displayed");
        getDriver().navigate().back();
    }

    @Test
    public void TC_3() {
        try {
            getDriver().findElement(MobileBy.AccessibilityId("Animation")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Bouncing Balls")).click();
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("Cloning")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Run")).click();
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("Custom Evaluator")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Play")).click();
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("Events")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Play")).click();
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("Loading")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Run")).click();
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("Reversing")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Play")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Reverse")).click();
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("Seeking")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Run")).click();
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("View Flip")).click();
            getDriver().findElement(MobileBy.AccessibilityId("Flip")).click();
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("Default Layout Animations")).click();
            for(int i = 0; i < 3; i++){
                getDriver().findElement(MobileBy.AccessibilityId("Add Button")).click();
            }
            getDriver().navigate().back();

            getDriver().findElement(MobileBy.AccessibilityId("Layout Animations")).click();
            getDriver().navigate().back();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TC_4(){
        getDriver().findElement(MobileBy.AccessibilityId("Animation")).click();
        getDriver().findElement(MobileBy.AccessibilityId("Bouncing Balls")).click();
        getDriver().navigate().back();
        getDriver().findElement(MobileBy.AccessibilityId("Layout Animations")).click();
        getDriver().navigate().back();
    }

    @Test
    public void TC_5(){
        getDriver().findElement(MobileBy.AccessibilityId("Animation")).click();
        getDriver().findElement(MobileBy.AccessibilityId("Layout Animations")).click();
        getDriver().navigate().back();
    }
}