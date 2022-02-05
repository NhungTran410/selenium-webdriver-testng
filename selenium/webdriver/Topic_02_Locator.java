package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class Topic_02_Locator {
		//Selenium webdriver: Khai báo biến đại diện cho Selenium Webdriver
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");

		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			
			//Khởi tạo browser lên
			driver = new FirefoxDriver();
			
			//Set thời gian chờ để tìm element
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Mở trang FaceBook
			driver.get("http://live.techpanda.org/index.php/customer/account/create/");
			
		}

		@Test
		public void TC_01() {
			//Selenium Locator (By class: trong  1 class có thể chứa biến/ hàm)
			
			//ID
			driver.findElement(By.id("firstname")).sendKeys("Automation");
			sleepInSecond(3);
			
			//Name
			driver.findElement(By.name("lastname")).sendKeys("FC");
			sleepInSecond(3);
			
			//Class: nếu class có space chỉ lấy 1 phần (ít dùng)
			driver.findElement(By.className("customer-name-middlename")).isDisplayed();
			//driver.findElement(By.className("name-middlename")).isDisplayed();
			//sleepInSecond(3);
			
			//Tagname
			Dimension inputNumber = driver.findElement(By.tagName("input")).getSize();
			System.out.print(inputNumber);
			sleepInSecond(3);
			
			//Link text: truyền hết toàn bộ chuỗi
			driver.findElement(By.linkText("SEARCH TERMS")).click();
			sleepInSecond(3);
			
			//Partial LinkText: lấy 1 phần attribute
			driver.findElement(By.partialLinkText("ADVANCED")).click();
			sleepInSecond(3);
			
			//Css
			driver.findElement(By.cssSelector("input[id='name']")).sendKeys("Iphone");
			sleepInSecond(3);
			
			driver.findElement(By.cssSelector("input[name='name']")).clear();
			driver.findElement(By.cssSelector("input[name='name']")).sendKeys("SamsungNote20");
			sleepInSecond(3);
			
			driver.findElement(By.cssSelector("#name")).clear();
			driver.findElement(By.cssSelector("#name")).sendKeys("Nokia");
			sleepInSecond(3);
			
			//Xpath
			
			driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Iphone15");
			sleepInSecond(3);
			
			driver.findElement(By.xpath("//input[@name='description']")).clear();
			driver.findElement(By.xpath("//input[@name='description']")).sendKeys("HQ");
			sleepInSecond(3);
			
			driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/input")).clear();
			driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/input")).sendKeys("VN");
			sleepInSecond(3);
			
		}
		
	
		@AfterClass
		public void afterClass() {
			
		}
		public void  sleepInSecond(long second) {
			try {
				Thread.sleep(second * 1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
