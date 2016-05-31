import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests binary heaps.
 * 
 * @author Matt Boutell. Created May 7, 2013.
 */
public class BinaryHeapTest {

	/**
	 * Simple test method for insert, delete, toString, and sort. Enforces the
	 * method signatures.
	 */
	@Test
	public void testSimple() {
		// TODO: Implement the BinaryHeap class according to the spec.
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
		// deleteMin returns null if it has no elements.
		assertNull(heap.deleteMin());
		heap.insert(21);
		assertEquals("[null, 21]", heap.toString());
		int min = heap.deleteMin();
		assertEquals(21, min);
		assertEquals("[null]", heap.toString());
		String[] csLegends = new String[] { "Edsger Dijkstra", "Grace Hopper",
				"Donald Knuth", "Ada Lovelace", "Claude Shannon", "Alan Turing" };

		BinaryHeap<String> csLegendsHeap = new BinaryHeap<String>();
		csLegendsHeap.sort(csLegends);
		assertEquals(
				"[Ada Lovelace, Alan Turing, Claude Shannon, Donald Knuth, Edsger Dijkstra, Grace Hopper]",
				Arrays.toString(csLegends));
	}

	// TODO: Add unit tests for each method until you are satisfied your code is
	// correct. I will test your code with more complex tests. Since this
	// assignment is short, I'd like you to give the tests some thought, rather
	// than just always relying on someone else's tests. Professional developers
	// usually write their own unit tests.
	
	/**
	 * More in-depth tests for insert than simple cases
	 * 
	 */
	@Test
	public void testInsert() {
		BinaryHeap<String> heapStr = new BinaryHeap<String>();// No percolating
																// should happen
																// in this one.
		assertEquals("[null]", heapStr.toString());
		heapStr.insert("A");
		assertEquals("[null, A]", heapStr.toString());
		heapStr.insert("B");
		assertEquals("[null, A, B]", heapStr.toString());
		heapStr.insert("C");
		assertEquals("[null, A, B, C]", heapStr.toString());
		heapStr.insert("D");
		assertEquals("[null, A, B, C, D]", heapStr.toString());
		heapStr.insert("E");
		assertEquals("[null, A, B, C, D, E]", heapStr.toString());
		heapStr.insert("F");
		assertEquals("[null, A, B, C, D, E, F]", heapStr.toString());
		heapStr.insert("G");
		assertEquals("[null, A, B, C, D, E, F, G]", heapStr.toString());
		heapStr.insert("H");
		assertEquals("[null, A, B, C, D, E, F, G, H]", heapStr.toString());
		heapStr.insert("I");
		assertEquals("[null, A, B, C, D, E, F, G, H, I]", heapStr.toString());

		BinaryHeap<Integer> heap2 = new BinaryHeap<Integer>();
		assertEquals("[null]", heap2.toString());
		heap2.insert(6);
		assertEquals("[null, 6]", heap2.toString());
		heap2.insert(2);
		assertEquals("[null, 2, 6]", heap2.toString());
		heap2.insert(11);
		assertEquals("[null, 2, 6, 11]", heap2.toString());
		heap2.insert(1);
		assertEquals("[null, 1, 2, 11, 6]", heap2.toString());
		heap2.insert(5);
		assertEquals("[null, 1, 2, 11, 6, 5]", heap2.toString());
		heap2.insert(3);
		assertEquals("[null, 1, 2, 3, 6, 5, 11]", heap2.toString());
		heap2.insert(4);
		assertEquals("[null, 1, 2, 3, 6, 5, 11, 4]", heap2.toString());
		heap2.insert(7);
		assertEquals("[null, 1, 2, 3, 6, 5, 11, 4, 7]", heap2.toString());

		heapStr = new BinaryHeap<String>();
		assertEquals("[null]", heapStr.toString());
		heapStr.insert("B");
		assertEquals("[null, B]", heapStr.toString());
		heapStr.insert("A");
		assertEquals("[null, A, B]", heapStr.toString());
		heapStr.insert("H");
		assertEquals("[null, A, B, H]", heapStr.toString());
		heapStr.insert("D");
		assertEquals("[null, A, B, H, D]", heapStr.toString());
		heapStr.insert("I");
		assertEquals("[null, A, B, H, D, I]", heapStr.toString());
		heapStr.insert("Z");
		assertEquals("[null, A, B, H, D, I, Z]", heapStr.toString());
		heapStr.insert("G");
		assertEquals("[null, A, B, G, D, I, Z, H]", heapStr.toString());
		heapStr.insert("G");
		assertEquals("[null, A, B, G, D, I, Z, H, G]", heapStr.toString());
		heapStr.insert("A");
		assertEquals("[null, A, A, G, B, I, Z, H, G, D]", heapStr.toString());

		heap2 = new BinaryHeap<Integer>();
		assertEquals("[null]", heap2.toString());
		heap2.insert(9);
		assertEquals("[null, 9]", heap2.toString());
		heap2.insert(8);
		assertEquals("[null, 8, 9]", heap2.toString());
		heap2.insert(7);
		assertEquals("[null, 7, 9, 8]", heap2.toString());
		heap2.insert(6);
		assertEquals("[null, 6, 7, 8, 9]", heap2.toString());
		heap2.insert(5);
		assertEquals("[null, 5, 6, 8, 9, 7]", heap2.toString());
		heap2.insert(4);
		assertEquals("[null, 4, 6, 5, 9, 7, 8]", heap2.toString());
		heap2.insert(3);
		assertEquals("[null, 3, 6, 4, 9, 7, 8, 5]", heap2.toString());
		heap2.insert(2);
		assertEquals("[null, 2, 3, 4, 6, 7, 8, 5, 9]", heap2.toString());
		heap2.insert(1);
		assertEquals("[null, 1, 2, 4, 3, 7, 8, 5, 9, 6]", heap2.toString());

	}

	/**
	 * More in-depth tests for delete than simple cases
	 * 
	 */
	@Test
	public void testDelete() {
		BinaryHeap<String> heapStr = new BinaryHeap<String>();
		heapStr.insert("A");
		heapStr.insert("B");
		heapStr.insert("C");
		heapStr.insert("D");
		heapStr.insert("E");
		heapStr.insert("F");
		heapStr.insert("G");
		heapStr.insert("H");
		heapStr.insert("I");
		assertEquals("A", heapStr.deleteMin());
		assertEquals("B", heapStr.deleteMin());
		assertEquals("C", heapStr.deleteMin());
		assertEquals("D", heapStr.deleteMin());
		assertEquals("E", heapStr.deleteMin());
		assertEquals("F", heapStr.deleteMin());
		assertEquals("G", heapStr.deleteMin());
		assertEquals("H", heapStr.deleteMin());
		assertEquals("I", heapStr.deleteMin());

		BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
		heap.insert(9);
		heap.insert(8);
		heap.insert(7);
		heap.insert(6);
		heap.insert(5);
		heap.insert(4);
		heap.insert(3);
		heap.insert(2);
		heap.insert(1);
		assertTrue(1 == heap.deleteMin());
		assertTrue(2 == heap.deleteMin());
		assertTrue(3 == heap.deleteMin());
		assertTrue(4 == heap.deleteMin());
		assertTrue(5 == heap.deleteMin());
		assertTrue(6 == heap.deleteMin());
		assertTrue(7 == heap.deleteMin());
		assertTrue(8 == heap.deleteMin());
		assertTrue(9 == heap.deleteMin());

		heapStr = new BinaryHeap<String>();
		heapStr.insert("R");
		heapStr.insert("O");
		heapStr.insert("S");
		heapStr.insert("E");
		heapStr.insert("H");
		heapStr.insert("U");
		heapStr.insert("L");
		heapStr.insert("M");
		heapStr.insert("A");
		heapStr.insert("N");
		assertEquals("A", heapStr.deleteMin());
		assertEquals("E", heapStr.deleteMin());
		assertEquals("H", heapStr.deleteMin());
		assertEquals("L", heapStr.deleteMin());
		assertEquals("M", heapStr.deleteMin());
		assertEquals("N", heapStr.deleteMin());
		assertEquals("O", heapStr.deleteMin());
		assertEquals("R", heapStr.deleteMin());
		assertEquals("S", heapStr.deleteMin());
		assertEquals("U", heapStr.deleteMin());
	}

	/**
	 * More in-depth tests for sort than simple cases
	 * 
	 */
	@Test
	public void testSort() {
		String[] backwards = new String[] { "f", "e", "d", "c", "b", "a" };
		BinaryHeap<String> backwardsHeap = new BinaryHeap<String>();
		backwardsHeap.sort(backwards);
		assertEquals("[a, b, c, d, e, f]", Arrays.toString(backwards));

		String[] random = new String[] { "d", "c", "f", "a", "e", "b" };
		BinaryHeap<String> randomHeap = new BinaryHeap<String>();
		randomHeap.sort(random);
		assertEquals("[a, b, c, d, e, f]", Arrays.toString(random));

		String[] normal = new String[] { "a", "b", "c", "d", "e", "f" };
		BinaryHeap<String> normalHeap = new BinaryHeap<String>();
		normalHeap.sort(normal);
		assertEquals("[a, b, c, d, e, f]", Arrays.toString(normal));

		Integer[] integers = new Integer[] { 1, 2, 3, 4, 5, 6 };
		BinaryHeap<Integer> intHeap = new BinaryHeap<Integer>();
		intHeap.sort(integers);
		assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(integers));

		integers = new Integer[] { 6, 5, 4, 3, 2, 1 };
		intHeap = new BinaryHeap<Integer>();
		intHeap.sort(integers);
		assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(integers));

		integers = new Integer[] { 5, 2, 6, 4, 1, 3 };
		intHeap = new BinaryHeap<Integer>();
		intHeap.sort(integers);
		assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(integers));
	}

	/**
	 * Tests that call insert AND Delete.
	 * 
	 */
	@Test
	public void testInsertAndDelete() {
		BinaryHeap<String> heapStr = new BinaryHeap<String>();
		assertEquals("[null]", heapStr.toString());
		heapStr.insert("A");
		assertEquals("[null, A]", heapStr.toString());
		heapStr.deleteMin();
		heapStr.insert("B");
		assertEquals("[null, B]", heapStr.toString());
		heapStr.insert("C");
		assertEquals("[null, B, C]", heapStr.toString());
		heapStr.insert("D");
		assertEquals("[null, B, C, D]", heapStr.toString());
		heapStr.deleteMin();
		heapStr.insert("E");
		assertEquals("[null, C, D, E]", heapStr.toString());
		heapStr.insert("F");
		heapStr.deleteMin();
		assertEquals("[null, D, F, E]", heapStr.toString());
		heapStr.insert("G");
		assertEquals("[null, D, F, E, G]", heapStr.toString());
		heapStr.insert("H");
		assertEquals("[null, D, F, E, G, H]", heapStr.toString());
		heapStr.insert("I");
		heapStr.deleteMin();
		assertEquals("[null, E, F, I, G, H]", heapStr.toString());
		heapStr.deleteMin();
		assertEquals("[null, F, G, I, H]", heapStr.toString());
		heapStr.deleteMin();
		heapStr.deleteMin();
		heapStr.deleteMin();
		heapStr.deleteMin();
		assertEquals("[null]", heapStr.toString());
		heapStr.deleteMin();
		assertEquals("[null]", heapStr.toString());
	}

}
