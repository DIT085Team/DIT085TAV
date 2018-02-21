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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ParameterTest {
	private int expected;
	private int r1, r2, r3, r4, r5, r6, l1, l2, x, y;
	CarImp car;
	
	@Mock
	Actuator act = mock(Actuator.class);
	
	@Before 
	public void setup() {
		car = new CarImp(3, 0, act);
	}
	
	public ParameterTest(int r1, int r2, int r3, int r4, int r5, int r6,
						int l1, int l2, int expected, int x, int y) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.r5 = r5;
		this.r6 = r6;
		this.l1 = l1;
		this.l2 = l2;
		this.expected = expected;
		this.x = x;
		this.y = y;
		
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
	}
	
	@Parameters
	public static Collection<Object[]> testData() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Q1 Radar 1: ");
		int r1 = scan.nextInt();
		System.out.println("Q1 Radar 2: ");
		int r2 = scan.nextInt();
		System.out.println("Q1 Radar 3: ");
		int r3 = scan.nextInt();
		System.out.println("Q2 Radar 1: ");
		int r4 = scan.nextInt();
		System.out.println("Q2 Radar 2: ");
		int r5 = scan.nextInt();
		System.out.println("Q2 Radar 3: ");
		int r6 = scan.nextInt();

		System.out.println("Q1 Lidar 1: ");
		int l1 = scan.nextInt();
		System.out.println("Q1 Lidar 2: ");
		int l2 = scan.nextInt();
		
		System.out.println("Expected: ");
		int expected = scan.nextInt();
		
		System.out.println("Starting car lane (1-3 with 3 being rightmost): ");
		int x = scan.nextInt();
		System.out.println("Starting car position(0-100): ");
		int y = scan.nextInt();
		
		Object[][] data = new Object[][] {{r1,r2, r3, r4, r5, r6, l1, l2, expected, x, y}};
		
		scan.close();
		return Arrays.asList(data);
	}
	
	@Test
	public void testAdd() {
		car.carPos.setX(x);
		car.carPos.setY(y);
		when(car.act.moveCar(car.carPos, 5)).thenReturn(y + 5);
		assertEquals(5, car.moveForward());
	}
}
