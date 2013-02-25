public class MaxHeap {

	private int[] arr = new int[10000];
	private int insertionIndex = 1;

	public void insert(Integer num) {
		arr[insertionIndex] = num;
		if (insertionIndex > 1) {
			bubbleUpElementInRightPlace(arr, insertionIndex);
		}
		insertionIndex++;
	}

	public int remove() throws Exception {
		if (insertionIndex == 1) {
			throw new Exception("size zero");
		}
		int numReturn = arr[1];
		arr[1] = arr[--insertionIndex];	
		bubbleDownRoot(arr, 1);
		return numReturn;
	}

	public int getMax() throws Exception {
		if (insertionIndex == 1) {
			throw new Exception("size zero");
		}
		return arr[1];
	}
	
	public int size() {
		return insertionIndex - 1;
	}
	
	private void bubbleDownRoot(int[] arr, int rootIndex) {
		// no children for this root
		if (rootIndex * 2 > insertionIndex - 1) {
			return;
		}
		if (rootIndex * 2 == insertionIndex - 1) {
			if (arr[rootIndex] < arr[rootIndex * 2]) {
				swap(arr, rootIndex, rootIndex * 2);
				bubbleDownRoot(arr, rootIndex * 2);
			} else {
				return;
			}
		} else if (rootIndex * 2 < insertionIndex - 1) {
			// both
			int childIndex = arr[rootIndex * 2] > arr[(rootIndex * 2) + 1] ? rootIndex * 2 : (rootIndex * 2) + 1;
			if (arr[rootIndex] < arr[childIndex]) {
				swap(arr, rootIndex, childIndex);
				bubbleDownRoot(arr, childIndex);
			} else {
				return;
			}
		}
	}

	private void bubbleUpElementInRightPlace(int[] arr, int insertionIndex) {
		int parentIndex = insertionIndex / 2;
		if (arr[insertionIndex] <= arr[parentIndex]) {
			return;
		}
		swap(arr, parentIndex, insertionIndex);
		if (parentIndex > 1) {
			bubbleUpElementInRightPlace(arr, parentIndex);
		}
	}

	private void swap(int[] arr, int parentIndex, int insertionIndex) {
		int temp = arr[parentIndex];
		arr[parentIndex] = arr[insertionIndex];
		arr[insertionIndex] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxHeap h = new MaxHeap();
		h.insert(4);		
		h.insert(14);
		h.insert(4);
		h.insert(1);
		h.insert(41);
		try {
			System.out.println("expected max : 41, actual : " + h.remove());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(43);		
		h.insert(114);
		try {
			System.out.println("expected max : 114, actual : " + h.remove());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(13);
		h.insert(11);
		try {
			System.out.println("expected max : 43, actual : " + h.remove());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(411);
		try {
			System.out.println("expected max : 411, actual : " + h.remove());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
