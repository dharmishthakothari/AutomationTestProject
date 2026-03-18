package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BaseTest handles the driver lifecycle and configuration setup.
 * All test classes should extend this class.
 */
public class BaseTest {
    public static WebDriver driver;
    public static ConfigReader config;
    public static WebDriverWait wait;
    public static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupSuite() {
        config = new ConfigReader();
    }

    @BeforeMethod
    public void setUp() {
        String browser = config.getBrowser();
        logger.info("Initializing browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitWait()));
        wait = new WebDriverWait(driver, Duration.ofSeconds(config.getExplicitWait()));
        driver.get(config.getUrl());
        logger.info("Navigated to URL: " + config.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed.");
        }
    }
}
