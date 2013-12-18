package ds;

public class MinNodeHeap {

	Node[] arr = new Node[10000];
	int lastIndex = 0;

	public Node min() {
		if (lastIndex <= 0) {
			System.out.print(" heap is empty ");
			return null;
		}
		return arr[1];
	}

	public int size() {
		return lastIndex;
	}
	
	public int decrementKey(int heapArrIndex, int newMinDistance) {
		Node n = arr[heapArrIndex];
		n.minDistance = newMinDistance;
		if (heapArrIndex == 1) {
			return 1;
		}
		while (heapArrIndex > 1) {
			if (newMinDistance < arr[heapArrIndex / 2].minDistance) {
				swap(arr, heapArrIndex, heapArrIndex / 2);
				heapArrIndex = heapArrIndex / 2;
			} else {
				break;
			}
		}
		return heapArrIndex;
	}
	
	private void bubbleDown(int index) {
		if (index * 2 > lastIndex) {
			return;
		}
		if (index * 2 == lastIndex) {
			if (arr[index].minDistance > arr[lastIndex].minDistance) {
				swap(arr, index, lastIndex);				
			}
			return;
		}
		if (arr[index].minDistance <= arr[index * 2].minDistance 
				&& arr[index].minDistance <= arr[index * 2 + 1].minDistance) {
			return;
		}
		int minIndex = arr[index * 2].minDistance < arr[index * 2 + 1].minDistance
				? index * 2 : index * 2 + 1;
		swap(arr, index, minIndex);
		bubbleDown(minIndex);
	}
	
	private void swap(Node[] arr, int index, int minIndex) {
		int temp = arr[index].minDistance;
		arr[index].minDistance = arr[minIndex].minDistance;
		arr[minIndex].minDistance = temp;
		
		temp = arr[index].vertexId;
		arr[index].vertexId = arr[minIndex].vertexId;
		arr[minIndex].vertexId = temp;
	}
	
	public void insert(Node element) {
		lastIndex++;
		arr[lastIndex] = element;
		bubbleUp(lastIndex);
	}

	private void bubbleUp(int lastIndex) {
		if (lastIndex == 1) {
			return;
		}
		if (arr[lastIndex / 2].minDistance <= arr[lastIndex].minDistance) {
			return;
		}
		swap(arr, lastIndex, lastIndex / 2);
		bubbleUp(lastIndex / 2);
	}

	public Node extractMin() {
		if (lastIndex <= 0) {
			return null;
		}
		Node min = arr[1];
		arr[1] = arr[lastIndex];
		lastIndex--;
		bubbleDown(1);
		return min;
	}
	
	public Node extractMin2(int[] positionInHeap) {
		if (lastIndex <= 0) {
			return null;
		}
		Node min = arr[1];
		arr[1] = arr[lastIndex];
		lastIndex--;
		bubbleDown2(1, positionInHeap);
		return min;
	}	
	
	private void bubbleDown2(int index, int[] positionInHeap) {
		if (index * 2 > lastIndex) {
			return;
		}
		if (index * 2 == lastIndex) {
			if (arr[index].minDistance > arr[lastIndex].minDistance) {
				swap2(arr, index, lastIndex, positionInHeap);				
			}
			return;
		}
		if (arr[index].minDistance <= arr[index * 2].minDistance 
				&& arr[index].minDistance <= arr[index * 2 + 1].minDistance) {
			return;
		}
		int minIndex = arr[index * 2].minDistance < arr[index * 2 + 1].minDistance
				? index * 2 : index * 2 + 1;
		swap2(arr, index, minIndex, positionInHeap);
		bubbleDown(minIndex);
	}
	
	private void swap2(Node[] arr, int index, int minIndex, int[] positionInHeap) {
		int temp = arr[index].minDistance;
		arr[index].minDistance = arr[minIndex].minDistance;
		arr[minIndex].minDistance = temp;
		
		temp = arr[index].vertexId;
		arr[index].vertexId = arr[minIndex].vertexId;
		arr[minIndex].vertexId = temp;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinNodeHeap h = new MinNodeHeap();
		h.insert(new Node(100, 4));		
		print(h);
		h.insert(new Node(100, 14));
		print(h);
		h.insert(new Node(100, 4));
		print(h);
		h.insert(new Node(100, 1));
		print(h);
		h.insert(new Node(100, 41));
		print(h);
		try {
			System.out.println("expected min : 1, actual : " + h.extractMin().minDistance);
			print(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(new Node(100, 43));	
		print(h);
		h.insert(new Node(100, 114));
		print(h);
		try {
			System.out.println("expected min : 4, actual : " + h.extractMin().minDistance);
			print(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(new Node(100, 13));
		print(h);
		h.insert(new Node(100, 11));
		print(h);
		try {
			System.out.println("expected min : 4, actual : " + h.extractMin().minDistance);
			print(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.insert(new Node(100, 411));
		print(h);
		try {
			System.out.println("expected min : 11, actual : " + h.extractMin().minDistance);
			print(h);
			/*System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());
			System.out.println("expected min : 11, actual : " + h.extractMin());*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	private static void print(MinNodeHeap h) {
		//System.out.println("elements in the " +  h.getClass().getSimpleName() + " after " + op +  " " + element);
		for (int i = 1 ; i <= h.lastIndex; i++) {
			System.out.print(h.arr[i].minDistance + " ");
		}
		System.out.println();
	}

}