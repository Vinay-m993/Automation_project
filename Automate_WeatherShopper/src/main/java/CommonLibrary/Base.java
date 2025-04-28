package CommonLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;

	public WebDriver browserLaunch(String Browser) throws Exception {

		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);

		} else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		} else {
			throw new Exception("Browser is not correct");
		}

		driver.manage().window().maximize();
		return driver;
	}

}
