/*
*
*   @author
*   Aakash Verma
*	
* 	Selection Sort
*
*	Input: 68 76 99 55 92 15 89 49
*
*	Output: 15 49 55 68 76 89 92 99
*
*/

public class SelectionSort {

	public void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			/* assuming that i = 0 is minimum index */
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				/* comparing element from (i + 1) to n and searching for an element smallar than arr[minIndex] */
				if(arr[j] < arr[minIndex]) {
					/* if available, make it minIndex */
					minIndex = j;
				}
			}

			/* finally swap it with the initial element */
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
			/* this process will be repeated, dry and run the program */
		}
	}

	public void printArray(int arr[]) 
    { 
        for (int a: arr) 
            System.out.print(a + " "); 
        System.out.println(); 
    } 

	public static void main(String[] args) {

		SelectionSort s = new SelectionSort();
		int arr[] = {68, 76, 99, 55, 92, 15, 89, 49};
		s.selectionSort(arr);
		s.printArray(arr);

	}

}