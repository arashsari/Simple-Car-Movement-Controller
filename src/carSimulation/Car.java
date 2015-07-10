package carSimulation;
import carSimulation.Position.DIRECTION;

/**
 * @author mehdi sarikhani
 * @date 23 June 2015 
 * 
 * Description: This class implements the INIT, FORWARD, TURN_LEFT and TURN_RIGHT commands.
 */
public class Car implements Commands {
	
	boolean initFirstCheck = false; 
	
	/**
	 * initializing the position of car.
	 * It will put the car at position X,Y facing NORTH, SOUTH, EAST or WEST. Assuming 0,0 is the south-west corner.
	 * The program should discard all commands until a valid INIT command has been executed. After that, any sequence of commands may be issued, in any order, including another INIT command. 
	 */
	@Override
	public boolean INIT(int x, int y, int f) {
		return INIT(x, y, DIRECTION.getDirectionByIniteger(f));
	}
	
	/**
	 * initializing the position of car.
	 * It will put the car at position X,Y facing NORTH, SOUTH, EAST or WEST. Assuming 0,0 is the south-west corner.
	 * The program should discard all commands until a valid INIT command has been executed. After that, any sequence of commands may be issued, in any order, including another INIT command. 
	 */
	@Override
	public boolean INIT(int x, int y, DIRECTION f) {
		
		if(((0 <= x ) && ( x<=4)) && ( 0 <= y) && (y <= 4)){
			Position.getInstance().updateXPosition(x);
			Position.getInstance().updateYPosition(y);
			Position.getInstance().updateDirection(f);
			
			initFirstCheck = true;
			
			return true;
		} else {
			System.out.println("Invalid position for initialization");
			return false;
		}
	}
	
	/**
	 * It will move the car one unit forward in the direction it is currently facing.
	 */
	@Override
	public boolean FORWARD() {
		if(initFirstCheck){
			switch(Position.getInstance().getDirection()){
				case NORTH:  Position.getInstance().updateYPosition( ((int) (Position.getInstance().getYcoordiante().intValue())) + 1);	
						break;
				case SOUTH: Position.getInstance().updateYPosition( ((int) (Position.getInstance().getYcoordiante().intValue())) - 1);
						break;
				case EAST: Position.getInstance().updateXPosition( ((int) (Position.getInstance().getXcoordiante().intValue())) + 1);
						break;
				case WEST:  Position.getInstance().updateXPosition( ((int) (Position.getInstance().getXcoordiante().intValue())) - 1);
						break;
				default : System.out.println("Invalid update");
						break;
			}
			return true;
		}else{
			System.out.println("Please first run INIT command");
			return false;
		}
	}

	/**
	 * It will rotate the car in the Left direction without changing its position on the grid.
	 */
	@Override
	public boolean TURN_LEFT() {
		if(initFirstCheck){
			switch(Position.getInstance().getDirection()){
				case NORTH:  Position.getInstance().updateDirection(Position.DIRECTION.WEST);
						break;
				case SOUTH:  Position.getInstance().updateDirection(Position.DIRECTION.EAST); 
						break;
				case EAST:   Position.getInstance().updateDirection(Position.DIRECTION.NORTH); 
						break;
				case WEST:   Position.getInstance().updateDirection(Position.DIRECTION.SOUTH); 
						break;
				default : System.out.println("Invalid update");
						break;
			}
			return true;
		}else{
			System.out.println("Please first run INIT command, then turn left");
			return false;
		}
	}
	
	/**
	 * It will rotate the car in the right direction without changing its position on the grid.
	 */
	@Override
	public boolean TURN_Right() {
		if(initFirstCheck){
			switch(Position.getInstance().getDirection()){
				case NORTH: Position.getInstance().updateDirection(Position.DIRECTION.EAST);
						break;
				case SOUTH: Position.getInstance().updateDirection(Position.DIRECTION.WEST); 
						break;
				case EAST:  Position.getInstance().updateDirection(Position.DIRECTION.SOUTH); 
						break;
				case WEST:  Position.getInstance().updateDirection(Position.DIRECTION.NORTH); 
						break;
				default : System.out.println("Invalid update");
						break;
			}
			return true;
		}else{
			System.out.println("Please first run INIT command, then turn right");
			return false;
		}
	}
	/**
	 * It will output the car's position and facing
	 */

	@Override
	public Position GPS_REPORT() {
		PRINT_GPS_REPORT();
		return Position.getInstance();
	}

	public  void  PRINT_GPS_REPORT(){
		if(initFirstCheck){
			System.out.println("X coordinate: "+ Position.getInstance().getXcoordiante()+
					", Y coordinate: " +Position.getInstance().getYcoordiante() +
					", Car Direction: "+Position.getInstance().getDirection().toString());
		} else {
			System.out.println("Please first run INIT command, then I will report the GPS position for you :) ");
		}
	}
	
	
}
