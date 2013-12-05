package graph2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphMaker {

	public List[] readGraph(String filePath, int vertexCount, boolean directed) {
		BufferedReader br = null;
		List[] arr = new List[vertexCount + 1];
		for (int  i = 0 ; i <= vertexCount ; i++) {
			arr[i] = new ArrayList();
		}
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(filePath));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] edge = sCurrentLine.split(" ");
				int v1 = Integer.parseInt(edge[0]);
				int v2 = Integer.parseInt(edge[1]);
				arr[v1].add(v2);
				if (!directed) {
					arr[v2].add(v1);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return arr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
