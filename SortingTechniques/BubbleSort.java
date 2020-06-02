/*
*
*   @author
*   Aakash Verma
*	
* 	Bubble Sorting
*
*	Input: 68 76 99 55 92 15 89 49
*
*	Output: 15 49 55 68 76 89 92 99
*
*
* 	Approach: ith loop will iterate from 0 till n-1 and for each i, jth loop will go from
*	0 to n-i-1, because arr[j] will be compared to arr[j+1].
*	Think if we are at j = n - 1 therefore, arr[n-1] will be compared to arr[n] and in that case, 
*	ArrayOutOfBoundException will be there because there is a existence of index from 0 to n-1 only.
*	And we are trying to excess nth index.
*
*	The idea is simple, we are comparing each element and shifting it at right position.
*	Try to dry and run this example. You'll definitely get of it.
*
*
*
*/


class BubbleSort {

	public static void main(String[] args) {
		
		int arr[] = {68, 76, 99, 55, 92, 15, 89, 49};
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		/* this is another way of iterating and is known as for-each loop */
		for(int a: arr) {
			System.out.print(a + " ");
		}
		System.out.println();
		
	}

}