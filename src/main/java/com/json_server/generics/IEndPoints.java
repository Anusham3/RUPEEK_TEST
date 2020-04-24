package com.json_server.generics;
/**
 * 
 * @author Admin
 *
 */

public interface IEndPoints {
	
	String GET_ALL_USERS="/api/v1/users";
	String GET_USER_PHONE="/api/v1/users/{phone}";
	String CREATE_TOKEN="/authenticate";
	

}
