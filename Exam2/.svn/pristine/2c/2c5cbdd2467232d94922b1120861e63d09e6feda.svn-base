package subtree;

import java.util.Stack;

/**
 * Exam 2a. Tree methods.
 * 
 * @author Matt Boutell and TODO: You.
 */

/*
 * TODO: Directions: Implement the method below. See the paper for details.
 */
public class BinaryTree {
	private BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode('$', 0);

	public BinaryTree() {
		root = NULL_NODE;
	}

	/** See the paper for details */
	public String maxSubtree() {
		if(this.root == NULL_NODE) {
			return "$0";
		}
		DataContainer data = this.root.maxSubtree();
		return "" + data.where + data.maxSum;
	}
	
	private class DataContainer {
		int sum; 
		int maxSum;
		char where;
		
		public DataContainer(int sum, int maxSum, char where) {
			this.sum = sum;
			this.maxSum = maxSum;
			this.where = where;
		}
	}

	/**
	 * If you already got more than 5 points on the previous problem, just skip
	 * this one. But if you are stuck on the previous problem, and are currently
	 * earning less than 5 points, I encourage you to do this problem. I will
	 * take the better of the previous one and this one. It should be a
	 * straightforward way to get 5 points. More importantly, solving it may
	 * give you some ideas on the previous problem.
	 * 
	 * @return The sum of the numeric values of the nodes in this tree. If the
	 *         tree is empty, returns 0. The sum of the nodes can be negative.
	 * 
	 */
	public int sum() {
		if (this.root == NULL_NODE) {
			return 0;
		}
		int[] sum = new int[1];
		sum[0] = 0;
		int max = this.root.subSum(sum);
		return max;
	}


	// /////////////// BinaryNode
	public class BinaryNode {

		// Note there are two "data" fields: a label and a value:
		public Character label;
		public int value;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Character label, int value) {
			this.label = label;
			this.value = value;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}


		public DataContainer maxSubtree() {
			if(this == NULL_NODE) {
				return new DataContainer(0, 0, '$');
			}
			
			DataContainer leftData = this.left.maxSubtree();
			DataContainer rightData = this.right.maxSubtree();
			
			int sum = leftData.sum + rightData.sum + this.value;
			
			// left is the maxSum
			if(leftData.maxSum >= rightData.maxSum && leftData.maxSum >= sum){
				return new DataContainer(sum, leftData.maxSum, leftData.where);
			}
			// right is the maxSum
			if(rightData.maxSum > leftData.maxSum && rightData.maxSum > sum) {

				return new DataContainer(sum, rightData.maxSum, rightData.where);
			}
			
			// this is the maxSum			
			return new DataContainer(sum, sum, this.label);
		}


		/**
		 * 
		 * returns the sum of the this value and all subtree values.
		 *
		 * @param sum
		 * @return
		 */
		public int subSum(int[] sum) {
			if (this == NULL_NODE) {
				return 0;
			}
			sum[0] += this.value;
			// check both directions
			this.left.subSum(sum);
			this.right.subSum(sum);
			return sum[0];

		}

		// The next methods are used by the unit tests
		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.label.toString() + right.toString();
		}
	}

	// The next methods are used by the unit tests
	@Override
	public String toString() {
		return root.toString();
	}

	/**
	 * This constructs a tree according to the preorder method introduced in
	 * displayable binary tree.
	 *
	 * @param charElements
	 * @param childCodes
	 */
	public BinaryTree(CharSequence charElements, CharSequence childCodes, int[] values) {
		root = preOrderBuild(charElements, childCodes, values);
	}

	/**
	 * Generates a binary tree whose node contents and pre-order traversal order
	 * come from charElements. For each of those nodes, the corresponding
	 * element in childCodes indicates the number of children, where L means one
	 * left child, R means one right child, and 0 and 2 mean zero and two
	 * children respectively.
	 *
	 * @param charElements
	 * @param childCodes
	 * @return the binary tree constructed from charElements and childCodes
	 */
	public BinaryNode preOrderBuild(CharSequence charElements, CharSequence childCodes, int[] values) {
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		for (int i = charElements.length() - 1; i >= 0; i--) {
			char label = charElements.charAt(i);
			char code = childCodes.charAt(i);
			int value = values[i];
			BinaryNode left = NULL_NODE, right = NULL_NODE;
			if (code == 'L' || code == '2') {
				left = stack.pop();
			}
			if (code == 'R' || code == '2') {
				right = stack.pop();
			}
			BinaryNode node = new BinaryNode(label, value);
			node.left = left;
			node.right = right;
			stack.push(node);
		}
		return stack.pop();
	}
}