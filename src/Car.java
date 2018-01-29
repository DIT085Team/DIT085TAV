/*

* The first phase of this project concerns test-driven development of a module
* that has  the basic functionalities regarding an
* autonomous lane change system.
*
*/
public class Car implements CarInterFace {
    // first one is x and the second one is y
    static int[] carPosition = {15,0};

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
    }

    public void leftLaneDetect() {
        
    }

    public void changeLane(){

        int[] position;

        if (leftLaneDetect()){
            //do something
            moveForward();
            changeLane();
            System.out.print("Lane change successfully performed");
        }
        else{
            //do something
            cancelChange();
            moveForward();
            System.out.print("Incoming car detected, stay on the same lane");
    }

    }

    public String cancelChange(){
        return "error";
    }

    public static String WhereIs(){
        System.out.println("Longitud:" + carPosition[1] + " latitudinal:" + carPosition[0]);
        String ReturnString = "Longitud:" + carPosition[1] + " latitudinal:" + carPosition[0];
        return ReturnString;

    }
    public void moveForward(){
        //do something
        System.out.println("The car is running forward and cover 5 meters");
    }
}
