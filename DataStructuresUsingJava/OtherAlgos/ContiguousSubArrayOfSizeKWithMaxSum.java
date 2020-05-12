/*
*
*	@author
*	Aakash Verma
*	
*	Problem: Given an array of positive numbers and a positive number ‘k’, 
*			 find the maximum sum of any contiguous subarray of size ‘k’.
*	
*	Sliding Window Pattern
*
*	Output: 9
*
*/



class ContiguousSubArrayOfSizeKWithMaxSum {

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	int contiguousSubArrayOfSizeKWithMaxSum(int arr[], int k) {
		int maxSum = 0;
		int windowSum = 0;
		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			if(windowEnd >= k - 1) {
				maxSum = max(windowSum, maxSum);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		ContiguousSubArrayOfSizeKWithMaxSum s = new ContiguousSubArrayOfSizeKWithMaxSum();
		int[] arr = {2, 1, 5, 1, 3, 2};
		int k = 3;
		int sum = s.contiguousSubArrayOfSizeKWithMaxSum(arr, k);
		System.out.println(sum);
	}

}