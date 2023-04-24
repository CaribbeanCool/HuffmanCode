package p2.DataStructures.List;

/**
 * List Abstract Data Type
 * @author Fernando J. Bermudez - bermed28
 *
 * @param <E> Generic Data Type to store elements
 */
public interface List<E> extends Iterable<E> {
	
	/**
	 * Adds an element to the end of the List
	 * @param obj - The element we wish to add to the List
	 */
	public void add(E obj);
	
	/**
	 * Adds an element to the position given by index.
	 * @param index - position we want to add the element to.
	 * @param obj - the element we wish to add
	 * @throws IndexOutOfBoundsException if the index is not valid
	 */
	public void add(int index, E obj);
	
	/**
	 * Removes the first instance of the element obj.
	 * @param obj - the value we want to remove
	 * @return  If the element was successfully found and removed. True if removed, false otherwise.
	 */
	public boolean remove(E obj);
	
	/**
	 * Removes the element at position index
	 * @param index - The position of the element we want to remove
	 * @return Always true since the position has to be valid (exist) to be removed.
	 * @throws IndexOutOfBoundsException if the index is not valid
	 */
	public boolean remove(int index);
	
	/**
	 * Removes every instance of element obj.
	 * @param obj - the value we want to remove
	 * @return number of entries that were removed.
	 */
	public int removeAll(E obj);
	
	/**
	 * Returns the value at the given position
	 * @param index - position of the value we want
	 * @throws IndexOutOfBoundsException if the index is not valid
	 * @return value at position index
	 */
	public E get(int index);
	
	/**
	 * Replaces the value at the position given by index.
	 * @param index - position we want to replace
	 * @param obj - the new value we want to place
	 * @throws IndexOutOfBoundsException if the index is not valid
	 * @return the old value at position index (the replaced value)
	 */
	public E set(int index, E obj);
	
	/**
	 * Returns the first element in the List
	 * @return First element in the List
	 */
	public E first();
	
	/**
	 * Returns the last element in the List.
	 * @return (E) last element in the List
	 */
	public E last();
	
	/**
	 * Returns the position where an instance of obj first appears.
	 * @param obj - obj we want to search for
	 * @return position where obj first appears in the List
	 */
	public int firstIndex(E obj);
	
	/**
	 * Returns the position where an instance of obj last appears.
	 * @param obj - obj we want to search for
	 * @return position where obj last appears in the List
	 */
	public int lastIndex(E obj);
	
	/**
	 * Returns the size of the List.
	 * @return The number of elements stored in the list
	 */
	public int size();
	
	/**
	 * Returns whether the List is empty of not.
	 * @return True if the list is empty, false otherwise
	 */
	public boolean isEmpty();
	
	
	/**
	 * Checks whether the value obj is present in the List
	 * @param obj - the value we want to verify its existance 
	 * @return (boolean) whether obj is present or not. True if present, false otherwise
	 */
	public boolean contains(E obj);
	
	/**
	 * Empties the List. 
	 */
	public void clear();
	
	/**
	 * Returns an array with all the elements in the list
	 * @return	Array containing all the elements in the list.
	 */
	public Object[] toArray();
}