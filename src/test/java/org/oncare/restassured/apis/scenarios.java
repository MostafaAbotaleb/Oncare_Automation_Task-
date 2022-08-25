package org.oncare.restassured.apis;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.oncare.restassured.utils.payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class scenarios  {
	public static String id;
	public static void main(String[] args) {
		RestAssured.baseURI="https://petstore.swagger.io/";


		//Post ----> will create id for new order
		String response=given().log().all().header("Content-Type","application/json")
				.body(payload.addPayload())
				.when().post("v2/store/order")
				.then().assertThat().statusCode(200).body("status", equalTo("placed"))
				.header("server", "Jetty(9.2.9.v20150224)").extract().response().asString();

		System.out.println(response);

		JsonPath js=new JsonPath(response); //for parsing Json
		id=js.getString("id");

		System.out.println(id);

		//Update ----->will update the quantity to 2 for the same id

		String responseUpdated=given().log().all().header("Content-Type","application/json")
				.body(payload.addPayloadForUpdate())
				.when().post("v2/store/order")
				.then().assertThat().statusCode(200).body("quantity", equalTo(2))
				.header("server", "Jetty(9.2.9.v20150224)").extract().response().asString();

		System.out.println(responseUpdated);

		JsonPath js1=new JsonPath(responseUpdated); //for parsing Json
		String   idOfUpdated=js1.getString("id");

		System.out.println(idOfUpdated);



		//Get ---->will get the same id with assertion on the quantity = 2


		String responseUpdated2=given().log().all().header("Content-Type","application/json")
				.when().get("v2/store/order/"+id)
				.then().assertThat().statusCode(200).body("quantity", equalTo(2))
				.header("server", "Jetty(9.2.9.v20150224)").extract().response().asString();

		System.out.println(responseUpdated2);

		JsonPath js2=new JsonPath(responseUpdated2); //for parsing Json
		String   idOfget=js2.getString("id");

		System.out.println(idOfget);


		//Delete ----->will delete the same id of the order

		String responseUpdated3=given().log().all().header("Content-Type","application/json")
				.when().delete("v2/store/order/"+id)
				.then().assertThat().statusCode(200).body("message", equalTo(id))
				.header("server", "Jetty(9.2.9.v20150224)").extract().response().asString();

		System.out.println(responseUpdated3);


		// Get again after deleting----> the code will be 404 and the message "Order not found"

		String responseUpdated4=given().log().all().header("Content-Type","application/json")
				.when().get("v2/store/order/"+id)
				.then().assertThat().statusCode(404).body("message", equalTo("Order not found"))
				.header("server", "Jetty(9.2.9.v20150224)").extract().response().asString();

		System.out.println(responseUpdated4);


	}

}
