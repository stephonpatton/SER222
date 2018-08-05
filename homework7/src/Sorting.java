import java.util.Arrays;

/**
 * Sorting demonstrates sorting and searching on an array 
 * of objects.
 *
 *Completion time: 5 hours
 *
 * @author Stephon Patton, Lewis and Chase
 * @version 4.0 
 */
public class Sorting 
{
	public static void quickSortMid(Comparable[] a) {
		quickSortMid(a, 0, a.length-1);
	}
	
	@SuppressWarnings("unchecked")
	private static void quickSortMid(Comparable[] a, int low, int high) {
		if(low + 10 > high) 
			insertionSort(a);
		else {
			int center = (low + high)/2;
			if(a[center].compareTo(a[low]) < 0)
				swap(a, low, center);
			if(a[high].compareTo(a[low]) < 0) 
				swap(a, low, high);
			if(a[high].compareTo(a[center]) < 0)
				swap(a, center, high);
			
			swap(a,center,high-1);
			Comparable pivot = a[high-1];
			
			int i, j;
			for(i=low, j = high -1; ;) {
				if(pivot.compareTo(a[--j]) < 0) {
					if(i>=j)
						break;
					swap(a,i,j);
				}
			}
			
			swap(a,i,high-1);
			quickSortMid(a, low, i-1);
			quickSortMid(a, i+1, high);
		}
	}
	
    /**
     * Sorts the specified array of integers using the selection
     * sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void selectionSort(T[] data)
    {
        int min;
        T temp;
        
        for (int index = 0; index < data.length-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < data.length; scan++)
                if (data[scan].compareTo(data[min])<0)
                    min = scan;
			
            swap(data, min, index);
        }
    }
	
	/**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private static <T extends Comparable<T>> 
		void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void insertionSort(T[] data)
    {
        for (int index = 1; index < data.length; index++)
        {
            T key = data[index];
            int position = index;
			
            // shift larger values to the right 
            while (position > 0 && data[position-1].compareTo(key) > 0)
            {
                data[position] = data[position-1];
                position--;
            }
			
            data[position] = key;
        }
    }
	
    /**
     * Sorts the specified array of objects using a bubble sort
     * algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void bubbleSort(T[] data)
    {
        int position, scan;
        T temp;
		
        for (position =  data.length - 1; position >= 0; position--)
        {
            for (scan = 0; scan <= position - 1; scan++)
            {
                if (data[scan].compareTo(data[scan+1]) > 0)
                    swap(data, scan, scan + 1);
            }
        }
    }
    
    public static Comparable[] mergesort(Comparable[] a) {
    	if(a.length < 2)
    		return a;
    	int middle = a.length/2;
    	Comparable[] left = new Comparable[middle];
    	Comparable[] right = new Comparable[a.length-middle];
    	
    	for(int i = 0; i < middle; i++) 
    		left[i] = a[i];
    	for(int i = middle, j=0; i<a.length; i++, j++) 
    		right[j] = a[i];
    	left = mergesort(left);
    	right = mergesort(right);
    	
    	a = merge(left,right);
    	return a;
    }

	public static Comparable[] merge(Comparable[] a, Comparable[] b) {
		Comparable[] result = new Comparable[a.length + b.length];
		
		int aCounter = 0;
		int bCounter = 0;
		int resultCounter = 0;
		
		while(aCounter < a.length || bCounter < b.length) {
			if(aCounter < a.length && bCounter < b.length) {
				if(((Comparable) a[aCounter]).compareTo(b[bCounter]) < 0 ) {
					result[resultCounter] = a[aCounter];
					resultCounter++;
					aCounter++;
				}
				else if(((Comparable) a[aCounter]).compareTo(b[bCounter]) > 0) {
					result[resultCounter] = b[bCounter];
					resultCounter++;
					bCounter++;
				} else {
					result[resultCounter] = a[aCounter];
					resultCounter++;
					aCounter++;
					
					result[resultCounter] = b[bCounter];
					resultCounter++;
					bCounter++;
				}
			}
			else if(aCounter<a.length && bCounter >= b.length) {
				result[resultCounter] = a[aCounter];
				resultCounter++;
				aCounter++;
			}
			else if(bCounter < b.length && aCounter>= a.length) {
				result[resultCounter] = b[bCounter];
				resultCounter++;
				bCounter++;
			}
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static Comparable[] mergesortRec(Comparable[] a) {
		int lastIndex = a.length-1;
		int firstIndex = a.length - a.length;
		
	    //base case: if length of array is 1
	    if (a[0] == a[a.length-1])
	        return a;
	
	    //split the array
	    int mid = (firstIndex + lastIndex)/2;

	    mergesortRec(a);
	    mergesortRec(a);
	    merge(a, firstIndex, mid+1,lastIndex);
	    
		return a;
	}
	
    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     *
     * @param data the array to be sorted
     */
	public static <T extends Comparable<T>>
		void mergeSort(T[] data)
	{
		mergeSort(data, 0, data.length - 1);
	}
	
    /**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min  the index of the first element 
     * @param max  the index of the last element
     */
	private static <T extends Comparable<T>>
		void mergeSort(T[] data, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid+1, max);
			merge(data, min, mid, max);
		}
	}
	
	/**
     * Merges two sorted subarrays of the specified array.
     *
     * @param data the array to be sorted
     * @param first the beginning index of the first subarray 
     * @param mid the ending index fo the first subarray
     * @param last the ending index of the second subarray
     */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>>
		void merge(T[] data, int first, int mid, int last)
	{
		T[] temp = (T[])(new Comparable[data.length]);
		
		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
   }
	


	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * 
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
		void quickSort(T[] data)
	{
		quickSort(data, 0, data.length - 1);
	}
	
	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * quick sort algorithm. 
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> 
		void quickSort(T[] data, int min, int max)
	{
		if (min < max)
		{
			// create partitions
			int indexofpartition = partition(data, min, max);
			
			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1);
			
			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max);
		}
	}
	
	/**
	 * Used by the quick sort algorithm to find the partition.
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> 
		int partition(T[] data, int min, int max)
	{
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;
		
		// use the middle data value as the partition element
		partitionelement = data[middle];
		// move it out of the way for now
		swap(data, middle, min);
		
		left = min;
		right = max;
		
		while (left < right)
		{
			// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) <= 0)
				left++;
			
			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0)
				right--;
			
			// swap the elements/
			if (left < right)
				swap(data, left, right);
		}
		
		// move the partition element into place
		swap(data, min, right);
		
		return right;
	}
}
