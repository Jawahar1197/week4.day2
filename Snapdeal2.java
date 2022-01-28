package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	    driver.get("https://www.snapdeal.com/");
	    Actions builder = new Actions(driver);
	    WebElement shoes = driver.findElement(By.xpath("//span[@class='catText'][1]"));
	    builder.moveToElement(shoes).perform();	
	    driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')][1]")).click();
	   // String text = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div")).getText();
	    //System.out.println(text);
	    driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Sort by')]")).click();
	    driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
	    WebElement price1 = driver.findElement(By.name("fromVal"));
	    price1.clear();
	    price1.sendKeys("900");
	    WebElement price2 = driver.findElement(By.xpath("//input[@name='toVal'][1]"));
	    price2.clear();
	    price2.sendKeys("1200");
	    driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@data-filtername=\"Color_s\"]")).click();
	    driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
	    Actions builder1 = new Actions(driver);
	    WebElement shoes2 = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
	    //Thread.sleep(3000);
	    builder1.moveToElement(shoes2).perform();
	    
        
	    
	    

}
	}
