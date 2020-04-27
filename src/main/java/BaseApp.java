import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class BaseApp {

    public static AndroidDriver<AndroidElement> capabilities()throws Exception{
        String appPath ="";
        String ipAdd ="192.168.0.102";
        //"/Users/panjane1/Desktop/IES/AutoMobilePrj/src/main/resources/ApiDemos-debug.apk"
        ///Users/panjane1/Desktop/UICatalog.app
        File fs = new File(new File(System.getProperty("user.dir")),"ApiDemos-debug.apk");
        //BaseApp.class.getClassLoader().getResource("ApiDemos-debug.apk")
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AJ_Fst");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/panjane1/Desktop/IES/AutoMobilePrj/src/main/resources/ApiDemos-debug.apk");
        //for real device:

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        //IOSDriver<IOSElement> iosDriver = new IOSDriver<IOSElement>(new URL("http://192.168.0.102:4723/wd/hub"),capabilities);
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(new URL("http://192.168.0.102:4723/wd/hub"),capabilities);
        return androidDriver;
    }
}
