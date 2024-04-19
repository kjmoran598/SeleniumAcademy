
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ProductsPageLessons {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] veggies = {"Mushroom","Potato","Pumpkin","Corn"};
		ProductsPageLessons p = new ProductsPageLessons();
		
		p.addItems(driver, veggies);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(), "Code applied ..!");
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		
		
	}
	
	public void addItems(WebDriver driver, String[] veggies) throws InterruptedException {
		int total = veggies.length;
		int count = 0;
		
		Thread.sleep(4000);
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i< products.size(); i++) {
			
			//format to get just the veggie and not the 1 kg
			
			String[] name = products.get(i).getText().split("-");
			String formatted = name[0].trim();
			
			List veggiesList = Arrays.asList(veggies);
			
			
			if(veggiesList.contains(formatted)) {
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				count++;
				if(count == total) {
					break;
				}
				
			}
		}

	}

}
