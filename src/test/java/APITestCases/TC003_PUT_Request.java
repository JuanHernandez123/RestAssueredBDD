package APITestCases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class TC003_PUT_Request {
	public static HashMap map = new HashMap();
	int emp_id = 2;

	@BeforeClass
	public void putData() {
		map.put("name", RestUtils.getUserName());
		map.put("job", RestUtils.getJob());

		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users/" + emp_id;

	}

	@Test
	public void testPUT() {
		given().
			contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			//Log is used to print all the request information
			.log().all();

	}
}
