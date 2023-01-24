package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {


WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
	WebElement heading;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')][1]")
	WebElement AddToCart1;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	WebElement AddToCart2;

	
	@FindBy(xpath="//div[@class='inventory_list']")
	WebElement inventory;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") 
	WebElement Cart;
	 
	public String getProductHeading() {
		String head=heading.getText();
		return head;
	}
}
