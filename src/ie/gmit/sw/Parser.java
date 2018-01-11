package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
/**
 * 
 * @author Kamila Michel g00340498
 * Crates class Parser which parse url or file
 */
public class Parser {
	/**
	 * 
	 * @param location
	 * @return buffer reader
	 */
	public static BufferedReader parse(String location){
		
		BufferedReader br = null;
		
		try{
			/**
			 * Checks for url
			 */
			if(location.contains("www.") || location.contains("http.")){
				URL url = new URL(location);
				br = new BufferedReader(
						new InputStreamReader(
								url.openStream()));
			}
			
			/**
			 * Checks for a file
			 */
			else{
				br = new BufferedReader(new FileReader(location));
				
			}
		}catch(IOException e){
			System.err.println("Invalid File or URL!");
		}
		return br;
		
	}
}
