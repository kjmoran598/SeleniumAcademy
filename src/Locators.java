import java.time.Duration;
import java.lang.Thread; 
import org.openqa.selenium.By;
//import java.util.System;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	public static void main(String[] args) throws InterruptedException {
		
      WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.get("https://rahulshettyacademy.com/locatorspractice/");
      //<input type="text" placeholder="Username" id="inputUsername" value="">
      driver.findElement(By.id("inputUsername")).sendKeys("rahul");
      driver.findElement(By.name("inputPassword")).sendKeys("hello");
      driver.findElement(By.className("signInBtn")).click();
      System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
      driver.findElement(By.linkText("Forgot your password?")).click();
      Thread.sleep(1000);
      
      driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("John");
      driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("kev@abc.com");
      driver.findElement(By.xpath("//input[@type = 'text'][2]")).clear();
      driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("kev2@abc.com");
      driver.findElement(By.xpath("//form/input[3]")).sendKeys("122334");
      driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
      System.out.println(driver.findElement(By.cssSelector("form p")).getText());
      driver.findElement(By.cssSelector(".go-to-login-btn")).click();
      Thread.sleep(1000);
      driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
      driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
      driver.findElement(By.id("chkboxOne")).click();
      driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}
}




















