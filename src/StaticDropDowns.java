import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      
	    //Static Dropdown
	    WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	    Select dropdown = new Select(staticDropdown);
	    
	    dropdown.selectByIndex(3);
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	    
	    dropdown.selectByVisibleText("AED");
	    System.out.println(dropdown.getFirstSelectedOption().getText());

	    dropdown.selectByValue("INR");
	    System.out.println(dropdown.getFirstSelectedOption().getText());

	    //Static dropdown with radio buttons and Done button
	    driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(2000);
	    for(int i=0; i<5; i++) {
		    driver.findElement(By.id("hrefIncAdt")).click();

	    }
	    driver.findElement(By.id("btnclosepaxoption")).click();
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
	    
	    //Dynamic dropdowns
	    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@value='BLR']")).click();
	    Thread.sleep(2000);
	    //driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click(); //alternative way but uses undesirable indexes
	    driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();//parent child relationship xpath
	    
	    //Auto suggestive dropdowns
	    driver.findElement(By.id("autosuggest")).sendKeys("ind");
	    Thread.sleep(2000);
	    List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	    
	   
	    for(WebElement option : options) {
	    	if(option.getText().equalsIgnoreCase("India")) {
	    		option.click();
	    		break;
	    	}
	    }
	    
	    
	    //Checkboxes with Assertions
	    Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
	    driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
	    Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
	    if(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()) {
	    	System.out.println("Checkbox Friends and Family is selected");
	    }
	  
	    System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	    
	    Thread.sleep(3000);
	    //Open Calendar 
	  	driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
	  	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	  	
	  	
	  	Thread.sleep(5000);
	  	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains(".5"));
	  	//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
	  	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	  	//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
	  	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
	  	{
	  		Assert.assertTrue(true);
	  		System.out.println("Successful change");

	  	}
	  	else {
	  		Assert.assertTrue(false);
	  		System.out.println("Failed change");
	  	}

	  	
	  
	    
	    //driver.close();
	}

}
