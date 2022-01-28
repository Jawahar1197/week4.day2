package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
		   ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-notifications");
		        
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://www.amazon.in/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			Actions builder = new Actions(driver);
			
			driver.findElement(By.linkText("Mobiles")).click();
			
		WebElement find1 = driver.findElement(By.xpath("(//span[@class='nav-a-content'])[2]"));
		
		WebElement find2 = driver.findElement(By.linkText("OnePlus"));
		
		builder.moveToElement(find1).moveToElement(find2).click(find2).perform();
		
		WebElement find3 = driver.findElement(By.id("twotabsearchtextbox"));
		
		find3.sendKeys("oneplus 9 pro");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		WebElement find4 = driver.findElement(By.xpath("//h2/a/span[contains(text(),'OnePlus')]"));
			
		WebElement find5 = find4.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[1]"));
		
		builder.moveToElement(find4).moveToElement(find5).click(find5).perform();
		
		String text = find5.findElement(By.xpath("//table[@id='histogramTable']//tr[1]/td[3]/span/a")).getText();
		
		find4.click();
		
		Thread.sleep(3000);
		
		System.out.println("Percentage of 5 star rating:" + text);
		
	
		Set<String> windowHandles1 = driver.getWindowHandles();
		
		List<String> window1 = new ArrayList<String>(windowHandles1);
		
		driver.switchTo().window(window1.get(1));
		
		
	   File source = driver.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./snaps/img.png");
		
		FileUtils.copyFile(source, dest);
		
		//Thread.sleep(5000);
		WebElement tot = driver.findElement(By.xpath("//table[@class='a-lineitem a-align-top']//span[@aria-hidden='true']"));
		
		Thread.sleep(5000);
	
		String text2 = tot.getText();
		String replace1 = text2.replaceAll("[^0-9]", "");
		int s1 = Integer.parseInt(replace1);
		int j1 = s1/100;
		
		
		System.out.println("Price:Rs."+j1);
		
		//Thread.sleep(7000);
		driver.findElement(By.id("add-to-cart-button")).click();
			
		Thread.sleep(7000);
		WebElement sub = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		
		String text3 = sub.getText();
		String replace2 = text3.replaceAll("[^0-9]", "");
		int s2 = Integer.parseInt(replace2);
		int j2 = s2/100;
			
		System.out.println("SubCart Total:Rs."+j2);
		
		if(text2.contains(text3)) {
			
			System.out.println("Total verified");
		}else {
			
			System.out.println("Total not same");
		}
				
		driver.switchTo().window(window1.get(0));
		
		
		
	}

}

