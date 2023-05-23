package tests;

import common.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import listener.TestListener;
import lombok.SneakyThrows;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.utils.SuiteConfiguration;
import ru.stqa.selenium.factory.LooseWebDriverPool;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

@Listeners(TestListener.class)
public class AbstractTestBase extends Base {

    protected WebDriver driver;
    private static String headless;
    private String grid;
    protected static WebDriverPool driverPool = new LooseWebDriverPool();
    private final Logger logger = LogManager.getLogger(AbstractTestBase.class);
    private final String browserName = "chrome";
    private final String browserVersion = "113.0";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass(alwaysRun = true)
    @SneakyThrows
    public void initTestSuit() {
        SuiteConfiguration config = new SuiteConfiguration();
        env = config.getProperty("site.url");
        headless = config.getProperty("headless");
        grid = config.getProperty("grid");
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver() throws MalformedURLException {
        logger.info("start set up driver");
        setUpDriver();
        setUpScreenResolution();
        logger.info("finish set up driver");
    }

    private ChromeOptions getChromeOptions() {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        ChromeOptions options = new ChromeOptions();
        options.setLogLevel(ChromeDriverLogLevel.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);

        if (headless.equals("--headless")) {
            options.addArguments(headless);
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
//            options.addArguments("--remote-allow-origins=*");
        }
        return options;
    }

    private DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities(getChromeOptions());
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", false,
                "enableVideo", false
        ));
        return capabilities;
    }

    private void setUpDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
            if (grid == null || grid.isEmpty()) {
                driver = driverPool.getDriver(getDesiredCapabilities());
            } else {
                RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(grid), getDesiredCapabilities());
                remoteWebDriver.setFileDetector(new LocalFileDetector());
                driver = remoteWebDriver;
            }
        }
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);


    private void setUpScreenResolution() {
        if (headless.equals("--headless")) {
            driver.manage().window().setSize(new Dimension(1920, 1200));
        } else {
            driver.manage().window().maximize();
        }
    }

    @AfterMethod
    public void quiteDriver() {
        logger.info("quite driver");
        driver.quit();
    }

    @AfterSuite()
    public void afterSuite() {
        addAllureEnvProperties();
    }

    private void addAllureEnvProperties() {
        File f = new File("target/allure-results/environment.properties");

        Properties props = new Properties();
        props.setProperty("URL", env);
        props.setProperty("Browser", browserName);
        props.setProperty("Browser Version", browserVersion);

        try {
            if (f.createNewFile()) {
                OutputStream out = new FileOutputStream(f);
                props.store(out, "Allure report Environment variables");
            } else {
                logger.warn("Allure environment.properties file exists");
            }
        } catch (Exception e) {
            logger.error("Allure environment.properties file was not created");
        }
    }
}
