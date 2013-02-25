
public class ThreeLetterWordsInFive {
	
	static char[] str = "India".toCharArray();
	static int totalLetters = str.length;
	static int maxLetters = 3;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		p("", 0, maxLetters);
	}

	private static void p(String curString, int curIndex, int addNMoreLetters) {
		if (curString.length() == maxLetters) {
			System.out.println(curString);
			return;
		}
		p(curString.concat(Character.toString(str[curIndex])), curIndex + 1, addNMoreLetters - 1);
		if (totalLetters - curIndex > addNMoreLetters) {
			p(curString, curIndex + 1, addNMoreLetters);
		}
	}
}
