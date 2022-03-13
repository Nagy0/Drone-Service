package com.musalasoft.drones.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DroneMaxWeightReached extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 46212088226625086L;
	
	private String message;
	
	public DroneMaxWeightReached(String errorMessage) {
		this.message = errorMessage;
	}
}
