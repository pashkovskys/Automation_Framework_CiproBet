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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.utils.SuiteConfiguration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

@Listeners(TestListener.class)
public class AbstractTestBase extends Base {

    protected WebDriver driver;
    private static String headless;
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
    }

    @BeforeMethod
    public void initDriver() {
        logger.info("start set up driver");
        setUpDriver();
        setUpScreenResolution();
        logger.info("finish set up driver");
    }

    private void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

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
