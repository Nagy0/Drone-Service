package com.musalasoft.drones.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DroneNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4296212088226625086L;
	
	private String errorMessage;
	
	public DroneNotFoundException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
