import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * TODO: Insert description here. (generated by srallabandi)
 */
public class QueensFaster {

	public static void m1(int curRow, int colCount, int[] out, Map<Integer, List<String>> map) {
		for (int curCol = 1; curCol <= colCount; curCol++) {
			if (canI(curRow, curCol, colCount, map)) {
				out[curRow] = curCol;
				addQueenToMap(curRow, curCol, map);
				if (curRow == colCount) {
					print(out);
				}
				m1(curRow + 1, colCount, out, map);
			}
		}
	}

	private static void addQueenToMap(int curRow, int curCol, Map<Integer, List<String>> map) {
		
		
	}

	private static void print(int[] out) {
		for (int row = 1; row < out.length; row++) {
			System.out.print(" " + out[row]);
		}
		System.out.println("");
	}
	
	private static boolean canI(int curRow, int curCol, int colCount,  Map<Integer, List<String>> map) { 
		return !map.containsKey((colCount * curRow) + curCol);
	}

	private static boolean canI2(int curRow, int curCol, int[] out) {
		for (int row = 1; row < curRow; row++) {
			int alreadyRow = row;
			int alreadyCol = out[row];
			if (curRow == alreadyRow
					|| curCol == alreadyCol
					|| Math.abs(curCol - alreadyCol) == Math.abs(curRow
							- alreadyRow)
					|| checkIfPointsInStraightLine(curRow, curCol, out)) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkIfPointsInStraightLine(int curRow, int curCol,
			int[] out) {
		if (curRow > 2) {
			for (int i = 1; i < curRow; i++) {
				for (int j = 1; j < curRow; j++) {
					if (j > i) {
						int coli = out[i];
						int colj = out[j];
						if (((1000 * Math.abs(coli - colj)) / Math.abs(i - j)) == ((1000 * Math.abs(coli - curCol)) / Math.abs(i - curRow))) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] out = new int[18];
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		m1(1, 17, out, map);
	}
	}