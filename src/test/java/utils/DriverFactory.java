//package utils;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class DriverFactory {
//
//    public static void initDriver() {
//
//        Properties prop = PropertyReader.getProperties();
//        String browser = prop.getProperty("Browser");
//
//        WebDriver driver;
//
//        switch (browser.toLowerCase()) {
//
//            case "chrome":
//                Map<String, Object> prefs = new HashMap<>();
//                prefs.put("credentials_enable_service", false);
//                prefs.put("profile.password_manager_leak_detection", false);
//
//                ChromeOptions options = new ChromeOptions();
//                options.setExperimentalOption("prefs", prefs);
//                driver = new ChromeDriver(options);
//                break;
//
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//
//            default:
//                throw new RuntimeException("Invalid browser in config");
//        }
//
//        driver.manage().window().maximize();
//        driver.get(prop.getProperty("URL"));
//
//        DriverManager.setDriver(driver);
//    }
//
//    public static void quitDriver() {
//        if (DriverManager.getDriver() != null) {
//            DriverManager.getDriver().quit();
//            DriverManager.unload();
//        }
//    }
//}
package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    public static void initDriver() throws MalformedURLException {

        Properties prop = PropertyReader.getProperties();
        String browser = prop.getProperty("Browser");

        WebDriver driver;

        String gridURL = "http://localhost:4444";  // Grid URL

        switch (browser.toLowerCase()) {

            case "chrome":

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_leak_detection", false);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", prefs);

                driver = new RemoteWebDriver(
                        new URL(gridURL),
                        chromeOptions
                );
                break;

            case "firefox":

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                driver = new RemoteWebDriver(
                        new URL(gridURL),
                        firefoxOptions
                );
                break;

            case "edge":

                EdgeOptions edgeOptions = new EdgeOptions();

                driver = new RemoteWebDriver(
                        new URL(gridURL),
                        edgeOptions
                );
                break;

            default:
                throw new RuntimeException("Invalid browser in config");
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));

        DriverManager.setDriver(driver);
    }

    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}