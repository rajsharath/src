package sorting;

public class QuickSort {

	public void qs(int[] arr, int f, int l) {
		if (f >= l) {
			return;
		}
		if (l == (f + 1)) {
			if (arr[f] > arr[l]) {
				swap(arr, f, l);
			}
			return;
		}
		int pivot = partition2(arr, f, l);
		qs(arr, f, pivot - 1);
		qs(arr, pivot + 1, l);
	}

	public int partition(int[] arr, int f, int l) {
		int pivot = arr[f];
		int i = f + 1;
		int j = f;
		while (i <= l) {
			if (arr[i] < pivot) {
				if (j == f) {
					// do nothing
				} else {
					swap(arr, i, j);
					j++;
				}
			} else {
				if (j == f) {
					j = i;
				} else {
					// do nothing
				}
			}
			i++;
		}
		if (j == f) {
			swap(arr, f, l);
			return l;
		} else {
			swap(arr, f, j - 1);
			return j - 1;
		}
	}

	public int partition2(int[] arr, int f, int l) {
		int pivot = arr[f];
		int i = f + 1;
		int j = f;
		while (i <= l) {
			if (arr[i] < pivot && j != f) {
				swap(arr, i, j);
				j++;
			} else if (arr[i] >= pivot && j == f) {
				j = i;
			}
			i++;
		}
		if (j == f) {
			swap(arr, f, l);
			return l;
		} else {
			swap(arr, f, j - 1);
			return j - 1;
		}
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr3 = { 11, -7, 9, 3, 7, 8, 0, 6, 1, 2, 4, 5 };
		new QuickSort().qs(arr3, 0, 11);
		System.out.println();

	}

}
