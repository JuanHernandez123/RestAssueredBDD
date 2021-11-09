package APITestCases;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class Demo_Authentication_API {
	//Basic Authentication, all the options working fine
		//@Test
		void testBasicAuthentication()
		{
			
			given()
				//.auth().basic("ToolsQA", "TestPassword")
			.auth().preemptive().basic("ToolsQA", "TestPassword")
			//digest command is used when the is necessary other parameters to log In
			//.auth().digest("ToolsQA", "TestPassword")
			
			.when()
			
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
			
			.then()
				.statusCode(200)
				.assertThat().body("FaultId",equalTo("OPERATION_SUCCESS"))
				.assertThat().body("Fault",equalTo("Operation completed successfully"))
				.log().all();
				
		}
		
		
		///Bearer Token Authentication
		@Test(priority=2)
		void testBearerTokenAuthentication() throws IOException
		{
			
			String bearerToken="E4F284BFADA11D01A52508ED7B92FFD7EE0905659F5DED06A4B73FC7739B48A287648801";
			//myRequest contains the body to send the post request
			String myRequest=RestUtils.generateStringFromResource(".\\Resources\\PostData.txt");
					
			given()
				.headers("Authorization","Bearer " + bearerToken)
				.contentType("text/xml")
				.body(myRequest)
			.when()
				.post("https://certtransaction.elementexpress.com")
			
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 200 OK")
				.log().all();			
		
		}

}
