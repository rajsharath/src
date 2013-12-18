package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LCS {
	
	public static int lcs(String s1, int s1I, String s2, int s2I, int[][] outSet) {
		
		if (s1I < 0 || s2I < 0 ) {
			return 0;
		}
				
		int x = (s1.charAt(s1I) == s2.charAt(s2I) ? 1 : 0) + 
				lcs(s1, s1I - 1, s2, s2I - 1, outSet);		
		int y = lcs(s1, s1I - 1, s2, s2I, outSet);		
		int z = lcs(s1, s1I,     s2, s2I - 1, outSet);
		
		int temp = x > y ? x : y;
		int res = temp > z ? temp : z;
		outSet[s1I][s2I] = res;
		return res;
	}

	public static int[][] lcs2(String s1, String s2) {
		
		int[][] outSet = new int[s1.length()][s2.length()];
		
		for (int i = 0 ; i < s1.length() ; i++) {
			if (s1.charAt(i) == s2.charAt(0)) {
				outSet[i][0] = 1;
			}
		}
		for (int j = 0 ; j < s2.length() ; j++) {
			if (s2.charAt(j) == s1.charAt(0)) {
				outSet[0][j] = 1;
			}
		}
		
		for (int i = 1 ; i < s1.length() ; i++) {
			for (int j = 1 ; j < s2.length() ; j++) {
				
				int x = (s1.charAt(i) == s2.charAt(j) ? 1 : 0) + outSet[i - 1][j - 1];		
				int y = outSet[i - 1][j];		
				int z = outSet[i][j - 1];
				
				int temp = x > y ? x : y;
				int res = temp > z ? temp : z;
				outSet[i][j] = res;
			}
		}		
		return outSet;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String s1 = "AAACCGTGAGTTATTCGTTCTAGAA";
		//axydzbcse
		//String s2 = "CACCCCTAAGGTACCTTTGGTTC";
		String s1 = "axydzbcse";
		String s2 = "abcde";
		int[][] arr = lcs2(s1, s2);
		System.out.println("lcs is : " + arr[s1.length() - 1][s2.length() - 1]);
	}
}
