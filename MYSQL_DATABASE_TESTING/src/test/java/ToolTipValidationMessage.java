

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipValidationMessage {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.findElement(By.name("email")).sendKeys("a",Keys.ENTER);

		
		System.out.println(driver.findElement(By.name("email")).getAttribute("validationMessage"));
		
				
		
	
	
	
	}
}
