package com.musalasoft.drones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musalasoft.drones.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {

	@Transactional
	@Query(value = "SELECT * FROM DRONE WHERE STATE = ?1", nativeQuery = true)
	public List<Drone> findAvailbleDrones(String state);
}
