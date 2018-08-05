/**
 * Implements various sorting algorithms.
 * 
 * Completion Time: 5 hours
 * 
 * 
 * @author Stephon Patton, Acuna, Sedgewick
 * @verison 1.0
 */

public class PattonSorting {
     
    /**
     * Entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Q1
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//        Sorting.quickSort(a);
        quicksortmid(a);
        assert isSorted(a); //requires assertions enabled.
        show(a);
        
        //Q2
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//        Sorting.mergeSort(b);
        
        mergesort(b);
        assert isSorted(b);
        show(b);
    }
    
    public static void quicksortmid(Comparable[] a) {
    	Sorting.quickSortMid(a);
    }
    
    @SuppressWarnings("unchecked")
	public static void mergesort(Comparable[] a) {
       Sorting.mergeSort(a);
    }
    
    /**
     * Displays contents of array, space separated.
     * @author Sedgewick
     * @param a Array to display.
     */
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }
    
    /**
     * Checks if array is in sorted order.
     * @author Sedgewick
     * @param a Array to be checked.
     * @return Returns true if array is sorted.
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
    
    //See previous method.
    private static boolean less(Comparable<Comparable> v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}