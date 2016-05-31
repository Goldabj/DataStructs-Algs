package sublist;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int subListPoints = 0;

	@Test
	public void testSubListEmpty() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		assertEquals("[]", t.subList(0, 100).toString());
		assertEquals("[]", t.subList(10, 10).toString());
		subListPoints += 1;
	}

	@Test
	public void testSubListRoot() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(50);
		assertEquals("[50]", t.subList(0, 100).toString());
		assertEquals("[]", t.subList(51, 100).toString());
		assertEquals("[]", t.subList(0, 49).toString());
		subListPoints += 2;
	}

	@Test
	public void testSubListSimple() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(50);
		t.insert(20);
		t.insert(30);
		t.insert(60);
		assertEquals("[50]", t.subList(45, 55).toString());
		assertEquals("[30, 50]", t.subList(25, 55).toString());
		assertEquals("[20, 30, 50]", t.subList(15, 55).toString());
		assertEquals("[20, 30]", t.subList(15, 35).toString());
		assertEquals("[20, 30, 50, 60]", t.subList(15, 65).toString());
		assertEquals("[20]", t.subList(15, 25).toString());
		subListPoints += 2;
	}

	@Test
	public void testSubListBoundary() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(50);
		t.insert(20);
		t.insert(30);
		t.insert(60);
		assertEquals("[50]", t.subList(44, 50).toString());
		assertEquals("[50]", t.subList(50, 55).toString());
		assertEquals("[30, 50]", t.subList(30, 50).toString());
		assertEquals("[20, 30, 50]", t.subList(20, 50).toString());
		assertEquals("[20, 30]", t.subList(20, 30).toString());
		assertEquals("[20, 30, 50, 60]", t.subList(20, 60).toString());
		assertEquals("[20]", t.subList(20, 20).toString());
		subListPoints += 2;
	}

	@Test
	public void testSubListLarger() {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(100);
		t.insert(50);
		t.insert(75);
		t.insert(25);
		t.insert(150);
		t.insert(175);
		t.insert(160);
		t.insert(155);
		t.insert(12);
		t.insert(37);
		t.insert(6);
		t.insert(8);
		t.insert(10);
		t.insert(11);
		assertEquals("[10, 11, 12]", t.subList(10, 12).toString());
		assertEquals("[100, 150]", t.subList(100, 150).toString());
		assertEquals("[25, 37, 50]", t.subList(25, 50).toString());
		assertEquals("[8, 10, 11, 12, 25, 37, 50, 75]", t.subList(7, 76).toString());
		assertEquals("[150, 155]", t.subList(150, 155).toString());
		assertEquals("[]", t.subList(90, 95).toString());
		subListPoints += 8;
	}

	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/15 subList corectness points\n", subListPoints);
		System.out.printf("      ---sublist efficiency will be checked by the instructor)\n");
	}
}
