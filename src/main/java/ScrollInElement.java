import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ScrollInElement {


    AndroidDriver driver;

    @Test
    public void deneme() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        swipeLeftInElement(AppiumBy.id("trendyol.com:id/recyclerViewSliderProduct"));
    }


    public void scrollDownInElement(By by) {
        WebElement element = driver.findElement(by);
        int startX = element.getRect().getX() + element.getSize().getWidth() / 2; //250
        int startY = element.getRect().getY() + element.getSize().getHeight() * 3 / 4; //1500
        int endx = element.getRect().getX() + element.getSize().getWidth() / 2; //250
        int endy = element.getRect().getY() + element.getSize().getHeight() * 1 / 4; //500
        baseScrollMethod(startX, startY, endx, endy);
    }

    public void swipeLeftInElement(By by) {
        WebElement element = driver.findElement(by);
        int startX = element.getRect().getX() + element.getSize().getWidth() * 3 / 4; //250
        int startY = element.getRect().getY() + element.getSize().getHeight() / 2; //1500
        int endx = element.getRect().getX() + element.getSize().getWidth() * 1 / 4; //250
        int endy = element.getRect().getY() + element.getSize().getHeight() / 2; //500
        baseScrollMethod(startX, startY, endx, endy);
    }

    public void baseScrollMethod(int startX, int startY, int endx, int endy) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "Scroll");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endx, endy));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));
    }

}
