package binarytree;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int isHeightBalancedPoints = 0;

	// Helper method to shorten tests. Just loops through the string, inserting
	// one character at a time into the BST.
	private static void insertManyChars(BinarySearchTree t, String string) {
		for (int i = 0; i < string.length(); i++) {
			t.insert(string.charAt(i));
		}
	}

	@Test
	public void testIsHeightBalanceSmall() {
		BinarySearchTree b1 = new BinarySearchTree();
		insertManyChars(b1, "BAC");
		assertTrue(b1.isHeightBalanced());

		BinarySearchTree b2 = new BinarySearchTree();
		insertManyChars(b2, "ABC"); // no rotations, so it looks like a linked
									// list.
		assertFalse(b2.isHeightBalanced());
		isHeightBalancedPoints += 2;
	}

	@Test
	public void testIsHeightBalanceCheckRootBalance() {
		BinarySearchTree b1 = new BinarySearchTree();
		insertManyChars(b1, "BADC");
		assertTrue(b1.isHeightBalanced());

		BinarySearchTree b2 = new BinarySearchTree();
		insertManyChars(b2, "ACBD");
		assertFalse(b2.isHeightBalanced());
		isHeightBalancedPoints += 3;
	}

	@Test
	public void testIsHeightBalanceCheckOtherBalances() {
		BinarySearchTree b1 = new BinarySearchTree();
		insertManyChars(b1, "DBFACEG");
		assertTrue(b1.isHeightBalanced());

		BinarySearchTree b2 = new BinarySearchTree();
		insertManyChars(b2, "DCFAEGB");
		assertFalse(b2.isHeightBalanced());
		isHeightBalancedPoints += 3;
	}

	@Test
	public void testIsHeightBalanceHeightOfFour() {
		BinarySearchTree b1 = new BinarySearchTree();
		insertManyChars(b1, "HCKBFJMADGJMELN");
		assertTrue(b1.isHeightBalanced());

		BinarySearchTree b2 = new BinarySearchTree();
		insertManyChars(b2, "HBKAFJMDGLCE");
		assertFalse(b2.isHeightBalanced());
		isHeightBalancedPoints += 3;
	}

	@Test
	public void testIsHeightBalanceExtremeCases() {

		// THIS IS THE ONE DRAWN IN THE SPEC
		// On this height-balanced tree, there are many, many more nodes on one
		// side than the other. The solution needs to use heights to
		// check balance.
		BinarySearchTree b1 = new BinarySearchTree();
		insertManyChars(b1, "ECNBDJSAGLQUFHKMPRTV");
		assertTrue(b1.isHeightBalanced());

		// For this one, the left and right are both unbalanced to discourage
		// anyone from just comparing the left and right results to each other.
		BinarySearchTree b2 = new BinarySearchTree();
		insertManyChars(b2, "DCGAFBE");
		assertFalse(b2.isHeightBalanced());
		isHeightBalancedPoints += 3;
	}

	@AfterClass
	public static void displayPoints() {
		System.out.printf("isHeightBalanced unit test points:  %2d/14\n",
				isHeightBalancedPoints);
		System.out
				.printf("   (Efficiency will be checked by the instructor)\n");

	}
}