package countinversions;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author anderson.
 *         Created Nov 11, 2012.
 */
public class SortTest {
	
	public static int points = 0;
	public static int possiblePoints = 0;
	Integer [] a0 = {1, 2, 3, 4, 6};
	Integer [] a1 = {1, 3, 2};
	Integer [] a2 = {3, 1, 2};
	Integer [] a3 = {3, 2, 1};
	Integer [] a4 = {3, 1, 4, 2};
	Integer [] a5 = {0, 8, 7, 6, 5, 4, 3, 2, 1, 9 };
	Integer [] a6 = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};

	
	public void oneTest(Integer[] a1, int answer1,  Integer[] a2, int answer2, int possible) {
		possiblePoints += possible;
		assertEquals(answer1, Sort.mergeSortAndCountInversions(a1));
		assertEquals(answer2, Sort.mergeSortAndCountInversions(a2));
		points += possible;

	}


	@Test
	public void testMergeSortAndCountInversions0() {
		oneTest(a0, 0, a1, 1, 2);
	}
	
	@Test
	public void testMergeSortAndCountInversions1() {
		oneTest(a2, 2, a1, 1, 2);
	}
	
	@Test
	public void testMergeSortAndCountInversions2() {
		oneTest(a3, 3, a1, 1, 2);
	}
	
	@Test
	public void testMergeSortAndCountInversions3() {
		oneTest(a4, 3, a1, 1, 2);
	}
	
	@Test
	public void testMergeSortAndCountInversions4() {
		oneTest(a5, 28, a1, 1, 6);
	}
	
	@Test
	public void testMergeSortAndCountInversions5() {
		oneTest(a6, 8, a1, 1, 4);
	}
	

	@AfterClass
	public static void printPoints() {
		System.out.println(points + "/" + possiblePoints
				+ "      countInversions\n");
	}
}
