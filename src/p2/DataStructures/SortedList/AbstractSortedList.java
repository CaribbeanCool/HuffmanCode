package p2.DataStructures.SortedList;
/**
 * Abstract Sorted List Class
 * 
 * @author Fernando J. Bermudez - bermed28
 * 
 * @param <E> Generic comparable data type for elements to insert 
 */
public abstract class AbstractSortedList<E extends Comparable<? super E>> implements SortedList<E> {
	protected int currentSize;

	/* ABSTRACT METHODS */
	
	@Override
	public abstract void add(E e);

	@Override
	public abstract boolean remove(E e);

	@Override
	public abstract E removeIndex(int index);

	@Override
	public abstract int firstIndex(E e);

	@Override
	public abstract E get(int index);

	@Override
	public abstract Comparable<E>[] toArray();

	/* IMPLEMENTED METHODS */

	@Override
	public boolean contains(E e) {
		return firstIndex(e) >= 0;
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		while (!isEmpty())
			removeIndex(0);
	}

}