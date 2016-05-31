package binarysearchtree;


// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of this package.


/**
 * Basic node stored in unbalanced binary search trees
 * Note that this class is not accessible outside of this package.
 * 
 * @param <AnyType>  The type of a node element.
 */
class BinaryNode<AnyType> {
	
    // Data: accessible by other package routines
	
	/**
	 * The data in the node
	 */
    AnyType             element;  // The data in the node
    /**
     * Left child
     */
    BinaryNode<AnyType> left;     // Left child
    /**
     * Right child
     */
    BinaryNode<AnyType> right;    // Right child
    /**
     * size of subtree rooted at this node.
     */
    int size;
    
    /**
     * Constructor for a leaf node
     * @param theElement
     */
    BinaryNode( AnyType theElement ) {
        this(theElement, null, null);
    }

    /**
     * Constructor for any node
     * @param theElement
     * @param left
     * @param right
     */
    BinaryNode( AnyType theElement, BinaryNode<AnyType> left, BinaryNode<AnyType> right ) {
        this.element = theElement;
        this.left = left;
        this.right = right;
    }
    
    /**
     * Returns the rank of this node
     * @return This node's rank.
     */
    int getRank() {
    	return this.left == null ? 0 : this.left.size;
    }
}


 
