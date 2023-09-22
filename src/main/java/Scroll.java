import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Scroll {
    AndroidDriver driver;

    @Test
    public void deneme() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        scrollDown();
    }


    public void scrollDown() {
        int startX = driver.manage().window().getSize().getWidth() / 2; //250
        int startY = driver.manage().window().getSize().getHeight() * 3 / 4; //1500
        int endx = driver.manage().window().getSize().getWidth() / 2; //250
        int endy = driver.manage().window().getSize().getHeight() * 1 / 4; //500

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "sdadsaads");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endx, endy));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));
    }

    public void scrollUp() {
        int startX = driver.manage().window().getSize().getWidth() / 2; //250
        int startY = driver.manage().window().getSize().getHeight() * 1 / 4; //500
        int endx = driver.manage().window().getSize().getWidth() / 2; //250
        int endy = driver.manage().window().getSize().getHeight() * 3 / 4; //1500

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "sdadsaads");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endx, endy));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));
    }

    public void swipeRight() {
        int startX = driver.manage().window().getSize().getWidth() * 1 / 4; //100
        int startY = driver.manage().window().getSize().getHeight() / 2; //1000
        int endx = driver.manage().window().getSize().getWidth() * 3 / 4; //400
        int endy = driver.manage().window().getSize().getHeight() / 2; //1000

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "sdadsaads");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endx, endy));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));
    }

    public void swipeLeft() {
        int startX = driver.manage().window().getSize().getWidth() * 3 / 4; //400
        int startY = driver.manage().window().getSize().getHeight() / 2; //1000
        int endx = driver.manage().window().getSize().getWidth() * 1 / 4; //100
        int endy = driver.manage().window().getSize().getHeight() / 2; //1000

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "sdadsaads");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endx, endy));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));
    }


}
