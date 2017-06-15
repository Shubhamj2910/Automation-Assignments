package huffingTonPost;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.*;
import cucumber.api.java.en_lol.WEN; 

public class Test { 
	WebDriver driver = null; 

	@Given("^I have open the browser$") 
	public void openBrowser() { 
		String base_Path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",base_Path+"/lib/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	} 

	@WEN("^I open HuffingtonPost website$") 
	public void goToHuffingtonPost() { 
		driver.navigate().to("http://www.huffingtonpost.in/"); 
	} 

	@Then("^LifeStyle label should exits$") 
	public void verifyLifestyletab() { 
		if(driver.findElement(By.xpath("//header//nav//div[@class='nav__inner']//div[@data-s-value='lifestyle']")).isDisplayed()) { 
			System.out.println("Test 1 Pass"); 
		} else { 
			System.out.println("Test 1 Fail"); 
		}  
	}

	@Then("^Click on Lifestyle tab$")
	public void  selectLifestyle() throws Exception{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//header//nav//div[@class='nav__inner']//div[@data-s-value='lifestyle']"))).build().perform();
	}

	@Then("^verify tech link is visible$") 
	public void verifyLTechLink() throws Exception{ 
		WebDriverWait wait = new WebDriverWait(driver,10);        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header//nav//div[@class='nav__inner']//div[@data-s-value='lifestyle']/div//div//div//a"))).isDisplayed();
	}

	@Then("^Select tech link$")
	public void  selectTechLink() throws InterruptedException{
		driver.findElement(By.xpath("//header//nav//div[@class='nav__inner']//div[@data-s-value='lifestyle']/div//div//div//a")).click();
	}

	@Then("^verify title of tech page$")
	public void verifyTechpage() throws InterruptedException{

		if(driver.getTitle().equals("Tech | Huffington Post India"))
			System.out.println("Test 3 pass , Its a valid Tech page");
		else {
			System.out.println("Test 3 fail , Its not a tech page");
			driver.navigate().back();
		}
	}

	@Then("^Read Articles Data and verify links$")
	public void readArticle(){
		URL url=null;
		HttpURLConnection huc=null;
		try{
			List<WebElement> allData = driver.findElements(By.xpath("//div[@class='apage-list']//article//div[@class='apage__content']")); 
			for(WebElement e : allData)     
			{       
				String title=e.findElement(By.className("entry-headline")).getText();
				String authorName=e.findElement(By.className("apage__author")).getText();

				if(authorName.equals("")){
					authorName="NA";
				}
				System.out.println("Title="+title );System.out.println("Author Name=" +authorName);	
				url = new URL(e.findElement(By.linkText(e.findElement(By.className("entry-headline")).getText())).getAttribute("href"));
				huc = (HttpURLConnection)url.openConnection();
				huc.setRequestMethod("GET");
				huc.connect();

				if(huc.getResponseCode()==200){
					System.out.println("Response Code is 200 , Its valid URL");
				}else{
					System.out.println("Invalid URL");
				}
				huc.disconnect();
				System.out.println("");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		driver.close();
	}

}