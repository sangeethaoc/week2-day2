package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountFB {

	public static void main(String[] args) throws InterruptedException {
		
				//Setup the driver
				WebDriverManager.chromedriver().setup();
				
				//Launch the driver
				ChromeDriver chromeDriver = new ChromeDriver();
				
				//Load the url
				chromeDriver.get("https://en-gb.facebook.com");
				
				//Maximize the browser
				chromeDriver.manage().window().maximize();
				
				// Click Create New Account button
				chromeDriver.findElement(By.xpath("//a[text()='Create New Account']")).click();
				
				Thread.sleep(2000);
				
				// Enter First Name
				chromeDriver.findElement(By.name("firstname")).sendKeys("Sangeetha");
				
				// Enter surname
				chromeDriver.findElement(By.name("lastname")).sendKeys("Mathivanan");
				
				// Enter Mobile number or e-mail address
				chromeDriver.findElement(By.name("reg_email__")).sendKeys("sangeethaoc@gmail.com");
				
				Thread.sleep(2000);
				
				//Re-enter Email address
				chromeDriver.findElement(By.xpath("//div[text()='Re-enter email address']/following-sibling::input")).sendKeys("sangeethaoc@gmail.com");
				
				
				// Enter New password
				chromeDriver.findElement(By.id("password_step_input")).sendKeys("Fb@12345");
				
				// Enter Date of birth
				
				//Select Birthday Date
				Select dateSelect= new Select(chromeDriver.findElement(By.name("birthday_day")));
				dateSelect.selectByVisibleText("6");
				
				//Select Birthday Month
				Select monthSelect= new Select(chromeDriver.findElement(By.name("birthday_month")));
				monthSelect.selectByValue("1");
				
				// Select Birthday Year
				Select yearSelect = new Select(chromeDriver.findElement(By.name("birthday_year")));
				yearSelect.selectByVisibleText("1987");
				
				Thread.sleep(2000);
				
				// Select Gender 'Female' by clicking on radio button
				chromeDriver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
				
				Thread.sleep(2000);
				
				// Click 'Sign Up' button
				chromeDriver.findElement(By.name("websubmit")).click();
				
	}

}
