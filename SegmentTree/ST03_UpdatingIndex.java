/*

	@author Aakash.Verma

	This code is the implementation of How a Segment tree changes when a value is updated in the original array.

	Output: 

	Original Array: [1, 2, 3, 4, 5, 6, 7, 8, 9]
	Segment Tree: 1 1 6 1 4 6 8 1 3 4 5 6 7 8 9 1 2 
	Min of (0 - 4): 1
	Min of (3 - 7): 4
	Changing value at index 3 to -3
	Updated Segment Tree: -3 -3 6 1 -3 6 8 1 3 -3 5 6 7 8 9 1 2 
	Min of (0 - 4): -3
	Min of (3 - 7): -3


*/

import java.util.*;
import java.io.*;

class ST03_UpdatingIndex {

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

		System.out.println("Changing value at index 3 to -3");		
		updateIndex(tree, index, start, end, 3, -3);

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