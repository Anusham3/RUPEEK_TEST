package com.json_server.generics;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;

/**
 * 
 * @author Admin
 *
 */
public class BaseLib {
	/**
	 * to initialize the base URI, port and authentication
	 */
	public static String token;

	@BeforeSuite
	public void config() {
		baseURI = "http://13.126.80.194";
		port = 8080;

		

	}

	@BeforeTest

	public void authenticate() {

		try {

			FileInputStream fis = new FileInputStream(new String("./src/test/resources/Json/Create.json"));
			Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
					.post(IEndPoints.CREATE_TOKEN);
			response.then().assertThat().contentType(ContentType.JSON).and().statusCode(200);

			
			String token = response.toString();
		
			given().auth().oauth2(token);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}


}
