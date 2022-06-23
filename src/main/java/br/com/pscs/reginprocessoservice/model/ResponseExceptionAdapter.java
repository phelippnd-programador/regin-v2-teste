package br.com.pscs.reginprocessoservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ResponseExceptionAdapter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private LocalDateTime timestamp;
	private String description;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
