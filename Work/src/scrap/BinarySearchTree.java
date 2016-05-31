package binarysearchtree;

import java.lang.reflect.Array;

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// void removeMin( )      --> Remove minimum item
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Exceptions are thrown by insert, remove, and removeMin if warranted

/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo method.
 * 
 * @author Mark Allen Weiss, modified by Claude Anderson and Matt Boutell
 * @param <AnyType>
 *            Any comparable type
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	/** The tree root. */
	protected BinaryNode<AnyType> root;

	/**
	 * Construct the tree.
	 */
	public BinarySearchTree() {
		this.root = null;
	}

	private BinarySearchTree(BinaryNode<AnyType> rootNode) {
		this.root = rootNode;
	}

	/**
	 * Insert into the tree.
	 * 
	 * @param x
	 *            the item to insert.
	 * @throws DuplicateItemException
	 *             if x is already present.
	 */
	public void insert(AnyType x) {
		this.root = this.insert(x, this.root);
	}

	/**
	 * Remove from the tree..
	 * 
	 * @param x
	 *            the item to remove.
	 * @throws ItemNotFoundException
	 *             if x is not found.
	 */
	public void remove(AnyType x) {
		this.root = this.remove(x, this.root);
	}

	/**
	 * Remove minimum item from the tree.
	 * 
	 * @throws ItemNotFoundException
	 *             if tree is empty.
	 */
	public void removeMin() {
		this.root = this.removeMin(this.root);
	}

	/**
	 * Find the smallest item in the tree.
	 * 
	 * @return smallest item or null if empty.
	 */
	public AnyType findMin() {
		return this.elementAt(findMin(this.root));
	}

	/**
	 * Find the largest item in the tree.
	 * 
	 * @return the largest item or null if empty.
	 */
	public AnyType findMax() {
		return this.elementAt(findMax(this.root));
	}

	/**
	 * Find an item in the tree.
	 * 
	 * @param x
	 *            the item to search for.
	 * @return the matching item or null if not found.
	 */
	public AnyType find(AnyType x) {
		return this.elementAt(find(x, this.root));
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty() {
		this.root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return this.root == null;
	}

	/**
	 * Internal method to get element field.
	 * 
	 * @param t
	 *            the node.
	 * @return the element field or null if t is null.
	 */
	private AnyType elementAt(BinaryNode<AnyType> t) {
		return t == null ? null : t.element;
	}

	/**
	 * Internal method to insert into a subtree.
	 * 
	 * @param x
	 *            the item to insert.
	 * @param t
	 *            the node that roots the tree.
	 * @return the new root.
	 * @throws DuplicateItemException
	 *             if x is already present.
	 */
	protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			t = new BinaryNode<AnyType>(x);
		else if (x.compareTo(t.element) < 0) {
			t.left = insert(x, t.left);
		} else if (x.compareTo(t.element) > 0)
			t.right = insert(x, t.right);
		else
			throw new DuplicateItemException(x.toString()); // Duplicate
		t.size++;
		return t;
	}

	/**
	 * Internal method to remove from a subtree.
	 * 
	 * @param x
	 *            the item to remove.
	 * @param t
	 *            the node that roots the tree.
	 * @return the new root.
	 * @throws ItemNotFoundException
	 *             if x is not found.
	 */
	protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			throw new ItemNotFoundException(x.toString());
		if (x.compareTo(t.element) < 0)
			t.left = remove(x, t.left);

		else if (x.compareTo(t.element) > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) {// Two children
			t.element = findMin(t.right).element;
			t.right = removeMin(t.right);
		} else
			t = (t.left != null) ? t.left : t.right;
		t.size--;
		return t;
	}

	/**
	 * Internal method to remove minimum item from a subtree.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return the new root.
	 * @throws ItemNotFoundException
	 *             if t is empty.
	 */
	protected BinaryNode<AnyType> removeMin(BinaryNode<AnyType> t) {
		if (t == null)
			throw new ItemNotFoundException();
		else if (t.left != null) {
			t.left = removeMin(t.left);
			t.size--;
			return t;
		} else {
			return t.right;
		}
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	protected BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if (t != null)
			while (t.left != null)
				t = t.left;

		return t;
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if (t != null)
			while (t.right != null)
				t = t.right;

		return t;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * 
	 * @param x
	 *            is item to search for.
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the matched item.
	 */
	private BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> t) {
		while (t != null) {
			if (x.compareTo(t.element) < 0)
				t = t.left;
			else if (x.compareTo(t.element) > 0)
				t = t.right;
			else
				return t; // Match
		}

		return null; // Not found
	}

	/**
	 * 
	 * counts elements in this tree
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size(this.root);
	}

	private int size(BinaryNode<AnyType> n) {
		if (n == null)
			return 0;
		return n.size;
	}

	/**
	 * 
	 * computes the height of this tree
	 * 
	 * @return height of tree
	 */
	public int height() {
		return height(this.root);
	}

	private int height(BinaryNode<AnyType> n) {
		if (n == null)
			return -1;
		return 1 + Math.max(height(n.left), height(n.right));
	}

	/**
	 * 
	 * Counts the number of elements in this tree whose values are between
	 * lowest and highest, inclusive. IMPORTANT NOTE: For full credit, the
	 * running time of your code must be O(h + s), where h is the height of the
	 * tree and s is the value returned by the method.
	 * 
	 * @param lowest
	 *            the lowest value in the search range
	 * @param highest
	 *            the highest value in the search range
	 * 
	 * @return the number of such elements in this tree
	 */
	public int rangeCount(AnyType lowest, AnyType highest) {
		if (lowest.compareTo(highest) > 0) {
			return 0;
		}
		int range = 0;
		int low = findRangeLow(lowest);
		int high = findRangeHigh(highest, lowest);
		range = high - low;
		if(range != 1 && range != 0)
			range++;
		return range;
	}

	/**
	 * Returns the number of emelents from this element from the root.
	 * 
	 * @param lowest
	 * @return
	 */
	private int findRangeLow(AnyType lowest) {
		BinaryNode<AnyType> t = this.root;
		int range = 0;
		while (t != null) {
			if (t.left != null && lowest.compareTo(t.element) < 0
					&& lowest.compareTo(t.left.element) <= 0) {// left
				t = t.left;
			} else if (t.right != null && lowest.compareTo(t.element) > 0
					&& lowest.compareTo(t.right.element) >= 0) {// right
				range += t.getRank() + 1;
				t = t.right;
			} else {
				System.out.println(t.element);
				// if(t.element.compareTo(lowest) == 0){
				// range++;
				// }
				return range + t.getRank(); // Match
			}
		}
		return 0;// notfound
	}

	/**
	 * Returns the number of emelents from this element from the root.
	 * 
	 * @param lowest
	 * @return
	 */
	private int findRangeHigh(AnyType lowest, AnyType other) {
		BinaryNode<AnyType> t = this.root;
		int range = 0;
		while (t != null) {
			if (t.left != null && lowest.compareTo(t.element) < 0
					&& lowest.compareTo(t.left.element) <= 0) {// left
				t = t.left;
			} else if (t.right != null && lowest.compareTo(t.element) > 0
					&& lowest.compareTo(t.right.element) >= 0) {// right
				range += t.getRank() + 1;
				t = t.right;

			} else {
				
				System.out.println(t.element);
				return range + t.getRank(); // Match
			}
		}
		return 0;// notfound
	}

	/**
	 * Returns an array whose elements are the elements of the tree,
	 * corresponding to an in-order traversal of the tree. Implementation
	 * requirement: runs in O(n) time and uses rank. The node class' getRank()
	 * method is provided for your convenience.
	 * 
	 * @return The required array. If the tree is empty, returns null.
	 */
	public AnyType[] toArray() {
		// TODO: Complete this method. You may modify any of the given code.
		if (this.root == null) {
			return null;
		}
		// Create a generic array of AnyTypes.
		// This doesn't work: AnyType[] a = new AnyType[this.size(this.root)];
		// Instead, we use the syntax below. You saw this on the max and min
		// problems
		// from WA2. We provided it for you here since declaring a generic array
		// isn't a learning outcome of the course.
		@SuppressWarnings("unchecked")
		AnyType[] a = (AnyType[]) Array.newInstance(
				this.root.element.getClass(), this.size(this.root));

		a[this.root.getRank()] = this.root.element;
		if (this.root.right != null) {
			helpToArray(a, this.root.right, this.root.getRank()
					+ this.root.right.getRank() + 1);
		}
		if (this.root.left != null) {
			helpToArray(a, this.root.left, this.root.left.getRank());
		}
		// TODO: You'll want to mutate the array before returning it, of course.
		return a;
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param a
	 * 
	 * @param right
	 * @param i
	 */
	private void helpToArray(AnyType[] a, BinaryNode<AnyType> node, int i) {
		a[i] = node.element;
		if (node.right != null) {
			helpToArray(a, node.right, i + node.right.getRank() + 1);
		}
		if (node.left != null) {
			helpToArray(a, node.left, i
					- (node.getRank() - node.left.getRank()));
		}
	}

}
