package test;

import static org.junit.Assert.*;

import org.junit.Test;

import carSimulation.Car;
import carSimulation.Position.DIRECTION;

/**
 * @author mehdi sarikhani
 * @date 23 June 2015 
 * 
 * Test mentioned in the description of code test  
 */

public class TestCaseIncludeInDescriptionDoc {

	@Test
	public void firstTest()  {
		Car ic = new Car();	
		ic.INIT(0, 0, DIRECTION.NORTH);
		ic.FORWARD();
		ic.GPS_REPORT();
		assertTrue(ic.GPS_REPORT().isEqual(0, 1, DIRECTION.NORTH));
	}
	@Test
	public void secondTest() {
		Car ic = new Car();	
		ic.INIT(0, 0, DIRECTION.NORTH);
		ic.TURN_LEFT();
		ic.GPS_REPORT();
		assertTrue(ic.GPS_REPORT().isEqual(0, 0, DIRECTION.WEST));
	}
	@Test
	public void thirdTest() {
		Car ic = new Car();	
		ic.INIT(1, 2, DIRECTION.EAST);
		ic.FORWARD();
		ic.FORWARD();
		ic.TURN_LEFT();
		ic.FORWARD();
		ic.GPS_REPORT();
		assertTrue(ic.GPS_REPORT().isEqual(3, 3, DIRECTION.NORTH));
	}
}
