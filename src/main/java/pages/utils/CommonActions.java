package pages.utils;

import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Random;

public class CommonActions {

    @SneakyThrows
    public static void scrollForElement(WebElement element, WebDriver drv) {
        ((JavascriptExecutor) drv).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(200);
    }

    public static void switchToTab(WebDriver drv, Integer num) {
        ArrayList<String> tab = new ArrayList<>
                (drv.getWindowHandles());
        drv.switchTo().window(tab.get(num));
    }

    public static String getCookiesValueByName(WebDriver driver, String name) {
        try {
            return driver.manage().getCookieNamed(name).getValue();
        } catch (NullPointerException e) {
            return "";
        }
    }

    public static String generateRandomSymbolString(int length) {
        char[] chars = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяabcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
