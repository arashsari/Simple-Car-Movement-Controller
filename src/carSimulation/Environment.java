package carSimulation;

/**
 * @author mehdi sarikhani
 * @date 23 June 2015 
 * 
 * Description: This class contains  method to create an environment for this simulation.
 * This class is instantiated Position class.
 */

public class Environment {
	int[][]  env= null;
	
	public int[][] createEnvironment(int xCoordinate, int yCoordinate){
		return env = new int[xCoordinate][yCoordinate];
	}
	public int[][] getEnv(){
		return env;
	}
}
