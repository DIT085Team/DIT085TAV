import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class test {
	private CarImp auto;
	//Instantiating a new automobile object for each test case
	@Before
    public void setUp() {
		auto = new CarImp(3, 0);
    }
	
    @Test public void testWhereIsUnexpectedVaules() {
    	auto.carPos.setX(-567);
    	auto.carPos.setY(1337);
    	System.out.println(auto.carPos.getX());
    	System.out.println(auto.carPos.getY());
    	//assertEquals(auto.whereIs(), "Longitude:" + auto.x + " latitude:" + auto.y);
    	assertArrayEquals(new int [] {-567, 1337}, auto.whereIs());
    }

}
