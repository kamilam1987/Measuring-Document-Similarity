package ie.gmit.sw;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Kamila Michel g00340498
 *
 */
public class Runner {
	
	private static Scanner scanner = new Scanner (System.in);
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException{
    
    	/**
    	 * Declare Variables
    	 * Initialise
    	 */
    	int option = 0;
    	String parse = "doc.txt";
    	
    	/**
    	 * Menu options
    	 */
    	System.out.println("******Document Comparsion Service**********");
		System.out.println("1) Parse File or URL");
		System.out.println("2) Similarity");
		System.out.println("3) Exit");
		
		do {
			
			/**
			 * User Input
			 */
			System.out.print("\nPlease choose from option above (1-3): \n");	
			option = scanner.nextInt();
			
			/**
			 * User choice for menu
			 */
			switch(option) {
				case 1:
					
					/**
					 * Parse File or URL
					 */
					System.out.print("\tEnter File Name / URL 1: ");
					parse = scanner.next();
					System.out.print("\tEnter File Name / URL 2: ");
					parse = scanner.next();
					System.out.print("Correct File or URL ! \n");
					break;
				case 2:
					/**
					 * Method display
					 */
					display();
					break;
				case 3:
					/**
					 * Exit
					 */
					System.out.println("Closing application....Thank You!");
					break;
				default:
					/**
					 * Default option
					 */
					System.out.println("Wrong selection ! Please try again");
			}
			/**
			 * Ends when user picks 3
			 */
		} while(option != 3);
	}
    
    /**
     * Method display
     * @throws IOException
     */
    public static void display() throws IOException {
    	
    	/**
    	 * Passes two text documents
    	 */
    	Document document = new FileDocument("TheSunTrail.txt");
	    Document document1 = new FileDocument("Wonder.txt");
	        
	    BlockingQueue<Shingle> q = new LinkedBlockingDeque<>();

        ShingleCreator creator = new ShingleCreator(document, 4, q,2);
        ShingleCreator creator1 = new ShingleCreator(document1, 4, q,2);

        /**
         * Makes two new threads
         */
        Thread t = new Thread(creator);
        t.start();
        Thread t2= new Thread(creator1);
        t2.start();
    }
   
}

