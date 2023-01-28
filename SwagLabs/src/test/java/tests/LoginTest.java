package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.LoginDataProvider;
import helper.BrowserUtil;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;


public class LoginTest {

	private static Logger log = LogManager.getLogger(LoginTest .class);
	 
	static WebDriver driver = BrowserUtil.startBrowser("chrome","https://www.saucedemo.com/");
	
@Test(priority =1,dataProvider="swagLabLoginFailedMethod",dataProviderClass=LoginDataProvider.class)
	
	public void loginTestFailedMethod(String username,String password,String expectedResult) {
		log.info("Starting loginTestFailedMethod Method");
		LoginPage login=new LoginPage(driver);
		login.username(username);
		login.password(password);
		login.loginbutton();
		
		String actualResult=login.getErrorMessage();
		Assert.assertEquals(actualResult, expectedResult);
	
	}
	
	@Test(priority =2, dataProvider="swagLabLoginMethod",dataProviderClass=LoginDataProvider.class)
	 
	public void loginMethod(String username,String password,String expectedResult) {
		log.info("Starting loginMethod Method");
		LoginPage login=new LoginPage(driver);
		login.username(username);
		login.password(password);
		login.loginbutton();
		
		InventoryPage inventory = new InventoryPage(driver);
		String actualResult = inventory.getProductHeading();
		Assert.assertEquals(actualResult, expectedResult);
	}
	


@Test(priority =3,dataProvider="swagLabAddToCart",dataProviderClass=LoginDataProvider.class)

public void addToCartMethod(String item,String expectedResult) {
	log.info("Starting addToCartMethod Method");
	InventoryPage page = new InventoryPage(driver);
	log.info("With InventoryPage class Object calling addItem method");
	page.addItem(item);
	log.info("With InventoryPage class Object calling cart method");
	page.cart();

	CartPage cart = new CartPage(driver);
	
	String text = cart.getMyTitle();
	log.info("By using CartPage class object getting title",text);
	Boolean value = cart.validateCartItems(item);
	log.info("Calling validateCartItems method ");
	Assert.assertEquals(true, value);
	boolean flag = cart.validateCartItemsCount(item);
	log.info("Calling validateCartItemsCount method ");
	Assert.assertEquals(true, flag);
	/*
	 * loop and check all items from input are available proper cart assert next
	 * remove all items from cart to add it again in another test RemoveAllItems -
	 * inventory page logic - loop and click on remove button
	 */
}
}
