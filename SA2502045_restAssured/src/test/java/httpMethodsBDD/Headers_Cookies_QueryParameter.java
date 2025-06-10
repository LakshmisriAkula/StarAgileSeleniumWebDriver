package httpMethodsBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Headers_Cookies_QueryParameter {

	String reqres_URL = "https://reqres.in/api/users?page=2";

	@Test
	public void headersTest() {

		given().when().get(reqres_URL).then().statusCode(200).log().headers();

//		Response res = given().when().get(reqres_URL);
//				System.out.println("Print header "+ res.header("X-Powered-By"));
//				System.out.println("Print header "+ res.header("Content-Type"));
	}

	@Test
	public void queryParameterTest() {

		given().header("x-api-key", "reqres-free-v1").pathParam("path", "users").queryParam("page", "1").when()
				.get("https://reqres.in/api/{path}").then().statusCode(200).log().all();

	}

	@Test
	public void cookiesTest() {
		given().when().get("https://www.google.com/").then().log().cookies();

		Response res = given().when().get("https://www.google.com/");

		System.out.println("Cookie details of NID " + res.cookie("NID"));

		System.out.println("Cookie details of AEC " + res.cookie("AEC"));

	}
}
