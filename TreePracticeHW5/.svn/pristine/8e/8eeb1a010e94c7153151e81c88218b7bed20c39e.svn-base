/**
 * More Binary Tree practice problems. This problem creates BSTs of type
 * Integer: 1. Neither problem makes use of the BST ordering property; I just
 * found insert() to be a convenient way to build trees for testing. 2. I used
 * Integer instead of T since the makeTree method sets the data value of each
 * node to be a depth, which is an Integer.
 * 
 * @author Matt Boutell and <<<YOUR NAME HERE>>>.
 * @param <T>
 */

/*
 * TODO: 0 You are to implement the methods below. Use recursion!
 */
public class BinarySearchTree {

	private BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	/**
	 * This constructor creates a full tree of Integers, where the value of each
	 * node is just the depth of that node in the tree.
	 * 
	 * @param maxDepth
	 *            The depth of the leaves in the tree.
	 */
	public BinarySearchTree(int maxDepth) {
		root = NULL_NODE;
		// add a level for each depth until maxDepth
		for (int i = 0; i <= maxDepth; i++) {
			this.root = this.root.addLevel(i);
		}
	}

	public int getSumOfHeights() {
		return this.root.sumofHeights();
	}

	// These are here for testing.
	public void insert(Integer e) {
		root = root.insert(e);
	}

	/**
	 * @return A string showing an in-order traversal of nodes with extra
	 *         brackets so that the structure of the tree can be determined.
	 */
	public String toStructuredString() {
		return root.toStructuredString();
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public Integer data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Integer element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public int sumofHeights() {
			int[] total_obj = new int[1]; // used so we can manipulate this data
			sumofHeightsHelper(total_obj);
			return total_obj[0];
		}

		/**
		 * 
		 *Helper method that adds the current height of a node
		 *to an object that holds the sum of heights. does this recursivly 
		 *until the bottom of the tree is reached
		 *
		 * @param total_obj
		 * @return
		 */
		private int sumofHeightsHelper(int[] total_obj) {
			// height of empty tree is -1
			if (this == NULL_NODE) {
				return -1;
			}
			// calculate the height of the current node
			int currentHeight = 1 + Math.max(this.left.sumofHeightsHelper(total_obj),
					this.right.sumofHeightsHelper(total_obj));
			// add the current height to the total
			total_obj[0] += currentHeight;
			return currentHeight;
		}

		public BinaryNode addLevel(Integer depth) {
			// if this is null add a Binary Node in this spot
			if (this == NULL_NODE) {
				return new BinaryNode(depth);
			}
			// check recursively left and right
			left = left.addLevel(depth);
			right = right.addLevel(depth);
			return this;

		}

		public BinaryNode insert(Integer e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(data) < 0) {
				left = left.insert(e);
			} else if (e.compareTo(data) > 0) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}

		public String toStructuredString() {
			if (this == NULL_NODE) {
				return "";
			}
			return "[" + left.toStructuredString() + this.data + right.toStructuredString() + "]";
		}

	}
}