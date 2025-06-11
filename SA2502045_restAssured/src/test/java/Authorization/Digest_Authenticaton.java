package Authorization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Digest_Authenticaton {

	@Test
	public void digest_Auth() {

		String digest_Auth_Req = "https://postman-echo.com/basic-auth";

		given().auth().digest("postman", "password").when().get(digest_Auth_Req).then()
				.body("authenticated", equalTo(true)).log().body();

	}

}
