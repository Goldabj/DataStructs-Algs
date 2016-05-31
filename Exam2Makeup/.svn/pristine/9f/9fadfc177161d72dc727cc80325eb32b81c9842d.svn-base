package lefttaller;
/**
 * Exam 2. Tree methods.
 * 
 * @author You!
 */

/*
 * Directions: Implement the given method. See the paper for details.
 */
public class BinarySearchTree {

	BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	public boolean isLeftAlwaysTaller() {
		DataContainer rootData = this.root.leftHelper();
		if(rootData.stillTrue == false) {
			return false;
		}
		return true;
	}

	/**
	 * Feel free to call from tests to use to verify the shapes of your trees
	 * while debugging. Just remove the calls you are done so the output isn't
	 * cluttered.
	 * 
	 * @return A string showing a traversal of the nodes where children are
	 *         indented so that the structure of the tree can be determined.
	 * 
	 */
	public String toIndentString() {
		return root.toIndentString("");
	}

	// The next methods are used by the unit tests
	public void insert(Character e) {
		root = root.insert(e);
	}

	@Override
	public String toString() {
		return root.toString();
	}
	
	public class DataContainer{
		boolean stillTrue;
		int height;
		
		public DataContainer(int h, boolean leftBigger) {
			this.height = h;
			this.stillTrue = leftBigger;
			
		}
		
	}

	// /////////////// BinaryNode
	public class BinaryNode {
		public Character data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Character element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		// The next 2 methods are used by the unit tests
		public BinaryNode insert(Character e) {
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
		
		public DataContainer leftHelper() {
			if(this == NULL_NODE) {
				return new DataContainer(0, true);
			}
			// for this left and right heights
			int leftHeight;
			int rightHeight;
			
			// compute left height
			DataContainer leftData = this.left.leftHelper();
			leftHeight = leftData.height;
			if(this.left != NULL_NODE) {
				leftHeight++; 
			}
			
			DataContainer rightData = this.right.leftHelper();
			// compute right height
			rightHeight = rightData.height;
			if(this.right != NULL_NODE) {
				rightHeight++;
			}
			
			if(rightHeight >= leftHeight) {
				if(rightHeight != 0 || leftHeight != 0) { 
					leftData.stillTrue = false;
				}
			}
			
			// used to check if somwhere lower in the tree already detected a false 
			boolean truth; 
			if(rightData.stillTrue == false || leftData.stillTrue == false) {
				truth = false;
			}else {
				truth = true;
			}
			
			// used so this.rights height could be left.height or right.height with still
			// having the bottom of the tree true
			int totalH = Math.max(leftHeight, rightHeight);
			// else on child is empty
			return new DataContainer(totalH, truth);
		}

		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.data.toString() + right.toString();
		}

		public String toIndentString(String indent) {
			if (this == NULL_NODE) {
				return indent + "NULL\n";
			}

			String myInfo = indent + String.format("%c\n", this.data);

			return myInfo + this.left.toIndentString(indent + "  ") + this.right.toIndentString(indent + "  ");
		}
	}
}