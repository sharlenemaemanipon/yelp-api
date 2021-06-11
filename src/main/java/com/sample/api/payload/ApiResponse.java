package com.sample.api.payload;

/**
 * Generic API response payload to requests
 * 
 * @author SharleneMae.Manipon
 *
 */
public class ApiResponse {

	private Object data;
	private String message;

	public ApiResponse(Object data) {
		this.data = data;
		if (data != null) {
			this.setMessage("Success");
		}
	}

	public ApiResponse(Object data, String message) {
		this.data = data;
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
