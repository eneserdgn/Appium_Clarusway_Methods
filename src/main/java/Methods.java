import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Methods {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);

        By automator = AppiumBy.androidUIAutomator("");
        By predicate = AppiumBy.iOSNsPredicateString("");
        By chain = AppiumBy.iOSClassChain("");
        By id = AppiumBy.id("");
        By xpath = AppiumBy.xpath("");


        /*

       // Fiziksel Butonlara veya Değişik Butonlara tıklamak için kullanılır
        driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

        /*

        //Telefonda package ismini verdiğim uygulama yüklü mü?
        boolean appYukluMu = driver.isAppInstalled("trendyol.com");
        System.out.println(appYukluMu);
        //Package ismini verdiğim uygulamayı çalıştırır
        driver.activateApp("trendyol.com");
        Thread.sleep(3000);
        //Package ismini verdiğim uygulamayı kapatır.
        driver.terminateApp("trendyol.com");

         */

        /*

        //Klavye açık mı
        boolean klavyeAcikMi = driver.isKeyboardShown();
        System.out.println(klavyeAcikMi);
        //Klavyeyi kapatıyor
        driver.hideKeyboard();

         */


        /*

        //Telefondan uygulamayı siler
        driver.removeApp("trendyol.com");
        Thread.sleep(3000);
        //Path değerini yazdığım uygulamayı telefona yükler
        driver.installApp("C:\\Users\\EnesErdogan\\Desktop\\AppiumDersleri\\Methods\\src\\main\\resources\\Trendyol.apk");

         */

        /*

        driver.activateApp("trendyol.com");
        Thread.sleep(3000);
        //İçerisine yazdığım süre boyunca uygulamayı arka plana atar daha sonrasında tekrar öne getirir
        driver.runAppInBackground(Duration.ofSeconds(10));

         */

        /*

        //Cihaz kapalı mi açık mi
        boolean cihazAcikMi = driver.isDeviceLocked();
        System.out.println(cihazAcikMi);
        //Cihazı kapatmak için
        driver.lockDevice();
        Thread.sleep(3000);
        //Cihazı açmak için
        driver.unlockDevice();
        //Telefon şifreliyse şifreyi girmek için
        driver.unpin(new ScriptKey("1234"));

         */

        /*

        //Ekranı yan görmek için
        driver.rotate(ScreenOrientation.LANDSCAPE);
        //Ekranı düz görmek için - 8.5.1 DE HATALI METHOD
        driver.rotate(ScreenOrientation.PORTRAIT);

         */

        /*

        //Bildirimler kısmını açıyor
        driver.openNotifications();

         */

        /*

        //Wifiyi açıp kapatmaya
        driver.toggleWifi();
        //İnterneti açıp kapatmaya
        driver.toggleData();
        //Konumu açıp kapatmaya
        driver.toggleLocationServices();
        //Uçak Modunu açıp kapatmaya
        driver.toggleAirplaneMode();

         */

        /*

        //Fake mesaj göndermek için
        driver.sendSMS("+905439459532","Bu bir mesajdır");
        //Aramaları yönetebilirim. Fake arama yapabilir, Aramayı Kabul Edebilir, Reddedebilir, Bekletebilirim
        driver.makeGsmCall("+905439459532", GsmCallActions.CALL);
        Thread.sleep(3000);
        driver.makeGsmCall("+905439459532", GsmCallActions.CANCEL);

         */

        /*

        //Seleniumda da olan metodlar
        driver.getPageSource();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(""));
        driver.manage().window().getSize();

         */
    }
}
