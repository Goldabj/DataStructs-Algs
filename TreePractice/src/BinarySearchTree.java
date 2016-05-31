/**
 * Binary Tree practice problems
 * 
 * @author Matt Boutell and <<<YOUR NAME HERE>>>. 2014.
 * @param <T>
 */

/*
 * TODO: 0 You are to implement the four methods below. I took most of them from
 * a CSSE230 exam given in a prior term. These can all be solved by recursion -
 * I encourage you to do so too, since most students find practicing recursion
 * to be more useful.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

	private BinaryNode root;
	private final BinaryNode NULL_NODE = new BinaryNode(null);
	private int currentNodeDepth = 0;
	private String numChildrenString = "";
	private int previousSide = -1; // if 1 then prevoius = left, if 0 previous = right
	private int positiveCount = 0;
	
	public BinarySearchTree() {
		root = NULL_NODE;
	}

	/**
	 * This method counts the number of occurrences of positive Integers in the
	 * tree that is of type Integer. Hint: You may assume this tree contains
	 * integers, so may use a cast.
	 * 
	 * @return The number of positive integers in the tree.
	 */
	public int countPositives() {
		this.positiveCount = 0;
		return this.root.countPositives();
	}

	/**
	 * Recall that the depth of a node is number of edges in a path from this
	 * node to the root. Returns the depth of the given item in the tree. If the
	 * item isn't in the tree, then it returns -1.
	 * 
	 * @param item
	 * @return The depth, or -1 if it isn't in the tree.
	 */
	public int getDepth(T item) {
		this.currentNodeDepth = 0;
		return this.root.getDepth(item);
	}

	/**
	 * This method visits each node of the BST in pre-order and determines the
	 * number of children of each node. It produces a string of those numbers.
	 * If the tree is empty, an empty string is to be returned. For the
	 * following tree, the method returns the string: "2200110"
	 * 
	 * 10 5 15 2 7 18 10
	 * 
	 * @return A string representing the number of children of each node when
	 *         the nodes are visited in pre-order.
	 */

	public String numChildrenOfEachNode() {
		this.numChildrenString = "";
		return this.root.numChildrenString();
	}

	/**
	 * This method determines if a BST forms a zig-zag pattern. By this we mean
	 * that each node has exactly one child, except for the leaf. In addition,
	 * the nodes alternate between being a left and a right child. An empty tree
	 * or a tree consisting of just the root are both said to form a zigzag
	 * pattern. For example, if you insert the elements 10, 5, 9, 6, 7 into a
	 * BST in that order. , you will get a zig-zag.
	 * 
	 * @return True if the tree forms a zigzag and false otherwise.
	 */
	public boolean isZigZag() {
		this.previousSide = -1;
		return this.root.isZigZag();
	}

	public void insert(T e) {
		root = root.insert(e);
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public T element;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(T element) {
			this.element = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		/**
		 * returns flase if the current position of the
		 * node doesn't follow the previous zig zag patteren
		 * if it reaches a null node, then returns true
		 *
		 * @return
		 */
		public boolean isZigZag() {
			//return true if root is NULL_NODE
			if(this == NULL_NODE) {
				return true;
			}
			// if more than one child return false
			if(this.left != NULL_NODE && this.right != NULL_NODE) {
				return false;
			}
			if(this.left != NULL_NODE) {
				// if prevous was left return false
				if(previousSide == 1) {
					return false;
				}
				// check if it continues to zig zag
				previousSide = 1;
				return this.left.isZigZag();
			}
			
			if(this.right != NULL_NODE) {
				// if previous was right then return false
				if(previousSide == 0) {
					return false;
				}
				//chekcs if it contiunes to zig zag
				previousSide = 0;
				return this.right.isZigZag();
			}
			// gets here if we are at a leaf node
			return true;
		}

		/**
		 * puts together a string that is conatins the 
		 * amount of children each node has, iterating in preoder
		 *
		 * @return
		 */
		public String numChildrenString() {
			//return if NULL_NODE
			if(this == NULL_NODE) {
				return "";
			}
			// if not NULL_NODE then count number of children
			if(this.left!= NULL_NODE && this.right != NULL_NODE) {
				numChildrenString += "2";
			}else if(this.left != NULL_NODE || this.right != NULL_NODE){
				numChildrenString += "1";
			}else {
				numChildrenString += "0";
			}
			// goes to left, then goes to right
				this.left.numChildrenString();
				this.right.numChildrenString();
			return numChildrenString;
		}

		/**
		 * reutrns the depth of the elemetn from the 
		 *
		 * @param item
		 * @return
		 */
		public int getDepth(T item) {
			//if root == NULL_NODE return -1
			if(this == NULL_NODE) {
				return -1;
			}
			if((int) this.element > (int) item){
				//if there is a path add one to depth
				if(this.left != NULL_NODE){
					currentNodeDepth++;
					return this.left.getDepth(item);
				}
				// item not found
				currentNodeDepth = 0;
				return -1;
			}
			if((int) this.element < (int) item) {
				//if there is a path then add one to depth
				if(this.right != NULL_NODE){
					currentNodeDepth++;
					return this.right.getDepth(item);
				}
				// item not found 
				currentNodeDepth = 0;
				return -1;
			}
			// will return depth if element is found
			return currentNodeDepth;
		}

		/**
		 * This method counts the number of occurrences of positive Integers in
		 * the tree that is of type Integer. Hint: You may assume this tree
		 * contains integers, so may use a cast.
		 * 
		 * @return The number of positive integers in the tree.
		 */
		public int countPositives() {
			if (this == NULL_NODE) {
				return 0;
			}
			// adds this element
			if ((int) this.element > 0) {
				positiveCount++;
			}
			//count positives in left subtree
			this.left.countPositives();
			//count positives in right subtree
			this.right.countPositives();
			return positiveCount;
		}

		public BinaryNode insert(T e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(element) < 0) {
				left = left.insert(e);
			} else if (e.compareTo(element) > 0) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}
	}
}