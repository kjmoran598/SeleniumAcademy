import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      WebDriver driver = new ChromeDriver();
	      driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
	      System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	      
	      

	}

}
