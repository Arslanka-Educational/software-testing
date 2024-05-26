package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Utils {
    public static final String DEFAULT_URL = "https://www.answers.com/";

    private static FirefoxDriver firefoxDriver;

    private static ChromeDriver chromeDriver;

    public static FirefoxDriver getFireFoxDriver() {
        if (firefoxDriver == null) {
            firefoxDriver = new FirefoxDriver();
        }
        return firefoxDriver;
    }

    public static ChromeDriver getChromeDriver() {
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver();
        }
        return chromeDriver;
    }

    public static List<WebDriver> getDrivers() {
        return List.of(
               getChromeDriver());
            //   getFireFoxDriver());
    }

    public static void wait10Sec(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
    }
}
