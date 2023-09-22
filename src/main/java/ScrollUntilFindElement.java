import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ScrollUntilFindElement {

    AndroidDriver driver;

    @Test
    public void deneme() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        scrollUntilFindElement();
    }


    public void finalScrollMethod(){
        // elementi buldumu bulmadı mı kontrol ediyorum. eğer elementi bulduysa false a çekiyor. bu sayede while dan çıkabiliyorum.
        boolean check = true;
        // sayfanın en sonundamıyım kontrol etmek için kullanıyorum. Şuanki page source u alıp daha kaydırdıktan sonraki page source ile kıyaslamak için.
        String prevPageSource = driver.getPageSource();
        String currentPageSource;
        WebElement element = null;
        //Scroll sayımı kontrol etmek için. Sonsuz bi sayfa varsa sonsuza kadar kaydırmasın diye. Scroll sayısını filtreliyorum.
        int i = 0;
        do {
            // elementi bulmaya çalışıyorum. Bulamazsam findElement metodu hata verdiği için try catchin içine koyduk.
            try {
                element = driver.findElement(AppiumBy.xpath("//*[@name=\"Enes\"]"));
            } catch (Exception e) {

            }
            //eğer elementi bulmuşsam checki false yap. Bu sayede while ın içinden çıkabil.
            if (element != null) {
                check = false;
            }
            // eğer elementi bulamamışsa scroll işlemlerime başla
            else {
                //Scroll işlemi
                scrollDown();
                //Scroll işleminden sonraki page source u alıyorum
                currentPageSource = driver.getPageSource();
                // Scrolldan sonraki page source ile önceki page source eşitse demekki sayfa sonuna geldim. Veya i 10 olmuşsa 10 sefer ekranı kaydırmışım daha fazla gerek yok
                if (prevPageSource.equals(currentPageSource) || i == 10) {
                    Assert.fail("Element bulunamadı");
                }
                //şimdiki page souseum bir sonki işlem için previus olmak zorunda.
                else {
                    prevPageSource = currentPageSource;
                }
            }
            //Scroll sayısı kontrolü yapmak için her döngüde 1 arttırıyorum
            i++;
        } while (check);
    }


    public void scrollUntilFindElement() {
        boolean check = true;
        String prevPageSource = driver.getPageSource();
        String currentPageSource;
        WebElement element = null;
        int i = 0;

        do {
            try {
                element = driver.findElement(AppiumBy.xpath("//*[@name=\"Enes\"]"));
            } catch (Exception e) {

            }
            if (element != null) {
                check = false;
            } else {
                scrollDown();
                currentPageSource = driver.getPageSource();
                if (prevPageSource.equals(currentPageSource) || i == 10) {
                    Assert.fail("Element bulunamadı");
                } else {
                    prevPageSource = currentPageSource;
                }
            }
            i++;
        } while (check);



        /*
        int i = 0;
        do {
            try {
                element = driver.findElement(AppiumBy.xpath("//*[@name=\"Enes\"]"));
            } catch (Exception e) {

            }
            if (element != null) {
                check = false;
            } else {
                scrollDown();
            }
            if (i == 10) {
                Assert.fail("Elementi bulamadı");
            }
            i++;
        } while (check);
         */


        /*
        while (check){
            WebElement element = driver.findElement(AppiumBy.xpath(""));
            if (element.isDisplayed()) {
                check = false;
            }
            else {
                scrollDown();
            }
        }
         */
        // diğer işlemleri yapmaya devam et.....
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
}
