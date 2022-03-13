package com.musalasoft.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musalasoft.drones.model.BatteryLevelAudit;

@Repository
public interface BatteryLevelAuditRepo extends JpaRepository<BatteryLevelAudit, Integer> {

}
