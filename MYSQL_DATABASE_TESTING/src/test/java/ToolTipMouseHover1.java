

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTipMouseHover1 {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.hongkiat.com/blog/websites-creative-mouse-over-effects/");
		
		WebElement e =driver.findElement(By.xpath("//input[@name='wp-chimp-mcemail']"));
		 
		Actions a = new Actions(driver);
		
		a.moveToElement(e).build().perform();
		
		System.out.println(e.getAttribute("validationMessage"));
		
	
	
	
	}
}
