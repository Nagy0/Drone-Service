package com.musalasoft.drones.service;

import java.util.List;

import com.musalasoft.drones.dto.BatteryLevelResponse;
import com.musalasoft.drones.dto.DroneDto;
import com.musalasoft.drones.dto.MedicationDto;
import com.musalasoft.drones.exception.DroneMaxWeightReached;
import com.musalasoft.drones.exception.DroneNotFoundException;
import com.musalasoft.drones.exception.LowBatterException;

public interface DroneService {

	DroneDto registerDrone(DroneDto droneDto);
	
	DroneDto loadDroneItems(List<MedicationDto> items, Integer droneId) throws DroneNotFoundException, LowBatterException, DroneMaxWeightReached;
	
	DroneDto findDroneByid(Integer id) throws DroneNotFoundException;
	
	List<DroneDto> getAvailableDrones();
	
	List<MedicationDto> getLoadedMedications(Integer id) throws DroneNotFoundException;
	
	BatteryLevelResponse checkBatterLevel(Integer id) throws DroneNotFoundException;
}
