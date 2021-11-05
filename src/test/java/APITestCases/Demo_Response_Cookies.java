package APITestCases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class Demo_Response_Cookies {
	
	//Validate cookies
	
		//@Test(priority=1)
		public void testCookies()
		{
			given()
				.when()
					.get("http://jsonplaceholder.typicode.com/photos")
				.then()
				// Cookie name and value - The value will change in each request
					.cookie("__cfduid","dc7938d467c6f02e2e07116a000ffc2d31559896449");
		}

		//get Cookies
		//@Test(priority=2)
		public void testGetCookies()
		{
			//How test cookies dynamically
			Response response=
					given()
						.when()
							.get("http://jsonplaceholder.typicode.com/photos");
			
			//Get Single/Specific cookie from Response _ get the cookie value
			String cookie_value=response.getCookie("__cfduid");
			System.out.println("Value of Cookie is:"+cookie_value);
			
			//Get All cookies from Response when the response return more that one cookies
			Map<String,String> cookies_values = response.getCookies();
			
			// entrySet() is the object that storage the name and value of the cookie
			// Map.Entry is the object that can read the row of the Map
			for(Map.Entry entry:cookies_values.entrySet())
			{
				System.out.println(entry.getKey()+"==>"+entry.getValue());
			}
				
		}
		
		//get Details of Cookies
		@Test(priority=3)
			public void testDetailedCookies()
			{
				Response response=get("http://jsonplaceholder.typicode.com/photos");
				
				//Get cookie - detailed information
				Cookie cookie_info=response.getDetailedCookie("__cfduid");
				
				System.out.println(cookie_info.hasExpiryDate()); //true/false
				System.out.println(cookie_info.getExpiryDate());
				
				System.out.println(cookie_info.hasValue()); //true/false
				System.out.println(cookie_info.getValue());
				
					
			}

}
