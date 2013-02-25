import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class TrueLies {
	
	public static void m1(Map<String, String[]> inputMap, Map<String, String> visited, String whichlist) {
		
		Iterator<String> inputMapIterator = inputMap.keySet().iterator();
		while (inputMapIterator.hasNext()) {
			String currentPerson = inputMapIterator.next();
			if (!visited.get(currentPerson).isEmpty()) {
				continue;
			}
			visited.put(currentPerson, whichlist);  // which list??
			String otherList = whichlist.equals("list1") ? "list2" : "list1";
			String[] liers = inputMap.get(currentPerson);
			for (String lier : liers) {
				processLier(lier, inputMap, visited, otherList);
			}
		}
	}

	private static void processLier(String currentPerson, Map<String, String[]> inputMap, Map<String, String> visited,
			String whichlist) {
		if (!visited.get(currentPerson).isEmpty()) {
			return;
		}
		visited.put(currentPerson, whichlist);  // which list??
		String otherList = whichlist.equals("list1") ? "list2" : "list1";
		if (!inputMap.containsKey(currentPerson)) {
			return;
		}
		String[] liers = inputMap.get(currentPerson);
		for (String lier : liers) {
			processLier(lier, inputMap, visited, otherList);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		Map<String, String[]> inputMap = createInputMap();
		// setup visited
		Map<String, String> visited = new HashMap<String, String>();
		Iterator<String> iterator1 = inputMap.keySet().iterator();
		while (iterator1.hasNext()) {
			visited.put(iterator1.next(), ""); 
		}
		m1(inputMap, visited, "list1");
	}

	private static Map<String, String[]> createInputMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
