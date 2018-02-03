/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {
    @Test public void testAppHasAGreeting() {
        //App classUnderTest = new App();
        //assertNotNull("app should have a greeting", classUnderTest.getGreeting());
        Automobile auto = new Automobile();

        auto.x = 5;
        assertEquals(5, auto.x);
    }
    @Test public void testThatWhereIsReturnNotNull(){
    	Automobile auto = new Automobile();
    	assertNotNull(auto.whereIs());
    }
    
    @Test public void testThatWhereIsReturnAutoXAndY(){
    	Automobile auto = new Automobile();
    	assertEquals(auto.whereIs(), "Longitud:" + auto.x + " latitudinal:" + auto.y);
    }
   
    @Test public void testWhereIsUnexpectedVaules() {
    	
    	Automobile auto = new Automobile();
    	auto.x = -567;
    	auto.y = 1337;
    	assertEquals(auto.whereIs(), "Longitud:" + auto.x + " latitudinal:" + auto.y);
    	//assertThat(fail(auto.x = undefined));
    }
	    @Test public void maxDistance() {
    	Automobile auto = new Automobile();
    	    auto.y=96;
    		auto.moveForward(auto);
    		System.out.println(auto.y);
    	    assertEquals("we check if starting value is correct",96, auto.y);
    		
    	}
    @Test public void fiveDistance() {
    	Automobile auto = new Automobile();
	    auto.y=50;
		auto.moveForward(auto);
		System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",55, auto.y);
    }
    @Test public void maxDistanceV2() {
    	Automobile auto = new Automobile();
	    auto.y=97;
		auto.moveForward(auto);
		System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",97, auto.y);
    }
    @Test public void underDistance() {
    	Automobile auto = new Automobile();
	    auto.y=-1;
		
		//System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",-1, auto.moveForward(auto));
    }
    @Test public void overDistance() {
    	Automobile auto = new Automobile();
	    auto.y=101;
		
		//System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",-1, auto.moveForward(auto));
    }
    @Test public void distanceTest() {
    	Automobile auto = new Automobile();
	    auto.y=95;
	    auto.moveForward(auto);
		//System.out.println(auto.y);
	    assertEquals("we check if starting value is correct",100,auto.y);
    }
    
}
