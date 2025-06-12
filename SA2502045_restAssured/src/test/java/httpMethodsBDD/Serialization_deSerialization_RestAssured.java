package httpMethodsBDD;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization_deSerialization_RestAssured {

	@Test
	public void serializationTest() throws JsonProcessingException {

		// here data in java object format.
		PojoData pdata = new PojoData();
		pdata.setName("Ketaki Rane");
		pdata.setJob("Business Analyst");

		ObjectMapper obj = new ObjectMapper();
		String jData = obj.writerWithDefaultPrettyPrinter().writeValueAsString(pdata);
		System.out.println("Jdata " + jData); // converting java --> json

		System.out.println("-----------------------------------------------------------");
	}

	@Test
	public void deSerializationTest() throws JsonProcessingException {
		String jData = "{\n" + "  \"name\" : \"Ketaki Rane\",\n" + "  \"job\" : \"Business Analyst\"\n" + "}";

		ObjectMapper obj = new ObjectMapper();
		PojoData pjD = obj.readValue(jData, PojoData.class); // json data ,

		System.out.println(pjD.getName());
		System.out.println(pjD.getJob());
	}

}
