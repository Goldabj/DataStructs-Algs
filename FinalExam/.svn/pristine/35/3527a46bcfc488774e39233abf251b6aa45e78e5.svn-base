package bst;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * Test the treeFromArray method.
 * 
 * @author Claude Anderson. Created Oct 31, 2012.
 */
public class TreeFromArrayTest {

	/**
	 * points earned for this exam problem.
	 */
	static int points = 0;

	/**
	 * 
	 * Test the treeFromArray method.
	 *
	 */
	@Test
	public void testTreeFromArray() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>(new Integer[] { 3, 4, 5 });
		assertEquals(3, t.size());
		assertEquals(1, t.height());
		assertEquals(new Integer("3"), t.findMin());
		assertEquals(new Integer("5"), t.findMax());
		points += 2;

		t = new BinarySearchTree<Integer>(new Integer[] { 2, 3, 4, 5 });
		assertEquals(4, t.size());
		assertEquals(2, t.height());
		assertEquals(new Integer("2"), t.findMin());
		assertEquals(new Integer("5"), t.findMax());
		points += 2;

		t = new BinarySearchTree<Integer>(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 });
		assertEquals(14, t.size());
		assertEquals(3, t.height());
		assertEquals(new Integer("1"), t.findMin());
		assertEquals(new Integer("14"), t.findMax());
		points += 2;

		Integer[] a = new Integer[63];
		for (int i = 0; i < 63; i++)
			a[i] = i + 1;
		t = new BinarySearchTree<Integer>(a);
		assertEquals(63, t.size());
		assertEquals(5, t.height());
		assertEquals(new Integer("1"), t.findMin());
		assertEquals(new Integer("63"), t.findMax());
		points += 2;
		for (int i = 1; i <= 61; i += 2)
			t.remove(i);
		assertEquals(32, t.size());
		assertEquals(5, t.height());
		assertEquals(new Integer("2"), t.findMin());
		assertEquals(new Integer("63"), t.findMax());
		points += 3;
		t.remove(63);
		assertEquals(31, t.size());
		assertEquals(4, t.height());
		assertEquals(new Integer("2"), t.findMin());
		assertEquals(new Integer("62"), t.findMax());
		points += 3;

		t = new BinarySearchTree<Integer>(new Integer[] {});
		assertEquals(0, t.size());
		assertEquals(-1, t.height());
		points += 1;
	}

	/**
	 * Print the number of points earned.
	 */
	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/15 treeFromArray\n", points);
		System.out.printf("   (Efficiency will be checked by the instructor)\n");
	}

}
