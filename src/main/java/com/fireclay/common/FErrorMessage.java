/**
 * 
 */
package com.fireclay.common;

/**
 * @author Franklin Chua
 *
 */
public enum FErrorMessage {

	INVALID_REQUIRED_FIELDS("One or more required fields contain invalid data"),
	DUPLICATE_USERNAME("Username is already taken"),
	DUPLICATE_BUSINESS_NAME("Duplicate business name"),
	INVALID_PASSWORD("Password is required");
	
	private String message;
	
	FErrorMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
