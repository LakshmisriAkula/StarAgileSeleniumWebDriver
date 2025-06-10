package assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment1 {
	
	String req_URL = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
	@Test
	public void getPetByStatus() {
		
		Response res = RestAssured.get(req_URL);
		
		System.out.println(res.asPrettyString());
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Status code is invalid");
		
	}

}
