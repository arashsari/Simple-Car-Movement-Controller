package carSimulation;



/**
 * @author mehdi sarikhani
 * @date 23 June 2015 
 * 
 * Description: This class uses singleton design pattern to keep update latest position of a car. 
 * it contains x coordinate, y coordinate and heading variables that indicate what is the car direction 
 * This class contains all the methods required for initiating and updating the position of a Car.
 * 
 * The constructor of this class create the environment.
 * The car direction is identified as an enumerated type: NORTH (0), SOUTH (1), EAST (2), WEST (3);
 */

public class Position {
	
	static Integer x;
	static Integer y;
	static Integer xMax = 5;
	static Integer yMax = 5 ;
	private static DIRECTION direction ;
	
	/**
	 * The car direction is identified as an enumerated type.
	 * The getDirectionByIniteger method receives an integer value and returns its corresponding enum.
	 */
	public static enum DIRECTION {
		NORTH (0), SOUTH (1), EAST (2), WEST (3);
		private final int code;
		DIRECTION(int code)  { 
				this.code = code; 	
		}
		public int getCode() { 
			return code; 
		}
		
		public static DIRECTION getDirectionByIniteger(int dir){
			DIRECTION direc= null;
			switch(dir){
			case 0 : direc = direction.NORTH;
					break;	
			case 1 : direc = direction.SOUTH;
					break;
			case 2 : direc = direction.EAST;
					break;
			case 3 : direc = direction.WEST;
					break;
			default : System.out.println("Invalid input for the car direction");
					break;
			}
			
			return direc;
		}
	};
		
	private static Position carPos;
	
	/**
	 * Constructor 
	 * It creates an environment object and initiates an object for position.
	 */
	private Position(){
		Environment envObj = new Environment();
		int[][] env = envObj.createEnvironment(5, 5);
		
		this.x = 0;
		this.y = 0;
		this.xMax = env.length;
		this.yMax = env.length;
		this.direction = DIRECTION.NORTH;
	}
	
	/**
	 * Lazy initiation of Singleton class for single threaded 
	 * in case of multi-threaded environment use :	
	 * 			"public static synchronized Position getInstance(){"
	 */
	public static Position getInstance(){	
		if(carPos == null){
			carPos = new Position();
		}
		return carPos;
	}
	
	public  Integer getXcoordiante(){
		return x;	
	}

	public  Integer getYcoordiante(){
		return y;	
	}
	
	public DIRECTION getDirection(){
		return direction;	
	}
	
	public static void updatePosition(Position pos){	
		if(pos != null){
			x = pos.getXcoordiante();
			y = pos.getYcoordiante();
			direction = pos.getDirection();
		}
	}
	/**
	 * Update the x coordinate of position
	 * @param posX
	 */
	public static void updateXPosition(Integer posX){	
		if(posX != null){
			if((0 <= posX ) && (posX < 5)){
				x = posX;
			} else{
				System.out.println("Invalid X input; out of Grid; command ignored");
			}
		}
	}
	
	/**
	 * Update the y coordinate of position
	 * @param posY
	 */
	public static void updateYPosition(Integer posY){	
		if(posY != null){
			if((0 <=  posY) && (posY < yMax)){
				y = posY;
			} else{
				System.out.println("Invalid Y input; out of Grid; command ignored");
			}
			
		}
	}
	
	/**
	 *  Update the direction of position
	 * @param dir
	 */
	public static void updateDirection(DIRECTION dir){	
		
		if(dir != null){
			direction = dir;
		}
	}
	
	/**
	 *  Update the direction of position, if the direction is initiated by integer value
	 * @param dir
	 */
	public static void updateDirection(Integer dir){	
		if(dir != null){
			updateDirection(DIRECTION.getDirectionByIniteger(dir.intValue()));
		}
	}
	
	/**
	 * It checks the validity of input value
	 * @param inp
	 * @return
	 */
	public static boolean checkInputX(Integer inp){
		
		if((inp.intValue() < xMax) && (inp instanceof java.lang.Integer)){

			return true;
		}else{
				return false;
		}	
	}
	/**
	 *  It checks the validity of input value
	 * @param inp
	 * @return
	 */
	public static boolean checkInputY(Integer inp){
		if( (inp < yMax) && (inp instanceof java.lang.Integer)){
				return true;
		}else{
				return false;
		}
	}
	
	/**
	 * This method will check two positions whether they are the same or not. 
	 * It is used in test classes.
	 * @param x1
	 * @param y1
	 * @param dir
	 * @return
	 */
	public static boolean isEqual(int x1, int y1, DIRECTION dir){
		
		if(x == x1 && y == y1 && direction == dir){
		  return true;
		}else {
			return false;
		}
	}
}

