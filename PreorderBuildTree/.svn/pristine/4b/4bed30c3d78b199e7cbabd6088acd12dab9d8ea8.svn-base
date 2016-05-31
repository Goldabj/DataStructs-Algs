package buildtree;

/**
 * 
 * @author Matt Boutell and <<<YOUR NAME HERE>>>.
 * @param <T>
 */

public class BinaryTree {

	private BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinaryTree() {
		root = NULL_NODE;
	}

	/**
	 * Constructs a tree (any tree of characters, not just a BST) with the given
	 * values and number of children, given in a pre-order traversal order. See
	 * the HW spec for more details.
	 * 
	 * @param chars
	 *            One char per node.
	 * @param children
	 *            L,R, 2, or 0.
	 */
	public BinaryTree(String chars, String children) {
		// Done: Implement this constructor. You may not add any other fields to
		// the BinaryTree class, but you may add local variables and helper
		// methods if you like.
		this.root = NULL_NODE;
		for (int i = -1; i < children.length() - 1; i++) {
			// if tree empty
			if (i == -1) {
				this.root = new BinaryNode(chars.charAt(i + 1));
			} else {
				// checking where to add by last node added
				switch (children.charAt(i)) {
				case '2':
					// always add left
					this.root.constructHelper(chars.charAt(i), 'L', chars.charAt(i+1));
					break;
				case '0':
					// parent node is a previous node with 2 children
					char parentData = this.root.data;
					int previous0 = 0;
					for (int j = i; j > -1; j--) {
						if(children.charAt(j) == '0') {
							previous0++;
						}
						if (children.charAt(j) == '2') {
							previous0--;
							if(previous0 == 0) {
								parentData = chars.charAt(j);
								break;
							}
						}
					}
					// alwasy add to the right
					this.root.constructHelper(parentData, 'R', chars.charAt(i+1));
					break;
				case 'L':
					this.root.constructHelper(chars.charAt(i), 'L', chars.charAt(i+1));
					break;
				case 'R': 
					this.root.constructHelper(chars.charAt(i), 'R', chars.charAt(i+1));
				}
			}
		}
	}

	/**
	 * In-order traversal of the characters
	 */
	@Override
	public String toString() {
		return root.toString();
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

		public Character data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Character element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + data + right.toString();
		}

		public String toStructuredString() {
			if (this == NULL_NODE) {
				return "";
			}
			return "(" + left.toStructuredString() + this.data + right.toStructuredString() + ")";
		}

		// slow O(N) time
		/**
		 * binary tree constructor helper, adds the new node at the specified direction
		 * of the previous node
		 *
		 * @param previousNode
		 * @param direction
		 * @param toAdd
		 */
		void constructHelper(char previousNode, char direction, char toAdd) {
			// if previous node isnt found on this side
			if (this.equals(NULL_NODE)) {
				return;
			}
			if (this.data == previousNode) {
				if (direction == 'L') {
					this.left = new BinaryNode(toAdd);
				} else {
					this.right = new BinaryNode(toAdd);
				}
			} else {
				this.left.constructHelper(previousNode, direction, toAdd);
				this.right.constructHelper(previousNode, direction, toAdd);
			}
		}

	}
}