package com.musalasoft.drones.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musalasoft.drones.constants.Constants;
import com.musalasoft.drones.dto.BatteryLevelResponse;
import com.musalasoft.drones.dto.DroneDto;
import com.musalasoft.drones.dto.MedicationDto;
import com.musalasoft.drones.exception.DroneMaxWeightReached;
import com.musalasoft.drones.exception.DroneNotFoundException;
import com.musalasoft.drones.exception.LowBatterException;
import com.musalasoft.drones.model.Drone;
import com.musalasoft.drones.model.Medication;
import com.musalasoft.drones.model.State;
import com.musalasoft.drones.repository.DroneRepository;
import com.musalasoft.drones.service.DroneService;

@Service
public class DroneServiceImpl implements DroneService {

	@Autowired
	private DroneRepository droneRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public DroneDto registerDrone(DroneDto droneDto) {
		Drone drone = mapper.map(droneDto, Drone.class);
		return mapper.map(droneRepository.save(drone), DroneDto.class);
	}

	@Override
	public DroneDto loadDroneItems(List<MedicationDto> medications, Integer droneId)
			throws DroneNotFoundException, LowBatterException, DroneMaxWeightReached {
		Optional<Drone> droneOptional = droneRepository.findById(droneId);
		if (droneOptional.isPresent()) {
			Drone drone = droneOptional.get();
			if (drone.getBatteryPercentage() < 25) {
				throw new LowBatterException(Constants.DRONE_BATTERY_LOW);
			}
			double itemsWeight = checkItemsWeight(medications);
			if(itemsWeight > drone.getWeight()) {
				throw new DroneMaxWeightReached(Constants.DRONE_MAX_WEIGHT_REACHED);
			}
			for (MedicationDto medication : medications) {
				Medication medicationEntity = mapper.map(medication, Medication.class);
				drone.getMedications().add(medicationEntity);
				medicationEntity.setDrone(drone);
			}
			drone.setState(State.LOADED.toString());
			return mapper.map(droneRepository.save(drone), DroneDto.class);
		}
		throw new DroneNotFoundException(Constants.DRONE_NOT_FOUND);
	}

	@Override
	public DroneDto findDroneByid(Integer id) throws DroneNotFoundException {
		Optional<Drone> droneOptional = droneRepository.findById(id);
		if (droneOptional.isPresent()) {
			Drone drone = droneOptional.get();
			return mapper.map(drone, DroneDto.class);
		}
		throw new DroneNotFoundException(Constants.DRONE_NOT_FOUND);
	}

	@Override
	public List<DroneDto> getAvailableDrones() {
		List<Drone> drones = droneRepository.findAvailbleDrones(State.IDLE.toString());
		return drones.stream().map(drone -> mapper.map(drone, DroneDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<MedicationDto> getLoadedMedications(Integer id) throws DroneNotFoundException {
		DroneDto droneDto = findDroneByid(id);
		return droneDto.getMedications();
	}

	@Override
	public BatteryLevelResponse checkBatterLevel(Integer id) throws DroneNotFoundException {
		DroneDto droneDto = findDroneByid(id);
		return BatteryLevelResponse.builder().batteryLevel(droneDto.getBatteryPercentage()).build();
	}

	private double checkItemsWeight(List<MedicationDto> medications) {
		double weight = 0.0;
		for (MedicationDto medication : medications) {
			weight += medication.getWeight();
		}
		return weight;
	}
}
