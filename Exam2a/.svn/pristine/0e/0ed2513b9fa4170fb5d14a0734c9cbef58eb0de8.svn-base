import java.util.Stack;

/**
 * Exam 2a. Tree methods.
 * 
 * @author Matt Boutell and TODO: You!
 * @param <T>
 */

/*
 * TODO: Directions: Implement the methods below. See the paper for details.
 */
public class BinarySearchTree {

	BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode('\0');

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	public boolean isLinkedList() {
		// this is an empty linked list
		if (this.root == NULL_NODE) {
			return true;
		}
		// else return recursive node method
		return this.root.isLinkedList();
	}

	public String pathString(char item) {
		String path = this.root.pathString(item);
		if (path.charAt(path.length() - 1) == '0') {
			// if path is marked with not found marker
			return "";
		}
		// else return the path
		return path;
	}

	public int evaluate() {
		// if tree is empty
		if (this.root == NULL_NODE) {
			return 0;
		}
		// if tree only conatins a single leaf
		if (Character.isDigit(this.root.data)) {
			return Integer.parseInt(this.root.data + "");
		}
		// else use recursive helper
		String postfix = this.root.toPrefix();

		// evaluate the postifx expresion
		Stack<Integer> stack = new Stack<Integer>(); 
		Character currentChar;
		int total = 0;
		//String[] operations = postfix.split(" ");
		// since the is a prefix string, we must go backwards
		for (int i=0 ; i<= postfix.length() - 1; i++){
			currentChar = postfix.charAt(i);
			// if the character is a digit
			if (Character.isDigit(currentChar))
				// add digit to the stack
				stack.push(Integer.parseInt(currentChar + "" ));
			// if the character is a operation
			if (!Character.isDigit(currentChar)){
				char ops = currentChar;
				int first = stack.pop();
				int second = stack.pop();
				// choose what operation to do
				// then put the total back onto the stack
				switch(ops){
				case '+': 
					stack.push(first + second);
					break; 
				case '-':
					stack.push(second - first);
					break; 
				case '*':
					stack.push(first * second);
					break; 
				case '/':
					if (first == 0){
						throw new ArithmeticException();
					} 
					stack.push(second/first);
					break; 
				case '^':
					stack.push((int) Math.pow(second, first));
					break;			
				}				
			}
		}
		if (stack.size() > 1)
			throw new ArithmeticException();
		total = stack.pop();
		return total;
		
		
		
		
		
	}

	// Other methods used by the unit tests are below BinaryNode.

	public class BinaryNode {
		public char data;
		public BinaryNode left;
		public BinaryNode right;

		// Helpers here:

		public boolean isLinkedList() {
			// if it has reached a null node then it has gone
			// all the way through wihtout returning false
			if (this.left == NULL_NODE && this.right == NULL_NODE) {
				return true;
			}
			// if no left, but a right
			if (this.left == NULL_NODE) {
				return right.isLinkedList();
			}
			// if no right, but a left
			if (this.right == NULL_NODE) {
				return left.isLinkedList();
			}
			// if there is a left and a right
			return false;
		}

		/**
		 * helper method that converts the tree into a postfix transversal
		 * String. which is also equal to a  postfix expresion
		 * 
		 * @return - postfix expresion string
		 */
		public String toPrefix() {
			// go in pre-order and add to string
			// if has two children
			if (this.left != NULL_NODE && this.right != NULL_NODE) {
				return this.left.toPrefix() + this.right.toPrefix() + this.data;
			}
			// if only left
			if (this.left != NULL_NODE) {
				return this.left.toPrefix() + this.data;
			}
			// if only right
			if (this.right != NULL_NODE) {
				return this.right.toPrefix() + this.data;
			}
			// if this is a leaf node
			return this.data + "";
		}

		public String pathString(char item) {
			// item is not found
			if (this == NULL_NODE) {
				// String is marked with 0 marker
				return "0";
			}
			if (item < this.data) {
				// add this to the path, and go left
				return this.data + this.left.pathString(item);
			}
			if (item > this.data) {
				// add htis to the path, and go right
				return this.data + this.right.pathString(item);
			}
			// if this.data == item
			return this.data + "";
		}

		// The rest of the methods are used by the unit tests and for debugging
		public BinaryNode(char element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public BinaryNode(char element, BinaryNode left, BinaryNode right) {
			this(element);
			this.left = left;
			this.right = right;
		}

		public BinaryNode insert(char e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e < data) {
				left = left.insert(e);
			} else if (e > data) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}

		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.data + right.toString();
		}

		public String toIndentString(String indent) {
			if (this == NULL_NODE) {
				return indent + "NULL\n";
			}

			String myInfo = indent + String.format("%c\n", this.data);

			return myInfo + this.left.toIndentString(indent + "  ") + this.right.toIndentString(indent + "  ");
		}
	}

	// The next methods are used by the unit tests
	public void insert(char e) {
		root = root.insert(e);
	}

	/**
	 * Constructs a binary tree using the given in-order and pre-order
	 * traversals.
	 * 
	 * @param preOrder
	 * @param inOrder
	 */
	public BinarySearchTree(String preOrder, String inOrder) {
		root = buildTree(preOrder, inOrder);
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

	@Override
	public String toString() {
		return root.toString();
	}

	/**
	 * Builds a binary tree with the given in-order and pre-order traversals.
	 * This is a nice algorithm. :)
	 * 
	 * @param preOrder
	 * @param inOrder
	 * 
	 * @return the root of the generated binary tree, or null for an empty tree
	 */
	BinaryNode buildTree(String preOrder, String inOrder) {
		if (inOrder.length() == 0) {
			return NULL_NODE;
		}
		char elem = preOrder.charAt(0);
		int elemsInOrderIndex = inOrder.indexOf(elem);
		if (elemsInOrderIndex < 0) {
			throw new IllegalArgumentException("no valid tree for given arguments");
		}

		String leftPreOrder = preOrder.substring(1, elemsInOrderIndex + 1);
		String rightPreOrder = preOrder.substring(elemsInOrderIndex + 1);
		String leftInOrder = inOrder.substring(0, elemsInOrderIndex);
		String rightInOrder = inOrder.substring(elemsInOrderIndex + 1);
		BinaryNode left = buildTree(leftPreOrder, leftInOrder);
		BinaryNode right = buildTree(rightPreOrder, rightInOrder);
		return new BinaryNode(elem, left, right);
	}
}