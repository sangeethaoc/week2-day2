package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		// Setup the driver
				WebDriverManager.chromedriver().setup();

				// Launch the driver
				ChromeDriver chromeDriver = new ChromeDriver();

				// Load the url
				chromeDriver.get("http://leaftaps.com/opentaps");

				// Maximize the browser
				chromeDriver.manage().window().maximize();

				// Enter the Username
				WebElement userName = chromeDriver.findElement(By.id("username"));

				userName.sendKeys("DemoSalesManager");

				// Enter the password"
				chromeDriver.findElement(By.id("password")).sendKeys("crmsfa");

				Thread.sleep(2000);

				// Click Submit button
				chromeDriver.findElement(By.className("decorativeSubmit")).click();

				Thread.sleep(2000);

				// Click CRM/SFA
				chromeDriver.findElement(By.linkText("CRM/SFA")).click();

				Thread.sleep(2000);

				// Click Leads tab
				chromeDriver.findElement(By.linkText("Leads")).click();

				Thread.sleep(2000);
				
				// Click Find Leads tab
				chromeDriver.findElement(By.linkText("Find Leads")).click();
				
				Thread.sleep(2000);
				
				// Click Email link
				chromeDriver.findElement(By.xpath("//span[text()='Email']")).click();
				
				Thread.sleep(2000);
				
				// Enter Email Address
				chromeDriver.findElement(By.xpath("(//label[text()='Email Address:']/following::input)[1]")).sendKeys("sangeethaoc@gmail.com");
				
				Thread.sleep(2000);
				
				// Click Find Leads button
				chromeDriver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
				
				Thread.sleep(2000);
				
				// Click First Lead
				WebElement leadIDWE = chromeDriver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
				String leadID = leadIDWE.getText();
				leadIDWE.click();
				
				// Get First Name of the original lead 
				String firstNameActual = chromeDriver.findElement(By.id("viewLead_firstName_sp")).getText();
				
				// Get Last Name of the original lead
				String lastNameActual = chromeDriver.findElement(By.id("viewLead_lastName_sp")).getText();
				
				System.out.println("Page Title : "+chromeDriver.getTitle());
				System.out.println("First Name of  Actual Lead before duplication : " +firstNameActual);
				System.out.println("Last Name of  Actual Lead before duplication : " +lastNameActual);
				
				Thread.sleep(2000);
				
				// Click Duplicate Lead link
				chromeDriver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
				
				Thread.sleep(2000);
				
				// Click Create Lead button
				chromeDriver.findElement(By.className("smallSubmit")).click();
				
				// Get First Name of the duplicated lead 
				String firstName = chromeDriver.findElement(By.id("viewLead_firstName_sp")).getText();
				
				// Get Last Name of the duplicated lead
				String lastName = chromeDriver.findElement(By.id("viewLead_lastName_sp")).getText();
				
				System.out.println("Page Title : "+chromeDriver.getTitle());
				System.out.println("First Name of  Duplicated Lead before duplication : " +firstName);
				System.out.println("Last Name of  Duplicated Lead before duplication : " +lastName);
				
				// Check if the Duplicated Lead is same as Actual Lead
				if(firstName != null && lastName != null) 
				{
					if(firstName.equalsIgnoreCase(firstNameActual) && lastName.equalsIgnoreCase(lastNameActual))
						System.out.println("Both the actual and duplicated leads are same based on their first name and last name.");
					else
						System.out.println("The actual and duplicated leads are not same.");
				}
				
				// Close the browser
				chromeDriver.close();
	}

}
