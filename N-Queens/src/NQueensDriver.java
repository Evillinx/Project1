import java.util.*;
import java.io.*;

/*
 * Purpose: Design and Analysis of Algorithms Assignment 1 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/03/2015
 * Submitted:  02/04/2015
 * Comment: test suite and sample run attached
 * @author: James Ortiz
 * @version: 2015.02.04
 */
public class NQueensDriver {

		
		static BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		static NQueensFlip f;
		static int num;
		
		public static void main(String[] args) throws IOException  {
			System.out.println("Weclome to the N-Queens simulator!");
		 while (true) {
	         System.out.print("\nSelect from the following menu:\n        1. Show one board.\n        2. Show all possible boards.\n        3. Exit. \nMake your menu selection: ");
	         try {
	             int num = Integer.parseInt(input.readLine());
	             System.out.println(num);
	             switch (num) {
	                 case 1: 
	                	 System.out.print("Enter size of the board: ");
	                	 int n = Integer.parseInt(input.readLine());
	                	 System.out.println(n);
	                	 f = new NQueensFlip(n,false);
	                 break;
	                 case 2: 
	                	 System.out.print("Enter size of the board: ");
	                	 n = Integer.parseInt(input.readLine());
	                	 System.out.println(n);
	                	 f = new NQueensFlip(n,true);
	                 break;
	                 case 3:
	                	 exit();
	                 break;
	                 default : System.out.println("\n        Error: Not a valid command.");
	                 break;
	             }
	         }   
	         catch (NumberFormatException e) {
	             System.out.println(" Error: Only input numbers!");
	         }
	     }
	 }
			 

		public static void exit()
	    {
	        System.out.println("Exiting program...Good Bye");
	        System.out.println("\f");
	        System.exit(0);
	    }
}
