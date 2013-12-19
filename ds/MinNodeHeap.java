package graph;

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

  public int decrementKey(int heapArrIndex, int newMinDistance, int[] positionInHeap) {
    Node n = heap[heapArrIndex];
    n.minDistance = newMinDistance;
    if (heapArrIndex == 1) {
      return 1;
    }
    while (heapArrIndex > 1) {
      if (newMinDistance < heap[heapArrIndex / 2].minDistance) {
        swap2(heap, heapArrIndex, heapArrIndex / 2, positionInHeap);
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
      if (heap[index].minDistance > heap[lastIndex].minDistance) {
        swap(heap, index, lastIndex);
      }
      return;
    }
    if (heap[index].minDistance <= heap[index * 2].minDistance
        && heap[index].minDistance <= heap[index * 2 + 1].minDistance) {
      return;
    }
    int minIndex =
        heap[index * 2].minDistance < heap[index * 2 + 1].minDistance ? index * 2 : index * 2 + 1;
    swap(heap, index, minIndex);
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
    heap[lastIndex] = element;
    bubbleUp(lastIndex);
  }

  private void bubbleUp(int lastIndex) {
    if (lastIndex == 1) {
      return;
    }
    if (heap[lastIndex / 2].minDistance <= heap[lastIndex].minDistance) {
      return;
    }
    swap(heap, lastIndex, lastIndex / 2);
    bubbleUp(lastIndex / 2);
  }

  public Node extractMin() {
    if (lastIndex <= 0) {
      return null;
    }
    Node min = heap[1];
    heap[1] = heap[lastIndex];
    lastIndex--;
    bubbleDown(1);
    return min;
  }

  public Node extractMin2(int[] positionOfGivenVertexInHeap) {
    if (lastIndex <= 0) {
      return null;
    }
    Node min = heap[1];
    heap[1] = heap[lastIndex];
    //positionOfGivenVertexInHeap[1] = positionOfGivenVertexInHeap[lastIndex];
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
    bubbleDown(minIndex);
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
      /*
       * System.out.println("expected min : 11, actual : " + h.extractMin());
       * System.out.println("expected min : 11, actual : " + h.extractMin());
       * System.out.println("expected min : 11, actual : " + h.extractMin());
       * System.out.println("expected min : 11, actual : " + h.extractMin());
       * System.out.println("expected min : 11, actual : " + h.extractMin());
       * System.out.println("expected min : 11, actual : " + h.extractMin());
       * System.out.println("expected min : 11, actual : " + h.extractMin());
       */
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  private static void print(MinNodeHeap h) {
    // System.out.println("elements in the " + h.getClass().getSimpleName() + " after " + op + " " +
    // element);
    for (int i = 1; i <= h.lastIndex; i++) {
      System.out.print(h.heap[i].minDistance + " ");
    }
    System.out.println();
  }

}
