public class LCS4 {

	public static String s1 = "ABRACADABRA";//"124993548";// "124993548";344
	public static String s2 = "YABBADABBADOO";// "927499888";"4484211009";448
	static int end1 = s1.length() - 1;
	static int end2 = s2.length() - 1;

	private static int lcs(int start1, int start2, int[][] arr, char[] outS1, char[] outS2) {
		int copyOfStart1 = start1;
		int copyOfStart2 = start2;
		char s1Char;
		char s2Char;

		if (start1 > end1 || start2 > end2) {
			return 0;
		}
		if (arr[start1][start2] != -1) {
			return arr[start1][start2];
		}

		int max = 0;

		for (int count = start2; count <= end2; count++) {
			int currentMatch = (s1.charAt(start1) == s2.charAt(start2) ? 1 : 0);
			int currentRec = lcs(start1 + 1, start2 + 1, arr, outS1, outS2);
			int current = currentMatch + currentRec;

			if (current > max) {
				max = current;
				s1Char = s1.charAt(start1);
				s2Char = s2.charAt(start2);
			}
			start2++;
		}

		start2 = copyOfStart2;
		
		for (int count = start1; count <= end1; count++) {
			int currentMatch = (s1.charAt(start1) == s2.charAt(start2) ? 1 : 0);
			int currentRec = lcs(start1 + 1, start2 + 1, arr, outS1, outS2);
			int current = currentMatch + currentRec;
			
			if (current > max) {
				max = current;
			}
			start1++;
		}
		arr[copyOfStart1][copyOfStart2] = max;
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = new int[s1.length()][s2.length()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = -1;
			}
		}
		char[] outS1 = new char[s1.length()];
		char[] outS2 = new char[s2.length()];
		int x = lcs(0, 0, arr, outS1, outS2);
		System.out.println(x);
	}
}
