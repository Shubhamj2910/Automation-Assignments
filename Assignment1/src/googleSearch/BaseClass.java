package googleSearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver; 
	BaseClass() {
		String base_Path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",base_Path+"/lib/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String baseUrl="https://www.google.com/";
		driver.get(baseUrl);
	}
}
