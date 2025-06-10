package api_Methods;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Multipleids_jsonValidation {
	String reqres_URL = "https://reqres.in/api/users?page=2";

	@Test
	public void getId_s() {

		Response res = RestAssured.get(reqres_URL);

		System.out.println("Response as " + res.asPrettyString());

		// List<Integer> NoOfIlds= res.jsonPath().get("data.id");
		List<Integer> NoOfIlds = res.jsonPath().getList("data.id");
		System.out.println("Id's" + NoOfIlds);

		for (Integer id : NoOfIlds) {
			System.out.println("Id's " + id);

		}
	}

}