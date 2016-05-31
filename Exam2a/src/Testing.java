import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int totalPoints = 0;
	private static int isLinkedListPoints = 0;
	private static int pathStringPoints = 0;
	private static int evaluatePoints = 0;

	// Helper method to shorten tests. Just loops through the string, inserting
	// one character at a time into the BST.
	private void insertManyChars(BinarySearchTree t, String string) {
		for (int i = 0; i < string.length(); i++) {
			t.insert(string.charAt(i));
		}
	}

	@Test
	public void testIsLinkedListSimple() {
		BinarySearchTree t = new BinarySearchTree();
		assertTrue(t.isLinkedList());

		t.insert('M');
		assertTrue(t.isLinkedList());

		t.insert('F');
		assertTrue(t.isLinkedList());

		t.insert('Z');
		assertFalse(t.isLinkedList());

		isLinkedListPoints += 6;
	}

	private BinarySearchTree buildLinkedListTree() {
		BinarySearchTree t = new BinarySearchTree();
		assertTrue(t.isLinkedList());
		t.insert('T');
		assertTrue(t.isLinkedList());
		t.insert('C');
		assertTrue(t.isLinkedList());
		t.insert('N');
		assertTrue(t.isLinkedList());
		t.insert('L');
		assertTrue(t.isLinkedList());
		t.insert('E');
		assertTrue(t.isLinkedList());
		t.insert('D');
		assertTrue(t.isLinkedList());
		return t;
	}

	@Test
	public void testIsLinkedList() {
		BinarySearchTree t = buildLinkedListTree();
		t.insert('G');
		assertFalse(t.isLinkedList());

		t = buildLinkedListTree();
		t.insert('Z');
		assertFalse(t.isLinkedList());
		t.insert('Y');
		assertFalse(t.isLinkedList());
		t.insert('A');
		assertFalse(t.isLinkedList());

		t = buildLinkedListTree();
		t.insert('A');
		assertFalse(t.isLinkedList());

		t = buildLinkedListTree();
		t.insert('P');
		assertFalse(t.isLinkedList());

		isLinkedListPoints += 10;
	}

	@Test
	public void testPathStringEmpty() {
		BinarySearchTree t = new BinarySearchTree();
		assertEquals("", t.pathString('x'));
		pathStringPoints += 1;
	}

	@Test
	public void testPathStringNotFound() {
		BinarySearchTree t = new BinarySearchTree();
		assertEquals("", t.pathString('r'));
		insertManyChars(t, "metabolic");
		assertEquals("", t.pathString('x'));
		pathStringPoints += 2;
	}

	@Test
	public void testPathString() {
		BinarySearchTree t = new BinarySearchTree();
		insertManyChars(t, "METABOLIC");
		assertEquals("MEL", t.pathString('L'));
		pathStringPoints += 3;
	}

	@Test
	public void testPathString2() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert('M');
		assertEquals("M", t.pathString('M'));
		t.insert('E');
		assertEquals("ME", t.pathString('E'));
		t.insert('T');
		assertEquals("MT", t.pathString('T'));
		t.insert('I');
		assertEquals("MEI", t.pathString('I'));
		assertEquals("ME", t.pathString('E'));
		t.insert('W');
		assertEquals("MTW", t.pathString('W'));
		pathStringPoints += 8;
	}

	@Test
	public void testEvaluateSingleValue() {
		String preOrder = "8";
		String inOrder = "8";
		BinarySearchTree t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(8, t.evaluate());
		evaluatePoints += 2;
	}

	@Test
	public void testEvaluateSingleOperation() {
		String preOrder;
		String inOrder;
		BinarySearchTree t;

		preOrder = "+34";
		inOrder = "3+4";
		t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(7, t.evaluate());
		evaluatePoints += 2;

		preOrder = "-38";
		inOrder = "3-8";
		t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(-5, t.evaluate());
		evaluatePoints += 1;

		preOrder = "*98";
		inOrder = "9*8";
		t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(72, t.evaluate());
		evaluatePoints += 1;

		preOrder = "/82";
		inOrder = "8/2";
		t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(4, t.evaluate());
		evaluatePoints += 1;

		preOrder = "^34";
		inOrder = "3^4";
		t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(81, t.evaluate());
		evaluatePoints += 1;
	}

	@Test
	public void testEvaluateTwoOperations() {
		String preOrder = "*+357";
		String inOrder = "3+5*7";
		BinarySearchTree t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(56, t.evaluate());
		evaluatePoints += 3;
	}

	@Test
	public void testEvaluateThreeOperations() {
		String preOrder = "*+23-37";
		String inOrder = "2+3*3-7";
		BinarySearchTree t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(-20, t.evaluate());
		evaluatePoints += 4;
	}

	@Test
	public void testEvaluateFourOperations() {
		String preOrder = "*^32-/639";
		String inOrder = "3^2*6/3-9";
		BinarySearchTree t = new BinarySearchTree(preOrder, inOrder);
		assertEquals(-63, t.evaluate());
		evaluatePoints += 5;
	}

	@AfterClass
	public static void displayPoints() {
		System.out.printf("1. isLinkedList points:                   %2d/16\n", isLinkedListPoints);
		System.out.printf("2. pathString unit test points:           %2d/14\n", pathStringPoints);
		System.out.printf("3. evaluate points:                       %2d/20\n", evaluatePoints);
		totalPoints = isLinkedListPoints + pathStringPoints + evaluatePoints;
		System.out.printf("---Total unit test points:                %2d/50\n", totalPoints);
		System.out.printf("   (pathString efficiency and elegance of all will be checked by the instructor)\n");
	}
}
