package com.musalasoft.drones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.musalasoft.drones.model.BatteryLevelAudit;
import com.musalasoft.drones.model.Drone;
import com.musalasoft.drones.repository.BatteryLevelAuditRepo;
import com.musalasoft.drones.repository.DroneRepository;

@Component
public class AuditPeriodicTask {

	@Autowired
	private DroneRepository droneRepo;

	@Autowired
	private BatteryLevelAuditRepo batteryLevelAuditRepo;

	@Scheduled(fixedRate = 30 * 60 * 1000)
	public void logAuditForBatteryLevel() {
		List<Drone> drones = droneRepo.findAll();
		drones.stream().forEach(drone -> {
			batteryLevelAuditRepo.save(BatteryLevelAudit.builder().droneId(drone.getId())
					.batteryLevel(drone.getBatteryPercentage()).build());
		});
	}
}
