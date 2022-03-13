package com.musalasoft.drones.constants;

public final class Constants {

	public static final String DRONE_NOT_FOUND = "Drone not found!!";
	public static final String DRONE_BATTERY_LOW = "Drone battery is below 25%";
	public static final String DRONE_MAX_WEIGHT_REACHED = "Drone max weight reached.";
	public static final String ALLOWED_DRONE_MODELS = "CRUISERWEIGHT" + "|" + "HEAVYWEIGHT" + "|" + "LIGHTWEIGHT" + "|"
			+ "MIDDLEWEIGHT";
	public static final String ALLOWED_DRONE_STATES = "IDLE" + "|" + "LOADING" + "|" + "LOADED" + "|"
			+ "DELIVERING" + "|" + "DELIVERED" + "|" + "RETURNING";
	
	public static final String DRONE_MODEL_NOT_ALLOWED = "Drone Model not allowed";
	public static final String DRONE_STATE_NOT_ALLOWED = "Drone State not allowed";
	
	public static final String MEDICATION_NAME_REGEX = "^[a-zA-Z0-9_-]*$";
	public static final String MEDICATION_NAME_REGEX_ERROR_MESSAGE = "(allowed only letters, numbers, ‘-‘, ‘_’)";
	
	public static final String MEDICATION_CODE_REGEX = "^[A-Z0-9_]*$";
	public static final String MEDICATION_CODE_REGEX_ERROR_MESSAGE = "(allowed only upper case letters, underscore and numbers)";


}
