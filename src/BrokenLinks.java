import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		String url = driver.findElement(By.cssSelector("a[href*=\"soapui\"]")).getAttribute("href");
		String urlBrokenLink = driver.findElement(By.cssSelector("a[href*=\"brokenlink\"]")).getAttribute("href");

		//Verify good link returns 200 status code
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
		
		HttpURLConnection connBL = (HttpURLConnection)new URL(urlBrokenLink).openConnection();
		connBL.setRequestMethod("HEAD");
		connBL.connect();
		int respCodeBL = connBL.getResponseCode();
		System.out.println(respCodeBL);
		
		
		List<WebElement> allUrl = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : allUrl)
		{
			String urlAll = link.getAttribute("href");
			
			HttpURLConnection connAll = (HttpURLConnection)new URL(urlAll).openConnection();
			connAll.setRequestMethod("HEAD");
			connAll.connect();
			int respCodeAll = connAll.getResponseCode();
			System.out.println(respCodeAll);
			
			//Soft Assert which will continue despite any 400+ status codes
			a.assertTrue(respCodeAll < 400, "Link is broken for: "+ link.getText() + " with code: "+respCodeAll);
			
			//Hard Assert which will fail after the first 400+ status code
//			if(respCodeAll > 400)
//			{
//				System.out.println("Link is broken for: "+ link.getText() + " with code: "+respCodeAll);
//				Assert.assertTrue(false);
//			}
		}
		a.assertAll();
		
		
		
	}

}
