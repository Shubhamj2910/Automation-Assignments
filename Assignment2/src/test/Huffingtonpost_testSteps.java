package test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import basePaths.BasePath;
import pages.HuffingtonPost;
import pages.TechPage;

public class Huffingtonpost_testSteps extends BasePath{

	HuffingtonPost huffingtonpost;
	TechPage techPage;
	public static  WebDriver driver;
	Properties ps=new Properties();

	public void setUp(){
		try {

			ps.load(new FileInputStream(new File(object_repo_Path)));

			System.setProperty("webdriver.chrome.driver",chromeDriver_Path);

			driver=new ChromeDriver();
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get(ps.getProperty("WebPage.url"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void performAction(){

		huffingtonpost = new HuffingtonPost(driver,ps);
		huffingtonpost.navigateToTechPage();

		TechPage techpage=new TechPage(driver,ps); 
		techpage.getArticleDetails();

	}

	public void closeDriver(){
		driver.close();
	}

}