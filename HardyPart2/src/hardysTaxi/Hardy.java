package hardysTaxi;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Provides the static method hardySolutionsLessThan(N) which finds all "taxicab
 * numbers that are less than n. These are represented as TaxicabNumber objects,
 * which include the sum and two different ways of writing that as a sum of two
 * cubes.
 * 
 * @author Claude Anderson.
 * 
 */
public class Hardy {
	// google's EfficientHashSet -- very good at saving memory
	//private static EfficientHashSet<Long> possibles = new EfficientHashSet<>();
	// TreeSet to order the hardyNumbers in increasing order
	//private static TreeSet<Long> hardyNum = new TreeSet<>();


	/**
	 * Find the nth Hardy number (start counting with 1, not 0) and the numbers
	 * whose cubes demonstrate that it is a Hardy number.
	 * 
	 * @param n
	 * @return the nth Hardy number
	 */
	public static long nthHardyNumber(int n) {
		// reinitailize each instance var
		HashSet<Long> possibles = new HashSet<>();//new EfficientHashSet<>();
		TreeSet<Long> hardyNum = new TreeSet<>();

		// our values that will be squared
		long a = 1;
		long b = 1;
		int counter = 0;
		int duplicate = 0;
		// the number of hardy numbers to store
		double numsLeft = n;
		// this is the limit of the while, it will start as a max value but will later changed
		// limit will be changed since our for loop will eventually add hardy numbers that are
		// larger than nth hardy value
		double limit = Double.MAX_VALUE;
		
		while (a <= limit) {
			// adds all the cubic sums of ((1 to a), a) and increments a
			for (b = 1; b <= a; b++) {
				long possibleNum = (a * a * a) + (b * b * b);
				
				// possibleNum is a hardy number if it is already in possibles
				if (possibles.contains(possibleNum)) {
					counter++;
					if(counter > Math.floor(n*0.5)){
						boolean added = hardyNum.add(possibleNum);
						if(added == false) {
							duplicate++;
						}
					}
					
					numsLeft--;
					// once n hardy numbers are found, we do not want to check
					// possible values that are larger than the nth(max) value
					// since these are not acutally possible to be conaitned in our set
					// and sometimes larger values than needed are store, so we must also
					// continue to add the lower value terms
					if(numsLeft == 0) {
						limit = Math.cbrt(hardyNum.last());
					}
					
				} else {
					// add the possible number to the hashSet
					possibles.add(possibleNum);	
				}
				
			}
			a++;
		}
		// iterate to get the correct nth Hardy number
		while(hardyNum.size() > n-Math.floor(n*0.5) + duplicate) {
			hardyNum.pollLast();
		}
		
		
		return hardyNum.pollLast();
	}

}
