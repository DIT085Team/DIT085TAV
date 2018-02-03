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

    public String  leftLaneDetect(int radars[], int lidar, int query) {
        int faultyReadings = 0;

        //checking for sensor faulty readings
        for (int i = 0; i < radars.length; i++) {
            if (radars[i] > 50 || radars[i] < 0) {
                faultyReadings++;
            }
        }
        if (lidar > 50 || lidar < 0) {
            faultyReadings++;
        }

        //If more than 2 faulty readings, return error.
        if (faultyReadings > 1) {
            return "Error: faulty readings";
        }

        //Check if there is a car 5 meters to the car's left
        for (int i = 0; i < radars.length; i++) {
            if (radars[i] >= 0 && radars[i] < 6) {
                return "Car detected";
            }
        }
        if (lidar >= 0 && lidar < 6) {
            return "Car detected";
        }

        //If the method was only called once, it will call itself again
        if (query == 1) {
            leftLaneDetect(radars, lidar,2);
        }
        return "No car detected";
    }

//    public void changeLane(){
//
//        int[] position;
//        int radarValues[] = {30, 34, 22};
//        
//        if (leftLaneDetect(radarValues, 20, 1)){
//            //do something
//            moveForward(carPosition);
//            changeLane();
//            System.out.print("Lane change successfully performed");
//        }
//        else{
//            //do something
//            cancelChange();
//            moveForward(carPosition);
//            System.out.print("Incoming car detected, stay on the same lane");
//        }
//
//    }

    public String cancelChange(){
        return "error";
    }

    public String whereIs(){
        System.out.println("Longitud:" + x + " latitudinal:" + y);
        String ReturnString = "Longitud:" + x + " latitudinal:" + y;
        return ReturnString;

    }
    public void moveForward(Automobile auto){
        if(auto.y < 96){
            auto.y += 5;
        }
    }
}
