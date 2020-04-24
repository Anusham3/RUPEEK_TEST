package com.json_server.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import com.json_server.generics.BaseLib;
import com.json_server.generics.IEndPoints;

import io.restassured.http.ContentType;

public class GetUser extends BaseLib {

	@Test
	public void getAll() {

		when().get(IEndPoints.GET_ALL_USERS).then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.and().time(lessThan(1400l));
	}

	@Test

	public void getSingleResourceWithValidId() {
		given().pathParam("phone", 9995879555l).when().get(IEndPoints.GET_USER_PHONE).then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).and().body("first_name", equalTo("Folrunsho"))
				.and().body("last_name", equalTo("Alakija")).and().body("career", equalTo("Billionaire Oil Magnate"))
				.and().time(lessThan(1000l));

	}

	@Test

	public void getSingleResourceWithInValidId() {
		given().pathParam("phone", 99958765).when().get(IEndPoints.GET_USER_PHONE).then().assertThat().statusCode(404)
				.and().contentType(ContentType.JSON).and().time(lessThan(2000l));

	}

}