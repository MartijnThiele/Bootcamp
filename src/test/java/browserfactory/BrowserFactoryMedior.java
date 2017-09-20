package browserfactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Gebruiker on 27-7-2017.
 */
public class BrowserFactoryMedior {
    public static WebDriver getDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "firefox":
                return getFirefoxDriver();
            case "ie":
                return getIEDriver();
            case "chrome":
                return getChromeDriver();
            default:
                return getChromeDriver();
        }

    }

    private static WebDriver getFirefoxDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("trustAllSSLCertificates", true);
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(capabilities);
    }

    private static WebDriver getChromeDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("myhttpproxy:3337");
        capabilities.setCapability("proxy", proxy);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("ignore-certificate-errors");
        capabilities.setCapability("chrome.switches", "--verbose");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(capabilities);
    }

    private static WebDriver getIEDriver() {
        InternetExplorerDriverManager.getInstance().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
}
