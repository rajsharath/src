
public class LXS {
  
  public static String s1 = "124993548";//"124993548";344
  public static String s2 = "927499888";//"927499888";"4484211009";448
  static int end1 = s1.length() - 1;
  static int end2 = s2.length() - 1;
  
  private static int lcs(int start1, int start2, int[][] arr) {
    
    if (start1 > end1 || start2 > end2) {
      return 0;
    }
    if (arr[start1][start2] != -1) {
    	return arr[start1][start2];
    }
    
    int max = 0;
    int s1RemChars = end1 - start1 + 1;
    int s2RemChars = end2 - start2 + 1;   
    
    for (int count = 0 ; count < s2RemChars ; count++) { 
      int current = lcs(start1 + 1, start2 + 1, arr) + (s1.charAt(start1) == s2.charAt(start2) ? 1 : 0);
      if (current > max) {
        max = current;
      }
      if (start2 + 1 <= end2) { 
        start2++;
      }
    }
    
    for (int count = 0 ; count < s1RemChars ; count++) {
      int current = lcs(start1 + 1, start2 + 1, arr) + (s1.charAt(start1) == s2.charAt(start2) ? 1 : 0);
      if (current > max) {
        max = current;
      }
      if (start1 + 1 <= end1) {
        start1++;
      }
    }    
    arr[start1][start2] = max;
    return max;    
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
	  int [][] arr = new int[s1.length()][s2.length()];
	  for (int  i = 0 ; i < arr.length ; i++) {
		  for (int j = 0 ; j < arr[0].length ; j++) {
			  arr[i][j] = -1;
		  }
	  }
    int x = lcs(0, 0, arr);
    System.out.println(x);
  }
}

