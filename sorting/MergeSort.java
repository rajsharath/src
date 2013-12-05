package sorting;

public class MergeSort {
	
	public int[] ms(int[] arr, int f, int l) {
		if (f == l) {
			int[] retArr = new int[1];
			retArr[0] = arr[f];
			return retArr;
		}
		int m = (f + l) / 2;
		int[] left = ms(arr, f, m);
		int[] right =  ms(arr, m + 1, l);
		int[] out = sortSA(left, right);
		return out;
	}
	
	public int[] sortSA(int[] arr1, int[] arr2) {
		int cur1 = 0; int cur2 = 0;
		int[] out = new int[arr1.length + arr2.length];
		int oIndex = 0;
		while (cur1 < arr1.length && cur2 < arr2.length) {
			if (arr1[cur1] < arr2[cur2]) {
				out[oIndex] = arr1[cur1];
				cur1++;
			} else {
				out[oIndex] = arr2[cur2];
				cur2++;
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
			for (int i = cur1 ; i < arr1.length ; i++) {
				out[oIndex] = arr1[cur1];
				cur1++;
				oIndex++;
			}
		}
		return out;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {};
		int[] arr2 = {1};
		int[] arr3 = {9, 3, 7, 8, 0, 6, 1, 2, 4, 5};
	//	int[] a1 = new MergeSort().ms(arr2, 0, 0);
		int[] a2 = new MergeSort().ms(arr3, 0, 9);
		System.out.println();
	}

}
