package Flip;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "\\E:\\SELENIUM_WEB_DRIVER\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		
		driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]"
				+ "/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")).sendKeys("iphone");
		
		driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]"
				+ "/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 11 (White, 64 GB)')]")).click();
		Thread.sleep(3000);
		
    Set<String> ids =driver.getWindowHandles(); //does not store value base on index.
		
	
		ArrayList a = new ArrayList(ids); //it stores on basis of index
	    
		System.out.println(a.get(0));
		
		driver.switchTo().window((String) a.get(1));
		
		
		
        driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[3]/"
				+ "div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")).click();
        
        Thread.sleep(2000);

		WebElement ser= driver.findElement(By.xpath("(//button[@class='_23FHuj'])[2]"));
		
		Point loc = ser.getLocation();
		
		System.out.println(loc);
		JavascriptExecutor js =((JavascriptExecutor)driver);
		
		js.executeScript("scroll(117, 792)");
		driver.findElement(By.xpath("(//button[@class='_23FHuj'])[2]")).click();
		
		Thread.sleep(2000);
		
		WebElement price = driver.findElement(By.xpath("//span[text()=' ₹94,056']"));
		System.out.println(price.getText());

		Thread.sleep(2000);
		driver.quit();
	}

}
