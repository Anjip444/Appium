import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import javafx.scene.input.KeyCode;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;

public class Gestures {

    public static void gesturesTest(AndroidDriver<AndroidElement> driver){
        TouchAction t = new TouchAction(driver);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))").click();
        //driver.findElementByAndroidUIAutomator("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
        WebElement customAdapter = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
        t.tap(tapOptions().withElement(element(customAdapter))).perform();
        t.longPress(longPressOptions().withElement(element(driver.findElementByAndroidUIAutomator("text(\"People Names\")")))).perform();
        //driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
    }

    public static void swipeElement(AndroidDriver<AndroidElement> driver) throws Exception{
        TouchAction t = new TouchAction(driver);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))").click();
        driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement dest = driver.findElementByXPath("//*[@content-desc='45']");
        t.longPress(longPressOptions().withElement(element(first)).withDuration(Duration.ofMillis(2000))).moveTo(element(dest)).release().perform();
        File fi = (driver.getScreenshotAs(OutputType.FILE));
        FileUtils.copyFile(fi,new File("/Users/panjane1/Desktop/IES/AutoMobilePrj/src/main/resources/Screens"+"screen.img"));
        driver.navigate().back();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        System.out.println(driver.isDeviceLocked());
        System.out.println(driver.getBatteryInfo());
        System.out.println("the context is : "+driver.getContext());
        driver.lockDevice();
        driver.unlockDevice();
    }
}
