package heap;

import static heap.CheckHeap.checkHeap;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class CheckHeapTest {
	
	public static int points = 0;

	@Test
	public void testCheckHeap1() {
		assertTrue(checkHeap(new int[]{0,1}));
		assertFalse(checkHeap(new int[]{0, 2, 1}));
		points += 1;
	}

	
	@Test
	public void testCheckHeap2() {
		assertTrue(checkHeap(new int[]{0,3,5,4,6}));
		assertFalse(checkHeap(new int[]{0, 2, 1}));
		points += 2;
	}
	
	@Test
	public void testCheckHeap3() {
		assertTrue(checkHeap(new int[]{0,3,5,4,6}));
		assertFalse(checkHeap(new int[]{0, 1, 3, 4, 2}));
		points += 2;
	}
	
	@Test
	public void testCheckHeap4() {
		assertTrue(checkHeap(new int[]{0,7,12,8,13,20,57,9,14,18,21,30,60}));
		assertFalse(checkHeap(new int[]{0, 1, 3, 4, 2}));
		points += 2;
	}
	
	@Test
	public void testCheckHeap5() {
		assertTrue(checkHeap(new int[]{0,7,12,8,13,20,57,9,14,18,21,30,60}));
		assertFalse(checkHeap(new int[]{0,7,12,8,13,20,57,9,14,18,21,30,56}));
		points += 2;
	}
	
	@Test
	public void testCheckHeap6() {
		assertTrue(checkHeap(new int[]{19,7,12,8,13,20,57,9,14,18,21,30,60}));
		assertFalse(checkHeap(new int[]{3,5,7,9,8,6,12,18,20,22,24,28,30,32}));
		points += 2;

	}
	
	@AfterClass
	public static void printPoints() {
		System.out.println(points + "/11" + "      checkHeap");
		System.out.println();
	}

}
