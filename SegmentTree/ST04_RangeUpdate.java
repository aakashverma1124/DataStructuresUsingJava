/*

	@author Aakash.Verma

	This code is the implementation of How a Segment tree changes when a value is updated in the original array.

	Output: 

	Original Array: [1, 2, 3, 4, 5, 6, 7, 8, 9]
	Segment Tree: 1 1 6 1 4 6 8 1 3 4 5 6 7 8 9 1 2 
	Min of (0 - 4): 1
	Min of (3 - 7): 4
	Updating a range
	Updated Segment Tree: 1 1 7 1 9 7 8 1 8 9 10 11 7 8 9 1 7 
	Min of (0 - 4): 1
	Min of (3 - 7): 7


*/

import java.util.*;
import java.io.*;

class ST04_RangeUpdate {

	/* 
		Building a Segment Tree
		We've already build this tree in the previous example.
	*/
	static void buildTree(int arr[], int tree[], int start, int end, int index) {
		/* Base Case */
		if(start > end) {
			return;
		}

		/* Base Case */
		if(start == end) {
			tree[index] = arr[start];
			return;
		}

		int mid = (start + end)/2;

		buildTree(arr, tree, start, mid, 2*index);
		buildTree(arr, tree, mid + 1, end, 2*index+1);

		tree[index] = Math.min(tree[2*index], tree[2*index+1]);
	}

	static int rangeMinQuery(int tree[], int index, int start, int end, int queryStart, int queryEnd) {

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
		int leftAnswer = rangeMinQuery(tree, 2*index, start, mid, queryStart, queryEnd);
		int rightAnswer = rangeMinQuery(tree, 2*index+1, mid+1, end, queryStart, queryEnd);

		return Math.min(leftAnswer, rightAnswer);
	}


	/*
		Range Update!
		Let's suppose, I am given a range and rangeStart & rangeEnd. Then I've to increment every element
		int the given range by some value.
		Then what will be the updated Segment Tree?
	*/
	static void rangeUpdate(int tree[], int index, int start, int end, int rangeStart, int rangeEnd, int value) {

		/* No overlap */
		if(rangeEnd < start || rangeStart > end) {
			return;
		}

		/* Leaf Node */
		if(start == end) {
			tree[index] += value;
			return;
		}

		/* Partial Overlap */
		int mid = (start + end)/2;
		rangeUpdate(tree, 2*index, start, mid, rangeStart, rangeEnd, value);
		rangeUpdate(tree, 2*index+1, mid+1, end, rangeStart, rangeEnd, value);
		tree[index] = Math.min(tree[2*index], tree[2*index+1]);
		return;
	}

	public static void main(String[] args) {

		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int tree[] = new int[2*arr.length];  
		int start = 0;
		int end = arr.length - 1;
		int index = 1;

		System.out.print("Original Array: ");
		System.out.println(Arrays.toString(arr));

		buildTree(arr, tree, start, end, index);
		/* Printing Segment Tree */
		System.out.print("Segment Tree: ");
		for(int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();

		int ans1 = rangeMinQuery(tree, index, start, end, 0, 4);
		System.out.println("Min of (0 - 4): " + ans1);		
		int ans2 = rangeMinQuery(tree, index, start, end, 3, 7);
		System.out.println("Min of (3 - 7): " + ans2);

		System.out.println("Updating a range");		
		rangeUpdate(tree, index, start, end, 1, 5, 5);

		/* Printing Updated Segment Tree */
		System.out.print("Updated Segment Tree: ");
		for(int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();

		int ans3 = rangeMinQuery(tree, index, start, end, 0, 4);
		System.out.println("Min of (0 - 4): " + ans3);
		int ans4 = rangeMinQuery(tree, index, start, end, 3, 7);
		System.out.println("Min of (3 - 7): " + ans4);


		

	}
	

}