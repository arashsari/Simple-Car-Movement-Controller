package carSimulation;

import carSimulation.Position.DIRECTION;

/**
 * @author mehdi sarikhani
 * @date 23 June 2015 
 * 
 * Description: This interface identifies the list of valid command to control a car including :
 * 	 INIT, FORWARD, TURN_LEFT and TURN_RIGHT commands.
 */

public interface Commands {

	public boolean INIT(int x, int y, int f);
	public boolean INIT(int x, int y, DIRECTION f);
	public  boolean FORWARD();
	public  boolean TURN_LEFT();
	public  boolean TURN_Right();
	public  Position  GPS_REPORT();

}

