DROP TABLE IF EXISTS DRONE;

CREATE TABLE DRONE (
  id INT AUTO_INCREMENT PRIMARY KEY,
  SERIAL_NUMBER VARCHAR(100) NOT NULL,
  MODEL VARCHAR(100) NOT NULL,
  WEIGHT double NOT NULL,
  BATTERY_PERCENTAGE int NOT NULL,
  STATE VARCHAR(100) NOT NULL
); 

DROP TABLE IF EXISTS BATTERY_LEVEL_AUDIT;
CREATE TABLE BATTERY_LEVEL_AUDIT (
  id INT AUTO_INCREMENT PRIMARY KEY,
  DRONE_ID INT NOT NULL,
  BATTERY_LEVEL VARCHAR(100) NOT NULL
 
);

DROP TABLE IF EXISTS Medication;
CREATE TABLE Medication (
	ID INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(100) NOT NULL,
	WEIGHT double NOT NULL,
	CODE VARCHAR(100) NOT NULL,
	drone_id INT NOT NULL,
	IMAGE BLOB,
	foreign key (drone_id) references DRONE(ID)
);