

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTipMouseHover2 {
	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/social-icon.html");
		WebElement e =driver.findElement(By.xpath("(//a[@title='Google+'])[2]"));
		
		//WebElement att =  driver.findElement(By.xpath("//span[@class='fswTooltip__text']")); 
		Actions a = new Actions(driver);
		a.moveToElement(e).build().perform();
		
		System.out.println(e.getAttribute("title"));
		
	
	
	
	}
}
