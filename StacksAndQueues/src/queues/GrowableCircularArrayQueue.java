package queues;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * A circular queue that grows as needed.
 * 
 * @author Matt Boutell and Brendan Goldacker and Vibha Alangar
 * @param <T>
 */
public class GrowableCircularArrayQueue<T> implements SimpleQueue<T> {
	// Done: Declare this class to implement SimpleQueue<T>, then add the
	// missing methods (Eclipse will help).
	// Done: The javadoc for overridden methods is in the MyQueue interface.
	// Read it!

	private static final int INITIAL_CAPACITY = 5;

	private T[] array;
	private Class<T> type;
	private int size;
	private int head;
	private int tail;
	private int capacity;

	/**
	 * Creates an empty queue with an initial capacity of 5
	 * 
	 * @param type
	 *            So that an array of this type can be constructed.
	 */
	@SuppressWarnings("unchecked")
	public GrowableCircularArrayQueue(Class<T> type) {
		this.type = type;
		// This is a workaround due to a limitation Java has with
		// constructing generic arrays.
		this.array = (T[]) Array.newInstance(this.type, INITIAL_CAPACITY);
		this.size = 0;
		this.head = -1;
		this.tail = 0;
		this.capacity = 5;
	}

	/**
	 * Displays the contents of the queue in insertion order, with the
	 * most-recently inserted one last, in other words, not wrapped around. Each
	 * adjacent pair will be separated by a comma and a space, and the whole
	 * contents will be bounded by square brackets. See the unit tests for
	 * examples.
	 */
	@Override
	public String toString() {
		// add the begining {
		String string = "[";
		for (int i = 0; i < this.size(); i++) {
			if (this.head + i < this.capacity) {
				string += this.array[this.head + i] + ", ";
			} else {
				string += this.array[i - (this.capacity - this.head)] + ", ";
			}
		}

		// removes the extra ", "
		if (string.length() > 2)
			string = string.substring(0, string.length() - 2);
		return string + "]";
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.size(); i++) {
			this.dequeue();
		}
		this.size = 0;
		this.tail = 0;
		this.head = -1;

	}

	@Override
	public void enqueue(T item) {
		// Done Auto-generated method stub.
		// the empty array case
		if (this.head == -1) {
			this.array[this.tail] = item;
			this.size++;
			this.tail++;
			this.head = 0;
			return;
		}
		// if the array is full
		if ((this.tail == this.head) || (this.head == 0 && (this.tail == this.capacity))) {
			// double the array size
			T[] array2 = (T[]) Array.newInstance(this.type, this.capacity * 2);
			// put values into new array
			for (int i = 0; i < this.size(); i++) {
				// make sure there is no overflow, and you wrap arround
				if (this.head + i < this.capacity) {
					array2[i] = this.array[this.head + i];
				} else {
					array2[i] = this.array[i - (this.capacity - this.head)];
				}
			}
			//update instance vars
			this.tail = this.size();
			array2[this.tail] = item;
			this.capacity = this.capacity * 2;
			this.size++;
			this.tail++;
			this.head = 0;
			this.array = array2;
		} else {
			if (this.tail == this.capacity) {
				this.tail = 0;
			}
			this.array[this.tail] = item;
			this.tail++;
			this.size++;
		}
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// done Auto-generated method stub.
		// empty array case
		if (this.head == -1) {
			throw new NoSuchElementException();
		}
		// get value and change value
		T toReturn = array[this.head];
		this.array[this.head] = null;

		// update head
		if (this.head < capacity - 1) {
			this.head += 1;
		} else {
			this.head = 0;
		}
		// if head == tail, then size = 0
		if (this.head == this.tail) {
			this.head = -1;
		}

		this.size -= 1;
		return toReturn;
	}

	@Override
	public T peek() throws NoSuchElementException {
		// DONE Auto-generated method stub.
		if (this.head == -1)
			throw new NoSuchElementException();
		return this.array[this.head];

	}

	@Override
	public boolean isEmpty() {
		// DONE Auto-generated method stub.
		return (this.size == 0);
	}

	@Override
	public int size() {
		// DONE Auto-generated method stub.
		return this.size;
	}

	@Override
	public boolean contains(T item) {
		// DONE Auto-generated method stub.
		for (int i = 0; i < this.size(); i++) {
			if (this.array[i] == item)
				return true;
		}
		return false;
	}

	@Override
	public String debugString() {
		String output = "[";
		for (int i = 0; i < this.capacity; i++) {
			output += this.array[i] + ", ";
		}

		// removes the extra ", "
		if (output.length() > 2)
			output = output.substring(0, output.length() - 2);
		return output + "]";
	}

}
