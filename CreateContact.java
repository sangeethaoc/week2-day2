package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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

		// Click Contacts tab
		chromeDriver.findElement(By.linkText("Contacts")).click();

		Thread.sleep(2000);

		// Click Create Contact
		chromeDriver.findElement(By.linkText("Create Contact")).click();

		// Enter First Name
		WebElement firstNameWE = chromeDriver.findElement(By.id("firstNameField"));
		firstNameWE.sendKeys("Sangeetha");

		String firstName = firstNameWE.getAttribute("value");

		// Enter Last Name
		chromeDriver.findElement(By.id("lastNameField")).sendKeys("Mathivanan");
		
		//Enter FirstName(Local)
		chromeDriver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Sangee");
		
		//Enter LastName(Local)
		chromeDriver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Mathi");
		
		//Enter Department Name
		chromeDriver.findElement(By.name("departmentName")).sendKeys("IT");
		
		//Enter description
		chromeDriver.findElement(By.name("description")).sendKeys("Information Technology");
		
		//Enter Primary Email
		chromeDriver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']"));
		
		//Select State/Province as NewYork Using Visible Text
		WebElement stateProvinceWE = chromeDriver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']"));
		
		Select stateProvinceSelect = new Select(stateProvinceWE);
		stateProvinceSelect.selectByVisibleText("New York");
		
		Thread.sleep(2000);

		// Click CreateContact button
		chromeDriver.findElement(By.className("smallSubmit")).click();
		
		Thread.sleep(2000);
		
		//Click on Edit button
		chromeDriver.findElement(By.xpath("//div[@class='frameSectionExtra']/a")).click();

		//Clear the Description fields
		chromeDriver.findElement(By.id("updateContactForm_description")).clear();
		
		//Enter the text in Important Note field
		chromeDriver.findElement(By.xpath("//textArea[@name='importantNote']")).sendKeys("This is my Primary Contact");
		
		// Click on Update button
		chromeDriver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		Thread.sleep(2000);
		
		// Print Browser Title
		System.out.println("Browser Title : " + chromeDriver.getTitle());

	}

}
