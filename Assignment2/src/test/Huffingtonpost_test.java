package test;

import org.testng.annotations.*;

public class Huffingtonpost_test {

	Huffingtonpost_testSteps steps= new Huffingtonpost_testSteps();

	@BeforeTest
	public void Driversetup(){
		steps.setUp();
	}

	@Test(groups = {"assignment2.HuffingtonPost"}, description = "")
	public void test(){
		steps.performAction();	
	}

	@AfterTest
	public void freeResource(){
		steps.closeDriver();	
	}

}
