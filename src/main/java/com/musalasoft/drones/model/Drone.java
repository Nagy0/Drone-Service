package com.musalasoft.drones.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "DRONE")
public class Drone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "SERIAL_NUMBER")
	private String serialNumber;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "WEIGHT")
	private double weight;
	
	@Column(name = "BATTERY_PERCENTAGE")
	private Integer batteryPercentage;
	
	@Column(name = "STATE")
	private String state;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "drone", orphanRemoval = true)
	private List<Medication> medications;
}
