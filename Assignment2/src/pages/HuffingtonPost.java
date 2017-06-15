package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HuffingtonPost {
	WebDriver driver;
	Properties ps;
	By lifestyle =null;

	public HuffingtonPost(WebDriver driver,Properties ps){

		this.driver = driver;     
		this.ps=ps;
		try {
			this.lifestyle = By.xpath(ps.getProperty("HuffingtonPost.lifestyle"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	//Get the link for lifestyle

	public WebElement getlifestyleLink(){
		return    driver.findElement(lifestyle);
	}

	public void navigateToTechPage(){
		WebElement lifestyle = getlifestyleLink();
		Actions action = new Actions(driver);
		action.moveToElement(lifestyle).build().perform();

		WebDriverWait wait = new WebDriverWait(driver,10);       
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ps.getProperty("HuffingtonPost.tech")))).click();
	}




}
