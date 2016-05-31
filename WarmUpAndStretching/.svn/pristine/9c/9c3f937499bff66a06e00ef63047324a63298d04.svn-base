package priorityQueue;

import java.util.ArrayList;

/**
 * An implementation of the Priority Queue interface using an array list.
 * 
 * @author Matt Boutell and <<Brendan Goldacker>>. Created Mar 29, 2014.
 * 
 * @param <T>
 *            Generic type of PQ elements
 */
public class ArrayListMinPQ<T extends Comparable<T>> {
	// Requirement: You must use this instance variable without changes.
	private ArrayList<T> items;

	public ArrayListMinPQ() {
		this.items = new ArrayList<>();
	}

	// finds the min of the ArrayList, which is the first item
	public T findMin() {
		// This is also known as peekMin
		if (this.items.size() > 0) {
			return this.items.get(0);
		}
		return null;
	}

	// deletes the min of the ArrayList, which is the first item
	public T deleteMin() {
		// deletes the first item since it is the smallest
		T removed = null;
		if (this.items.size() > 0) {
			removed = this.items.remove(0);
		}
		return removed;
	}

	// inserts item in the correct minimum position
	public void insert(T item) {
		// if no items in the array then adds
		if (this.items.size() == 0) {
			this.items.add(item);
			return;
		}
		// finds a postion where item is samller, then is placed there
		for (int i = 0; i < this.items.size(); i++) {
			int compare = item.compareTo(this.items.get(i));
			if (compare <= 0) {
				this.items.add(i, item);
				break;
			}
			// if there are no smaller items, then it is added to the end
			if (i + 1 == this.items.size()) {
				this.items.add(item);
				break;
			}
		}
		return;

	}

	// returns the size of items
	public int size() {
		return this.items.size();
	}

	// returns true if items is empty, else returns false
	public boolean isEmpty() {
		if (this.items.size() == 0)
			return true;
		return false;
	}

	// removes everything from items
	public void clear() {
		this.items.clear();
	}
}
