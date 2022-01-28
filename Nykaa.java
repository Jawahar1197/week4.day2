package week4.day2;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        Actions builder = new Actions(driver);
        WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brand).perform();
        WebElement list = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		list.sendKeys("l'Oreal paris");
		WebElement paris = driver.findElement(By.xpath("//a[contains(text(),'Paris')][1]"));
		paris.click();
		String text = driver.findElement(By.xpath("//div[@id='title']/h1")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
	    driver.findElement(By.xpath("//span[text()='Category']")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Hair')][1]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Hair Care')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).click();
	    driver.findElement(By.xpath("//span[text()='Concern']")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click();
	    driver.findElement(By.xpath("//div[@class='css-10zjw4o']")).click();
	    //WebElement ml = driver.findElement(By.xpath("//select[@title='SIZE']"));
	    //Select ML = new Select(ml);
	   // ML.selectByValue("1");
	   // String text2 = driver.findElement(By.xpath("//span[@class='css-12x6n3h']")).getText();
	   // System.out.println(text2);
	    driver.findElement(By.xpath("//button[@class='css-17hv1os']")).click();
	    driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']")).click();
	    String text3 = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
	    
	    System.out.println(text3);
	    }

}
