package sorting;

import util.TextFileReader;

public class InversionCount {
	
	public long countInversions(int[] arr, int f, int l, int[] sortedArr) {
		if (f == l) {
			sortedArr[0] = arr[f];
			return 0;
		}
		int m = (f + l) / 2;
		int[] leftArr = new int[m - f + 1];
		long left = countInversions(arr, f, m, leftArr);
		int[] rightArr = new int[l - m];
		long right =  countInversions(arr, m + 1, l, rightArr);
		long out = sortSA(leftArr, rightArr, sortedArr);
		return left + right + out;
	}
	
	public long sortSA(int[] arr1, int[] arr2, int out[]) {
		int cur1 = 0; int cur2 = 0;
		int oIndex = 0;
		long inversionCount = 0;
		while (cur1 < arr1.length && cur2 < arr2.length) {
			if (arr1[cur1] <= arr2[cur2]) {
				out[oIndex] = arr1[cur1];
				cur1++;
			} else {
				out[oIndex] = arr2[cur2];
				cur2++;
				inversionCount += (arr1.length - cur1);
			}
			oIndex++;
		}
		if (cur1 == arr1.length) {
			for (int i = cur2 ; i < arr2.length ; i++) {
				out[oIndex] = arr2[cur2];
				cur2++;
				oIndex++;
			}
		} else {
			out[oIndex] = arr1[cur1];
			oIndex++;
			cur1++;
			for (int i = cur1; i < arr1.length ; i++) {
				out[oIndex] = arr1[cur1];
				cur1++;
				oIndex++;
				//inversionCount += arr2.length;
			}
		}
		return inversionCount;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {};
		int[] arr2 = {1};
		int[] arr3 = {9, 3, 7, 8, 0, 6, 1, 2, 4, 5};
		int[] outArr3 = new int[10];
		int[] arr4 = {1, 3, 5, 2, 4, 6};
		int[] outArr4 = new int[6];
		int[] arr5 = new TextFileReader().readFile("C:\\dsaTextFiles\\countInv.txt");
		int[] outarr5 = new int[100000];
	//	int[] a1 = new MergeSort().ms(arr2, 0, 0);
		System.out.println(new InversionCount().countInversions(arr5, 0, 99999, outarr5));
	}

}
