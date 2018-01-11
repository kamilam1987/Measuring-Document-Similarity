package ie.gmit.sw;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Kamila Michel g00340498
 * Creates Jaccard class
 */
public class Jaccard {
	/**
	 * 
	 * @param k
	 * Code adapted from:https://github.com/tdebatty/java-string-similarity/blob/master/src/main/java/info/debatty/java/stringsimilarity/Jaccard.java
	 */
	public Jaccard(final int k) {
        super();
    }

	/**
	 * 
	 * @param s1 first string
	 * @param s2 second string
	 * @return calculations for similarity
	 * Similarity method Checks similarity by comparing string s1 with string s2
	 *
	 */
    public final double similarity(final String s1, final String s2) {
        if (s1 == null) {
        	
        	/**
        	 * throws NullPointerException if s1 is null.
        	 */
            throw new NullPointerException("s1 must not be null");
        }

        if (s2 == null) {
        	/**
        	 * throws NullPointerException if s2 is null.
        	 */
            throw new NullPointerException("s2 must not be null");
        }

        /**
         * If s1 same as s2
         */
        if (s1.equals(s2)) {
            return 1;
        }

        /**
         * Creates two maps which contains string and integer
         */
        Map<String, Integer> profile1 = getProfile(s1);
        Map<String, Integer> profile2 = getProfile(s2);


        Set<String> union = new HashSet<String>();
        /**
         * 
         */
        union.addAll(profile1.keySet());
        union.addAll(profile2.keySet());

        int inter = profile1.keySet().size() + profile2.keySet().size()
                - union.size();
        /**
         * @return calculation for similarity
         */
        return 1.0 * inter / union.size();
    }


    private Map<String, Integer> getProfile(String s1) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * Creates method which calculates distance between two strings
     * @param s1
     * @param s2
     * @return distance calculations
     */
    public final double distance(final String s1, final String s2) {
        return 1.0 - similarity(s1, s2);
    }
}
