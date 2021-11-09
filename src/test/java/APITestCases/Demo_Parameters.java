package APITestCases;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Demo_Parameters {
	
	//https://jsonplaceholder.typicode.com/comments?postId=1
	//@Test(priority=1)
	void testQueryParams()
	{
		given()
			.queryParam("postId",1)
				
		.when()
			.get("https://jsonplaceholder.typicode.com/comments")
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
	}
	
	//http://restapi.demoqa.com/utilities/weather/Delhi
	@Test(priority=2)
	void testPathParams()
	{
		given()
			.pathParam("city", "Delhi")
		
		.when()
			.get("http://restapi.demoqa.com/utilities/weather/{city}")
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
		
	}

}
