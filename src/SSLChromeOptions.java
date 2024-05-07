import java.io.File;
import java.util.HashMap;
import java.util.Map;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.apache.commons.io.FileUtils;



public class SSLChromeOptions {

	public static void main(String[] args) {

		// Use options to send to new WebDriver driver to handle SSL error pages like only http and not https

		ChromeOptions options = new ChromeOptions();

		//This is the option for SSL messages
		options.setAcceptInsecureCerts(true);
		
		//Chrome opens with no extension, so if any are needed, install them here with url to extension
		//options.addExtensions(null);

		//Some companies use a proxy to login so this is the set up for that
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);

		//When Chrome downloads any file, able to specify exactly where that file will be saved
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");

		//Ignoring pop ups, for example are experimental options that can be set up here along with Download path
		options.setExperimentalOption("prefs", prefs);

		//System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");

		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

//		File src = ((TakesScreenShot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("C://home/"));

	}

}
