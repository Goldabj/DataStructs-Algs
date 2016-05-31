package lefttaller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * 
 * @author Matt Boutell
 *
 */
public class Testing {

	private static int isLeftTallerPoints = 0;

	// Helper method to shorten tests. Just loops through the string, inserting
	// one character at a time into the BST.
	private void insertManyChars(BinarySearchTree t, String string) {
		for (int i = 0; i < string.length(); i++) {
			t.insert(string.charAt(i));
		}
	}

	@Test
	public void testIsLeftTallerTiny() {
		BinarySearchTree tree;

		// Empty tree is OK
		tree = new BinarySearchTree();
		assertTrue(tree.isLeftAlwaysTaller());

		// Any leaf is OK.
		tree = new BinarySearchTree();
		insertManyChars(tree, "A");
		assertTrue(tree.isLeftAlwaysTaller());

		// Check all other trees of height = 1
		tree = new BinarySearchTree();
		insertManyChars(tree, "BA");
		assertTrue(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		insertManyChars(tree, "AB");
		assertFalse(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		insertManyChars(tree, "BAC"); // full tree.
		assertFalse(tree.isLeftAlwaysTaller());
		isLeftTallerPoints += 3;
	}

	@Test
	public void testIsLeftTallerHeightOfTwo() {
		BinarySearchTree tree;

		tree = new BinarySearchTree();
		// no rotations, so it looks like a linked list.
		insertManyChars(tree, "ABC");
		assertFalse(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		// no rotations, so it looks like a linked list.
		insertManyChars(tree, "CBA");
		assertTrue(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		insertManyChars(tree, "CDBA");
		assertTrue(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		insertManyChars(tree, "BACD");
		assertFalse(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		insertManyChars(tree, "BADC");
		assertFalse(tree.isLeftAlwaysTaller());

		isLeftTallerPoints += 4;
	}

	@Test
	public void testIsLeftTallerCheckOtherDeeper() {
		// The nodes are inserted to keep it a BST, but I am building them in
		// level-order to be consistent.
		BinarySearchTree tree = new BinarySearchTree();
		insertManyChars(tree, "GCJBDIA");
		assertTrue(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		insertManyChars(tree, "GCJBDIAKH");
		assertFalse(tree.isLeftAlwaysTaller());
		isLeftTallerPoints += 3;
	}

	@Test
	public void testIsLeftTallerObviousLeft() {
		BinarySearchTree tree = new BinarySearchTree();
		insertManyChars(tree, "MKNILGJEHD");
		assertTrue(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		insertManyChars(tree, "MKNILGJEHDF");
		assertFalse(tree.isLeftAlwaysTaller());
		isLeftTallerPoints += 3;
	}

	@Test
	public void testIsLeftTallerOneFromSpec() {

		// A beautiful AVL tree.
		BinarySearchTree tree = new BinarySearchTree();
		insertManyChars(tree, "MKPHLOQGINF");
		assertTrue(tree.isLeftAlwaysTaller());

		// ...now with height-balance property despoiled by a single node...
		tree = new BinarySearchTree();
		insertManyChars(tree, "MKPHLOQGINFJ");
		assertFalse(tree.isLeftAlwaysTaller());

		// .. the original, minus node I: no longer H-B, but still left taller.
		tree = new BinarySearchTree();
		insertManyChars(tree, "MKPHLOQGNF");
		assertTrue(tree.isLeftAlwaysTaller());
		isLeftTallerPoints += 4;
	}

	@Test
	public void testIsLeftTallerOtherBigUglyOnes() {

		BinarySearchTree tree = new BinarySearchTree();
		insertManyChars(tree, "PIUGKTEHJSCFRBDA");
		assertTrue(tree.isLeftAlwaysTaller());

		tree = new BinarySearchTree();
		insertManyChars(tree, "PIUGKTEHJNSCFMORBDLA");
		assertFalse(tree.isLeftAlwaysTaller());
		isLeftTallerPoints += 3;
	}

	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/20 left-always-taller unit test points\n", isLeftTallerPoints);
		System.out.printf("   (Efficiency, worth 10 points, will be checked by the instructor)\n");

	}
}