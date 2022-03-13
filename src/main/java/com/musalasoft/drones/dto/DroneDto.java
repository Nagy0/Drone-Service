package com.musalasoft.drones.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.musalasoft.drones.constants.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DroneDto {

	private Integer id;
	@Max(value = 100)
	private String serialNumber;
	@Pattern(regexp = Constants.ALLOWED_DRONE_MODELS, message = Constants.DRONE_MODEL_NOT_ALLOWED)
	private String model;
	@Min(value = 0) 
	@Max(value = 500)
	private double weight;
	private Integer batteryPercentage;
	@Pattern(regexp = Constants.ALLOWED_DRONE_STATES, message = Constants.DRONE_STATE_NOT_ALLOWED)
	private String state;
	private List<MedicationDto> medications = new ArrayList<>();
}
