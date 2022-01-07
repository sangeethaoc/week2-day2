package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ACMELogin {

	public static void main(String[] args) throws InterruptedException {

		//Setup the driver
		WebDriverManager.chromedriver().setup();
		
		//Launch the driver
		ChromeDriver chromeDriver = new ChromeDriver();
		
		//Load the url
		chromeDriver.get("https://acme-test.uipath.com/login");
		
		//Maximize the browser
		chromeDriver.manage().window().maximize();
		
		// Enter E-mail
		chromeDriver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		
		// Enter password
		chromeDriver.findElement(By.id("password")).sendKeys("leaf@12");
		
		Thread.sleep(2000);
		
		// Click on Login button
		chromeDriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		// Print Title of the current webpage 
		System.out.println("Page Title : "+chromeDriver.getTitle());
		
		Thread.sleep(2000);
		
		// Click on Logout button
		chromeDriver.findElement(By.linkText("Log Out")).click();
		
	}

}
