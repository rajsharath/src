package recursion;

public class Coins {

	public static void change(int curSum, int max, int curCoin, int[] count) {
		if (curCoin != 37) {
			System.out.println("processing cuSum " + curSum + " curCoin " + curCoin + " paths " + count[0]);
			if (curSum + curCoin > max) {
				return;
			}
			curSum += curCoin;
			if (curSum == max) {
				// print the array
				count[0] = count[0] + 1;
				return;
			}
		}
		change(curSum, max, 1, count);
		change(curSum, max, 5, count);
		change(curSum, max, 10, count);
		change(curSum, max, 25, count);
	}

	public static int makeChange(int n, int denom) {

		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}

		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}
		return ways;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] count = { 0 };
		//change(0, 10, 37, count);
		//System.out.println("count " + count[0]);
		 System.out.println(makeChange(10, 25));
	}
}