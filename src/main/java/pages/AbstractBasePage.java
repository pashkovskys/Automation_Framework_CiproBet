package pages;

import common.Base;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.testng.Assert.fail;


public class AbstractBasePage extends Base {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected final Logger logger;
    private final int BASE_WAIT = 15;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_WAIT));
        this.logger = LogManager.getLogger(this.getClass());
    }

    public void open() {
    }

    protected void openUrl(String url) {
        logger.info("open url");
        driver.get(url);
    }

    protected WebElement getVisibilityElementByXpath(String locator) {
        return waitVisibilityOfElementLocated(locator);
    }

    protected WebElement getClickableElementByXpath(String locator) {
        return waitClickableElementByXpath(locator);
    }

    protected WebElement waitVisibilityOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            return null;
        }
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        } catch (WebDriverException e) {
            return null;
        }
    }

    protected WebElement findElementByXpath(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    protected List<WebElement> getElementsByXpath(String locator) {
        return waitPresenceOfElementsLocated(By.xpath(locator));
    }

    protected List<WebElement> waitPresenceOfElementsLocated(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (WebDriverException e) {
            logger.error("No presence elements: " + locator);
            fail("No presence elements: " + locator);
            return null;
        }
    }

    protected boolean waitInvisibilityOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.error("Element is visibility: " + locator);
            fail("Element is visibility: " + locator);
            return false;
        }
    }
}
