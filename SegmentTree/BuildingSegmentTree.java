/*

	@author Aakash.Verma

	This code is the implementation of How a Segment Tree can be built?
	We are just representing an array as a tree in the form of array itself.

*/

import java.util.*;
import java.io.*;

class BuildingSegmentTree {

	/* Building a Segment Tree */
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

	public static void main(String[] args) {

		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int tree[] = new int[2*arr.length];  
		int start = 0;
		int end = arr.length - 1;
		int index = 1;

		buildTree(arr, tree, start, end, index);
		/* Printing Segment Tree */
		for(int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();

		

	}
	

}