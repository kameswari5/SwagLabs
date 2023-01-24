package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.LoginDataProvider;
import helper.BrowserUtil;
import pages.InventoryPage;
import pages.LoginPage;


public class LoginTest {

	static WebDriver driver = BrowserUtil.startBrowser("chrome","https://www.saucedemo.com/");
	
	@Test(priority=1,dataProvider="swagLabLoginMethod",dataProviderClass=LoginDataProvider.class)
	 
	public void loginMethod(String username,String password,String expectedResult) {
		LoginPage login=new LoginPage(driver);
		login.username(username);
		login.password(password);
		login.loginbutton();
	
		InventoryPage inventory = new InventoryPage(driver);
		String actualResult = inventory.getProductHeading();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
@Test(dataProvider="swagLabLoginFailedMethod",dataProviderClass=LoginDataProvider.class)
	
	public void loginTestFailedMethod(String username,String password,String expectedResult) {
		LoginPage login=new LoginPage(driver);
		login.username(username);
		login.password(password);
		login.loginbutton();
		
		String actualResult=login.getErrorMessage();
		Assert.assertEquals(actualResult, expectedResult);
	
	}
	
}
