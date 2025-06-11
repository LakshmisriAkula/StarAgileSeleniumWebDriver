package Authorization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class BearerTokenAuthorization {

	@Test
	public void Bearer_Auth() {

		String req_url = "https://api.github.com/user/repos";

		String bearer_Token = "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";

		given().header("Authorization", "Bearer " + bearer_Token).when().get(req_url).then().log().body();

	}

}
