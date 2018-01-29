public class Car {
    // first one is x and the second one is y
    static int[] carPosition = {15,0};

    public static void main(String[] args) {
        int radarValues[] = {30, 34, 22};
        System.out.println(leftLaneDetect(radarValues, 30, 1));
    }

    public static String  leftLaneDetect(int radars[], int lidar, int query) {
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

    /*public int changeLane( int pos ){

        if (leftLaneDetect()){
            System.out.print("Lane change successfully performed");
            //do something
            moveForward();
            changeLane();
        }
        else{
            System.out.print("Incoming car detected, stay on the same lane");
            //do something
            moveForward();
    }
         return carPosition;

    }*/

    public static String WhereIs(){
        System.out.println("Longitud:" + carPosition[1] + " latitudinal:" + carPosition[0]);
        String ReturnString = "Longitud:" + carPosition[1] + " latitudinal:" + carPosition[0];
        return ReturnString;

    }
}
