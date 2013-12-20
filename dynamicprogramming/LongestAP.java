package dynamicprogramming;

public class LongestAP {
	
	public int longestAP(int[] arr) {
		int[] lengthArr = new int[arr.length];
		lengthArr[0] = 1;
		int[] diffArr = new int[arr.length];
		diffArr[0] = -1;
		for (int i = 1 ; i < arr.length ; i++) {
			int maxLength = 2;
			int bestIndex = 0;
			for (int j = 0 ; j < i ; j++) {
				int diff = diffArr[j];
				int currentLength = lengthArr[j] + 1;
				if (arr[i] - arr[j] == diff && currentLength + 1  > maxLength) {
					maxLength = currentLength + 1;	
					bestIndex = j;
				}
			}
			lengthArr[i] = maxLength;
			diffArr[i] = diffArr[bestIndex];
		}
		int best = 0;
		for (int i = 0 ; i < lengthArr.length ; i++) {
			if (lengthArr[i] > best) {
				best = lengthArr[i];
			}
		}
		return best;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 7, 10, 15, 27, 29};
		System.out.println(new LongestAP().longestAP(arr));

	}

}
