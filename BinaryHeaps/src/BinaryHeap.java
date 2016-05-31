import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<? super T>> {
	private ArrayList<T> heap;
	
	/**
	 * creates a new Heap which is an ArrayList
	 *
	 */
	public BinaryHeap() {
		this.heap = new ArrayList<>();
		this.heap.add(null);
	}
	/**
	 * takes and sorts an array by Building the heap
	 * then removing elements into the array
	 *
	 * @param array
	 */
	public void sort(T[] array) {
		
		for(T element : array) {
//			insert(element); // for n log n time
			this.heap.add(element);
			buildHeap();
		}		
		for(int i = 0; i < array.length; i++) {
			array[i] = deleteMin();
		}
	}
	
	/**
	 * Deletes the minimum element, then sets the new root to the 
	 * last element then calls perculate to sort the data
	 *
	 * @return
	 */
	public T deleteMin() {
		if(this.heap.size() == 1) {
			return null;
		}
		
		if(this.heap.size() == 2) {
			T min = this.heap.remove(1);
			return min;
		}// else heap.size() > 2
		T min = this.heap.remove(1);
		T newRoot = this.heap.remove(this.heap.size() - 1);
		this.heap.add(1, newRoot);
		perculateDown(1);
		return min;
	}
	
	/**
	 * preculates down from the hole
	 *
	 * @param hole
	 */
	private void perculateDown(int hole) {
		if(this.heap.size() <= 1) {
			return;
		}
		
		int newHole = hole;
		int minChildPos = 1;
		while(newHole <= this.heap.size() -1) {
			T parent = this.heap.get(newHole);
			T minChild = null;
			// find min of children
			int leftChildPos = newHole *2;
			if(leftChildPos <= this.heap.size() -1) { // check if this has child
				T leftChild = this.heap.get(leftChildPos);
				
				T rightChild = null;
				if(leftChildPos + 1 <= this.heap.size() -1) { // check for right child
					rightChild = this.heap.get(leftChildPos + 1);
					
					// find min of two children
					if(leftChild.compareTo(rightChild) <= 0) {
						minChild = leftChild;
						minChildPos = leftChildPos;
					}else {
						minChild = rightChild;
						minChildPos = leftChildPos + 1;
					}
				}else {// right child is null
					minChild = leftChild;
					minChildPos = leftChildPos;
				}
			}
			
			if(minChild != null) {
				if(minChild.compareTo(parent) < 0) {// min child smaller than last
					this.heap.set(minChildPos, parent); // remove smaller
					this.heap.set(newHole, minChild); // move smaller to hole
					newHole = minChildPos;
				}else { // last is smaller than smallest child
					break;
				}
			}else { // no children
				break;
			}
		}
	}

	/**
	 * returns the minimum element of the heap
	 *
	 * @return
	 */
	public T findMin() {
		return this.heap.get(1);
	}
	
	/**
	 * inserts an element in the last position then perculates
	 * it up to the position is should be
	 *
	 * @param element
	 */
	public void insert(T element) {
		int hole = this.heap.size();
		if(hole == 0) {
			this.heap.add(null);
			hole++;
		}
		while(hole > 1) {
			T parent = this.heap.get(hole/2);
			if(parent.compareTo(element) > 0) {
				this.heap.add(hole, parent); // swap with child
				this.heap.remove(hole/2); // remove duplicate
			}else { // parent is less than child
				break;
			}
			hole = hole/2; // set hole to the parent
		}
		this.heap.add(hole, element); // add element in 
	}
	
	/**
	 * taks the heap which is unsorted and sorts
	 * it to a binary Heap
	 *
	 */
	private void buildHeap() {
		for(int i = this.heap.size()/2; i > 0; i--) {
			perculateDown(i);
		}
	}
	
	@Override 
	public String toString() {
		return this.heap.toString();

	}
}
