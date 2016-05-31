package countinversions;


/**
 * A class that contains several sorting routines,
 * implemented as static methods.
 * Arrays are rearranged with smallest item first,
 * using compares.
 * @author Mark Allen Weiss (abridged and enhanced by Claude Anderson)
 */
public final class Sort  {
 
    /**
     * Mergesort algorithm.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>> int mergeSortAndCountInversions( AnyType [ ] a ) {
        AnyType [ ] tmpArray = (AnyType []) new Comparable[ a.length ];
        return mergeSort( a, tmpArray, 0, a.length - 1 );
    }

    /**
     * Internal method that makes recursive calls.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>> int mergeSort( AnyType [ ] a, AnyType [ ] tmpArray,
               int left, int right ) {
        if( left < right ) {
        	int numOfInversions = 0;
            int center = ( left + right ) / 2;
            numOfInversions+=mergeSort( a, tmpArray, left, center );
            numOfInversions+=mergeSort( a, tmpArray, center + 1, right );
            numOfInversions+=merge( a, tmpArray, left, center + 1, right );
            return numOfInversions;  // Replace this by a real calculation.
            //TODO inversion count:  Calculate and return the actual number of inversions.
            // You may modify merge() also.
        }
        return 0;  // This one should not need to be changed.
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>> int merge( AnyType [ ] a, AnyType [ ] tmpArray,
                               int leftPos, int rightPos, int rightEnd ) {
    	int numOfInversions = 0;
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd )
            if( a[ leftPos ].compareTo( a[ rightPos ] ) <= 0 )
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            else{
                tmpArray[ tmpPos++ ] = a[ rightPos++ ];
                numOfInversions+=rightPos-tmpPos;
            }
        while( leftPos <= leftEnd )    // Copy rest of first half
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];

        while( rightPos <= rightEnd )  // Copy rest of right half
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];

        // Copy tmpArray back
        for( int i = 0; i < numElements; i++, rightEnd-- )
            a[ rightEnd ] = tmpArray[ rightEnd ];
        return numOfInversions;
    }
    

}
