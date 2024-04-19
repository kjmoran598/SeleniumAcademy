import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "/Users/kevinslaptop/Documents/ChromeDriverFolder");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Navigate to a web page
        driver.get("https://www.example.com");

        // Get the title of the page
        String pageTitle = driver.getTitle();

        // Verify the title
        if (pageTitle.equals("Example Domain")) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
        driver.close();

        // Close the browser
 //       driver.quit();
        
        String[] name = {"kevin","Steve","Joe"};
        for(String s : name) {
        	System.out.println(s);
        }
        
        ArrayList<String> a = new ArrayList<String>();
        a.add("Jack");
        a.add("Alice");
        
        for(String s: a) {
        	System.out.println(s);
        }
        
        System.out.println(a.contains("Alice"));
        
        for(int i=0; i < a.size(); i++) {
        	System.out.println("-" + a.get(i));
        }
        
        List<String> newArrayList = Arrays.asList(name);
        newArrayList.contains("Steve");
        
        
        
	}

}
