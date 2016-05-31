package stacks;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * An implementation of a PurgeableStack.
 * 
 * @author Done: Brendan Goldacker
 * @param <T> Any type you want this stack to store.
 */
public class MyPurgeableStack<T> implements PurgeableStack<T>{
	// Done: Declare this class to implement PurgeableStack<T>, then add the
	// missing methods (Eclipse will help with all EXCEPT toString, 
	// which you must add that manually).
	
	// Done: The javadoc for overridden methods is in the PurgeableStack
	// interface. Read it!
	
	// If you use a growable array implementation, you'll probably want these 
	// and the code in the constructor, so I include them for your convenience.
	// If you don't, feel free to delete them.
	private static final int INITIAL_CAPACITY = 5;
	private T[] array;
	private Class<T> type;
	private int size;
	private int amount;
	
	// You may add any other fields you like.

	/**
	 * Creates an empty stack
	 * 
	 * @param type
	 *            So that an array of this type can be constructed.
	 */
	@SuppressWarnings("unchecked")
	public MyPurgeableStack(Class<T> type) {
		// Please keep the type parameter so the tests will run (it's needed for 
		// a growable array implementation), but you may ignore it if you choose
		// a different implementation. 
		// Otherwise, you may modify this method however you see fit.
		this.type = type;
		this.array = (T[]) Array.newInstance(this.type, INITIAL_CAPACITY);
		this.size = INITIAL_CAPACITY;
		this.amount = 0;

	}

	@Override
	public void push(T item) {
		if(this.amount + 1 > this.size - 1) {
			//resize the array and add elements (ammoritized O(1))
			T[] newArray = (T[]) Array.newInstance(this.type, this.size * 2);
			int i = 0;
			for(T element: this.array) {
				if(element != null) {
					newArray[i] = element;
					i++;
				}
			}
			// add the new item;
			newArray[i] = item;
			this.array = newArray;
			this.size = this.size * 2;
			this.amount++;
		}else {
			//else add the item to the array
			this.array[this.amount] = item;
			this.amount++;
		}
		
		
	}

	@Override
	public T pop() throws EmptyStackException {
		if(this.amount == 0){
			throw new EmptyStackException();
		}
		T removed = this.array[this.amount - 1];
		this.array[this.amount - 1] = null;
		this.amount--;
		return removed;
	}

	@Override
	public T peek() throws EmptyStackException {
		if(this.amount == 0) {
			throw new EmptyStackException();
		}
		return this.array[this.amount - 1];
	}

	@Override
	public boolean isEmpty() {
		return this.amount == 0;
	}

	@Override
	public int size() {
		return this.amount;
	}

	@Override
	public void clear() {
		// sets this.array to a new empty array
		this.array =(T[]) Array.newInstance(this.type, this.INITIAL_CAPACITY);
		this.amount = 0;
		this.size = this.INITIAL_CAPACITY;
		
	}

	@Override
	public int depth(T item) {
		//finds the element, and returns the amount - index
		for(int i = 0; i <= this.amount; i++){
			if(this.array[i] == item) {
				return this.amount - (i + 1);
			}
		}
		//not found
		return -1;
	}

	@Override
	public void purge() {
		T[] newArray = (T[]) Array.newInstance(this.type, this.size);
		int j = this.amount/2;
		for(int i = this.amount - 2; i >= 0; i -= 2) {
			newArray[j] = this.array[i];
			j--;
		}
		// add the new item;
		this.array = newArray;
		this.amount = this.amount / 2;
		
	}
	
	/**
	 * Converts the PurgeableStack to a string, with the most
	 * recent value in the beging of the string
	 *
	 * @return
	 */
	public String toString() {
		// used a stirng builder for efficency 
		StringBuilder string = new StringBuilder();
		string.append("[");
		for(int i = this.amount; i >= 0; i--) {
			T items = this.array[i];
			if(items != null) 
				string.append(items.toString() + ", ");
		}
		String str = "";
		if(string.length() > 2){
			str = string.substring(0, string.length() - 2);
		}else {
			str = string.toString();
		}
		str += "]";
		return str;
		
	}

}