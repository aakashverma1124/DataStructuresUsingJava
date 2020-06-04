/*
*
*   @author
*   Aakash Verma
*	
* 	Insertion Sort
*
*	Input: 68 76 99 55 92 15 89 49
*
*	Output: 15 49 55 68 76 89 92 99
*
*/

public class InsertionSort {

	/* 
		Initially we'll assume that a subarray which is present at index 0 is a sorted array.
		This subarray consists of only one element at index 0.
		Now, we'll start moving from i = 1 to n - 1 and we'll be pushing elements in the sorted subarray.
		Repeating this process will give me the sorted array.	
	*/

	public void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			/* 
			here, we are checking each element in a sorted subarray, if key is greater than any element
			Let's suppose:

			3 7 8 | 6 9 2
			In above example (3, 7, 8) is a sorted subarray and (6, 9, 2) is unsorted.
			let's suppose: key = 6
			Now, I'll check where 6 has to be inserted.
			So, I'll start going back and checking for the position where 6 has to be inserted.
			I start making j shift backward, if element at j is greater than key.
			Also, the element which is present at jth position, I'll shift it at (j+1)th position.
			We're doing this because I want to make a free space for storing key.
			And in this way, if I get key greater than jth element. I stop and come out of the while loop.
			And finally, I store key at (j+1)th position.

			*/
			while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 

            arr[j + 1] = key;
		}
	}

	public void printArray(int arr[]) 
    { 
        for (int a: arr) 
            System.out.print(a + " "); 
        System.out.println(); 
    } 

	public static void main(String[] args) {

		InsertionSort s = new InsertionSort();
		int arr[] = {68, 76, 99, 55, 92, 15, 89, 49};
		s.insertionSort(arr);
		s.printArray(arr);

	}

}