package com.json_server.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import com.json_server.generics.BaseLib;
import com.json_server.generics.IEndPoints;
import io.restassured.http.ContentType;
/**
 * 
 * @author Admin
 *
 */

public class GetUser extends BaseLib {
	
	/**
	 * to get all users Details
	 */   
	
	@Test(priority=0)
	public void getAllUser() {

		when().get(IEndPoints.GET_ALL_USERS).then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	
	}
	
	/**
	 * To get Single user by using valid Phone number
	 */
   
	@Test(priority=1)

	public void getSingleUserWithValidPhoneNum() {
		given().pathParam("phone", 9995879555l).when().get(IEndPoints.GET_USER_PHONE).then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).and().body("first_name", equalTo("Folrunsho"))
				.and().body("last_name", equalTo("Alakija")).and().body("career", equalTo("Billionaire Oil Magnate"));
			

	}
	
	/**
	 * To get Single user by using Invalid Phone number
	 */

	@Test(priority=2)

	public void getSingleUserWithInValidPhonenum() {
		given().pathParam("phone", 99958765).when().get(IEndPoints.GET_USER_PHONE).then().assertThat().statusCode(404)
				.and().contentType(ContentType.JSON);

	}

}