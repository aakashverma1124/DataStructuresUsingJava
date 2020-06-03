/*
*
*   @author
*   Aakash Verma
*	
* 	Problem: Merge Sort
*
*	Input: 68 76 99 55 92 15 89 49
*
*	Output: 
*	Before Sorting: 
*	68 76 99 55 92 15 89 49 
*
*	After Sorting: 
*	15 49 55 68 76 89 92 99
*
*	Link for the video: https://www.youtube.com/watch?v=JSceec-wEyw
*	Type: Divide & Conquer
*	Time Complexity: O(nlogn)
*	Space Complexity: O(n)
*	Stability: Yes
*
*
*
*/

public class MergeSort {

	public void merge(int arr[], int left, int mid, int right) { 
		
		int leftArraySize = mid - left + 1; 
		int rightArraySize = right - mid; 

		int leftArray[] = new int [leftArraySize]; 
		int rightArray[] = new int [rightArraySize]; 

		/* Copy data to temp arrays */
		for (int i=0; i<leftArraySize; ++i) 
			leftArray[i] = arr[left + i]; 
		for (int j=0; j<rightArraySize; ++j) 
			rightArray[j] = arr[mid + 1+ j]; 

		int i = 0, j = 0; 

		int k = left; 
		while (i < leftArraySize && j < rightArraySize) { 
			if (leftArray[i] <= rightArray[j]) { 
				arr[k] = leftArray[i]; 
				i++; 
			} 
			else { 
				arr[k] = rightArray[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of leftArray[] if available */
		while (i < leftArraySize) { 
			arr[k] = leftArray[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of rightArray[] if available */
		while (j < rightArraySize) { 
			arr[k] = rightArray[j]; 
			j++; 
			k++; 
		} 
	} 

	public void mergeSort(int arr[], int left, int right) 
	{ 
		if (left < right) 
		{ 
			/* finding mid point of each array */
			int mid = (left+right)/2; 

			/* sorting left & right array */
			mergeSort(arr, left, mid); 
			mergeSort(arr , mid+1, right); 

			/* merging two arrays */ 
			merge(arr, left, mid, right); 
		} 
	} 

	/* A utility function to print array of size n */
	public void printArray(int arr[]) { 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	public static void main(String args[]) {

		MergeSort m = new MergeSort(); 
		int arr[] = {68, 76, 99, 55, 92, 15, 89, 49}; 
		System.out.println("Before Sorting: "); 
		m.printArray(arr);

		m.mergeSort(arr, 0, arr.length-1);
		 
		System.out.println("\nAfter Sorting: "); 
		m.printArray(arr); 

	} 
} 