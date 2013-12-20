package ds;

public class MinNodeHeap2 {

  Node[] heap = new Node[10000];
  int lastIndex = 0;
  
  public void decrementKey2(int currentNodeIndexInHeap, int newMinDistance, int[] positionOfGivenVertexInHeapArr) {
	  // remove element at position "heapArrIndex" from heap
	  Node node =  heap[currentNodeIndexInHeap];
	  heap[currentNodeIndexInHeap] = heap[lastIndex];
	  positionOfGivenVertexInHeapArr[lastIndex] = currentNodeIndexInHeap;
	  lastIndex--;
	  bubbleDown2(currentNodeIndexInHeap, positionOfGivenVertexInHeapArr);
	  node.minDistance = newMinDistance;
	  insert2(node, positionOfGivenVertexInHeapArr);
  }
 
  public void insert2(Node node, int[] positionInHeap) {
    lastIndex++;
    heap[lastIndex] = node;
    positionInHeap[node.vertexId] = lastIndex;
    bubbleUp2(lastIndex, positionInHeap);
  }

  private void bubbleUp2(int insertIndex, int[] positionInHeap) {
    if (insertIndex == 1) {
      return;
    }
    if (heap[insertIndex / 2].minDistance <= heap[insertIndex].minDistance) {
      return;
    }
    swap2(heap, insertIndex, insertIndex / 2, positionInHeap);
    bubbleUp2(insertIndex / 2, positionInHeap);
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
    positionInHeap[heap[heapIndex1].vertexId] = heapIndex2;
    positionInHeap[heap[heapIndex2].vertexId] = heapIndex1;
  }
}
