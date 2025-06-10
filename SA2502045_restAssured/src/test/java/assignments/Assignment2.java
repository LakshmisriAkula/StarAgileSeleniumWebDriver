package assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment2 {
	String req_URL = "https://petstore.swagger.io/v2/pet";

	@Test
	public void addNewPET() {
		Response res = RestAssured.get(req_URL);
		
		

		System.out.println(res.asPrettyString());

		String petID = res.jsonPath().get("id");

		Assert.assertEquals(petID, 111, "Pet ID not matched");

	}
}
