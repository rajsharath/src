package ds;

public class MinHeap {

	int[] arr =  new int[10000];
	int lastIndex = 0;
	
	public int min() {
		if (lastIndex <= 0) {
			System.out.print(" heap is empty ");
			return -100000;
		}
		return arr[1];
	}
	
	public int size() {
		return lastIndex;
	}
	
	public int extractMin() {
		if (lastIndex <= 0) {
			return - 1;
		}
		int min = arr[1];
		arr[1] = arr[lastIndex];
		lastIndex--;
		bubbleDown(1);
		return min;
	}
	
	public void insert(int element) {
		lastIndex++;
		arr[lastIndex] = element;
		bubbleUp(lastIndex);
	}
	
	private void bubbleUp(int lastIndex) {
		if (lastIndex == 1) {
			return;
		}
		if (arr[lastIndex / 2] <= arr[lastIndex]) {
			return;
		}
		swap(arr, lastIndex, lastIndex / 2);
		bubbleUp(lastIndex / 2);
	}

	private void bubbleDown(int index) {
		if (index * 2 > lastIndex) {
			return;
		}
		if (index * 2 == lastIndex) {
			if (arr[index] > arr[lastIndex]) {
				swap(arr, index, lastIndex);
				return;
			}
		}
		if (arr[index] <= arr[index * 2] && arr[index] <= arr[index * 2 + 1]) {
			return;
		}
		int minIndex = arr[index * 2] < arr[index * 2 + 1] ? index * 2 : index * 2 + 1;
		swap(arr, index, minIndex);
		bubbleDown(minIndex);
	}
	
	private void swap(int[] arr, int index, int minIndex) {
		int temp = arr[index];
		arr[index] = arr[minIndex];
		arr[minIndex] = temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinHeap h = new MinHeap();
		h.insert(4);		
		h.insert(14);
		h.insert(4);
		h.insert(1);
		h.insert(41);
		try {
			System.out.println("expected min : 1, actual : " + h.extractMin());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(43);		
		h.insert(114);
		try {
			System.out.println("expected min : 4, actual : " + h.extractMin());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(13);
		h.insert(11);
		try {
			System.out.println("expected min : 4, actual : " + h.extractMin());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(411);
		try {
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
