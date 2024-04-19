import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.file;



public class SSLChromeOptions {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();

		Proxy proxy = new Proxy();

		proxy.setHttpProxy("ipaddress:4444");

		options.setCapability("proxy", proxy);

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");

		options.setExperimentalOption("prefs", prefs);

		options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");

		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

		File src = ((TakesScreenShot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://home/"));

	}

}
