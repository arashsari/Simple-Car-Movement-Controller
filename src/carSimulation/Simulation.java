package carSimulation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import test.AllTests;
import carSimulation.Position.DIRECTION;
/**
 * @author mehdi sarikhani
 * @date 23 June 2015 
 * 
 * Description: This is a Main Class that creates a Car Object and get the input commands to operate on the Car.
 * This simulation would get the input commands from console and control the movement of car.
 */
public class Simulation {

	public static void main(String[] args) throws java.io.IOException{

		Car ic = new Car();	
		
		String ch;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("|=======================================|");
		System.out.println("|== Enter I for For INIT the position ==|");
		System.out.println("|== Enter F for For Forward.          ==|");
		System.out.println("|== Enter R for For Turn_Right.       ==|");
		System.out.println("|== Enter L for For Turn_Left.        ==|");
		System.out.println("|== Enter G for For GPS_Report.       ==|");
		System.out.println("|== Enter T to run test Suite         ==|");
		System.out.println("|== Enter E for Exit.                 ==|");
		System.out.println("|=======================================|");
		System.out.print("Please choose your Command :");
		int x = 0 ;
		int y = 0;
		      do{
		    	  ch = scanner.next();
				switch( ch){
				case "i" : System.out.println("Please Enter x coordinate < 0-4 is Valid range> :");
				             x = scanner.nextInt();
				         while(!(Position.getInstance().checkInputX(x))){
				        	 System.out.println("Please Enter a corret value for x coordinate <  0-4 is Valid range > : ");
					         x = scanner.nextInt();
				         }
						
				         System.out.println("Please Enter y coordinate <0-4 is Valid range> :");
				          y = scanner.nextInt();
		
				         while(!(Position.getInstance().checkInputY(y))){
				        	 System.out.println("Please Enter a corret value for y coordinate <0-4 is Valid range> :");
					         y = scanner.nextInt();
				         }
				         
				         System.out.println(" Enter Direction, <NORTH (0), SOUTH (1), EAST (2), WEST (3)>, e.g Enter Zero for NORTH");
				         Object heading = scanner.nextInt();
				         if(heading.getClass().isEnum()){
				        	 ic.INIT(x, y,(DIRECTION) heading);
				         }else{
				        	 ic.INIT(x, y,(int) heading);
				         }
				        break;
				        
				case "I" : System.out.println("Please Enter x coordinate <0-4 is Valid range> : ");
						    x = scanner.nextInt();
					         while(!(Position.getInstance().checkInputX(x))){
					        	 System.out.println("Please Enter a corret value for x coordinate <  0-4 is Valid range > : ");
						         x = scanner.nextInt();
					         }
							
					         
					         System.out.println("Please Enter y coordinate <0-4 is Valid range> :");
					          y = scanner.nextInt();
			
					         while(!(Position.getInstance().checkInputY(y))){
					        	 System.out.println("Please Enter a corret value for y coordinate <0-4 is Valid range> :");
						         y = scanner.nextInt();
					         }
					         
					         
					         System.out.println(" Enter Direction, <NORTH (0), SOUTH (1), EAST (2), WEST (3)>, e.g Enter Zero for NORTH");
					          heading = scanner.nextInt();
					         if(heading.getClass().isEnum()){
					        	 ic.INIT(x, y,(DIRECTION) heading);
					         }else{
					        	 ic.INIT(x, y,(int) heading);
					         }
					        break;
				case "f": ic.FORWARD();
						break;
				case "F": ic.FORWARD();
						break;
				case "r" : ic.TURN_Right();
						break;
				case "R" : ic.TURN_Right();
						break;
				case "l" : ic.TURN_LEFT();
						break;
				case "L" : ic.TURN_LEFT();
						break;
				case "g" : ic.PRINT_GPS_REPORT();
						break;
				case "G" : ic.PRINT_GPS_REPORT();
						break;
				case "e" :  System.out.println(" BYE ");
							System.exit(0);
						break;
				case "E" :  System.out.println(" BYE ");
							System.exit(0);
						break;
				case "t" :  
				    Result result = JUnitCore.runClasses(AllTests.class);
				      for (Failure failure : result.getFailures()) {
				         System.out.println(failure.toString());
				      }
				      System.out.println(result.wasSuccessful());
						System.out.println(" Test Suite:  ");
						break;
				default : System.out.println("Invalid command");
						break;
				}
		}while (ch != "e");
		

		if(!(ic.INIT(2, 2, DIRECTION.NORTH))){
			System.out.println("Invalid input values in Initialising the car positions and/or directon");
		}
	}
	
	
}
