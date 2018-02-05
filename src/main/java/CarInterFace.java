
import java.lang.*;
//import java.util.*;

public interface CarInterFace { 
	
	/*Description : The car moves five meters until it has 
	  reached 100meter.
	  
	  Precondition: The y position of the car.
	  
	  Postcondition: The position.
	 */
	public int moveForward(Automobile auto);
	
	
	/*
	  Description: Detects if a car is nearby (0-5 meters away) using 3 radars and 1 lidar. Queries itself
	  twice to revise its readings. Alerts the user if their is more than 1 faulty sensor reading as well.
	  Only one reading between 0-5 meters is needed for the car to alert that another car was detected.
		
	  Pre-condition: All sensors give a reading to be analyzed. 

	  Post-condition: Returns if a car is detected, not detected, or if their are faulty sensor readings.
	  
	  Test-cases:
	*/
	public String leftLaneDetect(Radar radars[], Lidar lidar, int query); 
	
	
	/*
	  Description: It gets the X (longitud) and Y (latitudinal) values of the car and returns it as a String.

	  Pre-condition: The X and Y values of the car need to be initialized. 

	  Post-condition: Returns the longitud and latitudinal value of the cars.
	  
	  Test-cases:
	*/
	public String whereIs();
}
