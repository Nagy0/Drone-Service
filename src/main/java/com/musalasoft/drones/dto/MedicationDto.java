package com.musalasoft.drones.dto;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.musalasoft.drones.constants.Constants;
import com.musalasoft.drones.model.Drone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MedicationDto {

	private Integer id;
	@Pattern(regexp = Constants.MEDICATION_NAME_REGEX, message = Constants.MEDICATION_NAME_REGEX_ERROR_MESSAGE)
	private String name;
	private double weight;
	@Pattern(regexp = Constants.MEDICATION_CODE_REGEX, message = Constants.MEDICATION_CODE_REGEX_ERROR_MESSAGE)
	private String code;
	private byte[] image;
	@JsonIgnore
	private Drone drone;
}
