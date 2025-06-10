package assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Assignment1 {
//	Q.1. Find the endpoints and test with Postman using chai assertion and automate same in
//	RESTAssured.
	public static int generatedID;

	@Test(priority = 1)
	public void getPetByStatus() {

		String req_URL = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";

		Response res = RestAssured.get(req_URL);

		System.out.println(res.asPrettyString());
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Status code is invalid");

	}

	@Test(priority = 2)
	public void addPetToStore() {

		System.out.println("Adding pet to the store");

		String post_Req_URL = "https://petstore.swagger.io/v2/pet";

		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body("{\r\n" + "\"id\": 111,\r\n" + "\"category\": {\r\n" + "\"id\": 0,\r\n"
						+ "\"name\": \"string\"\r\n" + "},\r\n" + "\"name\": \"doggie\",\r\n" + "\"photoUrls\": [\r\n"
						+ "\"string\"\r\n" + "],\r\n" + "\"tags\": [\r\n" + "{\r\n" + "\"id\": 0,\r\n"
						+ "\"name\": \"string\"\r\n" + "}\r\n" + "],\r\n" + "\"status\": \"available\"\r\n" + "}'\r\n"
						+ "")
				.when().post(post_Req_URL);

		response.then().statusCode(200).body("id", equalTo(111)).log().body();

		generatedID = response.jsonPath().getInt("id");

		System.out.println("Extracted ID: " + generatedID);

	}

	@Test(priority = 3)
	public void getWithGeneratedID() {

		System.out.println("Retrieving pet details with generated ID");

		given().header("accept", "application/json").when().get("https://petstore.swagger.io/v2/pet/" + generatedID)
				.then().statusCode(200).body("id", equalTo(generatedID)).log().body();
	}

	@Test(priority = 4)
	public void updatePetDetails() {

		System.out.println("Updating pet details");

		given().header("accept", "application/json").header("Content-Type", "application/json")
				.body("{\r\n" + "\"id\": 0,\r\n" + "\"category\": {\r\n" + "\"id\": 0,\r\n" + "\"name\": \"string\"\r\n"
						+ "},\r\n" + "\"name\": \"doggie\",\r\n" + "\"photoUrls\": [\r\n" + "\"string\"\r\n" + "],\r\n"
						+ "\"tags\": [\r\n" + "    {\r\n" + "\"id\": 0,\r\n" + "\"name\" : \"string\"\r\n" + "}\r\n"
						+ "],\r\n" + "\"status\": \"available\"\r\n" + "}\r\n" + "")
				.when().put("https://petstore.swagger.io/v2/pet").then().statusCode(200).log().body();

	}

	@Test(priority = 5)

	public void deleteExistingPetDetails() {

		System.out.println("Deleting existing pet details");

		given().header("accept", "application/json").when().delete("https://petstore.swagger.io/v2/pet/" + generatedID)
				.then().statusCode(200).log().body();
	}

}
