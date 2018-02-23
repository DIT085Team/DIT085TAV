import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import controller.Actuator;
import controller.CarImp;
import model.Lidar;
import model.Radar;

public class CarScenarioTests {
	private CarImp auto;
	
	
	
	@Mock
	Actuator act = mock(Actuator.class);
	
	
	//Instantiating a new automobile object for each test case
	@Before
    public void setUp() {			
		auto = new CarImp(3, 0, act);
	}
	
	public Radar[][] setUpRadar(int a,int b, int c,int d,int e,int f) {
		auto.r1 = mock(Radar.class);
    	auto.r2 = mock(Radar.class);
    	auto.r3 = mock(Radar.class);
    	auto.r4 = mock(Radar.class);
    	auto.r5 = mock(Radar.class);
    	auto.r6 = mock(Radar.class);
    	
    	when(auto.r1.getReading()).thenReturn(a);
    	when(auto.r2.getReading()).thenReturn(b);
    	when(auto.r3.getReading()).thenReturn(c);
    	when(auto.r4.getReading()).thenReturn(d);
    	when(auto.r5.getReading()).thenReturn(e);
    	when(auto.r6.getReading()).thenReturn(f);
   		
    	Radar r1 = auto.r1;
    	Radar r2 = auto.r2;
    	Radar r3 = auto.r3;
    	Radar r4 = auto.r4;
    	Radar r5 = auto.r5;
    	Radar r6 = auto.r6;
    	Radar[][] radars = {{r1, r2, r3},{r4,r5,r6}};
		return  radars;
	}
	public Lidar[] setUpLidar(int a,int b) {
		
		auto.l1 = mock(Lidar.class);
		auto.l2 = mock(Lidar.class);
		when(auto.l1.getReading()).thenReturn(a);
		when(auto.l2.getReading()).thenReturn(b);
		Lidar l1 = auto.l1;
    	Lidar l2 = auto.l2;
		Lidar lidar[] = {l1,l2};
   		return lidar;
	}
	
	//A scenario for testing of faulty reading
	
	@Test
	public void scenarioOne() {
		Radar[][] radars = new Radar[2][3] ;
		Lidar[] lidar = new Lidar[2];
		auto.carPos.setX(3);
		auto.carPos.setY(0);
		radars = setUpRadar(100,270,10,100,270,10);
		lidar = setUpLidar(15,15);
		when(auto.act.moveCar(auto.carPos, 5)).thenReturn(15);
		when(act.changeOneLane(auto.carPos)).thenReturn(2);	
		auto.moveForward();
		auto.changeLane(auto, radars, lidar);
		radars = setUpRadar(10, 27,340,10,27,340);
		lidar = setUpLidar(155,155);
		auto.changeLane(auto, radars, lidar);
		lidar = setUpLidar(25,25);
		auto.changeLane(auto, radars, lidar);
		when(act.changeOneLane(auto.carPos)).thenReturn(1);
		radars = setUpRadar(101, 271,340,101,271,340);
		lidar = setUpLidar(155,155);
		auto.changeLane(auto, radars, lidar);
		radars = setUpRadar(12, 23,30,12,23,30);
		auto.changeLane(auto, radars, lidar);
		assertEquals(1, auto.carPos.getX());
	}
	
	//A scenario for testing the limits of the sensors
	
	@Test
	public void scenarioTwo() {
		Radar[][] radars = new Radar[2][3] ;
		Lidar[] lidar = new Lidar[2];
		auto.carPos.setX(3);
		auto.carPos.setY(26);
		System.out.print(auto.carPos.getY()+"\n");
		when(auto.act.moveCar(auto.carPos, 5)).thenReturn(36);
		auto.moveForward();
		System.out.print(auto.carPos.getY()+"\n");
		radars = setUpRadar(3,4,4,2,3,4);
		lidar = setUpLidar(3,2);
		// changeLane will change x direction but, will 0 the y position when run
		auto.changeLane(auto, radars, lidar);
		when(auto.act.moveCar(auto.carPos, 5)).thenReturn(96);
		auto.moveForward();
		System.out.print(auto.carPos.getY()+"\n");
		radars = setUpRadar(6,8,9,6,8,9);
		lidar = setUpLidar(9,9);
		assertEquals("y value incorrect", auto.changeLane(auto, radars, lidar));
	}
	
	//A scenario for testing the turning of the car
	
	@Test
	public void scenarioThree() {
		Radar[][] radars = new Radar[2][3] ;
		Lidar[] lidar = new Lidar[2];
		auto.carPos.setX(2);
		when(act.changeOneLane(auto.carPos)).thenReturn(1);	
		auto.carPos.setY(0);
		radars = setUpRadar(4,27,10,4,27,10);
		lidar = setUpLidar(15,15);
		auto.changeLane(auto, radars, lidar);
		radars = setUpRadar(42,27,10,42,27,10);
		lidar = setUpLidar(4,4);
		auto.changeLane(auto, radars, lidar);
		radars = setUpRadar(42,127,10,42,127,10);
		lidar = setUpLidar(54,54);
		auto.changeLane(auto, radars, lidar);
		radars = setUpRadar(42,17,10,42,17,10);
		lidar = setUpLidar(6,6);
		auto.changeLane(auto, radars, lidar);
		
		assertEquals("Can't change from this lane", auto.changeLane(auto, radars, lidar));
	}
	
	// A Scenario for testing the querry  
	@Test
    public void scenarioFour() {
        Radar[][] radars = new Radar[2][3] ;
        Lidar[] lidar = new Lidar[2];
        auto.carPos.setX(3);
        auto.carPos.setY(0);
        when(auto.act.moveCar(auto.carPos, 5)).thenReturn(5);
        when(act.changeOneLane(auto.carPos)).thenReturn(2);	
        auto.moveForward();
        
        radars = setUpRadar(7,10,30,23,12,14);
        lidar = setUpLidar(29,26);
        auto.changeLane(auto, radars, lidar);
        when(act.changeOneLane(auto.carPos)).thenReturn(2);
        
        radars = setUpRadar(6,15,37,38,3,42);
        lidar = setUpLidar(19,11);
        System.out.println("Omar:" + auto.changeLane(auto, radars, lidar));
        
        radars = setUpRadar(6,15,37,38,363,422);
        lidar = setUpLidar(19,111);
        auto.changeLane(auto, radars, lidar);
        
        assertEquals("Lane change failed,Error:faulty readings", auto.changeLane(auto, radars, lidar));
        auto.moveForward();
        
        when(auto.act.moveCar(auto.carPos, 5)).thenReturn(20);
        auto.moveForward();
        assertArrayEquals(new int [] {2, 20}, auto.whereIs());
    }
	
}
