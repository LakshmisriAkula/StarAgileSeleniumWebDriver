package assignments;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Assignment2 {

//	Q.2 Write an automation script to create POST Request using HashMap and POJO class

	String post_Req_URL = "https://api.restful-api.dev/objects";

	@Test
	public void PostRequestUsingHashMap() {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("year", 2019);
		data.put("price", 1849.99);
		data.put("CPUmodel", "Intel Core i9");
		data.put("Harddisk size", "1 TB");

		HashMap<String, Object> requestBody = new HashMap<String, Object>();
		requestBody.put("name", "Apple MacBook Pro 16");
		requestBody.put("data", data);

		given().header("Content-Type", "application/json").body(requestBody).when().post(post_Req_URL).then()
				.statusCode(200).log().body();

	}

	@Test
	public void PostRequestUsingPojo() {

		MacBookData macData = new MacBookData();
		macData.setYear(2019);
		macData.setPrice(1849.99);
		macData.setCpuModel("Intel Core i9");
		macData.setHarddiskSize("1 TB");

		PojoData data = new PojoData();
		data.setName("Apple MacBook Pro 16");
		data.setData(macData);

		given().header("Content-Type", "application/json").body(data).when().post(post_Req_URL).then().statusCode(200)
				.log().body();

	}
}
