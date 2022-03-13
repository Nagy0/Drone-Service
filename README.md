# Drone-Service

- This is a proposed design solution for Drone-service.
- This project uses JDK 11 and H2 in memory database and maven as build tool.

Steps to start the service:
1- import the project to any IDE.
2- Start the spring boot service.
3- You can navigate to http://localhost:8080/drone-service/h2-consol to see pre insetrted data for Drone table.

To test the mentioned api.
1- Register a drone: http://localhost:8080/drone-service/drone/register with json request body
2- Get drone by drone id: http://localhost:8080/drone-service/drone/{id}
3- load medications to drone: http://localhost:8080/drone-service/drone/load-drone-items/{id} with json request body
4- get drone medications:  http://localhost:8080/drone-service/drone/{id}/medications with json request body.
5- Get avilable drones:  http://localhost:8080/drone-service/drone/availableDrones
6- Check Drone battery level:  http://localhost:8080/drone-service/drone/{id}/checkBatterLevel


And the periodic task for auditing dron's batter levels is implmented in AuditPeriodicTask.java class.
