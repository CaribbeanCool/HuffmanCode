package p2.DataStructures.Map;

/**
 * Hash Function Functional Interface
 * @author Fernando J. Bermudez - bermed28
 *
 * @param <K> Generic data type for the key to hash
 */
@FunctionalInterface
public interface HashFunction<K> {
	
	/**
	 * Method that returns an integer denoting the hash code of the given key.
	 * 
	 * @param key	Key to compute the hash code
	 * @return		The hash code of the given key
	 */
	public int hashCode(K key);
	
}