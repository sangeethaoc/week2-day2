package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
				
				// Click First Lead
				WebElement leadIDWE = chromeDriver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
				String leadID = leadIDWE.getText();
				leadIDWE.click();
				
				//Click Delete Lead
				chromeDriver.findElement(By.className("subMenuButtonDangerous")).click();
				
				// Click Find Leads tab
				chromeDriver.findElement(By.linkText("Find Leads")).click();
				
				// Enter LeadID which was deleted in previous step
				chromeDriver.findElement(By.name("id")).sendKeys(leadID);
				
				Thread.sleep(2000);
				
				// Click Find Leads button
				chromeDriver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
				
				Thread.sleep(2000);
				
				// Confirm if the lead is deleted successfully
				WebElement displayMsgWE = chromeDriver.findElement(By.className("x-paging-info"));
				String displayMsg = displayMsgWE.getText();
				
				if(displayMsg != null && displayMsg.equalsIgnoreCase("No records to display"))
					
					System.out.println("The given Lead ID " +leadID+ " was deleted successfully");
				
				else
					
					System.out.println("The given Lead ID " +leadID+ " was not deleted successfully");
				
	}

}
