package p2.DataStructures.SortedList;
/**
 * Implementation of a Sorted List using a Singly Linked List structure
 * 
 * @author Alejandro A. Perez Pabon - 802211489
 * @version 3.0
 * @since 03/28/2023
 * @param <E> 
 */
public class SortedLinkedList<E extends Comparable<? super E>> extends AbstractSortedList<E> {

	@SuppressWarnings("unused")
	private static class Node<E> {

		private E value;
		private Node<E> next;

		public Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}

		public Node(E value) {
			this(value, null); // Delegate to other constructor
		}

		public Node() {
			this(null, null); // Delegate to other constructor
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public void clear() {
			value = null;
			next = null;
		}				
	} // End of Node class

	
	private Node<E> head; // First DATA node (This is NOT a dummy header node)
	
	public SortedLinkedList() {
		head = null;
		currentSize = 0;
	}

	/**
	 * Adds an element to the list in sorted order (ascending)
	 * 
	 * @param e The element to be added
	 * @return true if the element was added, false otherwise
	 * @author Alejandro A. Perez Pabon
	 */
	@Override
	public void add(E e) {
		/* Special case: Be careful when the new value is the smallest */
		Node<E> newNode = new Node<>(e);
		Node<E> curNode;

		if (head == null || e.compareTo(head.getValue()) < 0) { // Add to head
			newNode.setNext(head);
			head = newNode;
		} else { // Add after head
			curNode = head;
			while (curNode.getNext() != null && e.compareTo(curNode.getNext().getValue()) > 0) {
				curNode = curNode.getNext();
			}
			newNode.setNext(curNode.getNext());
			curNode.setNext(newNode);
		}
		currentSize++;
	}

	/**
	 * Removes an object from the list
	 * 
	 * @param e The object to be removed
	 * @return true if the element was removed, false otherwise
	 * @author Alejandro A. Perez Pabon
	 */
	@Override
	public boolean remove(E e) {
		/* Special case: Be careful when the value is found at the head node */
		Node<E> rmNode, curNode;

		if (head == null || e.compareTo(head.getValue()) < 0) { // Special case: remove from head
			return false;
		} else if (e.equals(head.getValue())) { // Remove head
			head = head.getNext();
			currentSize--;
			return true;
		} else { // Remove after head
			curNode = head;
			while (curNode.getNext() != null && e.compareTo(curNode.getNext().getValue()) > 0) {
				curNode = curNode.getNext();
			}
			if (curNode.getNext() != null && e.equals(curNode.getNext().getValue())) {
				rmNode = curNode.getNext();
				curNode.setNext(rmNode.getNext());
				rmNode.clear();
				currentSize--;
				return true;
			}
			return false;
		}
	}

	/**
	 * Removes an element from the list at a given index
	 * 
	 * @param index The index of the element to be removed
	 * @return The element removed, null if the index is out of bounds
	 * @author Alejandro A. Perez Pabon
	 */
	@Override
	public E removeIndex(int index) {
		/* Special case: Be careful when index = 0 */
		Node<E> rmNode, curNode;
		E value = null;

		if (head == null || index < 0 || index >= currentSize) {
			return null;
		} else if (index == 0) { // Special case: remove head
			value = head.getValue();
			head = head.getNext();
		} else { // Remove after head
			curNode = head;
			for (int i = 0; i < index - 1; i++) {
				curNode = curNode.getNext();
			}
			rmNode = curNode.getNext();
			value = rmNode.getValue();
			curNode.setNext(rmNode.getNext());
			rmNode.clear();
		}
		currentSize--;
		return value;
	}

	/**
	 * Returns the index of the first occurrence of an element in the list
	 * 
	 * @param e The element to be searched
	 * @return The index of the first occurrence of the element, -1 if not found
	 * @author Alejandro A. Perez Pabon
	 */
	@Override
	public int firstIndex(E e) {
		int target = -1;
		Node<E> curNode = head;
		for (int i = 0; i < currentSize; i++) {
			if (e.compareTo(curNode.getValue()) <= 0) {
				target = i;
				break;
			}
			curNode = curNode.getNext();
		}
		return target;
	}

	/**
	 * Returns the index of the last occurrence of an element in the list1
	 * 
	 * @param index The index of the element to be returned
	 * @return The element at the given index, null if the index is out of bounds
	 * @author Alejandro A. Perez Pabon
	 */
	@Override
	public E get(int index) {
		if (head == null || index < 0 || index >= currentSize) {
			return null;
		} else if (index == 0) { // Special case: get head value
			return head.getValue();
		} else { // Get after head
			Node<E> curNode = head;
			for (int i = 0; i < index; i++) {
				curNode = curNode.getNext();
			}
			return curNode.getValue();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Comparable<E>[] toArray() {
		int index = 0;
		Comparable[] theArray = new Comparable[size()]; // Cannot use Object here
		for(Node<E> curNode = this.head; index < size() && curNode  != null; curNode = curNode.getNext(), index++) {
			theArray[index] = curNode.getValue();
		}
		return theArray;
	}
}