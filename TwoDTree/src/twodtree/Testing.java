package twodtree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int testPoints = 0;
	private Point2[] points = new Point2[] { 
			new Point2(0.5, 0.7), 
			new Point2(0.75, 0.5), 
			new Point2(0.7, 0.15),
			new Point2(0.8, 0.25),
			new Point2(0.45, 0.4),
			new Point2(0.9, 0.15),
	};
	String[] labels = new String[] { "A", "B", "C", "D", "E", "F" };

	private Point2[] otherPoints = new Point2[] { 
			new Point2(0.49, 0.6), 
			new Point2(0.72, 0.49), 
			new Point2(0.72, 0.14),
			new Point2(0.81, 0.26),
			new Point2(0.44, 0.34),
			new Point2(0.91, 0.14),
	};
	
	@Test
	public void testInsert() {
		TwoDTree t = new TwoDTree();
		assertEquals("()", t.toString());
		String[] answers = new String[] {
				"A(0.50,0.70)", 
				"A(0.50,0.70)(B(0.75,0.50))",
				"A(0.50,0.70)((C(0.70,0.15))B(0.75,0.50))", 
				"A(0.50,0.70)((C(0.70,0.15)(D(0.80,0.25)))B(0.75,0.50))",
				"(E(0.45,0.40))A(0.50,0.70)((C(0.70,0.15)(D(0.80,0.25)))B(0.75,0.50))",
				"(E(0.45,0.40))A(0.50,0.70)((C(0.70,0.15)((F(0.90,0.15))D(0.80,0.25)))B(0.75,0.50))"
		};

		for (int i = 0; i < answers.length; i++) {
			t.insert(points[i], labels[i]);
			assertEquals(answers[i], t.toString());
			testPoints += 3;
		}
	}

	@Test
	public void testContains() {
		TwoDTree t = new TwoDTree();
		assertFalse(t.contains(new Point2(0.4, 0.6)));
		testPoints += 2;

		for (int i = 0; i < points.length; i++) {
			t.insert(points[i], labels[i]);
		}

		for (int i = 0; i < otherPoints.length; i++) {
			assertTrue(t.contains(points[i]));
		}
		testPoints += 2;
		
		
		for (int i = 0; i < otherPoints.length; i++) {
			assertFalse(t.contains(otherPoints[i]));
		}
		testPoints += 2;
	}

	@Test
	public void testContainsRandomTree() {
		TwoDTree t = new TwoDTree();

		Random r = new Random(17); // seed so reproducible
		int nPoints = 10;
		List<Point2> points = new ArrayList<Point2>();
		for (int i = 0; i < nPoints; i++) {
			points.add(new Point2(r.nextDouble(), r.nextDouble()));
		}
		for (Point2 point : points) {
			t.insert(point, "X");
		}
		
		for (int i = 0; i < points.size(); i++) {
			assertTrue(t.contains(points.get(i)));
		}
		testPoints += 3;

		for (int i = 0; i < nPoints; i++) {
			assertFalse(t.contains(new Point2(r.nextDouble(), r.nextDouble())));
		}
		testPoints += 3;
	}

	@Test
	public void testNearest() {
		TwoDTree t = new TwoDTree();
		for (int i = 0; i < points.length; i++) {
			t.insert(points[i], labels[i]);
		}

		Point2 query;
		Point2 expected;
		
		query = new Point2(0.6, 0.75);
		expected = points[0];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 2;
		
		query = new Point2(0.8, 0.4);
		expected = points[1];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 2;
		
		query = new Point2(0.75, 0.7);
		expected = points[1];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 2;
		
		query = new Point2(0.75, 0.15);
		expected = points[2];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 2;
		
		query = new Point2(0.60, 0.05);
		expected = points[2];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 2;
		
		query = new Point2(0.85, 0.35);
		expected = points[3];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 2;

		query = new Point2(0.4, 0.5);
		expected = points[4];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 2;
		
		query = new Point2(0.95, 0.10);
		expected = points[5];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 3;
		
		query = new Point2(0.88, 0.20);
		expected = points[5];
		assertEquals(expected, t.nearestNeighbor(query));
		testPoints += 3;
	}

	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/50 points earned on unit tests.\n", testPoints);
	}
}
