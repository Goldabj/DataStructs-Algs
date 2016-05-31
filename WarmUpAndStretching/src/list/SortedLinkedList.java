package list;

/**
 * 
 * @author anderson
 * 
 * @param <T>
 *            Any Comparable type
 * 
 *            A linked list whose elements are kept in sorted order.
 */
public class SortedLinkedList<T extends Comparable<T>> extends DoublyLinkedList<T> {

	/**
	 * Create an empty list
	 * 
	 */
	public SortedLinkedList() {
		super();
	}

	/**
	 * Creates a sorted list containing the same elements as the parameter
	 * 
	 * @param list
	 *            the input list
	 */
	public SortedLinkedList(DoublyLinkedList<T> list) {
		super();
		DLLIterator<T> iterator = list.iterator();
		while (iterator.hasNext()) {
			this.add(iterator.next());
		}
	}

	/**
	 * Adds the given element to the list, keeping it sorted.
	 */
	@Override
	public void add(T element) {
		// if empty then add first
		if (this.head.next == this.tail) {
			super.addFirst(element);
			return;
		}
		Node currentNode = this.head.next;
		while (currentNode.next != null) {
			if (currentNode.data.compareTo(element) > 0) {
				currentNode.prev.addAfter(element);
				return;
			}
			currentNode = currentNode.next;
		}
		this.tail.prev.addAfter(element);
		return;
	}

	@Override
	public void addFirst(T element) {
		// Done: throw UnsupportedOperationException exception
		throw new UnsupportedOperationException();
	}

	@Override
	public void addLast(T element) {
		// Done: throw UnsupportedOperationException exception
		throw new UnsupportedOperationException();
	}
}
