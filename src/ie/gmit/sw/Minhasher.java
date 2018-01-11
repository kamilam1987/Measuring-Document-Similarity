package ie.gmit.sw;

/**
 * 
 * @author Kamila Michel g00340498
 * Creates Minhasher class which implements Runnable 
 */
public class Minhasher implements Runnable {
	
	/**
	 * Declares variables
	 */
	private Shingle shingle;
	private int [] hashes;
	
	/**
	 * Creates constructor
	 * @param hashes
	 * @param shingle
	 */
	public Minhasher(int[] hashes, Shingle shingle) {
		this.hashes = hashes;
	}

	/**
	 * Crates run method
	 * @Override because implements
	 */
	@Override
	public void run() {
		/**
		 * Loops througth the hashes size
		 */
		for (int i=0; i<hashes.length;i++) {
			/**
			 * Calculates hashes
			 */
			int hash = shingle.getHashCode() ^ hashes[i];
		}
		
	}
}
