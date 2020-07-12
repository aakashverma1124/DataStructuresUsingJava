/*

	@author Aakash.Verma

	You are given a sequence A of N (N <= 50000) integers between -10000 and 10000. On this sequence you have to apply M (M <= 50000) operations:
	modify the i-th element in the sequence or for given x y print max{Ai + Ai+1 + .. + Aj | x<=i<=j<=y }.

	Input:
	The first line of input contains an integer N. The following line contains N integers, representing the sequence A1..AN.
	The third line contains an integer M. The next M lines contain the operations in following form:
	0 x y: modify Ax into y (|y|<=10000).
	1 x y: print max{Ai + Ai+1 + .. + Aj | x<=i<=j<=y }.
	
	Output:
	For each query, print an integer as the problem required.

	Example:
	Input: 
	4
	1 2 3 4
	4
	1 1 3
	0 3 -3
	1 2 4
	1 3 3

	Output:
	6
	4
	-3
*/



import java.util.*;
import java.lang.*;

class ST05_GSS3 {
	static void buildTree(int tree[], int arr[], int start, int end, int index) {
		if(start > end) {
			return;
		}
		if(start == end) {
			tree[index] = arr[start];
			return;
		}
		int mid = (start + end)/2;
		buildTree(tree, arr, start, mid, 2*index);
		buildTree(tree, arr, mid+1, end, 2*index+1);
		tree[index] = tree[2*index] + tree[2*index+1];
		return;
	}
	
	static int query(int tree[], int start, int end, int index, int queryStart, int queryEnd) {

		/*
			1. complete overlaps
			2. partial overlap
			3. no overlap
		*/

		/* no overlap */
		if(queryEnd < start || queryStart > end) {
			return Integer.MAX_VALUE;
		}

		/* complete overlap */
		if(start >= queryStart && end <= queryEnd) {
			return tree[index];
		}

		/* partial overlap */
		int mid = (start + end)/2;
		int leftAnswer = query(tree, start, mid, 2*index, queryStart, queryEnd);
		int rightAnswer = query(tree, mid+1, end, 2*index+1, queryStart, queryEnd);

		if(leftAnswer == Integer.MAX_VALUE) {
			return rightAnswer;
		}
		if(rightAnswer == Integer.MAX_VALUE) {
			return leftAnswer;
		}
		return Math.max(Math.max((leftAnswer + rightAnswer), (queryStart + 1)), (queryEnd + 1));
	}
	
	static void updateIndex(int tree[], int index, int start, int end, int i, int value) {
		
		/* No overlap */
		if(i < start || i > end) {
			return;
		}

		/* complete overlap */
		if(start == end) {
			tree[index]= value;
			return;
		}

		/* partial overlap */
		int mid = (start + end)/2;
		updateIndex(tree, 2*index, start, mid, i, value);
		updateIndex(tree, 2*index+1, mid+1, end, i, value);
		tree[index] = tree[2*index] + tree[2*index+1];
		return;

	}
	public static void main (String[] args) throws java.lang.Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		int tree[] = new int[2*n];
		int start = 0;
		int end = arr.length - 1;
		int index = 1;
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int m = scan.nextInt();
		buildTree(tree, arr, start, end, index);
		while(m-- > 0) {
			int query[] = new int[3];
			for(int j = 0; j < query.length; j++) {
			    query[j] = scan.nextInt();
			}
			int queryType = query[0];
			int rangeStart = query[1];
			int rangeEnd = query[2];
			if(queryType == 1) {
				int ans = query(tree, start, end, index, rangeStart - 1, rangeEnd - 1);
				System.out.println(ans);
			}
			else {
				updateIndex(tree, index, start, end, rangeStart - 1, rangeEnd);
			}
		}
	}
}