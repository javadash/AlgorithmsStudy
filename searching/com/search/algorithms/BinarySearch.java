package com.search.algorithms;

public class BinarySearch {
    static int binarySearch(int[] a, int x) {
    	int left = 0;
    	int right = a.length;
    	// sort array
    	return binarySearchHelper(a, left, right-1, x);
    }
    
    static int binarySearchHelper(int[] a, int l, int r, int x){
    	int middle = l + (r - l) / 2;
    	if (x > a[r] || x < a[l]) return -1;
    	if (r - l == 0 && a[l] != x) return -1;
        
        if (x  < a[middle]) return binarySearchHelper(a, l, middle - 1, x);
        else if (x > a[middle]) return binarySearchHelper(a, middle + 1, r, x);
        else return middle;
    }

    static int binarySearchIterative(int arr[], int key) {
    	int low = 0;
    	int high = arr.length - 1;

    	while (low <= high) {
    		int mid = (low + high) / 2;
    		int midVal = arr[mid];
    		if (midVal < key)
    			low = mid + 1;
    		else if (midVal > key)
    			high = mid - 1;
    		else
    			return mid; // key found
    	}
    	return -(low + 1);  // key not found.
    }

}
