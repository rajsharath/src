package ds;

public class MaxHeap {
	
	int[] arr = new int[10000];
	int lastIndex = 0; // next element is added at lastIndex + 1 location
	
	public void insert(int element) {
		arr[++lastIndex] = element;
		bubbleUp(lastIndex);
	}
	
	public int max() {
		if (lastIndex <= 0) {
			System.out.print(" heap is empty ");
			return -100000;
		}
		return arr[1];
	}
	
	public int size() {
		return lastIndex;
	}
	
	private void bubbleUp(int index) {
		if (index == 1) {
			return;
		}
		if (arr[index / 2] < arr[index]) {
			swap(arr, index/2, index);
			bubbleUp(index/2);
		}
	}
	
	public int extractMax() {
		if (lastIndex < 1) {
			return -1;
		}
		int element = arr[1];
		arr[1] = arr[lastIndex--];
		bubbleDown(1);		
		return element;
	}
	
	public void bubbleDown(int index) {
		if (lastIndex < 2 * index) {
			return;
		}
		if (index * 2 == lastIndex) {
			if (arr[index] < arr[index * 2]) {
				swap(arr, index, index * 2);
			}			
		}
		if (arr[index * 2] > arr[index] || arr[index * 2 + 1] > arr[index]) {
			int largestIndex = arr[index * 2] > arr[index * 2 + 1] ? index * 2 : index * 2 + 1;
			swap(arr, largestIndex, index);
			bubbleDown(largestIndex);
		}
	}
	
	public void swap(int[] arr, int f, int l) {
		int temp = arr[f];
		arr[f] = arr[l];
		arr[l] = temp;
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
			System.out.println("expected max : 41, actual : " + h.extractMax());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(43);		
		h.insert(114);
		try {
			System.out.println("expected max : 114, actual : " + h.extractMax());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(13);
		h.insert(11);
		try {
			System.out.println("expected max : 43, actual : " + h.extractMax());
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(411);
		try {
			System.out.println("expected max : 411, actual : " + h.extractMax());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
