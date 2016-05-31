
public class TreeMethods {

	/**
	 * Inserts the given element into this tree, maintaining parent references
	 * as appropriate. If the element already exists in the tree, does nothing.
	 * Your implementation must be O(H), where H is the height of the tree.
	 * 
	 * @param element
	 */
	public void insert(T element) {
		if (this.root == null)
			this.root = new NodeWithParent<T>(element);
		else {
			this.root.insert(element);
		}
	}

	/**
	 * Finds and returns the next node (after the given node, n) in an in-order
	 * traversal of this tree. Returns null if no such node exists. Your
	 * implementation must be O(H), where H is the height of the tree. Study the
	 * figure in the exam first; this is harder than it seems!
	 * 
	 * @param n
	 * @return the next node after n in an in-order traversal, or null if no
	 *         such node exists
	 */
	NodeWithParent<T> getInOrderSuccessor(NodeWithParent<T> n) {
		if (n.right == null) {
			if (n.parent == null) {
				return null;
			}
			if (n.parent.element.compareTo(n.element) < 0) {// parent is less
															// than the node
				if (n.parent.parent == null) {
					return n.right;
				}
				if (n.parent.element.compareTo(n.parent.parent.element) > 0) {// Grandparent
																				// is
																				// less
																				// than
																				// the
																				// parent
					return n.right;
				} else {
					return n.parent.parent;
				}
			} else {// parent is greater than the node
				n = n.parent;
			}
		} else {
			n = n.right;
			while (n.left != null) {
				n = n.left;
			}
		}
		return n;
	}

	/**
	 * @return the first node in an in-order traversal of this tree, or null of
	 *         no such node exists
	 */
	NodeWithParent<T> getFirstInOrderNode() {
		if (this.root == null) {
			return null;
		}
		NodeWithParent<T> result = this.root;
		while (result.left != null) {
			result = result.left;
		}
		return result;
	}

	/**
	 * @return the height of this tree
	 */
	public int height() {
		if (this.root == null)
			return -1;
		return this.root.height();
	}

	@Override
	public String toString() {
		if (this.root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		this.root.appendStringInOrder(sb);
		return sb.toString();
	}

}

	// ----------------------------------Node methods---------------------//
	/**
	 * @return the height of the subtree rooted at this node
	 */
	int height() {
		int leftHeight = -1;
		if (this.left != null) {
			leftHeight = this.left.height();
		}
		int rightHeight = -1;
		if (this.right != null) {
			rightHeight = this.right.height();
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}

	/**
	 * Appends the elements of an in-order traversal to the given string
	 * builder.
	 * 
	 * @param sb
	 *            mutated
	 */
	void appendStringInOrder(StringBuilder sb) {
		if (this.left != null)
			this.left.appendStringInOrder(sb);
		sb.append(this.element);
		if (this.right != null)
			this.right.appendStringInOrder(sb);
	}

	/**
	 * Inserts this element into this node's subtree
	 * 
	 * @param element
	 */
	void insert(T element) {
		int comp = this.element.compareTo(element);
		if (comp == 0) {
			return;
		}
		if (comp > 0) {// go left young man!
			if (this.left == null) {
				this.left = new NodeWithParent<T>(element);
				this.left.parent = this;
			} else {
				this.left.insert(element);
			}
		} else {// right it is
			if (this.right == null) {
				this.right = new NodeWithParent<T>(element);
				this.right.parent = this;
			} else {
				this.right.insert(element);
			}
		}
	}

}
