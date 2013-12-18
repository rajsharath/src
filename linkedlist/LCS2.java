package linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCS2 {
	
	public static int lcs(String s1, int s1I, String s2, int s2I, List<String> list, int index) {
		
		if (s1I >= s1.length() || s2I >= s2.length()) {
			int count = 0;
			for (int i = 0 ; i < index ; i++) {
				String x[] = list.get(i).split(",");
				if (x[0].equals(x[1])) {
					count++;
				}
			}
			return count;
		}
		
		list.add(index, new String(s1.charAt(s1I) + "," + s2.charAt(s2I)));
		index++;
		
		int x = lcs(s1, s1I + 1, s2, s2I + 1, list, index);
		int y = lcs(s1, s1I,     s2, s2I + 1, list, index - 1);
		int z = lcs(s1, s1I + 1, s2, s2I, list, index - 1);
		int temp = x > y ? x : y;
		return temp > z ? temp : z;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int index = 0;
		Set<String> outSet = new HashSet<String>();
		System.out.println("lcs is : " + lcs("ab", 0, "de", 0, list, index));
		// System.out.println("lcs is : " + lcs("abcde", 0, "abcde", 0, list, index));
		for (String str : outSet) {
			System.out.println(str);
		}
	}
}
