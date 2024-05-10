package webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.MessageFormat;

public class Driver {
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        if(drivers.get() == null) {
            WebDriver driver = createDriver("chrome");
            drivers.set(driver);
        }
        return drivers.get();
    }

    public static void quit() {

        if(drivers.get() != null) {
            WebDriver driver = drivers.get();
            driver.quit();
            drivers.set(null);
        }
    }

    private static WebDriver createDriver(String browser)  {

        WebDriver driver = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException(MessageFormat.format("browser {0} not supported", browser));
        };
        driver.manage().deleteAllCookies();
        return driver;
    }
}
