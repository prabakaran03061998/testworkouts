package com.management.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultResponse {
	private Date timestamp;
	private String message;
	private String uid;
	private HttpStatus status;
	public DefaultResponse(Date timestamp, String message, HttpStatus status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
	}
	public DefaultResponse(Date timestamp, String message, String uid, HttpStatus status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.uid = uid;
		this.status = status;
	}
	

	

}
