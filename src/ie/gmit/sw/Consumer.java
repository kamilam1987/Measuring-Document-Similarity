package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Kamila Michel g00340498
 * Creates Consumer class which implements Runnable class
 */
public class Consumer implements Runnable {
	
	private BlockingQueue<Shingle> q; 
	private int[] hashes;
	private int k;
	private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	
	/**
	 * Creates Constructor
	 * @param q queue
	 * @param k the basic unit (element) is a fixed-size block of characters of length k
	 */
	public Consumer(BlockingQueue<Shingle> q, int k) {
		this.q = q;
		this.k = k;
	}
	
	/**
	 * Creates array of hashes
	 * Method getMinHashSet
	 */
	public void getMinHashSet() {
		Random r = new Random();
		int[] hashes = new int[k];
		/**
		 * Loops through the hashes  fills hashes array
		 */
		for(int i=0;i<hashes.length;i++) {
			hashes[i]=r.nextInt();
		}
	}
	
	/**
	 * Creates method run
	 */
	public void run() {
		
		/**
		 * Declares variables
		 */
		int numDocs = 2;
		while (numDocs>0) {
			try {
				Shingle shingle =q.take();
				if(shingle.getHashCode()!=48) {
					List<Integer> list = map.get(shingle.getdocId());
					for(int i=0;i<hashes.length;i++) {
						int hash = shingle.getHashCode()^hashes[i];
						if(list == null) {
							list = new ArrayList<Integer>(Collections.nCopies(k, Integer.MAX_VALUE));
							map.put(shingle.getdocId(), list);
						}
						else {
							if(list.get(i)>hash) {
								list.set(i, hash);
							}
						}
					}
					map.put(shingle.getdocId(), list);
				}
				else {
					numDocs--;
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
