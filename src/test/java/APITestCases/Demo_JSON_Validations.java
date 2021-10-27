package APITestCases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo_JSON_Validations {

	// Web site to get the path from a JSON field https://jsonpathfinder.com/

	@Test(priority = 1)
	public void statusValidation() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log()
			.all();
	}

	@Test(priority = 2)
	public void getLogResponseAndSingleContent() {
		given().when()
			.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.assertThat()
		.body("data.email", equalTo("janet.weaver@reqres.in"))
		.log().all();
	}

	@Test(priority = 3)
	public void testMultipleContent() {
		//To verify multiple information in a JSON
		given()
		.when()
			.get("https://reqres.in/api/unknown")
		.then()
			.statusCode(200)
			.assertThat()
			.body("data.name", hasItems("cerulean","true red","blue turquoise"));
	}
	
	@Test(priority = 4)
	public void setParamsAndHeaders() {
		given()
			.param("MyName", "Abcd")
			.header("MyContry", "efgh")
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)	
		.log().all();
	}
}
