package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
/**
 * 
 * @author Kamila Michel g00340498
 * Creates ShingleCreator which implements Runnable
 */
public class ShingleCreator implements Runnable {

    private Document document;
    private int shingleSize;
    private BlockingQueue<Shingle> q;
    private int k;
    
    /**
     * Creates a constructor
     * @param document
     * @param shingleSize
     * @param q
     * @param k
     */
    public ShingleCreator(Document document, int shingleSize, BlockingQueue<Shingle> q, int k) {
        this.document = document;
        this.shingleSize = shingleSize;
        this.q = q;
        this.k = k;
    }

    @Override
    public void run() {
    	/**
    	 * Breaks text into array of words
    	 */
        String[] words = document.getText().split("[ \\s=+,.?\";!\\-\\n]");
        int pos = 0; 

        while (pos < words.length) { 
        	
        	/**
        	 * Makes new list for shingle
        	 */
            List<String> shingles = new ArrayList<>(); 
            
            /**
             * Loop throught the size of shingle
             */
            for (int i = pos; i < pos + shingleSize; i++) { 
                if (i == words.length) {
                    break; 
                }
                shingles.add(words[i]);
            }
            
            System.out.println(shingles);
            Shingle shingle = new Shingle(shingles, document.getId());
            
            try {
                q.put(shingle);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pos += shingleSize;
           
        }
        
    }
    
}
