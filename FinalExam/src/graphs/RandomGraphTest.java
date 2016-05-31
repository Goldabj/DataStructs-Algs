package graphs;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * Tests {@link RandomGraph}.
 * 
 * @author Matt Boutell
 */
public class RandomGraphTest {

	private static int points = 0;

	@Test
	public void testSmall() {
		RandomGraph singleVertex = new RandomGraph(1);
		assertEquals("[]", singleVertex.reachableInTwo(0).toString());

		RandomGraph twoVertices = new RandomGraph(2, new int[][] { { 0, 1 } });
		assertEquals("[0]", twoVertices.reachableInTwo(0).toString());
		assertEquals("[1]", twoVertices.reachableInTwo(1).toString());

		RandomGraph threeVertices = new RandomGraph(3, new int[][] { { 0, 1 }, { 1, 2 } });
		assertEquals("[0, 2]", threeVertices.reachableInTwo(0).toString());
		assertEquals("[1]", threeVertices.reachableInTwo(1).toString());
		assertEquals("[0, 2]", threeVertices.reachableInTwo(2).toString());
		points += 1;
	}

	@Test
	public void testTree() {
		RandomGraph tree = new RandomGraph(5, new int[][] { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } });
		assertEquals("[0, 2, 3]", tree.reachableInTwo(0).toString());
		assertEquals("[1, 4]", tree.reachableInTwo(1).toString());
		assertEquals("[0, 2, 3]", tree.reachableInTwo(2).toString());
		assertEquals("[0, 2, 3]", tree.reachableInTwo(3).toString());
		assertEquals("[1, 4]", tree.reachableInTwo(4).toString());
		points += 1;
	}

	@Test
	public void testCompleteFour() {
		RandomGraph k4 = new RandomGraph(4, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 3 }, { 1, 2 }, { 1, 3 } });
		assertEquals("[0, 1, 2, 3]", k4.reachableInTwo(0).toString());
		assertEquals("[0, 1, 2, 3]", k4.reachableInTwo(1).toString());
		assertEquals("[0, 1, 2, 3]", k4.reachableInTwo(2).toString());
		assertEquals("[0, 1, 2, 3]", k4.reachableInTwo(3).toString());
		points += 1;
	}

	@Test
	public void testCycleFour() {
		RandomGraph cycle4 = new RandomGraph(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 } });
		assertEquals("[0, 2]", cycle4.reachableInTwo(0).toString());
		assertEquals("[1, 3]", cycle4.reachableInTwo(1).toString());
		assertEquals("[0, 2]", cycle4.reachableInTwo(2).toString());
		assertEquals("[1, 3]", cycle4.reachableInTwo(3).toString());
		points += 1;
	}

	@Test
	public void testCycleSix() {
		RandomGraph cycle6 = new RandomGraph(6,
				new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 0 } });
		assertEquals("[0, 2, 4]", cycle6.reachableInTwo(0).toString());
		assertEquals("[1, 3, 5]", cycle6.reachableInTwo(1).toString());
		assertEquals("[0, 2, 4]", cycle6.reachableInTwo(2).toString());
		assertEquals("[1, 3, 5]", cycle6.reachableInTwo(3).toString());
		assertEquals("[0, 2, 4]", cycle6.reachableInTwo(4).toString());
		assertEquals("[1, 3, 5]", cycle6.reachableInTwo(5).toString());
		points += 1;
	}

	@Test
	public void testLarger() {
		RandomGraph graph = new RandomGraph(8,
				new int[][] { { 0, 1 }, { 1, 2 }, { 0, 2 }, { 2, 3 }, { 3, 4 }, { 4, 0 }, { 0, 5 }, { 0, 6 }, { 6, 7 } });
		assertEquals("[0, 1, 2, 3, 7]", graph.reachableInTwo(0).toString());
		assertEquals("[0, 1, 2, 3, 4, 5, 6]", graph.reachableInTwo(1).toString());
		assertEquals("[0, 1, 2, 4, 5, 6]", graph.reachableInTwo(2).toString());
		assertEquals("[0, 1, 3]", graph.reachableInTwo(3).toString());
		assertEquals("[1, 2, 4, 5, 6]", graph.reachableInTwo(4).toString());
		assertEquals("[1, 2, 4, 5, 6]", graph.reachableInTwo(5).toString());
		assertEquals("[1, 2, 4, 5, 6]", graph.reachableInTwo(6).toString());
		assertEquals("[0, 7]", graph.reachableInTwo(7).toString());
		points += 5;
	}
	
	@Test
	public void testLarger2() {
		RandomGraph graph = new RandomGraph(9,
				new int[][] { { 0, 8 }, { 8, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 4, 7 }, { 6, 7 } });
		assertEquals("[0, 2]", graph.reachableInTwo(0).toString());
		assertEquals("[]", graph.reachableInTwo(1).toString());
		assertEquals("[0, 2, 4]", graph.reachableInTwo(2).toString());
		assertEquals("[3, 5, 7, 8]", graph.reachableInTwo(3).toString());
		assertEquals("[2, 4, 6]", graph.reachableInTwo(4).toString());
		assertEquals("[3, 5, 7]", graph.reachableInTwo(5).toString());
		assertEquals("[4, 6]", graph.reachableInTwo(6).toString());
		assertEquals("[3, 5, 7]", graph.reachableInTwo(7).toString());
		assertEquals("[3, 8]", graph.reachableInTwo(8).toString());
		points += 5;
	}
	
	/**
	 * Reports results.
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/15 reachableInTwo\n", points);
	}
}
