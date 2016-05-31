package hardysTaxi;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides the static method hardySolutionsLessThan(N) which finds all
 * "taxicab numbers" that are less than n. These are represented as
 * TaxicabNumber objects: each includes the sum and two different ways of
 * writing that sum as a sum of two cubes.
 * 
 * @author anderson November, 2010.
 *
 */
public class Hardy {

	/**
	 * Returns floor of the cube root of n. Can you see why this method is
	 * useful for this problem? This is not a very efficient implementation.
	 * (Not required) Can you think of a more efficient approach?
	 * 
	 * @param n
	 *            a positive integer
	 * @return integer cube root of n
	 */
	public static int cubeRootFloor(int n) {
		// Very inefficient, but quick to write.
		double cubed = Math.cbrt(n);
		return (int) cubed;
	}

	/**
	 * Computes and returns a sorted list of all taxicab numbers less than n.
	 * 
	 * @param n
	 *            a positive integer
	 * @return a List<TaxicabNumber> object. Each object contains the sum and
	 *         two different ways to write it as a sum of cubes.
	 */

	public static List<TaxicabNumber> hardySolutionsLessThan(int n) {
		List<TaxicabNumber> result = new ArrayList<TaxicabNumber>(); // You are
																		// to
																		// populate
																		// this
																		// list.
		int limit = cubeRootFloor(n);
		/* Done: fill in the calculations */
		boolean duplicate = false;
		// loop through for each number and combination
		for (int i = 0; i <= limit; i++) {
			for (int j = 0; j <= limit; j++) {
				for (int k = 0; k <= limit; k++)
					for (int l = 0; l <= limit; l++) {
						// checks to see if cubed numbers are equal, if so then
						// result is a taxicabNumber
						if (TaxicabNumber.cube(i) + TaxicabNumber.cube(j) == TaxicabNumber.cube(k)
								+ TaxicabNumber.cube(l) && i + j != k + l) {
							int taxNumber = TaxicabNumber.cube(i) + TaxicabNumber.cube(j);
							// if taxNumber is the limit then break out of
							// adding it
							if (taxNumber == n) {
								break;
							}
							TaxicabNumber taxCabNum = new TaxicabNumber(taxNumber, i, j, k, l);
							for (TaxicabNumber t : result) {
								if (t.compareTo(taxCabNum) == 0) {
									duplicate = true;
									break;
								}
							}
							// doesn't add any duplicates
							if (!duplicate) {
								result.add(taxCabNum);
							} else {
								duplicate = false;
							}

						}
					}
			}
		}

		java.util.Collections.sort(result);
		return result;
	}

	/**
	 * main() is provided in case you want to test your code other than with
	 * unit tests. Just put try various arguments in the method call below.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hardySolutionsLessThan(1730));
	}

}
