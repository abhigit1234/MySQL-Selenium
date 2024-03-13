package MySql_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class sqlConnection {// http://localhost:8012/opencart/upload
							// http://localhost:8012/opencart/upload/admin

	@Test
	public void opencart() throws InterruptedException, SQLException {

		String cus_firstname = "sushma";
		String cus_lastname = "shetty";
		String cus_email ="london@londongmail.com";
		String cus_password = "sushasn";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8083/opencart/upload");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.partialLinkText("Register")).click();
		driver.findElement(By.name("firstname")).sendKeys(cus_firstname);
		driver.findElement(By.name("lastname")).sendKeys(cus_lastname);
		driver.findElement(By.name("email")).sendKeys(cus_email);
		driver.findElement(By.name("password")).sendKeys(cus_password);

		WebElement agree = driver.findElement(By.name("agree"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", agree);
		WebElement button = driver.findElement(By.xpath("//button[text()='Continue']"));
		jse.executeScript("arguments[0].click()", button);

		try {
			String confirm = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
			if (confirm.equals("Your Account Has Been Created!")) {
				System.out.println("Registration successfull from UI/Application");
			} else {
				System.out.println("Registration not successfull");
			}}
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
		
		


		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/opencart","root",""); 
		Statement st = con.createStatement();
		String sql = "select firstname,lastname,email,password from oc_customer";
		ResultSet rs =		st.executeQuery(sql);
		
		boolean status = false;
		
		while(rs.next()) {
			String fname =	rs.getString("firstname");
			String lname =	rs.getString("lastname");
			String email =	rs.getString("email");
			String pswd =	rs.getString("password");
		
		System.out.println(fname+" "+lname+" "+email);
			if(cus_firstname.equals(fname) && cus_lastname.equals(lname) 
					&& cus_email.equals(email)) {
				System.out.println("Record found in table || Test Passed");
				status=true;
				break;
			}	
		
		}
		if(status==false) {
			System.out.println("Record not found in table || Test Failed");
		}
			
//	driver.close();
		
/*		insert method
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/office", "root", "");
		Statement st = con.createStatement();
			
		String sql = "insert into employee values('sushma','shetty',29)";

		 boolean b = st.execute(sql);
*/	
	}
}
