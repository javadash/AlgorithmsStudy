package Chap01_Arrays_and_Strings.chap1;

public class BinarySearch {
	public int binarysarch(int[] arr, int key) {
		int len = arr.length;
		int low, high;
		low = 0;
		high = arr.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == key) return mid;
			else if (key < mid) high = mid;
			else if (key > mid) low = mid + 1;
		}
		return -1;
	}
}
