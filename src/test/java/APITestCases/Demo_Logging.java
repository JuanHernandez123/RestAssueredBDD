package APITestCases;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Demo_Logging {
	//@Test(priority=1)
	void testLogging1()
	{
		given()
			.when()
				.get("https://reqres.in/api/users?page=2")
		.then()
			//.log().body()
			//.log().headers()
			//.log().cookies()
			.log().all();
	}
	
	@Test(priority=2)
	void testLogging2()
	{
		given()
			.when()
				.get("https://reqres.in/api/users/23")
		.then()
			//.log().ifError() // It will print only if is an error
			//.log().ifStatusCodeIsEqualTo(404) It will print only if the statement is accomplished
			.log().ifValidationFails()
			.contentType("text/html; charset=UTF-8")  //Actual is "application/json"
			;
	}

}
