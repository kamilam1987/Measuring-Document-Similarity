package ie.gmit.sw;

import java.awt.List;
import java.util.Collection;
import java.util.Random;

/**
 * @author Kamila Mihel g00340498
 *
 * @param <Integers>
 */
public class Shingle<Integers> {
	
	private final int hashCode;
    private final int docId;
    /**
     * Crates constructor
     * @param words
     * @param docId
     */
    public Shingle(Collection<String> words, int docId){
       String allWorlds = String.join(" ", words).toLowerCase();
        hashCode = allWorlds.hashCode();
        this.docId = docId;
    }
    /**
     * Creates method getMinHasSet
     * @param size
     */
    public void getMinHashSet(int size) {
    	Random r = new Random();
    	int[] hashes = new int [size];
    	
    	for(int i=0;i<size;i++) {
    		hashes[i] = r.nextInt();
    	}
    }
    
	@Override
	public int hashCode() {
	    return hashCode;
	}
	
	public int getHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	 public int docId() {
	        return docId;
	}
	
	public int getdocId() {
			// TODO Auto-generated method stub
		return 0;
	}
}
