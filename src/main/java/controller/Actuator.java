package controller;
import model.CarPos;

public interface Actuator {
	/*
	 * Description: Moves the car a specific amount (distanceToTravel) based on
	 * previousPos. If distance traveled would be more than 100, car doesn't move.
	 * If previousPos is not between 0-100, return -1.
	 */
	public int moveCar(CarPos carPos, int distanceToTravel);
	/*
	 * Description: Moves the car to a specific lane (lanesToChane) based on
	 * previousPos. If the car is in the left most lane (1), the car won't change lane
	 * If it is not in lane 1-3, -1 will be returned.
	 */
	public int changeOneLane(CarPos carPos);
}
