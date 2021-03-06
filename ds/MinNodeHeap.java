package ds;

public class MinNodeHeap {

  Node[] heap = new Node[10000];
  int lastIndex = 0;

  public Node min() {
    if (lastIndex <= 0) {
      System.out.print(" heap is empty ");
      return null;
    }
    return heap[1];
  }

  public int size() {
    return lastIndex;
  }
  
  public int decrementKey2(int heapArrIndex, int newMinDistance, int[] positionOfGivenVertexInHeap) {
	  // remove element at position "heapArrIndex" from heap
	  Node node =  heap[heapArrIndex];
	  heap[heapArrIndex] = heap[lastIndex];
	  positionOfGivenVertexInHeap[lastIndex] = heapArrIndex;
	  lastIndex--;
	  bubbleDown2(heapArrIndex, positionOfGivenVertexInHeap);
	  node.minDistance = newMinDistance;
	  insert2(node, positionOfGivenVertexInHeap);
	  return -1;
  }
 
  public void insert2(Node element, int[] positionInHeap) {
    lastIndex++;
    heap[lastIndex] = element;
    bubbleUp2(lastIndex, positionInHeap);
  }

  private void bubbleUp2(int lastIndex, int[] positionInHeap) {
    if (lastIndex == 1) {
      return;
    }
    if (heap[lastIndex / 2].minDistance <= heap[lastIndex].minDistance) {
      return;
    }
    swap2(heap, lastIndex, lastIndex / 2, positionInHeap);
    bubbleUp2(lastIndex / 2, positionInHeap);
  }

  public Node extractMin2(int[] positionOfGivenVertexInHeap) {
    if (lastIndex <= 0) {
      return null;
    }
    Node min = heap[1];
    heap[1] = heap[lastIndex];
    positionOfGivenVertexInHeap[lastIndex] = 1;
    lastIndex--;
    bubbleDown2(1, positionOfGivenVertexInHeap);
    return min;
  }

  private void bubbleDown2(int index, int[] positionInHeap) {
    if (index * 2 > lastIndex) {
      return;
    }
    if (index * 2 == lastIndex) {
      if (heap[index].minDistance > heap[lastIndex].minDistance) {
        swap2(heap, index, lastIndex, positionInHeap);
      }
      return;
    }
    if (heap[index].minDistance <= heap[index * 2].minDistance
        && heap[index].minDistance <= heap[index * 2 + 1].minDistance) {
      return;
    }
    int minIndex =
        heap[index * 2].minDistance < heap[index * 2 + 1].minDistance ? index * 2 : index * 2 + 1;
    swap2(heap, index, minIndex, positionInHeap);
    bubbleDown2(minIndex, positionInHeap);
  }

  private void swap2(Node[] arr, int index, int minIndex, int[] positionInHeap) {    
    swapActualHeap(arr, index, minIndex);    
    swapVertexPositionInHeap(positionInHeap, index, minIndex);
  }
  
  private void swapActualHeap(Node[] arr, int index1, int index2) {
    Node temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  private void swapVertexPositionInHeap( int[] positionInHeap, int heapIndex1, int heapIndex2) {
    int temp = positionInHeap[heap[heapIndex1].vertexId];
    positionInHeap[heap[heapIndex1].vertexId] = positionInHeap[heap[heapIndex2].vertexId];
    positionInHeap[heap[heapIndex2].vertexId] = temp;
  }

  public static void main(String[] args) {
  }
}
