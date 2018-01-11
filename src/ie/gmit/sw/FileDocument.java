package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Kamila Michel g00340498
 * Creates FileDocument class which implements Document
 */
public class FileDocument implements Document {

	/**
	 * File path
	 */
    String path; 
   
    /**
     * Text from file
     */
    String text; 

    /**
     * 
     * @param path
     * @throws IOException
     */
    public FileDocument(String path) throws IOException {
        this.path = path;
        
        /**
         * BufferReader reads a file
         */
        BufferedReader br = new BufferedReader(new FileReader(path));
       
        /**
         * StringBuilder builds a string
         */
        StringBuilder sb = new StringBuilder();
        /**
         * Holds each line
         */
        String line; 
        
        while((line = br.readLine()) != null){
            sb.append(line);          
        }
        
        text = sb.toString();

    }
    /**
     * @return text
     * @
     */
    @Override
    public String getText() {
        return text;
    }

    @Override
    public int getId() {
        return 0;
    }
}
