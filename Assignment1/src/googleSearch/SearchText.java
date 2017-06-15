package googleSearch;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchText extends BaseClass{

	static String textBoxId="lst-ib";
	static String SearchbuttonId="_fZl";
	static String resultsLink="//div[@id='rso']//div[@class='srg']//div[@class='g']//h3//a";
	static String searchText="Times of India";

	public static void main(String[] args) {

		SearchText searchText=new SearchText();
		searchText.search();
		searchText.verifyResults();
		driver.close();
		System.exit(0);

	}

	public void search(){
		driver.findElement(By.id(textBoxId)).sendKeys(searchText);
		driver.findElement(By.id(SearchbuttonId)).click();
	}

	public void verifyResults(){
		
		WebDriverWait wait = new WebDriverWait(driver,10);       
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(resultsLink)));
		
		List<WebElement> allLinkElements = driver.findElements(By.xpath(resultsLink));

		for (WebElement Element : allLinkElements) {
			String text=Element.getText();
			if(text.contains("Times of India")){
				System.out.println(text+" , is a Valid Link");	            	

			}else {
				System.out.println(text+" , is a Invalid Link");
			}
		}
	}

}
