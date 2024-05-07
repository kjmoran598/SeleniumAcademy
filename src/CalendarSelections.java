import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;




public class CalendarSelections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String month = "12";
		String day = "11";
		String year = "2026";
		
		//Click on the calendar
		driver.findElement(By.cssSelector("div[class='react-date-picker__inputGroup']")).click();
		
		//Click on the title part to get to months and then years for selection
		driver.findElement(By.cssSelector("button[class='react-calendar__navigation__label']")).click();
		driver.findElement(By.cssSelector("button[class='react-calendar__navigation__label']")).click();
		
		//Find the locator for the specific year
		String url = "//button[normalize-space()='" + year + "']";
		driver.findElement(By.xpath(url)).click();
		//Alternative xpath: "//button[text()='"+year+"']"
		
		url = "//button[@class='react-calendar__tile react-calendar__year-view__months__month'][" + month + "]";
		driver.findElement(By.xpath(url)).click();
		
		url = "//button[normalize-space()='" + day + "']";
		driver.findElement(By.xpath(url)).click();
		
		//Pull the values from the text box and assert the results because each value is separate in this text box
		WebElement element = driver.findElement(By.xpath("//input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__year']"));
		String dateText = element.getAttribute("value") + " ";
		//Get Day
		element = driver.findElement(By.xpath("//input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__day']"));
		dateText = dateText + element.getAttribute("value") + " ";
		//Get Month
		if(Integer.parseInt(month) > 9) {
			element = driver.findElement(By.xpath("//input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__month']"));
			dateText = dateText + element.getAttribute("value");
			
		}
		else {
			element = driver.findElement(By.xpath("//input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__month react-date-picker__inputGroup__input--hasLeadingZero']"));
			dateText = dateText + element.getAttribute("value");
			
		}
		System.out.println(dateText);
		String expected = year + " " + day + " " + month;
		System.out.println(expected);
		Assert.assertEquals(dateText, expected);
		
		//Alternate solution from Rahul
//		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
//
//		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
//
//		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
//
//		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
//
//		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
//
//		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
//
//		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
//
//		for(int i =0; i<actualList.size();i++)
//
//		{
//
//		System.out.println(actualList.get(i).getAttribute("value"));
//
//		Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
//
//		}

	}

}