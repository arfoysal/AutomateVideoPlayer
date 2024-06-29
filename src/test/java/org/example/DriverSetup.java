package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class DriverSetup {
    private static String browserName = System.getProperty("browser", "chrome");
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        DriverSetup.LOCAL_DRIVER.set(driver);
    }

    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();
    }

    public static WebDriver getBrowser(String browserName){
        switch (browserName.toLowerCase()){
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return  new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new RuntimeException("Browser not Found! using the given browser name: " + browserName);
        }
    }

    @BeforeSuite
    public static synchronized void setBrowser(){
        WebDriver driver = getBrowser(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setDriver(driver);
    }
    @AfterSuite
    public static synchronized void quiteBrowser(){
        getDriver().quit();
    }
}
