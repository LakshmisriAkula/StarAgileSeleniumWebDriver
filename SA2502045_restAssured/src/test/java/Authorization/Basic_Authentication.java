package Authorization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Basic_Authentication {

	@Test
	public void Base_Authentication() {
		String base_Auth_Req = "https://postman-echo.com/basic-auth";

		Response res = given().auth().basic("postman","password").when().get(base_Auth_Req);
		
		res.then().body("authenticated", equalTo(true)).log().body();

	}

}
