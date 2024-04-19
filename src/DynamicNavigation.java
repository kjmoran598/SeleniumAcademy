import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class DynamicNavigation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Click on the second checkbox
		driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();
		String choice = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		//System.out.println("This is it: " + choice);
		
		//Select the option from the dropdown equal to the checkbox text
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select staticDown = new Select(dropdown);
		List<WebElement> options = staticDown.getOptions();
		
		
		//System.out.println("Length is: " + options.size());
		//Go through each dropdown option and compare the string
		for(int i = 1; i< options.size(); i++)
		{
			String selectedText = options.get(i).getText();
			if(selectedText.equals(choice) )
			{
				//System.out.println(options.get(i).getText());
				staticDown.selectByVisibleText(selectedText);
				break;
			}
		}
		
		//Enter the text in the text box and click Alert button
		driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(choice);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		
		//System.out.println(driver.switchTo().alert().getText());
		
		//Get text from alert box, split out the dynamic name and compare it with original checkbox text
		String message = driver.switchTo().alert().getText();
		message = message.split(",")[0].split("Hello ")[1];
		
		//System.out.println(message);
		if(message.equals(choice))
		{
			System.out.println("SUCCESS");
		}
		
		driver.switchTo().alert().accept();

		
		

	}

}
