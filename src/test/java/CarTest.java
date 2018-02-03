/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class CarTest {
	private Automobile auto;
	
	@Before
    public void setUp() {
		auto = new Automobile();
    }
	 
    @Test public void testThatWhereIsReturnNotNull(){
    	assertNotNull(auto.whereIs());
    }
    
    @Test public void testThatWhereIsReturnAutoXAndY(){
    	assertEquals(auto.whereIs(), "Longitud:" + auto.x + " latitudinal:" + auto.y);
    }
   
    @Test public void testWhereIsUnexpectedVaules() {
    	auto.x = -567;
    	auto.y = 1337;
    	assertEquals(auto.whereIs(), "Longitud:" + auto.x + " latitudinal:" + auto.y);
    	//assertThat(fail(auto.x = undefined));
    }
    
    // This test runs the moveForward method from the position 96, 
    // the car should not moveForward.
    @Test public void maxDistance() {
	    auto.y=96;
		auto.moveForward(auto);
		System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",96, auto.y);
	}
	
    @Test public void fiveDistance() {
	    auto.y=50;
		auto.moveForward(auto);
		System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",55, auto.y);
    }
    @Test public void maxDistanceV2() {
	    auto.y=97;
		auto.moveForward(auto);
		System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",97, auto.y);
    }
    @Test public void underDistance() {
	    auto.y=-1;
	    assertEquals("we check if starting value is correct",-1, auto.moveForward(auto));
    }
    @Test public void overDistance() {
	    auto.y=101;
	    assertEquals("we check if starting value is correct",-1, auto.moveForward(auto));
    }
    @Test public void distanceTest() {
	    auto.y=95;
	    auto.moveForward(auto);
		//System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",100,auto.y);
    }
    
    
    @Test public void noCarLeftLane() {
    	int radars[] = {30, 34, 28};
    	assertEquals(auto.leftLaneDetect(radars, 26, 1), "No car detected");
    }
    @Test public void oneFaultyReading() {
    	int radars[] = {930, 41, 44};
    	assertEquals(auto.leftLaneDetect(radars, 39, 1), "No car detected");
    }
    @Test public void twoFaultyReadings1() {
    	int radars[] = {865, 430, 17};
    	assertEquals(auto.leftLaneDetect(radars, 15, 1), "Error: faulty readings");
    }
    @Test public void twoFaultyReadings2() {
    	int radars[] = {28, 30, 460};
    	assertEquals(auto.leftLaneDetect(radars, 370, 1), "Error: faulty readings");
    }
    @Test public void twoFaultyReadingsWithNearbyCar() {
    	int radars[] = {4, 259, 270};
    	assertEquals(auto.leftLaneDetect(radars, 15, 1), "Error: faulty readings");
    }
    @Test public void nearbyCarDetectedRadar1() {
    	int radars[] = {4, 10, 7};
    	assertEquals(auto.leftLaneDetect(radars, 13, 1), "Car detected");
    }
    @Test public void nearbyCarDetectedRadar2() {
    	int radars[] = {12, 3, 8};
    	assertEquals(auto.leftLaneDetect(radars, 13, 1), "Car detected");
    }
    @Test public void nearbyCarDetectedRadar3() {
    	int radars[] = {8, 10, 2};
    	assertEquals(auto.leftLaneDetect(radars, 7, 1), "Car detected");
    }
    @Test public void nearbyCarDetectedRadar4() {
    	int radars[] = {13, 14, 12};
    	assertEquals(auto.leftLaneDetect(radars, 3, 1), "Car detected");
    }
    @Test public void oneFaultyReadingWithNearbyCar() {
    	int radars[] = {300, 2, 13};
    	assertEquals(auto.leftLaneDetect(radars, 7, 1), "Car detected");
    }
    @Test public void negativeFaultyReadings() {
    	int radars[] = {-42, 18, 15};
    	assertEquals(auto.leftLaneDetect(radars, 203, 1), "Error: faulty readings");
    }
    @Test public void nearbyCarDetectedLowerBoundary() {
    	int radars[] = {0, 12, 30};
    	assertEquals(auto.leftLaneDetect(radars, 0, 1), "Car detected");
    }
    @Test public void nearbyCarDetectedUpperBoundary() {
    	int radars[] = {5, 14, 17};
    	assertEquals(auto.leftLaneDetect(radars, 5, 1), "Car detected");
    }
    @Test public void noCarDetectedUpperBoundary() {
    	int radars[] = {5, 14, 17};
    	assertEquals(auto.leftLaneDetect(radars, 5, 1), "Car detected");
    }
    @Test public void allFaultyReadings() {
    	int radars[] = {305, 800, 340};
    	assertEquals(auto.leftLaneDetect(radars, 200, 1), "Error: faulty readings");
    }
}
