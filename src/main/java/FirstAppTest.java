import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.concurrent.TimeUnit;

public class FirstAppTest extends BaseApp{

    public static AndroidDriver<AndroidElement> driver;

    public static void main(String[] args) throws Exception{
        driver= capabilities();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //firstTest(driver);
        //Gestures.gesturesTest(driver);
        Gestures.swipeElement(driver);
    }

    public static void firstTest(AndroidDriver<AndroidElement> driver){
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("helloWifi");
        //driver.findElementById("android:id/button1").click();
        driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").get(1);
        driver.findElementByAndroidUIAutomator("text(\"OK\")").click();
       /* if((driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").getAttribute("enabled"))=="false"){
            driver.findElementById("android:id/checkbox").click();
            driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        }
        else{
            System.out.println("Is already enabled.");
        }*/
    }
}
