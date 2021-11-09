package APITestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;

public class Demo_RequestAndResponseSpecBuilder {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	void setup()
	{
		RequestSpecBuilder req_Builder=new RequestSpecBuilder();
		
		req_Builder.addParam("myparam", "paramValue1");
		req_Builder.addHeader("myheader", "headerValue1");
		req_Builder.setBaseUri("https://jsonplaceholder.typicode.com");
		req_Builder.setContentType(ContentType.JSON);
		requestSpec=req_Builder.build();
		
		//Used to verify the common expected
		ResponseSpecBuilder res_Builder=new ResponseSpecBuilder();
		res_Builder.expectStatusCode(200);
		res_Builder.expectStatusLine("HTTP/1.1 200 OK");
		res_Builder.expectHeader("Content-Type","application/json; charset=utf-8");
		res_Builder.expectHeader("Content-Encoding","gzip");
		responseSpec=res_Builder.build();
		
	}
	
	@Test(priority=1)
	void test_albums()
	{
		given()
			.spec(requestSpec)
		
		.when()
			.get("/users/1/albums")
		
		.then()
			.spec(responseSpec)
			.log().all();
		
	}
	
	@Test(priority=2)
	void test_todos()
	{
		given()
		.spec(requestSpec)
	
	.when()
		.get("/users/1/todos")
	
	.then()
		.spec(responseSpec)
		.log().all();
	}
	
	@Test(priority=3)
	void test_posts()
	{
		given()
		.spec(requestSpec)
	
	.when()
		.get("/users/1/posts")
	
	.then()
		.spec(responseSpec)
		.log().all();
	}
	
	
}






