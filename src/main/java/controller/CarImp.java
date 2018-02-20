package controller;
import model.CarPos;
import model.Lidar;
import model.Radar;

/*

* The first phase of this project concerns test-driven development of a module
* that has  the basic functionalities regarding an
* autonomous lane change system.
*
*/
public class CarImp implements Car {
	public Actuator act;
    public Radar r1, r2, r3;
    public Lidar lidar;
    public CarPos carPos = new CarPos();
    
    public CarImp(int x,int y, Actuator act) {
    	carPos.setX(x);
    	carPos.setY(y);
    	this.act = act;
    }
    
    public CarImp() {
    	carPos.setX(3);
    	carPos.setY(0);
    }
   

    public static void main(String[] args) {
        int[] radarValues = {30, 340, 220};
        //System.out.println(add(4, 5));
        //System.out.println(leftLaneDetect(radarValues, 30, 1));
    }

    public String  leftLaneDetect(Radar radars[], Lidar lidar, int query) {
        int faultyReadings = 0;

        //checking for sensor faulty readings, needed for cases no: 12,13,14,20,24
        for (int i = 0; i < radars.length; i++) {
            if (radars[i].getReading() > 50 || radars[i].getReading() < 0) {
                faultyReadings++;
            }
        }
        if (lidar.getReading() > 50 || lidar.getReading() < 0) {
            faultyReadings++;
        }

        //If more than 2 faulty readings, return error.
        if (faultyReadings > 1) {
            return "Error: faulty readings";
        }

        //Check if there is a car 5 meters to the car's left
        //Satisfies test cases no: 15-18
        for (int i = 0; i < radars.length; i++) {
            if (radars[i].getReading() >= 0 && radars[i].getReading() < 6) {
                return "Car detected";
            }
        }
        if (lidar.getReading() >= 0 && lidar.getReading() < 6) {
            return "Car detected";
        }

        //If the method was only called once, it will call itself again
        if (query == 1) {
            leftLaneDetect(radars, lidar,2);
        }	
        
        //Otherwise no car has been detected, needed for cases no: 10,11,23
        return "No car detected";
    }

    public String changeLane(CarImp auto, Radar radarValues[], Lidar lidar){
  
    	String str1 ="No car detected" ;
    	String str2 = "Car detected";
    	String str3 = "Error: faulty readings";
        String detect = leftLaneDetect(radarValues, lidar, 1);
        
        int x = carPos.getX();
        int y = carPos.getY();
        System.out.print("testing"+y);
  
        //checking corrrect bound of the y value.
    	if (detect.equals(str1) ) {
    		if (y < 0 || y > 95) {
    			return "y value incorrrect";
    		}
			moveForward();
			//check for car lane is with possible change lane condition 
			if ( x >= 2 && x <= 3) {
				 carPos.setX(x - 1);
				 return "Lane changed";
			}
			else {
				return "Can't change from this lane";
			}
    	}
    	else if (detect.equals(str2)) {
    		moveForward();
    		return "Lane change failed car detected";
    	}
    	else if (detect.equals(str3)) {
    		moveForward();
    		return "Lane change failed,Error:faulty readings";
    	}
		return null;
    }

    //Satisfies test cases 1-3
    public int[] whereIs() {
    	int[] ReturnArray = {carPos.getX(), carPos.getY()};
        return ReturnArray;
    }
    
     public int moveForward() {
    	int newPos = act.moveCar(carPos, 5);
    	carPos.setY(newPos);
        return newPos;
	}
     
    public int add(int x, int y) {
    	return x + y;
    }
}
