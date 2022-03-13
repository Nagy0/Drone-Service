package com.musalasoft.drones.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musalasoft.drones.dto.BatteryLevelResponse;
import com.musalasoft.drones.dto.DroneDto;
import com.musalasoft.drones.dto.MedicationDto;
import com.musalasoft.drones.exception.DroneMaxWeightReached;
import com.musalasoft.drones.exception.DroneNotFoundException;
import com.musalasoft.drones.exception.LowBatterException;
import com.musalasoft.drones.service.DroneService;

@RestController
@RequestMapping("/drone")
public class DroneController {

	@Autowired
	private DroneService droneService;

	@PostMapping("/register")
	public ResponseEntity<DroneDto> registerDrone(@Valid @RequestBody DroneDto droneDto) {
		DroneDto drone = droneService.registerDrone(droneDto);
		return new ResponseEntity<>(drone, HttpStatus.OK);
	}

	@PutMapping("/load-drone-items")
	public ResponseEntity<Object> loadDroneItems(@RequestParam Integer id,
			@Valid @RequestBody List<MedicationDto> medicationList) {
		try {
			return new ResponseEntity<>(droneService.loadDroneItems(medicationList, id), HttpStatus.OK);
		} catch (DroneNotFoundException | LowBatterException | DroneMaxWeightReached e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<DroneDto> getDroneById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(droneService.findDroneByid(id), HttpStatus.OK);
		} catch (DroneNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}/medications")
	public ResponseEntity<List<MedicationDto>> getDroneMedications(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(droneService.getLoadedMedications(id), HttpStatus.OK);
		} catch (DroneNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/availableDrones")
	public ResponseEntity<List<DroneDto>> availableDrones() {
		return new ResponseEntity<>(droneService.getAvailableDrones(), HttpStatus.OK);
	}

	@GetMapping("/{id}/checkBatterLevel")
	public ResponseEntity<BatteryLevelResponse> chechBatterLevel(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(droneService.checkBatterLevel(id), HttpStatus.OK);
		} catch (DroneNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
