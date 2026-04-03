package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class APK_Automation {

    private ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters({"deviceName", "udid", "systemPort", "appiumServerUrl", "appPath"})
    public void setDriver(String deviceName, String udid, String systemPort, String appiumServerUrl, String appPath) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.APP, appPath);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        caps.setCapability("udid", udid);
        caps.setCapability("systemPort", Integer.parseInt(systemPort));

        // Optional stability configs
        caps.setCapability("noReset", false);
        caps.setCapability("newCommandTimeout", 300);

        AppiumDriver appiumDriver = new AndroidDriver(new URL(appiumServerUrl), caps);
        driver.set(appiumDriver);

        System.out.println("Started Appium session on device: " + deviceName + " | UDID: " + udid);
    }

    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            System.out.println("Driver quit successfully.");
        }
    }

    public AppiumDriver getDriver() {
        return driver.get();
    }
}