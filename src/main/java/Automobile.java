import org.junit.experimental.theories.Theories;

/*

* The first phase of this project concerns test-driven development of a module
* that has  the basic functionalities regarding an
* autonomous lane change system.
*
*/
public class Automobile implements CarInterFace {
    // first one is x and the second one is y
    int x;
    int y;
    
    public Automobile(int x,int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public Automobile() {
    	x = 3;
    	y = 0;
    }
   

    public static void main(String[] args) {
        int[] radarValues = {30, 340, 220};
        //System.out.println(leftLaneDetect(radarValues, 30, 1));
    }

    public String  leftLaneDetect(Radar radars[], Lidar lidar, int query) {
        int faultyReadings = 0;

        //checking for sensor faulty readings
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
        return "No car detected";
    }

    public String changeLane(Automobile auto, Radar radarValues [], Lidar lider  ){
  
    	String str1 ="No car detected" ;
    	String str2 = "Car detected";
    	String str3 = "Error: faulty readings";

        String detect = leftLaneDetect(radarValues, lider, 1);
        
        if (radarValues.length < 3) {
        		return "Too few radar inputs";
        }
        else if (radarValues.length > 3) {
        		return "too many inputs";
        }
        else if (auto.x > 3) {
    		return "fautly X values only three is allowed";
        }
        
    	if (detect.equals(str1) ) {
		 moveForward(auto);
		 if ( auto.x >= 2 && auto.x <= 3) {
			 auto.x--;
			 }
		   //System.out.println("Lane changed :" );
		 	return "Lane changed";
		 
    	}
    	else if (detect.equals(str2)) {
    		moveForward(auto);
    		//System.out.println("Lane changed failed:");
    		return "Lane changed failed car detected";
		 
    	}
    	else if (detect.equals(str3)) {
    		moveForward(auto);
    		//System.out.println("Lane changed failed");
    		return "Lane changed failed: Error:faulty";
    	}
		return null;
    }


    public String whereIs(){
    	String ReturnString = "Longitude:" + x + " latitude:" + y;
        return ReturnString;
    }
       public int moveForward(Automobile auto){
    	int val;
        if(auto.y < 96 && auto.y >= 0 ){
            auto.y += 5;
            val = auto.y;
        }else if(auto.y >= 96 && auto.y <= 100) {
        	val = auto.y;
        }else {
        	val = -1;
        }
        return val;
    }
}
