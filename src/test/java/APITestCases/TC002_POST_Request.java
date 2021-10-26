package APITestCases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class TC002_POST_Request {

	public static HashMap map = new HashMap();

	@BeforeClass
	public void postdata() {

		map.put("name", RestUtils.getUserName());
		map.put("job", RestUtils.getJob());

		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users";
	}

	@Test
	public void testPost() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201);
	}

}
