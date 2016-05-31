package heap;

public class CheckHeap {
	
	/**
	 * Determines whether or not an array represents a binary (min)heap or not.
	 * @param a
	 * @return true if it is a heap, false if not.
	 */
	public static boolean checkHeap(int [] a) {
//		if(a[0] != 0){
//			return false;
//		}
		boolean isHeap = true;
		for(int i = 1; i < a.length; i++){
			for(int j = i; j < a.length; j*=2){
				if(a[i] > a[j]){
					isHeap = false;
				}
			}
		}
		return isHeap;
	}

}
