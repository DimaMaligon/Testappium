import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jdk.internal.jline.internal.TestAccessible;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.URL;

public class MobileWebTest {


    public void testIncorrectFBLogin() throws Exception{
        URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"S");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_7_2012_Android_5");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME , "Browser");


        System.out.println("Step 1. Create new driver");
        AppiumDriver driver = new AndroidDriver(serverURL, capabilities);
        WebDriverWait wait = new WebDriverWait(driver,  30);

        System.out.println("Step 2. Open website");
        driver.get("http://ek.ua/");

        System.out.println("Step 3. Enter search button");
        driver.findElement(By.name("search_")).sendKeys("GeForce");

        System.out.println("Step 4. Click Search button");
        driver.findElement(By.name("search_but_")).click();

        Thread.sleep(5000);
        System.out.println("Step 5. Check result");

        String expectedResult = "Видеокарты Nvidia";
        String actualResult = driver.findElement(By.className("t2")).getText();
        Boolean resultCheck = driver.findElement(By.className("t2")).getText().contains(expectedResult);

        System.out.println("Expected result: " + expectedResult);
        System.out.println("Actual result: " + actualResult);
        System.out.println("Check result: " + resultCheck);

        Assert.assertTrue(driver.findElement(By.className("t2")).getText().contains(expectedResult));

        System.out.println("Step 6. Class driver");
        driver.quit();




    }




}
