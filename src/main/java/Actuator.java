
public interface Actuator {
	
	/*
	 * Description: Moves the car a specific amount (distanceToTravel) based on
	 * previousPos. If distance traveled would be more than 100, car doesn't move.
	 * If previousPos is not between 0-100, return -1.
	 */
	public int moveCar(CarPos carPos, int distanceToTravel);
}
