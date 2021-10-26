package APITestCases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC001_GET_Request {

	@Test
	void getAnUser() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.assertThat().body("data.email", equalTo("janet.weaver@reqres.in"))
			.header("Content-Type", "application/json; charset=utf-8");
	}

}
