
import java.lang.*;
//import java.util.*;

public interface CarInterFace {
    /*We check if the position of the y has changed
  and the car stops at the end of the street.
  Precondition:
  We need the location of the car.
  Postcondition:
  The position of the

 */
	public int moveForward(Automobile auto);
	
	
	/*
	  Description: Detects if a car is nearby (0-5 meters away) using 3 radars and 1 lidar. Queries itself
	  twice to revise its readings. Alerts the user if their is more than 1 faulty sensor reading as well.

	  Pre-condition: All sensors return a reading to be analyzed. 

	  Post-condition: Returns if a car is detected, not detected, or if their are faulty sensor readings.
	  
	  Test-cases:
	*/
	public String  leftLaneDetect(int radars[], int lidar, int query);
}
