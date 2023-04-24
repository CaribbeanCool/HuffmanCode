package p2.DataStructures.Map;

import java.io.PrintStream;

import p2.DataStructures.List.List;

/**
 * Map Abstract Data Type
 * 
 * @author Fernando J. Bermudez - bermed28
 *
 * @param <K> Generic Data Type of Keys to store
 * @param <V> Generic Data Type of Value associated to a given key
 */
public interface Map<K, V> {
	
	/**
	 * Method that returns the value that is mapped to a given key.
	 * If the key is not present in the map, the method returns null
	 * 
	 * @param key	Given key to look for in map
	 * @return		The value associated to the given key
	 */
	public V get(K key);
	
	/**
	 * Method that inserts a given value into the map 
	 * while being associated to a given key.
	 * 
	 * @param key	Given key to store in map
	 * @param value	Given value to associate with a given key in map
	 */
	public void put(K key, V value);
	
	/**
	 * Method that removes a value that is associated to a given key. 
	 * The method returns null if the key is not present in the map.
	 * 
	 * @param key	Given key to remove the value associated to it.
	 * @return		The value removed, null if the key is not present in the map.
	 */
	public V remove(K key);
	
	/**
	 * Method that determines whether a given key is present in the map.
	 * 
	 * @param key	Given key to searhc for in map.
	 * @return		True if the key is present in the map, false otherwise.
	 */
	public boolean containsKey(K key);
	
	/**
	 * Method that returns a list of all the keys stored in the map.
	 * @return 	List of keys in map
	 */
	public List<K> getKeys();
	
	/**
	 * Method that returns a list of all the values stored in the map.
	 * @return 	List of values in map
	 */
	public List<V> getValues();
	
	/**
	 * Method that returns the number of elements stored in the map.
	 * @return	Number of elements stored in map.
	 */
	public int size();
	
	/**
	 * Method that determines if the map has no elements inserted.
	 * @return	True if the size of the map is 0, false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Method that removes all the elements currently stored in the map
	 */
	public void clear();
	
	/**
	 * Method that prints to the console all the elements in the map 
	 * for debugging purposes. 
	 * @param out	Stream to print out the data to
	 */
	public void print(PrintStream out);
}