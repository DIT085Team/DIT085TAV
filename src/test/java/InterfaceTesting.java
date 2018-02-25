import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;

import controller.Actuator;
import controller.CarImp;
import model.Lidar;
import model.Radar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


public class InterfaceTesting {
	CarImp car;
	
	@Mock
	Actuator act = mock(Actuator.class);
		
	@Before 
	public void setup() {
		car = new CarImp(3, 0, act);
		
		car.r1 = mock(Radar.class);
		car.r2 = mock(Radar.class);
		car.r3 = mock(Radar.class);
		car.r4 = mock(Radar.class);
		car.r5 = mock(Radar.class);
		car.r6 = mock(Radar.class);
    	car.l1 = mock(Lidar.class);
    	car.l2 = mock(Lidar.class);
	}
	
	@Test
	public void userScenario() {
		boolean pickingMethods = true;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Starting car lane (1-3 with 3 being rightmost): ");
		int x = scan.nextInt();
		System.out.println("Starting car position(0-100): ");
		int y = scan.nextInt();
		
		car.carPos.setX(x);
		car.carPos.setY(y);
		
		while (pickingMethods) {
			System.out.println("------------------------------");
			System.out.println("Choose an action: ");
			System.out.println("1- Move Forward");
			System.out.println("2- Change Lane");
			System.out.println("3- Check Position");
			System.out.println("4- End Scenario");
			int chosenOption = scan.nextInt();
			
			switch (chosenOption) {
				case 1: 
					System.out.println("The method moveCar is being mocked, what value to expect moveCar to return(new Y position of car)?");
					int moveCarVal = scan.nextInt();
					
					when(act.moveCar(car.carPos, 5)).thenReturn(moveCarVal);
					int moveForwardVal = car.moveForward();
					assertEquals(car.carPos.getY(), moveForwardVal);
					
					System.out.println("Car moved to X: " + car.carPos.getX() + " Y: " + car.carPos.getY());
					System.out.println("Success: Method executed as expected.");
					break;
				case 2: 
					System.out.println("Please Enter Sensor Inputs");
					//First sensor query values
					System.out.println("Q1 Radar 1: ");
					int r1 = scan.nextInt();
					System.out.println("Q1 Radar 2: ");
					int r2 = scan.nextInt();
					System.out.println("Q1 Radar 3: ");
					int r3 = scan.nextInt();
					System.out.println("Q1 Lidar: ");
					int l1 = scan.nextInt();
					
					//Second sensor query values
					System.out.println("Q2 Radar 1: ");
					int r4 = scan.nextInt();
					System.out.println("Q2 Radar 2: ");
					int r5 = scan.nextInt();
					System.out.println("Q2 Radar 3: ");
					int r6 = scan.nextInt();
					System.out.println("Q1 Lidar 2: ");
					int l2 = scan.nextInt();


					//Ask for mocked methods values
					System.out.println("The method moveCar is being mocked, what value to expect moveCar to return(new Y position of car)?");
					int mockMoveCar = scan.nextInt();
					System.out.println("The method changeOneLane is being mocked, what value to expect changeOneLane to return(new X position of car)?");
					int mockOneLane = scan.nextInt();
					
					when(act.moveCar(car.carPos, 5)).thenReturn(mockMoveCar);
					when(act.changeOneLane(car.carPos)).thenReturn(mockOneLane);
					
			    	when(car.r1.getReading()).thenReturn(r1);
			    	when(car.r2.getReading()).thenReturn(r2);
			    	when(car.r3.getReading()).thenReturn(r3);
			    	when(car.l1.getReading()).thenReturn(l1);
			    	when(car.r4.getReading()).thenReturn(r4);
			    	when(car.r5.getReading()).thenReturn(r5);
			    	when(car.r6.getReading()).thenReturn(r6);
			    	when(car.l2.getReading()).thenReturn(l2);
					
			    	//Asking for expected output of changeLane
					System.out.println("Expected return value from changing lane?");
					System.out.println("1- Lane changed");
					System.out.println("2- Can't change from this lane");
					System.out.println("3- Lane change failed car detected");
					System.out.println("4- Lane change failed,Error:faulty readings");
					System.out.println("5- y value incorrect");
					int expectedReturnNum = scan.nextInt();
					
					String expectedReturn = "";
					if (expectedReturnNum == 1) {
						expectedReturn = "Lane changed";
					}
					else if (expectedReturnNum == 2) {
						expectedReturn = "Can't change from this lane";
					}
					else if (expectedReturnNum == 3) {
						expectedReturn = "Lane change failed car detected";
					}
					else if (expectedReturnNum == 4) {
						expectedReturn = "Lane change failed,Error:faulty readings";
					}
					else if (expectedReturnNum == 5) {
						expectedReturn = "y value incorrect";
					}
					
			    	Lidar lidars[] = {car.l1, car.l2};
			    	Radar[][] radars = {{car.r1, car.r2, car.r3}, {car.r4, car.r5, car.r6}};
			    	
					assertEquals(expectedReturn, car.changeLane(car, radars, lidars));
					
					System.out.println("Car moved to X: " + car.carPos.getX() + " Y: " + car.carPos.getY());
					System.out.println("Success: Method executed as expected.");
					break;
				case 3: 
					assertArrayEquals(new int [] {car.carPos.getX(), car.carPos.getY()}, car.whereIs());
					
					System.out.println("Car Position X: " + car.carPos.getX() + " Y: " + car.carPos.getY());
					System.out.println("Success: Method executed as expected.");
					break;
				case 4: 
					System.out.println("Scenario successful! Ending Scenario...");
					pickingMethods = false;
					break;
			}
		}
		scan.close();
	}
}
