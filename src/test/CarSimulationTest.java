package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import carSimulation.Car;
import carSimulation.Environment;
import carSimulation.Position;
import carSimulation.Simulation;
import carSimulation.Position.DIRECTION;

/**
 * @author mehdi sarikhani
 * @date 23 June 2015 
 * 
 * Extra Test cases
 */
public class CarSimulationTest {

	// Invalid INIT
	@Test
	public void test1() throws IOException {
		Car ic = new Car();	
		assertFalse(ic.INIT(5, 0, 0));
//		assertFalse(ic.INIT(5, 5, 0));
//		assertFalse(ic.INIT(0, 0, 0));
	}
	
	// valid INIT
	@Test
	public void test2() {

		Car ic = new Car();	
		assertTrue(ic.INIT(2, 2, DIRECTION.SOUTH));
	}
	
  // First need to INIT the position 
	@Test
	public void test3() {

		Car ic = new Car();	
		assertFalse(ic.FORWARD());
	}
	
	

   // test the isEqual method
	@Test
	public void test4() {
		Car ic = new Car();	
		ic.INIT(4,4, DIRECTION.NORTH);	
		assertTrue(ic.GPS_REPORT().isEqual(4, 4, DIRECTION.NORTH));
	}
	
   // test the isEqual method
	@Test
	public void test5() {
		Car ic = new Car();	
		ic.INIT(0,0, DIRECTION.NORTH);	
		ic.FORWARD();
		ic.FORWARD();
		ic.FORWARD();
		ic.FORWARD();
		assertTrue(ic.GPS_REPORT().isEqual(0, 4, DIRECTION.NORTH));
	}

   // test the isEqual method
	@Test
	public void test6() {
		Car ic = new Car();	
		ic.INIT(0,0, DIRECTION.NORTH);	
		ic.FORWARD();
		ic.FORWARD();
		ic.FORWARD();
		ic.FORWARD();
		ic.TURN_Right();
		assertTrue(ic.GPS_REPORT().isEqual(0, 4, DIRECTION.EAST));
	}
		
   // test out of border , ignoring invalid commands
		@Test
		public void test7() {
			Car ic = new Car();	
			ic.INIT(0,0, DIRECTION.NORTH);	
			ic.FORWARD();
			ic.FORWARD();
			ic.FORWARD();
			ic.FORWARD();
			ic.FORWARD();
			ic.FORWARD();
			ic.FORWARD();
			ic.FORWARD();
			assertTrue(ic.GPS_REPORT().isEqual(0, 4, DIRECTION.NORTH));
		}
	
   // test out of border , ignoring invalid commands
	@Test
	public void test8() {
		Car ic = new Car();	
		ic.INIT(0,0, DIRECTION.NORTH);		
		ic.TURN_Right();
		ic.TURN_Right();
		ic.TURN_Right();
		ic.TURN_Right();
		assertTrue(ic.GPS_REPORT().isEqual(0, 0, DIRECTION.NORTH));
	}
	
}
