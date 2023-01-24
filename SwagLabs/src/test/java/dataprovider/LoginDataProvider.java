package dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	@DataProvider
	public static Object[][] swagLabLoginMethod(){
		return new Object[][] {
			
			{"standard_user","secret_sauce","PRODUCTS"},
		};	
	}
	
	@DataProvider
	public static Object[][] swagLabLoginFailedMethod(){
		return new Object[][] {
			{" ","secret_sauce","Epic sadface: Username and password do not match any user in this service"},
			{"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},
			{"standard_user"," ","Epic sadface: Username and password do not match any user in this service"}
		};
	}
}
