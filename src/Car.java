public class Car {
    // first one is x and the second one is y
    static int[] carPosition = {15,0};


    public static void main(String[] args) {
        System.out.println("Hello World!");
        
    }

    public void leftLaneDetect() {
        
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
