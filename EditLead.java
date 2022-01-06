package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		
		// Enter First Name
		chromeDriver.findElement(By.xpath("(//input[@name='firstName'])[last()]")).sendKeys("Sangeetha");
		
		Thread.sleep(2000);
		
		// Click Find Leads button
		chromeDriver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		// Click First Lead
		WebElement leadIDWE = chromeDriver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a[1]"));
		leadIDWE.click();
		
		String pageTitle = chromeDriver.getTitle();
		
		if(pageTitle.equalsIgnoreCase("View Lead | opentaps CRM"))
			System.out.println("This is View Lead page");
		else
			System.out.println("This is not the desired page");
		
		// Click Edit on View Lead page
		chromeDriver.findElement(By.xpath("//a[text()= 'Edit']")).click();
		
		// Change the Company Name
		String compName = "CTS";
		WebElement compNameWE = chromeDriver.findElement(By.id("updateLeadForm_companyName"));
		compNameWE.clear();
		compNameWE.sendKeys(compName);
		
		// Click on Update
		chromeDriver.findElement(By.className("smallSubmit")).click();
		
		
		// Verify if the changed value displays in the View Lead page
		String updatedCompName = chromeDriver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(updatedCompName != null && updatedCompName.startsWith(compName))
			System.out.println("The Company Name has been updated with its new value.");
		else
			System.out.println("The Company Name has not been updated with its new value.");
		
	}

}
