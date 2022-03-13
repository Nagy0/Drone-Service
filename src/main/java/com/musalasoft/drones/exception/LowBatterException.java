package com.musalasoft.drones.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LowBatterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4292088226625086L;
	
	private String errorMessage;
	
	public LowBatterException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
