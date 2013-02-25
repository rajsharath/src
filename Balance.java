public class Balance {
  
  private static class Node {
    int leftW;
    int rightW;
    Node[] leftNodes;
    Node[] rightNodes;
    
    public Node(int leftW, int rightW, Node[] leftNodes, Node[] rightNodes) {
      this.leftW = leftW;
      this.rightW = rightW;
      this.leftNodes = leftNodes;
      this.rightNodes = rightNodes;
    }
  }
  
  public static int balance(Node node, int[] indexArray, int[] weightAdded) {
    if (node == null) {
      return 0;
    }
    
    // maintain the index 
    int index = indexArray[0];
    // left
    int totalLeftPanW = node.leftW;
    if (node.leftNodes != null && node.leftNodes.length > 0) {
      for (int i = 0 ; i < node.leftNodes.length ; i++) {
        indexArray[0] = indexArray[0] + 1;
        totalLeftPanW += balance(node.leftNodes[i], indexArray, weightAdded);
      }
    }
    
    //right
    int totalRightPanW = node.rightW;
    if (node.rightNodes != null && node.rightNodes.length > 0) {
      for (int i = 0 ; i < node.rightNodes.length ; i++) {
        indexArray[0] = indexArray[0] + 1;
        totalRightPanW += balance(node.rightNodes[i], indexArray, weightAdded);
      }
    }
    int diff = totalRightPanW - totalLeftPanW;
    // if diff is positive, add it to left.
    weightAdded[index] = diff;
    return totalLeftPanW + totalRightPanW + 10 + Math.abs(diff);    
  }
  
  public static void moveH(Node node, int[] indexArray, int[] weightAdded, int level) {
	  if (node == null || level < 1) {
		  return;
	  }
	  // process root, moveH(node.left, level - 1), moveH(node.right, level - 1)
	  if (level == 1) {
		  
	  }
	  for (int i = 0 ; i < node.leftNodes.length ; i++) {
	        indexArray[0] = indexArray[0] + 1;
	        totalLeftPanW += balance(node.leftNodes[i], indexArray, weightAdded);
	      }
	  moveH(node.left, indexArray, weightAdded, level);
  }

  /**
   * @param args
   */
  
  public static Node createTree() {   
    Node node3 = new Node(0, 0 , null, null);
    Node node2 = new Node(3, 0 , null, null);
   
    Node [] node1RightList = {node3};   
    Node node1 = new Node(0, 0 , null, node1RightList);
    
    Node [] node0LeftList = {node1};
    Node [] node0RightList = {node2};
    Node node0 = new Node(0, 0 , node0LeftList, node0RightList);
    
    return node0;
  }
  
  public static void main(String[] args) {
    int [] indexArray = new int[4];
    int [] weightAdded = new int[4];
    balance(createTree(), indexArray, weightAdded);
    for (int x : weightAdded) {
      System.out.println(x);
    }
  }
}