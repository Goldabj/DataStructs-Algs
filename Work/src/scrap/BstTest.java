package binarysearchtree;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * 
 * Test the rangeCount method
 *
 * @author Claude Anderson.
 *         Created Oct 31, 2012.
 */
public class BstTest {
	
	/**
	 * points earned for this exam problem.
	 */
	static int rangeCountPoints = 0;
	/**
	 * points earned for this exam problem.
	 */
	static int toArrayPoints = 0;

	/**
	 * 
	 * Test the rangeCount method.
	 *
	 */
	@Test
	public void testRangeCount1() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(12);
		t.insert(37);
		t.insert(7);
		t.insert(55);
		assertEquals(0, t.rangeCount(0,5));
		assertEquals(0, t.rangeCount(56,58));
		assertEquals(0, t.rangeCount(40,45));
		assertEquals(0, t.rangeCount(56,6));
		assertEquals(1, t.rangeCount(0,10));
		assertEquals(2, t.rangeCount(7,12));
		assertEquals(4, t.rangeCount(6,60));
		assertEquals(1, t.rangeCount(30,40));
		rangeCountPoints += 10;
		
		t.insert(18);
		t.insert(27);
		t.insert(40);
		t.insert(60);
		t.insert(2);
		t.insert(6);
		t.insert(4);
		t.insert(5);
		assertEquals(5, t.rangeCount(3,12));
		assertEquals(3, t.rangeCount(6,12));
		assertEquals(3, t.rangeCount(7,20));
		assertEquals(6, t.rangeCount(7,40));
		assertEquals(8, t.rangeCount(4,39));
		rangeCountPoints += 8;
	}

	/** Test for toArray(). */
	@Test
	public void testToArrayNull() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		assertNull(t.toArray());
		toArrayPoints += 1;
	}
	
	/** Test for toArray(). */
	@Test
	public void testToArrayInt() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(10);
		t.insert(5);
		assertEquals("[5, 10]", Arrays.toString(t.toArray()));
		toArrayPoints += 1;
		
		t.insert(25);
		t.insert(12);
		assertEquals("[5, 10, 12, 25]", Arrays.toString(t.toArray()));
		toArrayPoints += 2;
		
		t.insert(2);
		t.insert(1);
		t.insert(-3);
		assertEquals("[-3, 1, 2, 5, 10, 12, 25]", Arrays.toString(t.toArray()));
		toArrayPoints += 3;
		
		t.insert(15);
		t.insert(16);
		t.insert(17);
		t.insert(18);
		assertEquals("[-3, 1, 2, 5, 10, 12, 15, 16, 17, 18, 25]", Arrays.toString(t.toArray()));
		toArrayPoints += 3;
	}

	/** Test for toArray(). */
	@Test
	public void testToArrayString() {
		BinarySearchTree<String> t = new BinarySearchTree<String>();
		String s = "the quick brown fox jumped over a lazy dog it did jump really high";
		String[] words = s.split(" ");
		for (String word : words) {
			t.insert(word);
		}
		
		Arrays.sort(words);
		assertEquals(Arrays.toString(words), Arrays.toString(t.toArray()));
		toArrayPoints += 10;
	}
	
	
	/**
	 * Print the number of points earned.
	 */
	@AfterClass
	public static void printPoints() {
		System.out.println(rangeCountPoints + "/18" + "      rangeCount," + 
				" provided that you meet the efficiency constraints.");
		System.out.println();
		System.out.println(toArrayPoints + "/20" + "      toArray," + 
				" provided that you meet the constraints.");
		System.out.println();
	}

}
