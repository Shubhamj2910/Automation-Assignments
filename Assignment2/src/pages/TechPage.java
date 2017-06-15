package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TechPage {

	WebDriver driver;
	Properties ps;
	By article=null;

	public TechPage(WebDriver driver,Properties ps){

		this.driver = driver;
		this.ps=ps;
		try {
			this.article = By.xpath(ps.getProperty("TechPage.article"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Get the link for lifestyle Articles

	public List<WebElement> getarticleLink(){

		return    (List<WebElement>) driver.findElements(article);

	}

	public void getArticleDetails(){
		URL url=null;
		HttpURLConnection huc=null;
		try{
			List<WebElement> allData = getarticleLink(); 
			for(WebElement e : allData)     
			{       
				String title=e.findElement(By.className(ps.getProperty("TechPage.article.title.className"))).getText();
				String authorName=e.findElement(By.className(ps.getProperty("TechPage.article.author.className"))).getText();

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
			System.out.println(e);
		}
	}

}
